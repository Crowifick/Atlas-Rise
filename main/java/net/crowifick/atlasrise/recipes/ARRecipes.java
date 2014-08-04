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

        GameRegistry.addShapedRecipe(new ItemStack(ARBlocks.clorite, 1), "CCC", "CCC", "CCC", 'C', ARItems.cloriteIngot);
        GameRegistry.addShapelessRecipe(new ItemStack(ARItems.cloriteIngot, 9), ARBlocks.clorite);


    }

    private static void smelting() {

        GameRegistry.addSmelting(ARBlocks.cloriteOre, new ItemStack(ARItems.cloriteIngot, 1), 3F);

    }

    private static void toolRecipes() {

        recipeHelper.pickaxe(new ItemStack(ARItems.cloritePickaxeHead, 1), ARItems.cloriteIngot);
        recipeHelper.sword(new ItemStack(ARItems.cloriteSwordHead, 1), ARItems.cloriteIngot);
        recipeHelper.axe(new ItemStack(ARItems.cloriteAxeHead, 1), ARItems.cloriteIngot);
        recipeHelper.shovel(new ItemStack(ARItems.cloriteShovelHead, 1), ARItems.cloriteIngot);
        recipeHelper.hoe(new ItemStack(ARItems.cloriteHoeHead, 1), ARItems.cloriteIngot);

        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloritePickaxe, 1), "C", "I", 'C', ARItems.cloritePickaxeHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteSword, 1), "C", "I", 'C', ARItems.cloriteSwordHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteAxe, 1), "C", "I", 'C', ARItems.cloriteAxeHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteShovel, 1), "C", "I", 'C', ARItems.cloriteShovelHead, 'I', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ARItems.cloriteHoe, 1), "C", "I", 'C', ARItems.cloriteHoeHead, 'I', Items.stick);

    }

}
