package com.khorn.terraincontrol.bukkit.structuregens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.server.v1_4_6.StructurePiece;
import net.minecraft.server.v1_4_6.StructureStart;
import net.minecraft.server.v1_4_6.World;
import net.minecraft.server.v1_4_6.WorldGenNetherPiece15;

class NetherFortressStart extends StructureStart
{

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public NetherFortressStart(World world, Random random, int i, int j)
    {
        WorldGenNetherPiece15 worldgennetherpiece15 = new WorldGenNetherPiece15(random, (i << 4) + 2, (j << 4) + 2);

        this.a.add(worldgennetherpiece15);
        worldgennetherpiece15.a(worldgennetherpiece15, this.a, random);
        ArrayList arraylist = worldgennetherpiece15.d;

        while (!arraylist.isEmpty())
        {
            int k = random.nextInt(arraylist.size());
            StructurePiece structurepiece = (StructurePiece) arraylist.remove(k);

            structurepiece.a((StructurePiece) worldgennetherpiece15, (List) this.a, random);
        }

        this.c();
        this.a(world, random, 48, 70);
    }
}
