package com.spartakcore.gthandler;

import java.lang.reflect.Field;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class GT_MachineRecipeLoader implements Runnable{
	@Override
    public void run(){
		
		// --- GalaxySpace
        if (Loader.isModLoaded("GalaxySpace"))
        {
        	for (byte i = 0; i < 6; ++i)
        	GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 64L, i), com.spartakcore.item.ItemList.TCetiESeaweedExtract.getIS(), 3600, 262144);
        	
        	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[]{ItemList.Circuit_Chip_RPico.get(1L),Materials.MysteriousCrystal.getDust(2),GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.InfinityCatalyst,1L).copy().splitStack(0), com.spartakcore.item.ItemList.TCetiESeaweedExtract.getIS(1)},new FluidStack[]{Materials.Neutronium.getMolten(100L)},new FluidStack[]{GT_Values.NF},new ItemStack[]{ItemList.Circuit_Chip_Pico.get(1L)},3000,(int)(GT_Values.V[9]-(GT_Values.V[9]/10)));
        	
        }else {
        	
        	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[]{ItemList.Circuit_Chip_RPico.get(1L),Materials.MysteriousCrystal.getDust(2),GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.InfinityCatalyst,1L).copy().splitStack(0),Materials.AlienBiomass.getDust(1)},new FluidStack[]{Materials.Neutronium.getFluid(100L)},new FluidStack[]{GT_Values.NF},new ItemStack[]{ItemList.Circuit_Chip_Pico.get(1L)},3000,(int)(GT_Values.V[9]-(GT_Values.V[9]/10)));
        }
        	
		//Rocket Circuits
        final int[] EUperRecipe = new int[]{
                480,                //t2 = HV
                1920,                //t3 = EV
                7680,                //t4 = IV
                30720,                //t5 = LuV
                122880,                //t6 = ZPM
                500000,                //t7 = UV
                2000000,                //t8 = UHV
        };

        ItemStack[] RocketMaterial = new ItemStack[8];
        RocketMaterial[0] = GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L);
        RocketMaterial[1] = GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3);
        RocketMaterial[2] = GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L);
        RocketMaterial[3] = CustomItemList.HeavyDutyPlateTier4.get(1L);
        RocketMaterial[4] = CustomItemList.HeavyDutyPlateTier5.get(1L);
        RocketMaterial[5] = CustomItemList.HeavyDutyPlateTier6.get(1L);
        RocketMaterial[6] = CustomItemList.HeavyDutyPlateTier7.get(1L);
        RocketMaterial[7] = CustomItemList.HeavyDutyPlateTier8.get(1L);

        ItemStack[] RocketChip = new ItemStack[8];
        RocketChip[0] = CustomItemList.SchematicsTier1.get(1L);
        RocketChip[1] = CustomItemList.SchematicsTier2.get(1L);
        RocketChip[2] = CustomItemList.SchematicsTier3.get(1L);
        RocketChip[3] = CustomItemList.SchematicsTier4.get(1L);
        RocketChip[4] = CustomItemList.SchematicsTier5.get(1L);
        RocketChip[5] = CustomItemList.SchematicsTier6.get(1L);
        RocketChip[6] = CustomItemList.SchematicsTier7.get(1L);
        RocketChip[7] = CustomItemList.SchematicsTier8.get(1L);

        ItemStack[] ExtraChips = new ItemStack[3];
        ExtraChips[0] = CustomItemList.SchematicsMoonBuggy.get(1L);
        ExtraChips[1] = CustomItemList.SchematicsCargoRocket.get(1L);
        ExtraChips[2] = CustomItemList.SchematicsAstroMiner.get(1L);
        
		for (Materials tMat : Materials.values()) {//TODO dream things using soldering go in here!
            if (tMat.mStandardMoltenFluid != null && tMat.contains(SubTag.SOLDERING_MATERIAL) && !(GregTech_API.mUseOnlyGoodSolderingMaterials && !tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD))) {
                int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1 : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

              //Rocket Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Data.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);

                for (byte i=2;i<9;++i) {
                    ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                    DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i ));
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Elite.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Elitenanocomputer.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Quantumcomputer.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Crystalprocessor.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                    }

                for (byte i=0;i<3;++i) {
                	ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                    DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i+100)));
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Quantumprocessor.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Data.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Nanocomputer.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
                }
                
		if(Loader.isModLoaded("OpenComputers")) {
			//cable
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RedstoneAlloy, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
            //keyboard
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.stone_button, 64), new ItemStack(Blocks.stone_button, 40), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), 200, 64);
            //case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case1", 1, 0), 200, 120);
            //case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case2", 1, 0), 200, 256);
            //case 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2), ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case3", 1, 0), 200, 480);
            //micro case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), 200, 120);
            //mirco case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), 200, 256);
            //drone case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), ItemList.Electric_Motor_HV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 83), 300, 256);
            //drone case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 1L), ItemList.Electric_Motor_EV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 87), 300, 480);
            //Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), 200, 64);
            //floppy
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 4), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), 200, 64);

            //floppys w NBT
            make_floppy("OpenOS (Operating System)","openos", 2, 1);
            make_floppy("Plan9k (Operating System)","plan9k", 1, 2);
            make_floppy("Network (Network Stack)","network", 10, 3);
            make_floppy("Data Card Software","data", 9, 4);
            make_floppy("OpenLoader (Boot Loader)","openloader", 13, 5);
            make_floppy("Builder","builder", 11, 6);
            make_floppy("Generator","generator", 5, 7);
            make_floppy("OPPM (Package Manager)","oppm", 6, 8);
            make_floppy("Digger","dig", 3, 9);
            make_floppy("Mazer","maze", 14, 10);
            make_floppy("OpenIRC (IRC Client)","irc", 12, 11);

            //HDD 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), 300, 120);
            //HDD 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 2), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), 300, 256);
            //HDD 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 38), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), 300, 480);
            //disk
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Cobalt.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), 200, 120);
            //rack
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L),  GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), new ItemStack(Blocks.iron_bars, 2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "rack", 1L, 0), 200, 256);
            //adapter block
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), 200, 120);
            //assembler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_LV.get(3L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "assembler", 1L, 0), 200, 256);
            //disassembler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_HV.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "disassembler", 1L, 0), 200, 256);
            //capacitor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(2L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(2L), ItemList.Circuit_Parts_Transistor.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), 200, 120);
            //charger
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("IC2", "blockChargepad", 2L, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0), 200, 256);
            //diskDrive
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), 200, 120);
            //diskDriver
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), new ItemStack(Blocks.iron_bars, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 109), 200, 480);
            //geolyzer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), ItemList.Sensor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), 200, 120);
            //hologram1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), GT_Utility.getIntegratedCircuit(10)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram1", 1L, 0), 200, 120);
            //hologram2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Emerald, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L, 0), 200, 256);
            //motionSensor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), new ItemStack(Blocks.daylight_detector, 2, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "motionSensor", 1L, 0), 200, 120);
            //netSplitter
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 3L, 0), ItemList.Electric_Piston_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "netSplitter", 1L, 0), 200, 64);
            //printer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_HV_Printer.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "printer", 1L, 0), 200, 256);
            //powerConverter
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_HV_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerConverter", 1L, 0), 200, 256);
            //powerDistributor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), 200, 256);
            //raid
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "raid", 1L, 0), 200, 256);
            //redstone
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), ItemList.Cover_ActivityDetector.get(1L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "redstone", 1L, 0), 200, 120);
            //relay
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), 200, 120);
            //transposer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Automation_ChestBuffer_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "transposer", 2L, 0), 400, 120);
            //waypoint
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "waypoint", 1L, 0), 200, 64);
            //cartridge empty
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), 200, 64);
            //cartridge full
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32420), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32425), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32427)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 95), 200, 64);
            //Interweb
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1), new ItemStack(Items.string, 8, 0), GT_Utility.getIntegratedCircuit(2)}, Materials.Glue.getFluid(576L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), 200, 64);
            //Linked Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 2L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_Utility.getIntegratedCircuit(1)}, Materials.EnderEye.getMolten(288L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), 400, 480);
            //Manual
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.book, 1, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getFluid(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 98), 100, 30);
            //Nano Machine
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 42), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 107), 400, 256);
            //Server Tier 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case1", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 45), 400, 256);
            //Server Tier 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 38), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 46), 400, 480);
            //Server Tier 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case3", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 39), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 40), 400, 1024);
             //Tablet Case Tier 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 74), 400, 120);
            //Tablet Case Tier 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 92), 400, 256);
            //remote Monitor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 41), 400, 120);
            //Terminal Server
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 108), 400, 480);
            //Block of Chamelium
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), GT_ModHandler.getModItem("OpenComputers", "chameliumBlock", 1L, 0), 300, 2);
            //Chamelium
            GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 4L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), 200, 120);
            
            //display t1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
            //display t2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
            //display t3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_Transistor.get(8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
            //ALU
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_ILC.get(16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27), 400, 64);
            //CU
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 200, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 200, 30);
            //anylyser
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(1L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
            //CPU 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), 200, 120);
            //CPU 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 12L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 200, 120);
            //CPU 3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), 200, 120);
            //Graphics Card 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8), 400, 120);
            //Graphics Card 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), 400, 256);
            //Graphics Card 3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), 400, 480);
            //Internet Crad
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lightbutton", 1L, 14), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44), 400, 480);
            //APU T1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101), 200, 256);
            //APU T2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 64L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102), 200, 480);
            //EEPROM
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(6L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_TransistorSMD.get(6L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
            make_lua_bios();
            //RAM 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 250, 64);
            //RAM 1.5
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), 250, 120);
            //RAM 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), 250, 256);
            //RAM 2.5
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), 250, 480);
            //RAM 3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), 250, 1024);
            //RAM 3.5
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39), 250, 1920);
            //Circuit 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 300, 120);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 300, 120);
            //Circuit 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 300, 256);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_TransistorSMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 300, 256);
            //Circuit 3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_Transistor.get(16L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 300, 480);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_TransistorSMD.get(16L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 300, 480);
            //network card
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), 200, 120);
            //wlan card1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Emitter_LV.get(1L), ItemList.Sensor_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 200, 120);
            //wlan card2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Emitter_HV.get(1L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), 200, 256);
            //World sensor card
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89), 200, 120);
            //redstone card 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(4L), new ItemStack(Blocks.redstone_torch, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 200, 120);
            //redstone card 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(16L), new ItemStack(Blocks.redstone_torch, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12), 200, 256);
            //data card 1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4, 27), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), 300, 120);
            //data card 2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1, 29), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105), 300, 156);
            //data card 3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1, 42), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106), 300, 480);
            //angel upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49), 250, 256);
            //hover upgrade Tier 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Electric_Motor_MV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99), 250, 256);
            //hover upgrade Tier 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Electric_Motor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), 250, 480);
            //battery upgrade 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
            //battery upgrade 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
            //battery upgrade 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
            //chunkloader upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("Railcraft", "machine.alpha", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 62), 250, 256);
            //inventory upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), 300, 120);
            //inventory controller upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), 300, 256);
            //tank upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), 300, 120);
            //tank controller upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), 300, 256);
            //card container 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57), 250, 120);
            //card container 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58), 250, 256);
            //card container 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59), 250, 480);
            //upgrade container 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54), 250, 120);
            //upgrade container 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55), 250, 256);
            //upgrade container 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56), 250, 480);
            //component bus t1
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), 250, 120);
            //component bus t2
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), 250, 256);
            //component bus t3
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), 250, 480);
            //database upgrade 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78), 250, 120);
            //database upgrade 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79), 250, 256);
            //database upgrade 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80), 250, 480);
            //experience upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52), 250, 120);
            //crafting component
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Cover_Crafting.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14), 250, 120);
            //generator upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockStirlingGenerator", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15), 250, 120);
            //leash upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), new ItemStack(Items.lead, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85), 250, 120);
            //mfu upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112), 250, 480);
            //navigation upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), new ItemStack(Items.compass, 1), new ItemStack(Items.filled_map, 1), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36), 250, 256);
            //piston upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75), 250, 120);
            //sing IO upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), ItemList.Dye_SquidInk.get(1L), new ItemStack(Items.sign, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35), 250, 120);
            //solar upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Cover_SolarPanel_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), 250, 256);
            //tractor beam upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Electric_Piston_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67), 250, 480);
            //trading upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 3L), ItemList.Electric_Piston_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110), 250, 256);
            //hover Boots
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), ItemList.Electric_Piston_MV.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, GT_Values.W), 350, 256);
		}
            }
		}
	}
	
	private final static boolean make_floppy(String displayname,String name,int color, int circuit) {
        ItemStack floppy = GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4);
        NBTTagCompound tag = new NBTTagCompound(),
        			   subtag = new NBTTagCompound();
        subtag.setString("Name", displayname);
        tag.setTag("display", subtag);
        subtag = new NBTTagCompound();
        subtag.setString("oc:fs.label", name);
        tag.setTag("oc:data", subtag);
        tag.setInteger("oc:color", color);
        tag.setString("oc:lootFactory","OpenComputers:"+name);
        floppy.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), GT_Utility.getIntegratedCircuit(circuit), floppy, 200, 120);
    }

    private final static boolean make_lua_bios() {
    	ItemStack lua = GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0);
    	NBTTagCompound tag = new NBTTagCompound(),
  		   			   subtag = new NBTTagCompound();
    	subtag.setString("oc:label", "EEPROM (Lua Bios)");
    	subtag.setBoolean("oc:readonly", false);
        final byte[] b = {
        		108, 111, 99, 97, 108, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107,
        		101, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 105, 110, 118, 111, 107, 101, 10, 102, 117,
        		110, 99, 116, 105, 111, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114,
        		101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 10, 32, 32, 108, 111, 99, 97,
        		108, 32, 114, 101, 115, 117, 108, 116, 32, 61, 32, 116, 97, 98, 108, 101, 46, 112, 97, 99, 107, 40, 112, 99,
        		97, 108, 108, 40, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107, 101, 44, 32, 97,
        		100, 100, 114, 101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 41, 10, 32, 32,
        		105, 102, 32, 110, 111, 116, 32, 114, 101, 115, 117, 108, 116, 91, 49, 93, 32, 116, 104, 101, 110, 10, 32, 32,
        		32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 115, 117, 108, 116, 91, 50, 93, 10,
        		32, 32, 101, 108, 115, 101, 10, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 116, 97, 98, 108, 101, 46,
        		117, 110, 112, 97, 99, 107, 40, 114, 101, 115, 117, 108, 116, 44, 32, 50, 44, 32, 114, 101, 115, 117, 108, 116,
        		46, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 10, 45, 45, 32, 98, 97, 99, 107, 119, 97, 114,
        		100, 115, 32, 99, 111, 109, 112, 97, 116, 105, 98, 105, 108, 105, 116, 121, 44, 32, 109, 97, 121, 32, 114, 101,
        		109, 111, 118, 101, 32, 108, 97, 116, 101, 114, 10, 108, 111, 99, 97, 108, 32, 101, 101, 112, 114, 111, 109, 32,
        		61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 101, 101, 112, 114, 111, 109,
        		34, 41, 40, 41, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100,
        		114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110, 40, 41, 10, 32, 32, 114, 101, 116, 117,
        		114, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34,
        		103, 101, 116, 68, 97, 116, 97, 34, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 115,
        		101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110,
        		40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 98, 111, 111, 116, 95,
        		105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34, 115, 101, 116, 68, 97, 116, 97, 34,
        		44, 32, 97, 100, 100, 114, 101, 115, 115, 41, 10, 101, 110, 100, 10, 10, 100, 111, 10, 32, 32, 108, 111, 99, 97,
        		108, 32, 115, 99, 114, 101, 101, 110, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115,
        		116, 40, 34, 115, 99, 114, 101, 101, 110, 34, 41, 40, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 103, 112, 117,
        		32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 103, 112, 117, 34, 41,
        		40, 41, 10, 32, 32, 105, 102, 32, 103, 112, 117, 32, 97, 110, 100, 32, 115, 99, 114, 101, 101, 110, 32, 116, 104,
        		101, 110, 10, 32, 32, 32, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 103, 112, 117, 44, 32, 34,
        		98, 105, 110, 100, 34, 44, 32, 115, 99, 114, 101, 101, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10,
        		108, 111, 99, 97, 108, 32, 102, 117, 110, 99, 116, 105, 111, 110, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114,
        		111, 109, 40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 104, 97, 110, 100, 108,
        		101, 44, 32, 114, 101, 97, 115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97,
        		100, 100, 114, 101, 115, 115, 44, 32, 34, 111, 112, 101, 110, 34, 44, 32, 34, 47, 105, 110, 105, 116, 46, 108, 117,
        		97, 34, 41, 10, 32, 32, 105, 102, 32, 110, 111, 116, 32, 104, 97, 110, 100, 108, 101, 32, 116, 104, 101, 110, 10,
        		32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32,
        		101, 110, 100, 10, 32, 32, 108, 111, 99, 97, 108, 32, 98, 117, 102, 102, 101, 114, 32, 61, 32, 34, 34, 10, 32, 32,
        		114, 101, 112, 101, 97, 116, 10, 32, 32, 32, 32, 108, 111, 99, 97, 108, 32, 100, 97, 116, 97, 44, 32, 114, 101, 97,
        		115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115,
        		44, 32, 34, 114, 101, 97, 100, 34, 44, 32, 104, 97, 110, 100, 108, 101, 44, 32, 109, 97, 116, 104, 46, 104, 117, 103,
        		101, 41, 10, 32, 32, 32, 32, 105, 102, 32, 110, 111, 116, 32, 100, 97, 116, 97, 32, 97, 110, 100, 32, 114, 101, 97,
        		115, 111, 110, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108,
        		44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32, 32, 32, 101, 110, 100, 10, 32, 32, 32, 32, 98, 117, 102, 102, 101,
        		114, 32, 61, 32, 98, 117, 102, 102, 101, 114, 32, 46, 46, 32, 40, 100, 97, 116, 97, 32, 111, 114, 32, 34, 34, 41, 10,
        		32, 32, 117, 110, 116, 105, 108, 32, 110, 111, 116, 32, 100, 97, 116, 97, 10, 32, 32, 98, 111, 111, 116, 95, 105, 110,
        		118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 34, 99, 108, 111, 115, 101, 34, 44, 32, 104, 97, 110,
        		100, 108, 101, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 108, 111, 97, 100, 40, 98, 117, 102, 102, 101, 114, 44,
        		32, 34, 61, 105, 110, 105, 116, 34, 41, 10, 101, 110, 100, 10, 108, 111, 99, 97, 108, 32, 105, 110, 105, 116, 44, 32,
        		114, 101, 97, 115, 111, 110, 10, 105, 102, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111,
        		116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 32, 116, 104, 101, 110, 10, 32, 32, 105, 110, 105, 116, 44, 32, 114, 101,
        		97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 99, 111, 109, 112, 117, 116, 101,
        		114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 41, 10, 101, 110, 100, 10, 105, 102,
        		32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46,
        		115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 10, 32, 32, 102, 111, 114, 32, 97, 100, 100,
        		114, 101, 115, 115, 32, 105, 110, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 102,
        		105, 108, 101, 115, 121, 115, 116, 101, 109, 34, 41, 32, 100, 111, 10, 32, 32, 32, 32, 105, 110, 105, 116, 44, 32, 114,
        		101, 97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 97, 100, 100, 114, 101, 115,
        		115, 41, 10, 32, 32, 32, 32, 105, 102, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 99,
        		111, 109, 112, 117, 116, 101, 114, 46, 115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 97, 100,
        		100, 114, 101, 115, 115, 41, 10, 32, 32, 32, 32, 32, 32, 98, 114, 101, 97, 107, 10, 32, 32, 32, 32, 101, 110, 100, 10,
        		32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 105, 102, 32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101,
        		110, 10, 32, 32, 101, 114, 114, 111, 114, 40, 34, 110, 111, 32, 98, 111, 111, 116, 97, 98, 108, 101, 32, 109, 101, 100,
        		105, 117, 109, 32, 102, 111, 117, 110, 100, 34, 32, 46, 46, 32, 40, 114, 101, 97, 115, 111, 110, 32, 97, 110, 100, 32,
        		40, 34, 58, 32, 34, 32, 46, 46, 32, 116, 111, 115, 116, 114, 105, 110, 103, 40, 114, 101, 97, 115, 111, 110, 41, 41, 32,
        		111, 114, 32, 34, 34, 41, 44, 32, 48, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 98, 101, 101,
        		112, 40, 49, 48, 48, 48, 44, 32, 48, 46, 50, 41, 10, 105, 110, 105, 116, 40, 41
        		};
        subtag.setByteArray("oc:eeprom", b);
        tag.setTag("oc:data", subtag);
        lua.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),GT_Utility.getIntegratedCircuit(1),lua,200,120);
    }
}