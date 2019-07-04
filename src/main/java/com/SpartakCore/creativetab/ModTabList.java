package com.SpartakCore.creativetab;

import com.SpartakCore.gthandler.CustomItemList;
import com.SpartakCore.item.ItemList;
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
	public static String ModSpaceTab = "tabSpartakCoreSpace";
	
	private ModTabList() {}
	
	public static void InitModTabs(CreativeTabsManager pTabManager, ModItemManager pItemManager)
	{
		pTabManager.AddCreativeTab(new ModCreativeTab(ModSpaceTab, ItemList.SchematicsTier1.Item.getConstructedItem()));
		
		
	}

}
