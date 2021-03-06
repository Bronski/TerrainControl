package com.khorn.terraincontrol.bukkit;

import net.minecraft.server.v1_4_6.BiomeBase;

import com.khorn.terraincontrol.configuration.BiomeConfig;

public class NullBiome extends BukkitBiome
{
    private String name;

    public NullBiome(String _name)
    {
        super(BiomeBase.OCEAN);
        this.name = _name;
    }

    @Override
    public boolean isCustom()
    {
        return true;
    }

    @Override
    public int getId()
    {
        return 255;
    }

    @Override
    public String getName()
    {
       return name;
    }

    @Override
    public void setVisuals(BiomeConfig config)
    {

    }
}
