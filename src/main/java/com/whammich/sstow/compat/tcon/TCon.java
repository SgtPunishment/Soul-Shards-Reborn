package com.whammich.sstow.compat.tcon;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.crafting.Smeltery;

import com.whammich.sstow.utils.Register;

public class TCon {

	public static void MeltSoulium() {
		Smeltery.addMelting(Register.BlockMaterials, 0, 800, new FluidStack(Register.souliumFluid, TConstruct.blockLiquidValue));
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 2), 88, new FluidStack(Register.souliumFluid, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 1), 88, new FluidStack(Register.souliumFluid, TConstruct.nuggetLiquidValue));
	}
	
}
