package com.spartakcore.gthandler.tileentities.multi;

import java.util.ArrayList;

import com.spartakcore.gthandler.casings.GT_Container_CasingsSC;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.gui.GT_GUIContainer_MultiMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class GT_MetaTileEntity_Farm  extends GT_MetaTileEntity_MultiBlockBase {
	
	public GT_MetaTileEntity_Farm(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_Farm(String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_Farm(mName);
    }
    
    @Override
    public String[] getDescription() {
        return new String[]{
        	"Controller Block for the Multiblock Farm",
                "Industrial Tree producer",
                "Size(WxHxD): 5x5x5, Controller (Bottom center)",
                "3x1x3 of Farm Casings (At the center of the bottom layer)",
                "3x1x3 of Reinforced Glass (At the center of the Top layer)",
                "1x Input Hatch/Bus (Any bottom layer casing)",
                "1x Output Hatch/Bus (Any bottom layer casing)",
                "1x Maintenance Hatch (Any bottom layer casing)",
                "1x Energy Hatch (Any bottom layer casing)",
                "Solid Steel Casings for the rest"};
    }
    
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[16], new GT_RenderedTexture(aActive ? Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE : Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE)};
        }
        return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[16]};
    }
    
    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_MultiMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "PyrolyseOven.png");
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return aFacing > 1;
    }
    
    @Override
	public boolean checkRecipe(ItemStack aStack) {
		ArrayList<ItemStack> tInputList = getStoredInputs();
		int tInputList_sS = tInputList.size();
		for (int i = 0; i < tInputList_sS - 1; i++) {
			for (int j = i + 1; j < tInputList_sS; j++) {
				if (GT_Utility.areStacksEqual((ItemStack) tInputList.get(i), (ItemStack) tInputList.get(j))) {
					if (((ItemStack) tInputList.get(i)).stackSize >= ((ItemStack) tInputList.get(j)).stackSize) {
						tInputList.remove(j--);
						tInputList_sS = tInputList.size();
					} else {
						tInputList.remove(i--);
						tInputList_sS = tInputList.size();
						break;
					}
				}
			}
		}
		tInputList.add(mInventory[1]);
		ItemStack[] inputs = tInputList.toArray(new ItemStack[tInputList.size()]);

		ArrayList<FluidStack> tFluidList = getStoredFluids();
		int tFluidList_sS = tFluidList.size();
		for (int i = 0; i < tFluidList_sS - 1; i++) {
			for (int j = i + 1; j < tFluidList_sS; j++) {
				if (GT_Utility.areFluidsEqual(tFluidList.get(i), tFluidList.get(j))) {
					if (tFluidList.get(i).amount >= tFluidList.get(j).amount) {
						tFluidList.remove(j--);
						tFluidList_sS = tFluidList.size();
					} else {
						tFluidList.remove(i--);
						tFluidList_sS = tFluidList.size();
						break;
					}
				}
			}
		}
		FluidStack[] fluids = tFluidList.toArray(new FluidStack[tFluidList.size()]);

		if (inputs.length > 0 || fluids.length > 0) {
			long voltage = getMaxInputVoltage();
			byte tier = (byte) Math.max(1, GT_Utility.getTier(voltage));
			GT_Recipe recipe = GT_Recipe.GT_Recipe_Map.sFarmRecipes.findRecipe(getBaseMetaTileEntity(), false,
					false, gregtech.api.enums.GT_Values.V[tier], fluids, inputs);
			if (recipe != null && recipe.isRecipeInputEqual(true, fluids, inputs)) {
				this.mEfficiency = (10000 - (getIdealStatus() - getRepairStatus()) * 1000);
				this.mEfficiencyIncrease = 10000;

				int EUt = recipe.mEUt;
				int maxProgresstime = recipe.mDuration;

				while (EUt <= gregtech.api.enums.GT_Values.V[tier - 1] && maxProgresstime > 2) {
					EUt *= 4;
					maxProgresstime /= 4;
				}
				if (maxProgresstime < 2) {
					maxProgresstime = 2;
					EUt = recipe.mEUt * recipe.mDuration / 2;
				}

				this.mEUt = -EUt;
				this.mMaxProgresstime = maxProgresstime;
				mOutputItems = new ItemStack[recipe.mOutputs.length];
 		        for (int i = 0; i < recipe.mOutputs.length; i++) {
 		            if (getBaseMetaTileEntity().getRandomNumber(10000) < recipe.getOutputChance(i)) {
 		                this.mOutputItems[i] = recipe.getOutput(i);
 		            }
 		        }
				this.mOutputFluids = recipe.mFluidOutputs;
				this.updateSlots();
				return true;
			}
		}
		return false;
	}
	
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
    	int xDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetX*2;
    	int zDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetZ*2;
    	        for (int i = -2; i < 3; i++) {
    	            for (int j = -2; j < 3; j++) {
    	                for (int h = 0; h < 5; h++) {
    	                    IGregTechTileEntity tTileEntity = aBaseMetaTileEntity.getIGregTechTileEntityOffset(xDir + i, h, zDir + j);
    	                    if ((i != -2 && i != 2) && (j != -2 && j != 2)) {
    	                        if(h == 0){
    	                        	if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GT_Container_CasingsSC.sBlockCasingsSC) {
    	                                return false;
    	                            }
    	                            if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 3) {
    	                                return false;
    	                            }
    	                        } else if (h == 4) {
    	                            if (!aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j).getUnlocalizedName().equals("blockAlloyGlass")) {
    	                                return false;
    	                            }
    	                        }  else {// innen air
    	                            if (!aBaseMetaTileEntity.getAirOffset(xDir + i, h, zDir + j)) {
    	                                return false;
    	                            }
    	                        }    
    	                    }  else {
    	                    	if (h == 0) {
    	                            if ((!addMaintenanceToMachineList(tTileEntity, 16)) && (!addInputToMachineList(tTileEntity, 16)) && (!addOutputToMachineList(tTileEntity, 16)) && (!addEnergyInputToMachineList(tTileEntity, 16))) {
    	                                if ((xDir + i != 0) || (zDir + j != 0)) {
    	                                    if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings2) {
    	                                        return false;
    	                                    }
    	                                    if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 0) {
    	                                        return false;
    	                                    }
    	                                }
    	                            }
    	                        } else {
    	                            if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings2) {
    	                                return false;
    	                            }
    	                            if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 0) {
    	                                return false;
    	                            }
    	                        }
    	                    }
    	                }
    	            }
    	        }
    	        return true;
    	    }
    
    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }
    
    @Override
	public int getPollutionPerTick(ItemStack aStack) {
		return 0;
	}

	@Override
	public int getDamageToComponent(ItemStack aStack) {
		return 0;
	}

	@Override
	public boolean explodesOnComponentBreak(ItemStack aStack) {
		return false;
	}

}
