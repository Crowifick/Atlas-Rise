package net.crowifick.atlasrise.recipes;

import net.crowifick.atlasrise.items.ARItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: Crowifick
 * Date: 8/5/14
 * Time: 12:51 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class AtlasConvoyRecipes {

    private static final AtlasConvoyRecipes smeltingBase = new AtlasConvoyRecipes();

    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    public static AtlasConvoyRecipes smelting() {

        return smeltingBase;

    }

    private AtlasConvoyRecipes(){

        addAtlasConvoyRecipe(ARItems.cloriteIngot, new ItemStack(ARItems.cloritePlate, 1), 1.0F);
        addAtlasConvoyRecipe(ARItems.redocoleMix, new ItemStack(ARItems.redocolePlate, 1), 1.2F);
        addAtlasConvoyRecipe(ARItems.redocolePlate, new ItemStack(ARItems.redocoleIngot, 1), 1.3F);
        addAtlasConvoyRecipe(ARItems.redocoleIngot, new ItemStack(ARItems.redocolePlate, 1), 1.0F);

    }

    public void addAtlasConvoyRecipe(Block block, ItemStack itemStack, float par3) {

        this.addAtlasConvoyRecipe(Item.getItemFromBlock(block), itemStack, par3);

    }

    public void addAtlasConvoyRecipe(Item item, ItemStack itemStack, float par3) {

        this.addAtlasConvoyRecipe(new ItemStack(item, 1, 32767), itemStack, par3);

    }

    public void addAtlasConvoyRecipe(ItemStack itemStack, ItemStack itemStack2, float par3) {

        this.smeltingList.put(itemStack, itemStack2);
        this.experienceList.put(itemStack2, Float.valueOf(par3));

    }

    public ItemStack getSmeltingResult(ItemStack itemStack) {

        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        do {

            if (!iterator.hasNext())
                return null;

            entry = (Map.Entry)iterator.next();

        }
        while (!this.func_151397_a(itemStack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();

    }

    private boolean func_151397_a(ItemStack itemStack, ItemStack itemStack2) {

        return itemStack2.getItem() == itemStack.getItem() && (itemStack2.getItemDamage() == 32767 || itemStack2.getItemDamage() == itemStack.getItemDamage());

    }

    public Map getSmeltingList() {

        return this.smeltingList;

    }

    public float func_151398_b(ItemStack itemStack) {

        float ret = itemStack.getItem().getSmeltingExperience(itemStack);

        if (ret != -1)
            return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();

        Map.Entry entry;

        do {

            if (!iterator.hasNext()) {

                return 0.0F;

            }

            entry = (Map.Entry)iterator.next();

        }

        while (!this.func_151397_a(itemStack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();

    }

}
