package com.spartakcore.gthandler;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.tileentities.automation.GT_MetaTileEntity_ChestBuffer;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_PlasmaGenerator;
import gregtech.common.tileentities.machines.basic.*;
import gregtech.loaders.preload.GT_Loader_MetaTileEntities;
import gtPlusPlus.core.material.gregtech.CustomGTMaterials;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GregtechMetaTransformerHiAmp;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GT_Loader_Machines {
	public void run()
	{
		registerMachines();
	}

	private void registerMachines()
	{
		long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
				| GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
		
		        // ===================================================================================================
				// Input Hatches
				// ===================================================================================================
				
				CustomItemList.Hatch_Input_UEV.set(new GT_MetaTileEntity_Hatch_Input(12250, "hatch.input.tier.10", "Input Hatch (UEV)",10).getStackForm(1L));
				CustomItemList.Hatch_Input_UIV.set(new GT_MetaTileEntity_Hatch_Input(12251, "hatch.input.tier.11", "Input Hatch (UIV)",11).getStackForm(1L));
				CustomItemList.Hatch_Input_UMV.set(new GT_MetaTileEntity_Hatch_Input(12252, "hatch.input.tier.12", "Input Hatch (UMV)",12).getStackForm(1L));
				CustomItemList.Hatch_Input_UXV.set(new GT_MetaTileEntity_Hatch_Input(12253, "hatch.input.tier.13", "Input Hatch (UXV)",13).getStackForm(1L));
				CustomItemList.Hatch_Input_OPV.set(new GT_MetaTileEntity_Hatch_Input(12254, "hatch.input.tier.14", "Input Hatch (OpV)",14).getStackForm(1L));
				CustomItemList.Hatch_Input_MAX.set(new GT_MetaTileEntity_Hatch_Input(12255, "hatch.input.tier.15", "Input Hatch (MAX)",15).getStackForm(1L));


				// ===================================================================================================
				// Output Hatches
				// ===================================================================================================

				CustomItemList.Hatch_Output_UEV.set(new GT_MetaTileEntity_Hatch_Output(12256, "hatch.output.tier.10", "Output Hatch (UEV)",10).getStackForm(1L));
				CustomItemList.Hatch_Output_UIV.set(new GT_MetaTileEntity_Hatch_Output(12257, "hatch.output.tier.11", "Output Hatch (UIV)",11).getStackForm(1L));
				CustomItemList.Hatch_Output_UMV.set(new GT_MetaTileEntity_Hatch_Output(12258, "hatch.output.tier.12", "Output Hatch (UMV)",12).getStackForm(1L));
				CustomItemList.Hatch_Output_UXV.set(new GT_MetaTileEntity_Hatch_Output(12259, "hatch.output.tier.13", "Output Hatch (UXV)",13).getStackForm(1L));
				CustomItemList.Hatch_Output_OPV.set(new GT_MetaTileEntity_Hatch_Output(12260, "hatch.output.tier.14", "Output Hatch (OpV)",14).getStackForm(1L));
				CustomItemList.Hatch_Output_MAX.set(new GT_MetaTileEntity_Hatch_Output(12261, "hatch.output.tier.15", "Output Hatch (MAX)",15).getStackForm(1L));

				ItemStack[] inHatches = {
								CustomItemList.Hatch_Input_UEV.get(1),
								CustomItemList.Hatch_Input_UIV.get(1),
								CustomItemList.Hatch_Input_UMV.get(1),
								CustomItemList.Hatch_Input_UXV.get(1),
								CustomItemList.Hatch_Input_OPV.get(1),
								CustomItemList.Hatch_Input_MAX.get(1)
				};
				ItemStack[] outHatches = {
								CustomItemList.Hatch_Output_UEV.get(1),
								CustomItemList.Hatch_Output_UIV.get(1),
								CustomItemList.Hatch_Output_UMV.get(1),
								CustomItemList.Hatch_Output_UXV.get(1),
								CustomItemList.Hatch_Output_OPV.get(1),
								CustomItemList.Hatch_Output_MAX.get(1)
				};
				ItemStack[][] flInputs = new ItemStack[6][3];
				ItemStack[][] flInputs2 = new ItemStack[6][3];
				ItemStack[] tanks = {
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,142),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,143),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,144),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,120),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,121),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,122),
				};
				ItemStack[] hulls = {
						ItemList.Hull_UEV.get(1),
						ItemList.Hull_UIV.get(1),
						ItemList.Hull_UMV.get(1),
						ItemList.Hull_UXV.get(1),
						ItemList.Hull_OPV.get(1),
						ItemList.Hull_MAXV.get(1),
				};
				for (int i = 0; i < 6; i++) {
					flInputs[i]= new ItemStack[]{hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(1)};
					flInputs2[i]= new ItemStack[]{hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(2)};
				}
				//10-15 since MAX crashes., change to 16 somwhen the NEI handler is fixed and MAX is optainable
				for (int aTier = 10; aTier < 15; aTier++) {
					if (Loader.isModLoaded("bartworks"))
			        {
					GT_Values.RA.addAssemblerRecipe(flInputs[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
					GT_Values.RA.addAssemblerRecipe(flInputs2[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }else {
			        	GT_Values.RA.addAssemblerRecipe(flInputs[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
						GT_Values.RA.addAssemblerRecipe(flInputs2[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }
				}
				
				// ===================================================================================================
				// Input Buses
				// ===================================================================================================
				
				CustomItemList.Bus_Input_UEV.set(new GT_MetaTileEntity_Hatch_InputBus(12262, "bus.input.tier.10", "Input Bus (UEV)",10).getStackForm(1L));
				CustomItemList.Bus_Input_UIV.set(new GT_MetaTileEntity_Hatch_InputBus(12263, "bus.input.tier.11", "Input Bus (UIV)",11).getStackForm(1L));
				CustomItemList.Bus_Input_UMV.set(new GT_MetaTileEntity_Hatch_InputBus(12264, "bus.input.tier.12", "Input Bus (UMV)",12).getStackForm(1L));
				CustomItemList.Bus_Input_UXV.set(new GT_MetaTileEntity_Hatch_InputBus(12265, "bus.input.tier.13", "Input Bus (UXV)",13).getStackForm(1L));
				CustomItemList.Bus_Input_OPV.set(new GT_MetaTileEntity_Hatch_InputBus(12266, "bus.input.tier.14", "Input Bus (OpV)",14).getStackForm(1L));
				CustomItemList.Bus_Input_MAX.set(new GT_MetaTileEntity_Hatch_InputBus(12267, "bus.input.tier.15", "Input Bus (MAX)",15).getStackForm(1L));


				// ===================================================================================================
				// Output Buses
				// ===================================================================================================

				CustomItemList.Bus_Output_UEV.set(new GT_MetaTileEntity_Hatch_OutputBus(12268, "bus.output.tier.10", "Output Bus (UEV)",10).getStackForm(1L));
				CustomItemList.Bus_Output_UIV.set(new GT_MetaTileEntity_Hatch_OutputBus(12269, "bus.output.tier.11", "Output Bus (UIV)",11).getStackForm(1L));
				CustomItemList.Bus_Output_UMV.set(new GT_MetaTileEntity_Hatch_OutputBus(12270, "bus.output.tier.12", "Output Bus (UMV)",12).getStackForm(1L));
				CustomItemList.Bus_Output_UXV.set(new GT_MetaTileEntity_Hatch_OutputBus(12271, "bus.output.tier.13", "Output Bus (UXV)",13).getStackForm(1L));
				CustomItemList.Bus_Output_OPV.set(new GT_MetaTileEntity_Hatch_OutputBus(12272, "bus.output.tier.14", "Output Bus (OpV)",14).getStackForm(1L));
				CustomItemList.Bus_Output_MAX.set(new GT_MetaTileEntity_Hatch_OutputBus(12273, "bus.output.tier.15", "Output Bus (MAX)",15).getStackForm(1L));
				
				ItemStack[] inBuses = {
						CustomItemList.Bus_Input_UEV.get(1),
						CustomItemList.Bus_Input_UIV.get(1),
						CustomItemList.Bus_Input_UMV.get(1),
						CustomItemList.Bus_Input_UXV.get(1),
						CustomItemList.Bus_Input_OPV.get(1),
						CustomItemList.Bus_Input_MAX.get(1)
		        };
		        ItemStack[] outBuses = {
						CustomItemList.Bus_Output_UEV.get(1),
						CustomItemList.Bus_Output_UIV.get(1),
						CustomItemList.Bus_Output_UMV.get(1),
						CustomItemList.Bus_Output_UXV.get(1),
						CustomItemList.Bus_Output_OPV.get(1),
						CustomItemList.Bus_Output_MAX.get(1)
		        };
		        ItemStack[][] itInputs = new ItemStack[6][3];
		        ItemStack[][] itInputs2 = new ItemStack[6][3];
		        ItemStack[] chests = {
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,147),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,148),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,149),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,127),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,128),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,129),
		        };
		        for (int i = 0; i < 6; i++) {
			            itInputs[i]= new ItemStack[]{hulls[i].copy(), chests[i].copy(), GT_Utility.getIntegratedCircuit(1)};
			            itInputs2[i]= new ItemStack[]{hulls[i].copy(), chests[i].copy(), GT_Utility.getIntegratedCircuit(2)};
		        }
		        for (int aTier = 10; aTier < 15; aTier++) {
			            GT_Values.RA.addAssemblerRecipe(itInputs[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			            GT_Values.RA.addAssemblerRecipe(itInputs2[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
		        }
				
				
				
	}

}
