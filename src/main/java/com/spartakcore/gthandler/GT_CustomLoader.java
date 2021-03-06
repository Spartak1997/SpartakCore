package com.spartakcore.gthandler;

import com.spartakcore.gthandler.casings.GT_Container_CasingsSC;
import com.spartakcore.gthandler.casings.GT_Loader_CasingsSC;
import com.spartakcore.item.ItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GT_CustomLoader {

	private static final GT_Loader_Items ItemLoader = new GT_Loader_Items();
	private static final GT_Loader_CasingsSC CasingLoader = new GT_Loader_CasingsSC();
	private static final GT_Loader_Machines MachineLoader = new GT_Loader_Machines();
	private static final GT_MachineRecipeLoader MachineRecipeLoader = new GT_MachineRecipeLoader();
	private static final GT_CraftingRecipeLoader CraftingRecipeLoader = new GT_CraftingRecipeLoader();
	
	public static void run()
    {
		ItemLoader.run();
		CasingLoader.run();
		MachineLoader.run();
		MachineRecipeLoader.run();
		CraftingRecipeLoader.run();
    }
}
