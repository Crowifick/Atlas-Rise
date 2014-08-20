package net.crowifick.atlasrise.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 6:11 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class RecipeHelper {

    /*
     * This class helps make the tool heads and such.
     */

    public static void pickaxe(Item item, Item item2) {

        GameRegistry.addShapedRecipe(new ItemStack(item, 1), "CCC", "C C", 'C', item2);

    }

    public static void sword(Item item, Item item2) {

        GameRegistry.addShapedRecipe(new ItemStack(item, 1), "C", "C", "C", 'C', item2);

    }

    public static void axe(Item item, Item item2) {

        GameRegistry.addShapedRecipe(new ItemStack(item, 1),  "CCC", "CC ", 'C', item2);

    }

    public static void shovel(Item item, Item item2) {

        GameRegistry.addShapedRecipe(new ItemStack(item, 1), "CCC", "CCC", "C C", 'C', item2);

    }

    public static void hoe(Item item, Item item2) {

        GameRegistry.addShapedRecipe(new ItemStack(item, 1), "CCC", "  C", 'C', item2);

    }

    public static void addDust(Item item, Item item2, Item item3) {

        GameRegistry.addShapelessRecipe(new ItemStack(item, 1), item2, item3);

    }

}
