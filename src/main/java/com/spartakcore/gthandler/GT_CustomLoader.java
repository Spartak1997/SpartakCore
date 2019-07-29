package com.spartakcore.gthandler;

import com.spartakcore.item.ItemList;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.spartakcore.gthandler.tileentities.CustomTextures;

public class GT_CustomLoader {

	private static final GT_Loader_Items ItemLoader = new GT_Loader_Items();
	private static final GT_MachineRecipeLoader MachineRecipeLoader = new GT_MachineRecipeLoader();
	private static final GT_TecTechLoader TecTechLoader = new GT_TecTechLoader();
	
	
	public static void run()
    {
		ItemLoader.run();
		MachineRecipeLoader.run();
		if (Loader.isModLoaded("tectech"))
	    {
		TecTechLoader.run();
	    }
    }
}
