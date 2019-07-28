package com.spartakcore.gthandler;

import com.spartakcore.item.ItemList;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.spartakcore.gthandler.tileentities.CustomTextures;

public class GT_CustomLoader {

	private static final GT_Loader_Items ItemLoader = new GT_Loader_Items();
	private static final GT_Loader_Batteries BatteryLoader = new GT_Loader_Batteries();
	private static final GT_MachineRecipeLoader MachineRecipeLoader = new GT_MachineRecipeLoader();
	
	public static void run()
    {
		ItemLoader.run();
		BatteryLoader.run();
		MachineRecipeLoader.run();
    }
}
