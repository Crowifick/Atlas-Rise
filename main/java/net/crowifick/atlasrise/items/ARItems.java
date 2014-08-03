package net.crowifick.atlasrise.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.utils.items.*;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
    public static ItemArmor.ArmorMaterial cloriteArmor = EnumHelper.addArmorMaterial("Clorite", 43, new int[]{5, 10, 8, 6}, 12);

    public static ARItem cloriteIngot = new ARItem("CloriteIngot", 64, CreativeTabs.tabMaterials);
    public static ARItem cloritePlate = new ARItem("CloritePlate", 64, CreativeTabs.tabMaterials);
    public static ARItem cloritePickaxeHead = new ARItem("CloritePickaxeHead", 1, CreativeTabs.tabMaterials);
    public static ARItem cloriteSwordHead = new ARItem("CloriteSwordHead", 1, CreativeTabs.tabMaterials);
    public static ARItem cloriteAxeHead = new ARItem("CloriteAxeHead", 1, CreativeTabs.tabMaterials);
    public static ARItem cloriteShovelHead = new ARItem("CloriteShovelHead", 1, CreativeTabs.tabMaterials);
    public static ARItem cloriteHoeHead = new ARItem("CloriteHoeHead", 1, CreativeTabs.tabMaterials);
    public static ARPickaxe cloritePickaxe = new ARPickaxe(clorite, "CloritePickaxe");
    public static ARSword cloriteSword = new ARSword(clorite, "CloriteSword");
    public static ARAxe cloriteAxe = new ARAxe(clorite, "CloriteAxe");
    public static ARShovel cloriteShovel = new ARShovel(clorite, "CloriteShovel");
    public static ARHoe cloriteHoe = new ARHoe(clorite, "CloriteHoe");

    public static void init() {

        GameRegistry.registerItem(cloriteIngot, "CloriteIngot");
        GameRegistry.registerItem(cloritePlate, "CloritePlate");
        GameRegistry.registerItem(cloritePickaxeHead, "CloritePickaxeHead");
        GameRegistry.registerItem(cloriteSwordHead, "CloriteSwordHead");
        GameRegistry.registerItem(cloriteAxeHead, "CloriteAxeHead");
        GameRegistry.registerItem(cloriteShovelHead, "CloriteShovelHead");
        GameRegistry.registerItem(cloriteHoeHead, "CloriteHoeHead");
        GameRegistry.registerItem(cloritePickaxe, "CloritePickaxe");
        GameRegistry.registerItem(cloriteSword, "CloriteSword");
        GameRegistry.registerItem(cloriteAxe, "CloriteAxe");
        GameRegistry.registerItem(cloriteShovel, "CloriteShovel");
        GameRegistry.registerItem(cloriteHoe, "CloriteHoe");

    }

}
