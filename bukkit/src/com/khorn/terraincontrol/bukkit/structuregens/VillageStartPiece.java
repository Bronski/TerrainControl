package com.khorn.terraincontrol.bukkit.structuregens;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.server.v1_4_6.BiomeBase;
import net.minecraft.server.v1_4_6.World;
import net.minecraft.server.v1_4_6.WorldChunkManager;
import net.minecraft.server.v1_4_6.WorldGenVillageStartPiece;

import com.khorn.terraincontrol.LocalWorld;
import com.khorn.terraincontrol.TerrainControl;
import com.khorn.terraincontrol.bukkit.util.WorldHelper;
import com.khorn.terraincontrol.configuration.BiomeConfig;
import com.khorn.terraincontrol.configuration.BiomeConfig.VillageType;

public class VillageStartPiece extends WorldGenVillageStartPiece
{
    public final WorldChunkManager worldChunkManager;

    @SuppressWarnings("rawtypes")
    public VillageStartPiece(World world, int i, Random random, int blockX, int blockZ, ArrayList arraylist, int size)
    {
        super(world.getWorldChunkManager(), i, random, blockX, blockZ, arraylist, size);
        this.worldChunkManager = world.getWorldChunkManager();
        
        // Whether the village is a sandstone village
        BiomeBase currentBiomeGenBase = worldChunkManager.getBiome(blockX, blockZ);
        LocalWorld worldTC = WorldHelper.toLocalWorld(world);
        BiomeConfig config = worldTC.getSettings().biomeConfigs.get(currentBiomeGenBase.id);
        setSandstoneVillage(config.villageType == VillageType.sandstone);
        
        this.k = this;
    }
    
    /**
     * Just sets the first boolean it can find in the WorldGenVillageStartPiece.class to sandstoneVillage.
     * @param sandstoneVillage Whether the village should be a sandstone village.
     */
    private void setSandstoneVillage(boolean sandstoneVillage)
    {
        for(Field field : WorldGenVillageStartPiece.class.getFields())
        {
            if(field.getType().toString().equals("boolean"))
            {
                try
                {
                    field.setAccessible(true);
                    field.setBoolean(this, sandstoneVillage);
                    break;
                } catch (Exception e)
                {
                    TerrainControl.log("Cannot make village a sandstone village!");
                    e.printStackTrace();
                }
            }
        }
    }

    public WorldChunkManager d()
    {
        return this.worldChunkManager;
    }
}
