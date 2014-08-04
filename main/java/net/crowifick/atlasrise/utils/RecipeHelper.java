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

    public static void pickaxe(ItemStack itemStack, Item item) {

        GameRegistry.addShapedRecipe(itemStack, "CCC", "C C", 'C', item);

    }

    public static void sword(ItemStack itemStack, Item item) {

        GameRegistry.addShapedRecipe(itemStack, "C", "C", "C", 'C', item);

    }

    public static void axe(ItemStack itemStack, Item item) {

        GameRegistry.addShapedRecipe(itemStack,  "CCC", "CC ", 'C', item);

    }

    public static void shovel(ItemStack itemStack, Item item) {

        GameRegistry.addShapedRecipe(itemStack, "CCC", "CCC", "C C", 'C', item);

    }

    public static void hoe(ItemStack itemStack, Item item) {

        GameRegistry.addShapedRecipe(itemStack, "CCC", "  C", 'C', item);

    }

}
