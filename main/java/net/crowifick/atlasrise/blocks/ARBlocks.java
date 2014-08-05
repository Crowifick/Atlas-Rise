package net.crowifick.atlasrise.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.utils.Reference;
import net.crowifick.atlasrise.utils.blocks.ARBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 11:36 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ARBlocks {

    public static ARBlock cloriteOre = (ARBlock) new ARBlock("CloriteOre", 3.2F, 10F, 2).setLightLevel(0.4F);
    public static ARBlock clorite = new ARBlock(Material.iron, "Clorite", "pickaxe", 5.2F, 10F, 2, CreativeTabs.tabBlock);

    public static Block atlasConvoyInActive = new AtlasConvoy(false).setCreativeTab(CreativeTabs.tabDecorations);
    public static Block atlasConvoyActive = new AtlasConvoy(true);

    public static void init() {

        GameRegistry.registerBlock(cloriteOre, "CloriteOre");
        GameRegistry.registerBlock(clorite, "Clorite");

        GameRegistry.registerBlock(atlasConvoyInActive, "AtlasConvoyInActive");
        GameRegistry.registerBlock(atlasConvoyActive, "AtlasConvoyActive");

    }

}
