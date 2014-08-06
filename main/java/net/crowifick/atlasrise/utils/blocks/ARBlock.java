package net.crowifick.atlasrise.utils.blocks;

import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.items.ARItems;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 12:28 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARBlock extends Block {

    /**
     *
     * Use this for regular blocks.
     *
     * @param name
     * @param hardness
     * @param resistance
     */
    public ARBlock(Material material, String name, float hardness, float resistance) {

        super(material);
        setBlockName(name);
        setBlockTextureName(Reference.MODID + ":" + name);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(CreativeTabs.tabBlock);

    }

    /**
     *
     * Use this for ore blocks.
     *
     * @param name
     * @param hardness
     * @param resistance
     * @param harvestinglevel
     */
    public ARBlock(String name, float hardness, float resistance, int harvestinglevel) {

        super(Material.rock);
        setBlockName(name);
        setBlockTextureName(Reference.MODID + ":" + name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvestinglevel);
        setCreativeTab(CreativeTabs.tabBlock);

    }

    /**
     *
     * Use this for blocks that need shovel or axe tools harvest level.
     *
     * @param material
     * @param name
     * @param tool
     * @param hardness
     * @param resistance
     * @param harvestinglevel
     */
    public ARBlock(Material material, String name, String tool, float hardness, float resistance, int harvestinglevel, CreativeTabs tab) {

        super(material);
        setBlockName(name);
        setBlockTextureName(Reference.MODID + ":" + name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, harvestinglevel);
        setCreativeTab(tab);

    }

    public int quantityDropped(Random random) {

        if (this.equals(ARBlocks.insonumOre))
            return 1 + random.nextInt(2);

        return 1;

    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

        if (this.equals(ARBlocks.insonumOre))
            return ARItems.insonum;

        return Item.getItemFromBlock(this);

    }

}
