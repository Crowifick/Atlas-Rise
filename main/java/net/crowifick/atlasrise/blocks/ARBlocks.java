package net.crowifick.atlasrise.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
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
    public static ARBlock cloriteBlock = new ARBlock(Material.iron, "CloriteBlock", "pickaxe", 5.2F, 10F, 2, CreativeTabs.tabBlock);
    public static ARBlock insonumOre = (ARBlock) new ARBlock("InsonumOre", 3.5F, 10F, 4).setLightLevel(0.5F);
    public static ARBlock insonumBlock = new ARBlock(Material.iron, "InsonumBlock", "pickaxe", 5.5F, 10F, 4, CreativeTabs.tabBlock);

    public static Block atlasConvoyInActive = new AtlasConvoy(false).setCreativeTab(CreativeTabs.tabDecorations);
    public static Block atlasConvoyActive = new AtlasConvoy(true);

    public static void init() {

        GameRegistry.registerBlock(cloriteOre, "CloriteOre");
        GameRegistry.registerBlock(cloriteBlock, "CloriteBlock");
        GameRegistry.registerBlock(insonumOre, "InsonumOre");
        GameRegistry.registerBlock(insonumBlock, "InsonumBlock");

        GameRegistry.registerBlock(atlasConvoyInActive, "AtlasConvoyInActive");
        GameRegistry.registerBlock(atlasConvoyActive, "AtlasConvoyActive");

        GameRegistry.registerTileEntity(TileEntityAtlasConvoy.class, "TileAtlasConvoy");

    }

}
