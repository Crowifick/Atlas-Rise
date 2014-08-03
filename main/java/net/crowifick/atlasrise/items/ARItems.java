package net.crowifick.atlasrise.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.utils.items.ARItem;
import net.crowifick.atlasrise.utils.items.ARPickaxe;
import net.crowifick.atlasrise.utils.items.ARSword;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 11:36 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ARItems {

    public static Item.ToolMaterial clorite = EnumHelper.addToolMaterial("Clorite", 4, 500, 10.0F, 4.0F, 15);

    public static ARItem cloriteIngot = new ARItem("CloriteIngot", 64, CreativeTabs.tabMaterials);

    public static ARPickaxe cloritePickaxe = new ARPickaxe(clorite, "CloritePickaxe");
    public static ARSword cloriteSword = new ARSword(clorite, "CloriteSword");

    public static void init() {

        GameRegistry.registerItem(cloriteIngot, "CloriteIngot");
        GameRegistry.registerItem(cloritePickaxe, "CloritePickaxe");
        GameRegistry.registerItem(cloriteSword, "CloriteSword");

    }

}
