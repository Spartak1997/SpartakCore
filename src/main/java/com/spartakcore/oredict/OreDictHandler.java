package com.spartakcore.oredict;

import com.spartakcore.item.ItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	public static void reg_additional() {
		if(Loader.isModLoaded("GalaxySpace"))
		for (byte i = 0; i<6; i++) {
			OreDictionary.registerOre("cropSpace", GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 1L,i));
			OreDictionary.registerOre("cropTcetiESeaweed", GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 1L,i));
		}
		OreDictionary.registerOre("dustFertilizer", GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L,0));
		OreDictionary.registerOre("dustSmallFertilizer", ItemList.DustSmallFertilizer.getIS());
		OreDictionary.registerOre("dustTinyFertilizer", ItemList.DustTinyFertilizer.getIS());

	}
	
	public static void register_all() {
		reg_additional();
	}
}
