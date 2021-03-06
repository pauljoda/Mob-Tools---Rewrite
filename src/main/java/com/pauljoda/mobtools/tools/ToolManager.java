package com.pauljoda.mobtools.tools;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.amulets.MobToolsAmulet;
import com.pauljoda.mobtools.amulets.MobToolsBlazeAmulet;
import com.pauljoda.mobtools.amulets.MobToolsHungerAmulet;
import com.pauljoda.mobtools.amulets.MobToolsJumpAmulet;
import com.pauljoda.mobtools.amulets.MobToolsMagnetAmulet;
import com.pauljoda.mobtools.amulets.MobToolsSpeedAmulet;
import com.pauljoda.mobtools.amulets.MobToolsTeleportAmulet;
import com.pauljoda.mobtools.blocks.BlockBlazeTorch;
import com.pauljoda.mobtools.blocks.BlockEnderPackage;
import com.pauljoda.mobtools.blocks.BlockEnderPad;
import com.pauljoda.mobtools.blocks.BlockInfusingFurnace;
import com.pauljoda.mobtools.blocks.BlockMobToolsSpawner;
import com.pauljoda.mobtools.blocks.BlockRepairAlter;
import com.pauljoda.mobtools.handlers.GeneralSettings;
import com.pauljoda.mobtools.item.ItemManager;
import com.pauljoda.mobtools.lib.EnumLibrary;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ToolManager {

	//Swords
	public static Item creeperSwordWood;
	public static Item creeperSwordStone;
	public static Item creeperSwordIron;
	public static Item creeperSwordGold;
	public static Item creeperSwordDiamond;
	
	public static Item enderSwordWood;
	public static Item enderSwordStone;
	public static Item enderSwordIron;
	public static Item enderSwordGold;
	public static Item enderSwordDiamond;
	
	public static Item spiderSwordWood;
	public static Item spiderSwordStone;
	public static Item spiderSwordIron;
	public static Item spiderSwordGold;
	public static Item spiderSwordDiamond;
	
	public static Item blazeSwordWood;
	public static Item blazeSwordStone;
	public static Item blazeSwordIron;
	public static Item blazeSwordGold;
	public static Item blazeSwordDiamond;
	
	//PickAxe
	public static Item creeperPickWood;
	public static Item creeperPickStone;
	public static Item creeperPickIron;
	public static Item creeperPickGold;
	public static Item creeperPickDiamond;
	
	public static Item enderPickWood;
	public static Item enderPickStone;
	public static Item enderPickIron;
	public static Item enderPickGold;
	public static Item enderPickDiamond;
	
	public static Item spiderPickWood;
	public static Item spiderPickStone;
	public static Item spiderPickIron;
	public static Item spiderPickGold;
	public static Item spiderPickDiamond;
	
	public static Item blazePickWood;
	public static Item blazePickStone;
	public static Item blazePickIron;
	public static Item blazePickGold;
	public static Item blazePickDiamond;
	
	//Shovels
	public static Item creeperShovelWood;
	public static Item creeperShovelStone;
	public static Item creeperShovelIron;
	public static Item creeperShovelGold;
	public static Item creeperShovelDiamond;
	
	public static Item enderShovelWood;
	public static Item enderShovelStone;
	public static Item enderShovelIron;
	public static Item enderShovelGold;
	public static Item enderShovelDiamond;
	
	public static Item spiderShovelWood;
	public static Item spiderShovelStone;
	public static Item spiderShovelIron;
	public static Item spiderShovelGold;
	public static Item spiderShovelDiamond;
	
	public static Item blazeShovelWood;
	public static Item blazeShovelStone;
	public static Item blazeShovelIron;
	public static Item blazeShovelGold;
	public static Item blazeShovelDiamond;
	
	//Axes
	public static Item creeperAxeWood;
	public static Item creeperAxeIron;
	public static Item creeperAxeStone;
	public static Item creeperAxeGold;
	public static Item creeperAxeDiamond;
	
	public static Item enderAxeWood;
	public static Item enderAxeStone;
	public static Item enderAxeIron;
	public static Item enderAxeGold;
	public static Item enderAxeDiamond;
	
	public static Item spiderAxeWood;
	public static Item spiderAxeStone;
	public static Item spiderAxeIron;
	public static Item spiderAxeGold;
	public static Item spiderAxeDiamond;
	
	public static Item blazeAxeWood;
	public static Item blazeAxeStone;
	public static Item blazeAxeIron;
	public static Item blazeAxeGold;
	public static Item blazeAxeDiamond;
	
	//Hoes
	public static Item creeperHoeWood;
	public static Item creeperHoeStone;
	public static Item creeperHoeIron;
	public static Item creeperHoeGold;
	public static Item creeperHoeDiamond;
	
	public static Item enderHoeWood;
	public static Item enderHoeStone;
	public static Item enderHoeIron;
	public static Item enderHoeGold;
	public static Item enderHoeDiamond;
	
	public static Item spiderHoeWood;
	public static Item spiderHoeStone;
	public static Item spiderHoeIron;
	public static Item spiderHoeGold;
	public static Item spiderHoeDiamond;
	
	public static Item blazeHoeWood;
	public static Item blazeHoeStone;
	public static Item blazeHoeIron;
	public static Item blazeHoeGold;
	public static Item blazeHoeDiamond;
	
	//Wands
	public static Item creeperWand;
	public static Item endiumWand;
	public static Item spidiumWand;
	public static Item blaziumWand;


	public static void registerTools()
	{
		//Adding----------------------------------------------------------------------------------------

		//Swords
		creeperSwordWood = new MobToolsSword(EnumLibrary.CREEPER_TOOL_MATERIAL_WOOD, "creeperSword", 0, 1, "Wooden").setCreativeTab(null);
		creeperSwordStone = new MobToolsSword(EnumLibrary.CREEPER_TOOL_MATERIAL_STONE, "creeperSword", 0, 1, "Stone").setCreativeTab(null);
		creeperSwordIron = new MobToolsSword(EnumLibrary.CREEPER_TOOL_MATERIAL_IRON, "creeperSword", 0, 1, "Iron").setCreativeTab(null);
		creeperSwordGold = new MobToolsSword(EnumLibrary.CREEPER_TOOL_MATERIAL_GOLD, "creeperSword", 0, 1, "Gold").setCreativeTab(null);
		creeperSwordDiamond = new MobToolsSword(EnumLibrary.CREEPER_TOOL_MATERIAL_DIAMOND, "creeperSword", 0, 1, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		enderSwordWood = new MobToolsSword(EnumLibrary.ENDER_TOOL_MATERIAL_WOOD, "enderSword", 0, 2, "Wooden").setCreativeTab(null);
		enderSwordStone = new MobToolsSword(EnumLibrary.ENDER_TOOL_MATERIAL_STONE, "enderSword", 0, 2, "Stone").setCreativeTab(null);
		enderSwordIron = new MobToolsSword(EnumLibrary.ENDER_TOOL_MATERIAL_IRON, "enderSword", 0, 2, "Iron").setCreativeTab(null);
		enderSwordGold = new MobToolsSword(EnumLibrary.ENDER_TOOL_MATERIAL_GOLD, "enderSword", 0, 2, "Gold").setCreativeTab(null);
		enderSwordDiamond = new MobToolsSword(EnumLibrary.ENDER_TOOL_MATERIAL_DIAMOND, "enderSword", 0, 2, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		spiderSwordWood = new MobToolsSword(EnumLibrary.SPIDER_TOOL_MATERIAL_WOOD, "spiderSword", 0, 3, "Wooden").setCreativeTab(null);
		spiderSwordStone = new MobToolsSword(EnumLibrary.SPIDER_TOOL_MATERIAL_STONE, "spiderSword", 0, 3, "Stone").setCreativeTab(null);
		spiderSwordIron = new MobToolsSword(EnumLibrary.SPIDER_TOOL_MATERIAL_IRON, "spiderSword", 0, 3, "Iron").setCreativeTab(null);
		spiderSwordGold = new MobToolsSword(EnumLibrary.SPIDER_TOOL_MATERIAL_GOLD, "spiderSword", 0, 3, "Gold").setCreativeTab(null);
		spiderSwordDiamond = new MobToolsSword(EnumLibrary.SPIDER_TOOL_MATERIAL_DIAMOND, "spiderSword", 0, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		blazeSwordWood = new MobToolsSword(EnumLibrary.BLAZE_TOOL_MATERIAL_WOOD, "blazeSword", 0, 4, "Wooden").setCreativeTab(null);
		blazeSwordStone = new MobToolsSword(EnumLibrary.BLAZE_TOOL_MATERIAL_STONE, "blazeSword", 0, 4, "Stone").setCreativeTab(null);
		blazeSwordIron = new MobToolsSword(EnumLibrary.BLAZE_TOOL_MATERIAL_IRON, "blazeSword", 0, 4, "Iron").setCreativeTab(null);
		blazeSwordGold = new MobToolsSword(EnumLibrary.BLAZE_TOOL_MATERIAL_GOLD, "blazeSword", 0, 4, "Gold").setCreativeTab(null);
		blazeSwordDiamond = new MobToolsSword(EnumLibrary.BLAZE_TOOL_MATERIAL_DIAMOND, "blazeSword", 0, 4, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		
		//Picks
		creeperPickWood = new MobToolsPick(EnumLibrary.CREEPER_TOOL_MATERIAL_WOOD, "creeperPick", 0, 1, 0, "Wooden").setCreativeTab(null);
		creeperPickStone = new MobToolsPick(EnumLibrary.CREEPER_TOOL_MATERIAL_STONE, "creeperPick", 0, 1, 1, "Stone").setCreativeTab(null);
		creeperPickIron = new MobToolsPick(EnumLibrary.CREEPER_TOOL_MATERIAL_IRON, "creeperPick", 0, 1, 2, "Iron").setCreativeTab(null);
		creeperPickGold = new MobToolsPick(EnumLibrary.CREEPER_TOOL_MATERIAL_GOLD, "creeperPick", 0, 1, 0, "Gold").setCreativeTab(null);
		creeperPickDiamond = new MobToolsPick(EnumLibrary.CREEPER_TOOL_MATERIAL_DIAMOND, "creeperPick", 0, 1, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		enderPickWood = new MobToolsPick(EnumLibrary.ENDER_TOOL_MATERIAL_WOOD, "enderPick", 0, 2, 0, "Wooden").setCreativeTab(null);
		enderPickStone = new MobToolsPick(EnumLibrary.ENDER_TOOL_MATERIAL_STONE, "enderPick", 0, 2, 1, "Stone").setCreativeTab(null);
		enderPickIron = new MobToolsPick(EnumLibrary.ENDER_TOOL_MATERIAL_IRON, "enderPick", 0, 2, 2, "Iron").setCreativeTab(null);
		enderPickGold = new MobToolsPick(EnumLibrary.ENDER_TOOL_MATERIAL_GOLD, "enderPick", 0, 2, 0, "Gold").setCreativeTab(null);
		enderPickDiamond = new MobToolsPick(EnumLibrary.ENDER_TOOL_MATERIAL_DIAMOND, "enderPick", 0, 2, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		spiderPickWood = new MobToolsPick(EnumLibrary.SPIDER_TOOL_MATERIAL_WOOD, "spiderPick", 0, 3, 0, "Wooden").setCreativeTab(null);
		spiderPickStone = new MobToolsPick(EnumLibrary.SPIDER_TOOL_MATERIAL_STONE, "spiderPick", 0, 3, 1, "Stone").setCreativeTab(null);
		spiderPickIron = new MobToolsPick(EnumLibrary.SPIDER_TOOL_MATERIAL_IRON, "spiderPick", 0, 3, 2, "Iron").setCreativeTab(null);
		spiderPickGold = new MobToolsPick(EnumLibrary.SPIDER_TOOL_MATERIAL_GOLD, "spiderPick", 0, 3, 0, "Gold").setCreativeTab(null);
		spiderPickDiamond = new MobToolsPick(EnumLibrary.SPIDER_TOOL_MATERIAL_DIAMOND, "spiderPick", 0, 3, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		blazePickWood = new MobToolsPick(EnumLibrary.BLAZE_TOOL_MATERIAL_WOOD, "blazePick", 0, 4, 0, "Wooden").setCreativeTab(null);
		blazePickStone = new MobToolsPick(EnumLibrary.BLAZE_TOOL_MATERIAL_STONE, "blazePick", 0, 4, 1, "Stone").setCreativeTab(null);
		blazePickIron = new MobToolsPick(EnumLibrary.BLAZE_TOOL_MATERIAL_IRON, "blazePick", 0, 4, 2, "Iron").setCreativeTab(null);
		blazePickGold = new MobToolsPick(EnumLibrary.BLAZE_TOOL_MATERIAL_GOLD, "blazePick", 0, 4, 0, "Gold").setCreativeTab(null);
		blazePickDiamond = new MobToolsPick(EnumLibrary.BLAZE_TOOL_MATERIAL_DIAMOND, "blazePick", 0, 4, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		
		//Shovel
		creeperShovelWood = new MobToolsShovel(EnumLibrary.CREEPER_TOOL_MATERIAL_WOOD, "creeperShovel", 0, 1, 0, "Wooden").setCreativeTab(null);
		creeperShovelStone = new MobToolsShovel(EnumLibrary.CREEPER_TOOL_MATERIAL_STONE, "creeperShovel", 0, 1, 1, "Stone").setCreativeTab(null);
		creeperShovelIron = new MobToolsShovel(EnumLibrary.CREEPER_TOOL_MATERIAL_IRON, "creeperShovel", 0, 1, 2, "Iron").setCreativeTab(null);
		creeperShovelGold = new MobToolsShovel(EnumLibrary.CREEPER_TOOL_MATERIAL_GOLD, "creeperShovel", 0, 1, 0, "Gold").setCreativeTab(null);
		creeperShovelDiamond = new MobToolsShovel(EnumLibrary.CREEPER_TOOL_MATERIAL_DIAMOND, "creeperShovel", 0, 1, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		enderShovelWood = new MobToolsShovel(EnumLibrary.ENDER_TOOL_MATERIAL_WOOD, "enderShovel", 0, 2, 0, "Wooden").setCreativeTab(null);
		enderShovelStone = new MobToolsShovel(EnumLibrary.ENDER_TOOL_MATERIAL_STONE, "enderShovel", 0, 2, 1, "Stone").setCreativeTab(null);
		enderShovelIron = new MobToolsShovel(EnumLibrary.ENDER_TOOL_MATERIAL_IRON, "enderShovel", 0, 2, 2, "Iron").setCreativeTab(null);
		enderShovelGold = new MobToolsShovel(EnumLibrary.ENDER_TOOL_MATERIAL_GOLD, "enderShovel", 0, 2, 0, "Gold").setCreativeTab(null);
		enderShovelDiamond = new MobToolsShovel(EnumLibrary.ENDER_TOOL_MATERIAL_DIAMOND, "enderShovel", 0, 2, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		spiderShovelWood = new MobToolsShovel(EnumLibrary.SPIDER_TOOL_MATERIAL_WOOD, "spiderShovel", 0, 3, 0, "Wooden").setCreativeTab(null);
		spiderShovelStone = new MobToolsShovel(EnumLibrary.SPIDER_TOOL_MATERIAL_STONE, "spiderShovel", 0, 3, 1, "Stone").setCreativeTab(null);
		spiderShovelIron = new MobToolsShovel(EnumLibrary.SPIDER_TOOL_MATERIAL_IRON, "spiderShovel", 0, 3, 2, "Iron").setCreativeTab(null);
		spiderShovelGold = new MobToolsShovel(EnumLibrary.SPIDER_TOOL_MATERIAL_GOLD, "spiderShovel", 0, 3, 0, "Gold").setCreativeTab(null);
		spiderShovelDiamond = new MobToolsShovel(EnumLibrary.SPIDER_TOOL_MATERIAL_DIAMOND, "spiderShovel", 0, 3, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		blazeShovelWood = new MobToolsShovel(EnumLibrary.BLAZE_TOOL_MATERIAL_WOOD, "blazeShovel", 0, 4, 0, "Wooden").setCreativeTab(null);
		blazeShovelStone = new MobToolsShovel(EnumLibrary.BLAZE_TOOL_MATERIAL_STONE, "blazeShovel", 0, 4, 1, "Stone").setCreativeTab(null);
		blazeShovelIron = new MobToolsShovel(EnumLibrary.BLAZE_TOOL_MATERIAL_IRON, "blazeShovel", 0, 4, 2, "Iron").setCreativeTab(null);
		blazeShovelGold = new MobToolsShovel(EnumLibrary.BLAZE_TOOL_MATERIAL_GOLD, "blazeShovel", 0, 4, 0, "Gold").setCreativeTab(null);
		blazeShovelDiamond = new MobToolsShovel(EnumLibrary.BLAZE_TOOL_MATERIAL_DIAMOND, "blazeShovel", 0, 4, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		
		//Axes
		creeperAxeWood = new MobToolsAxe(EnumLibrary.CREEPER_TOOL_MATERIAL_WOOD, "creeperAxe", 0, 1, 0, "Wooden").setCreativeTab(null);
		creeperAxeStone = new MobToolsAxe(EnumLibrary.CREEPER_TOOL_MATERIAL_STONE, "creeperAxe", 0, 1, 1, "Wooden").setCreativeTab(null);
		creeperAxeIron = new MobToolsAxe(EnumLibrary.CREEPER_TOOL_MATERIAL_IRON, "creeperAxe", 0, 1, 2, "Iron").setCreativeTab(null);
		creeperAxeGold = new MobToolsAxe(EnumLibrary.CREEPER_TOOL_MATERIAL_GOLD, "creeperAxe", 0, 1, 0, "Gold").setCreativeTab(null);
		creeperAxeDiamond = new MobToolsAxe(EnumLibrary.CREEPER_TOOL_MATERIAL_DIAMOND, "creeperAxe", 0, 1, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		enderAxeWood = new MobToolsAxe(EnumLibrary.ENDER_TOOL_MATERIAL_WOOD, "enderAxe", 0, 2, 0, "Wooden").setCreativeTab(null);
		enderAxeStone = new MobToolsAxe(EnumLibrary.ENDER_TOOL_MATERIAL_STONE, "enderAxe", 0, 2, 1, "Stone").setCreativeTab(null);
		enderAxeIron = new MobToolsAxe(EnumLibrary.ENDER_TOOL_MATERIAL_IRON, "enderAxe", 0, 2, 2, "Iron").setCreativeTab(null);
		enderAxeGold = new MobToolsAxe(EnumLibrary.ENDER_TOOL_MATERIAL_GOLD, "enderAxe", 0, 2, 0, "Gold").setCreativeTab(null);
		enderAxeDiamond = new MobToolsAxe(EnumLibrary.ENDER_TOOL_MATERIAL_DIAMOND, "enderAxe", 0, 2, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		spiderAxeWood = new MobToolsAxe(EnumLibrary.SPIDER_TOOL_MATERIAL_WOOD, "spiderAxe", 0, 3, 0, "Wooden").setCreativeTab(null);
		spiderAxeStone = new MobToolsAxe(EnumLibrary.SPIDER_TOOL_MATERIAL_STONE, "spiderAxe", 0, 3, 1, "Stone").setCreativeTab(null);
		spiderAxeIron = new MobToolsAxe(EnumLibrary.SPIDER_TOOL_MATERIAL_IRON, "spiderAxe", 0, 3, 2, "Iron").setCreativeTab(null);
		spiderAxeGold = new MobToolsAxe(EnumLibrary.SPIDER_TOOL_MATERIAL_GOLD, "spiderAxe", 0, 3, 0, "Gold").setCreativeTab(null);
		spiderAxeDiamond = new MobToolsAxe(EnumLibrary.SPIDER_TOOL_MATERIAL_DIAMOND, "spiderAxe", 0, 3, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		blazeAxeWood = new MobToolsAxe(EnumLibrary.BLAZE_TOOL_MATERIAL_WOOD, "blazeAxe", 0, 4, 0, "Wooden").setCreativeTab(null);
		blazeAxeStone = new MobToolsAxe(EnumLibrary.BLAZE_TOOL_MATERIAL_STONE, "blazeAxe", 0, 4, 1, "Stone").setCreativeTab(null);
		blazeAxeIron = new MobToolsAxe(EnumLibrary.BLAZE_TOOL_MATERIAL_IRON, "blazeAxe", 0, 4, 2, "Iron").setCreativeTab(null);
		blazeAxeGold = new MobToolsAxe(EnumLibrary.BLAZE_TOOL_MATERIAL_GOLD, "blazeAxe", 0, 4, 0, "Gold").setCreativeTab(null);
		blazeAxeDiamond = new MobToolsAxe(EnumLibrary.BLAZE_TOOL_MATERIAL_DIAMOND, "blazeAxe", 0, 4, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		
		//Hoes
		creeperHoeWood = new MobToolsHoe(EnumLibrary.CREEPER_TOOL_MATERIAL_WOOD, "creeperHoe", 0, 1, "Wooden").setCreativeTab(null);
		creeperHoeStone = new MobToolsHoe(EnumLibrary.CREEPER_TOOL_MATERIAL_STONE, "creeperHoe", 0, 1, "Stone").setCreativeTab(null);
		creeperHoeIron = new MobToolsHoe(EnumLibrary.CREEPER_TOOL_MATERIAL_IRON, "creeperHoe", 0, 1, "Iron").setCreativeTab(null);
		creeperHoeGold = new MobToolsHoe(EnumLibrary.CREEPER_TOOL_MATERIAL_GOLD, "creeperHoe", 0, 1, "Gold").setCreativeTab(null);
		creeperHoeDiamond = new MobToolsHoe(EnumLibrary.CREEPER_TOOL_MATERIAL_DIAMOND, "creeperHoe", 0, 1, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		enderHoeWood = new MobToolsHoe(EnumLibrary.ENDER_TOOL_MATERIAL_WOOD, "enderHoe",0, 2, "Wooden").setCreativeTab(null);
		enderHoeStone = new MobToolsHoe(EnumLibrary.ENDER_TOOL_MATERIAL_STONE, "enderHoe",0, 2, "Stone").setCreativeTab(null);
		enderHoeIron = new MobToolsHoe(EnumLibrary.ENDER_TOOL_MATERIAL_IRON, "enderHoe",0, 2, "Iron").setCreativeTab(null);
		enderHoeGold = new MobToolsHoe(EnumLibrary.ENDER_TOOL_MATERIAL_GOLD, "enderHoe",0, 2, "Gold").setCreativeTab(null);
		enderHoeDiamond = new MobToolsHoe(EnumLibrary.ENDER_TOOL_MATERIAL_DIAMOND, "enderHoe",0, 2, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		spiderHoeWood = new MobToolsHoe(EnumLibrary.SPIDER_TOOL_MATERIAL_WOOD, "spiderHoe", 0, 3, "Wooden").setCreativeTab(null);
		spiderHoeStone = new MobToolsHoe(EnumLibrary.SPIDER_TOOL_MATERIAL_STONE, "spiderHoe", 0, 3, "Stone").setCreativeTab(null);
		spiderHoeIron = new MobToolsHoe(EnumLibrary.SPIDER_TOOL_MATERIAL_IRON, "spiderHoe", 0, 3, "Iron").setCreativeTab(null);
		spiderHoeGold = new MobToolsHoe(EnumLibrary.SPIDER_TOOL_MATERIAL_GOLD, "spiderHoe", 0, 3, "Gold").setCreativeTab(null);
		spiderHoeDiamond = new MobToolsHoe(EnumLibrary.SPIDER_TOOL_MATERIAL_DIAMOND, "spiderHoe", 0, 3, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		blazeHoeWood = new MobToolsHoe( EnumLibrary.BLAZE_TOOL_MATERIAL_WOOD, "blazeHoe", 0, 4, "Wooden").setCreativeTab(null);
		blazeHoeStone = new MobToolsHoe( EnumLibrary.BLAZE_TOOL_MATERIAL_STONE, "blazeHoe", 0, 4, "Stone").setCreativeTab(null);
		blazeHoeIron = new MobToolsHoe( EnumLibrary.BLAZE_TOOL_MATERIAL_IRON, "blazeHoe", 0, 4, "Iron").setCreativeTab(null);
		blazeHoeGold = new MobToolsHoe( EnumLibrary.BLAZE_TOOL_MATERIAL_GOLD, "blazeHoe", 0, 4, "Gold").setCreativeTab(null);
		blazeHoeDiamond = new MobToolsHoe( EnumLibrary.BLAZE_TOOL_MATERIAL_DIAMOND, "blazeHoe", 0, 4, "Diamond").setCreativeTab(MobTools.tabMobTools);
		
		
		//Wands
		creeperWand = new MobToolsWand("creeperWand", 1, 100);
		endiumWand = new MobToolsWand("enderWand", 2, 2000);
		spidiumWand = new MobToolsWand("spiderWand", 3, 200);
		blaziumWand = new MobToolsWand("blazeWand", 4, 500);

		
		
		//Registering---------------------------------------------------------------------

		//Swords
		GameRegistry.registerItem(creeperSwordWood, "creeperSwordWood");
		GameRegistry.registerItem(creeperSwordStone, "creeperSwordStone");
		GameRegistry.registerItem(creeperSwordIron, "creeperSwordIron");
		GameRegistry.registerItem(creeperSwordGold, "creeperSwordGold");
		GameRegistry.registerItem(creeperSwordDiamond, "creeperSwordDiamond");
		
		GameRegistry.registerItem(enderSwordWood, "enderSwordWood");
		GameRegistry.registerItem(enderSwordStone, "enderSwordStone");
		GameRegistry.registerItem(enderSwordIron, "enderSwordIron");
		GameRegistry.registerItem(enderSwordGold, "enderSwordGold");
		GameRegistry.registerItem(enderSwordDiamond, "enderSwordDiamond");
		
		GameRegistry.registerItem(spiderSwordWood, "spiderSwordWood");
		GameRegistry.registerItem(spiderSwordStone, "spiderSwordStone");
		GameRegistry.registerItem(spiderSwordIron, "spiderSwordIron");
		GameRegistry.registerItem(spiderSwordGold, "spiderSwordGold");
		GameRegistry.registerItem(spiderSwordDiamond, "spiderSwordDiamond");
		
		GameRegistry.registerItem(blazeSwordWood, "blazeSwordWood");
		GameRegistry.registerItem(blazeSwordStone, "blazeSwordStone");
		GameRegistry.registerItem(blazeSwordIron, "blazeSwordIron");
		GameRegistry.registerItem(blazeSwordGold, "blazeSwordGold");
		GameRegistry.registerItem(blazeSwordDiamond, "blazeSwordDiamond");
		
		//Picks
		GameRegistry.registerItem(creeperPickWood, "creeperPickWood");
		GameRegistry.registerItem(creeperPickStone, "creeperPickStone");
		GameRegistry.registerItem(creeperPickIron, "creeperPickIron");
		GameRegistry.registerItem(creeperPickGold, "creeperPickGold");
		GameRegistry.registerItem(creeperPickDiamond, "creeperPickDiamond");
		
		GameRegistry.registerItem(enderPickWood, "enderPickWood");
		GameRegistry.registerItem(enderPickStone, "enderPickStone");
		GameRegistry.registerItem(enderPickIron, "enderPickIron");
		GameRegistry.registerItem(enderPickGold, "enderPickGold");
		GameRegistry.registerItem(enderPickDiamond, "enderPickDiamon");
		
		GameRegistry.registerItem(spiderPickWood, "spiderPickWood");
		GameRegistry.registerItem(spiderPickStone, "spiderPickStone");
		GameRegistry.registerItem(spiderPickIron, "spiderPickIron");
		GameRegistry.registerItem(spiderPickGold, "spiderPickGold");
		GameRegistry.registerItem(spiderPickDiamond, "spiderPickDiamond");
		
		GameRegistry.registerItem(blazePickWood, "blazePickWood");
		GameRegistry.registerItem(blazePickStone, "blazePickStone");
		GameRegistry.registerItem(blazePickIron, "blazePickIron");
		GameRegistry.registerItem(blazePickGold, "blazePickGold");
		GameRegistry.registerItem(blazePickDiamond, "blazePickDiamond");
		
		//Shovels
		GameRegistry.registerItem(creeperShovelWood, "creeperShovelWood");
		GameRegistry.registerItem(creeperShovelStone, "creeperShovelStone");
		GameRegistry.registerItem(creeperShovelIron, "creeperShovelIron");
		GameRegistry.registerItem(creeperShovelGold, "creeperShovelGold");
		GameRegistry.registerItem(creeperShovelDiamond, "creeperShovelDiamond");
		
		GameRegistry.registerItem(enderShovelWood, "enderShovelWood");
		GameRegistry.registerItem(enderShovelStone, "enderShovelStone");
		GameRegistry.registerItem(enderShovelIron, "enderShovelIron");
		GameRegistry.registerItem(enderShovelGold, "enderShovelGold");
		GameRegistry.registerItem(enderShovelDiamond, "enderShovelDiamond");
		
		GameRegistry.registerItem(spiderShovelWood, "spiderShovelWood");
		GameRegistry.registerItem(spiderShovelStone, "spiderShovelStone");
		GameRegistry.registerItem(spiderShovelIron, "spiderShovelIron");
		GameRegistry.registerItem(spiderShovelGold, "spiderShovelGold");
		GameRegistry.registerItem(spiderShovelDiamond, "spiderShovelDiamond");
		
		GameRegistry.registerItem(blazeShovelWood, "blazeShovelWood");
		GameRegistry.registerItem(blazeShovelStone, "blazeShovelStone");
		GameRegistry.registerItem(blazeShovelIron, "blazeShovelIron");
		GameRegistry.registerItem(blazeShovelGold, "blazeShovelGold");
		GameRegistry.registerItem(blazeShovelDiamond, "blazeShovelDiamond");
		
		//Axes
		GameRegistry.registerItem(creeperAxeWood, "creeperAxeWood");
		GameRegistry.registerItem(creeperAxeStone, "creeperAxeStone");
		GameRegistry.registerItem(creeperAxeIron, "creeperAxeIron");
		GameRegistry.registerItem(creeperAxeGold, "creeperAxeGold");
		GameRegistry.registerItem(creeperAxeDiamond, "creeperAxeDiamond");
		
		GameRegistry.registerItem(enderAxeWood, "enderAxeWood");
		GameRegistry.registerItem(enderAxeStone, "enderAxeStone");
		GameRegistry.registerItem(enderAxeIron, "enderAxeIron");
		GameRegistry.registerItem(enderAxeGold, "enderAxeGold");
		GameRegistry.registerItem(enderAxeDiamond, "enderAxeDiamond");
		
		GameRegistry.registerItem(spiderAxeWood, "spiderAxeWood");
		GameRegistry.registerItem(spiderAxeStone, "spiderAxeStone");
		GameRegistry.registerItem(spiderAxeIron, "spiderAxeIron");
		GameRegistry.registerItem(spiderAxeGold, "spiderAxeGold");
		GameRegistry.registerItem(spiderAxeDiamond, "spiderAxeDiamond");
		
		GameRegistry.registerItem(blazeAxeWood, "blazeAxeWood");
		GameRegistry.registerItem(blazeAxeStone, "blazeAxeStone");
		GameRegistry.registerItem(blazeAxeIron, "blazeAxeIron");
		GameRegistry.registerItem(blazeAxeGold, "blazeAxeGold");
		GameRegistry.registerItem(blazeAxeDiamond, "blazeAxeDiamond");
		
		//Hoes
		GameRegistry.registerItem(creeperHoeWood, "creeperHoeWood");
		GameRegistry.registerItem(creeperHoeStone, "creeperHoeStone");
		GameRegistry.registerItem(creeperHoeIron, "creeperHoeIron");
		GameRegistry.registerItem(creeperHoeGold, "creeperHoeGold");
		GameRegistry.registerItem(creeperHoeDiamond, "creeperHoeDiamond");
		
		GameRegistry.registerItem(enderHoeWood, "enderHoeWood");
		GameRegistry.registerItem(enderHoeStone, "enderHoeStone");
		GameRegistry.registerItem(enderHoeIron, "enderHoeIron");
		GameRegistry.registerItem(enderHoeGold, "enderHoeGold");
		GameRegistry.registerItem(enderHoeDiamond, "enderHoeDiamond");
		
		GameRegistry.registerItem(spiderHoeWood, "spiderHoeWood");
		GameRegistry.registerItem(spiderHoeStone, "spiderHoeStone");
		GameRegistry.registerItem(spiderHoeIron, "spiderHoeIron");
		GameRegistry.registerItem(spiderHoeGold, "spiderHoeGold");
		GameRegistry.registerItem(spiderHoeDiamond, "spiderHoeDiamond");
		
		GameRegistry.registerItem(blazeHoeWood, "blazeHoeWood");
		GameRegistry.registerItem(blazeHoeStone, "blazeHoeStone");
		GameRegistry.registerItem(blazeHoeIron, "blazeHoeIron");
		GameRegistry.registerItem(blazeHoeGold, "blazeHoeGold");
		GameRegistry.registerItem(blazeHoeDiamond, "blazeHoeDiamond");
		
		//Wands
		GameRegistry.registerItem(creeperWand, "creeperWand");
		GameRegistry.registerItem(endiumWand, "enderWand");
		GameRegistry.registerItem(spidiumWand, "spiderWand");
		GameRegistry.registerItem(blaziumWand, "blazeWand");


	}
}


