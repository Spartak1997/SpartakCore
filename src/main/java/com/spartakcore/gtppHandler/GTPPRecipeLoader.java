package com.spartakcore.gtppHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gtPlusPlus.core.material.ELEMENT;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class GTPPRecipeLoader implements Runnable {
    @Override
    public void run() {

        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("ender"), 250), new ItemStack(Items.ender_pearl, 1, 0), 100, 30);
        
        //MK4
        GT_Values.RA.addFusionReactorRecipe(Materials.Plutonium241.getMolten(144), Materials.Helium.getGas(1000), ELEMENT.getInstance().CURIUM.getFluid(144), 96, 98304, 500000000);
        GT_Values.RA.addFusionReactorRecipe(ELEMENT.getInstance().CURIUM.getFluid(144), Materials.Helium.getPlasma(144), ELEMENT.getInstance().CALIFORNIUM.getFluid(144), 128, 196608, 750000000);
        //GT_Values.RA.addFusionReactorRecipe(Materials.Plutonium241.getMolten(144), Materials.Calcium.getPlasma(144), Materials.Flerovium.getMolten(144), 160, 196608, 1000000000);

    }
}