package net.crowifick.atlasrise.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.items.ARItems;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.item.ItemStack;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 12:51 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ARRecipes {

    public static void init() {

        GameRegistry.addSmelting(ARBlocks.cloriteOre, new ItemStack(ARItems.cloriteIngot, 1), 3F);

        GameRegistry.addShapedRecipe(new ItemStack(ARBlocks.clorite, 1), "CCC", "CCC", "CCC", 'C', ARItems.cloriteIngot);

        GameRegistry.addShapelessRecipe(new ItemStack(ARItems.cloriteIngot, 9), ARBlocks.clorite);

    }

}