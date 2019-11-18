package com.spartakcore.gtppHandler;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.material.ELEMENT;
import gtPlusPlus.core.material.Material;

public class GTPPRecipeLoader implements Runnable {
	
	private static final String aTextWire1 = "wire."; private static final String aTextCable1 = "cable."; private static final String aTextWire2 = " Wire"; private static final String aTextCable2 = " Cable";
    private final static String aTextPlate = "PPP"; private final static String aTextPlateWrench = "PwP"; private final static String aTextPlateMotor = "PMP"; private final static String aTextCableHull = "CMC";
    private final static String aTextWireHull = "WMW"; private final static String aTextWireChest = "WTW"; private final static String aTextWireCoil = "WCW"; private final static String aTextMotorWire = "EWE";
    private final static String aTextWirePump = "WPW";
    public final static String imagination=EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.";
    private final static long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
    private final static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | bits;
	
    private final static boolean aBoolConst_0 = false;
	private final static Boolean isNEILoaded = Loader.isModLoaded("NotEnoughItems");
	
	public static String plateHastelloyC276= "plateHastelloyC276";
	public static String plateHastelloyN= "plateHastelloyN";
	public static String plateLafiumCompound= "plateLafiumCompound";
	public static String plateCinobiteA243= "plateCinobiteA243";
	
	@Override
    public void run() {

        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("ender"), 250), new ItemStack(Items.ender_pearl, 1, 0), 100, 30);
        
        //MK4
        GT_Values.RA.addFusionReactorRecipe(Materials.Plutonium241.getMolten(144), Materials.Helium.getGas(1000), ELEMENT.getInstance().CURIUM.getFluid(144), 96, 98304, 500000000);
        GT_Values.RA.addFusionReactorRecipe(ELEMENT.getInstance().CURIUM.getFluid(144), Materials.Helium.getPlasma(144), ELEMENT.getInstance().CALIFORNIUM.getFluid(144), 128, 196608, 750000000);
        //GT_Values.RA.addFusionReactorRecipe(Materials.Plutonium241.getMolten(144), Materials.Calcium.getPlasma(144), Materials.Flerovium.getMolten(144), 160, 196608, 1000000000);

        //Casing
        if (GT_Mod.gregtechproxy.mGTPlusPlusHard) {
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_IV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', "plateHastelloyC276"});
            GT_Values.RA.addAssemblerRecipe(ALLOY.HASTELLOY_C276.getPlate(8), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_IV.get(1L, new Object[0]), 50, 16);
            if (Loader.isModLoaded("bartworks")){
        }else {
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_LuV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', "plateHastelloyN"});
            GT_Values.RA.addAssemblerRecipe(ALLOY.HASTELLOY_N.getPlate(8), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_LuV.get(1L, new Object[0]), 50, 16);
            }
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_ZPM.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', "plateLafiumCompound"});
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_UV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', "plateCinobiteA243"});
            GT_Values.RA.addAssemblerRecipe(ALLOY.LAFIUM.getPlate(8), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_ZPM.get(1L, new Object[0]), 50, 16);
            GT_Values.RA.addAssemblerRecipe(ALLOY.CINOBITE.getPlate(8), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_UV.get(1L, new Object[0]), 50, 16);
        }else {
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_IV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.TungstenSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_LuV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Chrome)});
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_ZPM.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Iridium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Casing_UV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Osmium)});
            GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_IV.get(1L, new Object[0]), 50, 16);
            GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_LuV.get(1L, new Object[0]), 50, 16);
            GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_ZPM.get(1L, new Object[0]), 50, 16);
            GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), ItemList.Casing_UV.get(1L, new Object[0]), 50, 16);
        }
        
        
        
        
    }
}