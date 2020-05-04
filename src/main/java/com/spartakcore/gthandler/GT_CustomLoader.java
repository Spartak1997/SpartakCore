package com.spartakcore.gthandler;

import com.spartakcore.item.ItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GT_CustomLoader {

	private static final GT_Loader_Items ItemLoader = new GT_Loader_Items();
	
	public static void run()
    {
		ItemLoader.run();
		MachineRecipeLoader.run();
    }
}
