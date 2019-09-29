package com.spartakcore.creativetab;

import com.spartakcore.gthandler.CustomItemList;
import com.spartakcore.item.ItemList;
import eu.usrv.yamcore.creativetabs.CreativeTabsManager;
import eu.usrv.yamcore.creativetabs.ModCreativeTab;
import eu.usrv.yamcore.items.ModItemManager;
import gregtech.api.GregTech_API;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ModTabList {
	public static String ModGenericTab = "tabSpartakCoreItems_Generic";
	public static String ModSpaceTab = "tabSpartakCoreSpace";
	public static String ModBarsAndCasingsTab = "tabSpartakCoreBars_Casings";
	
	private ModTabList() {}
	
	public static void InitModTabs(CreativeTabsManager pTabManager, ModItemManager pItemManager)
	{
		pTabManager.AddCreativeTab(new ModCreativeTab(ModGenericTab, ItemList.QuantumPartChestplate.Item.getConstructedItem()));
		pTabManager.AddCreativeTab(new ModCreativeTab(ModSpaceTab, ItemList.SchematicsTier1.Item.getConstructedItem()));
		pTabManager.AddCreativeTab(new ModCreativeTab(ModBarsAndCasingsTab, ItemList.IridiumAlloyItemCasing.Item.getConstructedItem()));
		
		
	}

}
