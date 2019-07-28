package com.spartakcore.gthandler.tileentities;

import gregtech.api.enums.Dyes;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.objects.GT_SidedTexture;

import static gregtech.api.enums.Dyes.MACHINE_METAL;
import static gregtech.api.enums.Textures.BlockIcons.*;

public class CustomTextures {
	private static IIconContainer MACHINE_DE_SIDE = new CustomIcon("iconsets/MACHINE_DE_SIDE");
	private static IIconContainer MACHINE_DE_TOP = new CustomIcon("iconsets/MACHINE_DE_TOP");
	private static IIconContainer MACHINE_DE_BOTTOM = new CustomIcon("iconsets/MACHINE_DE_BOTTOM");
	
	public static IIconContainer[] 
			MACHINECASINGS_SIDE_SC = new IIconContainer[]{
					MACHINE_DE_SIDE,
			}, MACHINECASINGS_TOP_SC = new IIconContainer[]{
					MACHINE_DE_TOP, 
			}, MACHINECASINGS_BOTTOM_SC = new IIconContainer[]{
					MACHINE_DE_BOTTOM, 
			};
	
	public static ITexture[][] MACHINE_CASINGS_SC = new ITexture[16][17];

    public CustomTextures(){
        for (byte i = 0; i < MACHINE_CASINGS_SC.length; i++) {
            for (byte j = 0; j < MACHINE_CASINGS_SC[i].length; j++) {
                MACHINE_CASINGS_SC[i][j] = new GT_SidedTexture(MACHINECASINGS_BOTTOM_SC[i], MACHINECASINGS_TOP_SC[i], MACHINECASINGS_SIDE_SC[i], Dyes.getModulation(j - 1, MACHINE_METAL.mRGBa));
            }
        }
        MACHINE_CASINGS=MACHINE_CASINGS_SC;
    }

}
