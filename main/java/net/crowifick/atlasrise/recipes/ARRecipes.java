package net.crowifick.atlasrise.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.items.ARItems;
import net.crowifick.atlasrise.utils.RecipeHelper;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.init.Items;
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

    public static RecipeHelper recipeHelper;

    public static void init() {

        toolRecipes();
        smelting();
        regularRecipes();

    }

    private static void regularRecipes() {

        GameRegistry.addShapedRecipe(new ItemStack(ARBlocks.cloriteBlock, 1), "CCC", "CCC", "CCC", 'C', ARItems.cloriteIngot);
        GameRegistry.addShapelessRecipe(new ItemStack(ARItems.cloriteIngot, 9), ARBlocks.cloriteBlock);

        GameRegistry.addShapedRecipe(new ItemStack(ARBlocks.insonumBlock, 1), "III", "III", "III", 'I', ARItems.insonum);
        GameRegistry.addShapelessRecipe(new ItemStack(ARItems.insonum, 9), ARBlocks.insonumBlock);

        GameRegistry.addShapedRecipe(new ItemStack(ARBlocks.ghesumBlock, 1), "GG", "GG", 'G', ARItems.ghesumDust);
        GameRegistry.addShapelessRecipe(new ItemStack(ARItems.ghesumDust, 4), ARBlocks.ghesumBlock);

        RecipeHelper.addDust(ARItems.redocoleMix, ARItems.insonum, ARItems.ghesumDust);



    }

    private static void smelting() {

        GameRegistry.addSmelting(ARBlocks.cloriteOre, new ItemStack(ARItems.cloriteIngot, 1), 3F);

    }

    private static void toolRecipes() {

        recipeHelper.pickaxe(ARItems.cloritePickaxeHead, ARItems.cloriteIngot);
        recipeHelper.sword(ARItems.cloriteSwordHead, ARItems.cloriteIngot);
        recipeHelper.axe(ARItems.cloriteAxeHead, ARItems.cloriteIngot);
        recipeHelper.shovel(ARItems.cloriteShovelHead, ARItems.cloriteIngot);
        recipeHelper.hoe(ARItems.cloriteHoeHead, ARItems.cloriteIngot);

        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloritePickaxe, 1), "C", "I", 'C', ARItems.cloritePickaxeHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteSword, 1), "C", "I", 'C', ARItems.cloriteSwordHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteAxe, 1), "C", "I", 'C', ARItems.cloriteAxeHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteShovel, 1), "C", "I", 'C', ARItems.cloriteShovelHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteHoe, 1), "C", "I", 'C', ARItems.cloriteHoeHead, 'I', Items.stick);

    }

}
