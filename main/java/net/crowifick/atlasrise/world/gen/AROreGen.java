package net.crowifick.atlasrise.world.gen;

import cpw.mods.fml.common.IWorldGenerator;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.utils.world.OreGeneration;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 2:34 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class AROreGen implements IWorldGenerator {

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.dimensionId) {

            case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);

        }

    }

    private void generateEnd(World world, Random random, int x, int z) {



    }
    private void generateSurface(World world, Random random, int x, int z) {

        OreGeneration.addOreSpawn(ARBlocks.cloriteOre, world, random, x, z, 16, 16, 5, 9, 14, 30);
        OreGeneration.addOreSpawn(ARBlocks.insonumOre, world, random, x, z, 16, 16, 4, 7, 5, 20);

    }
    private void generateNether(World world, Random random, int x, int z) {



    }

}
