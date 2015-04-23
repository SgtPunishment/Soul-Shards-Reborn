package com.whammich.sstow.compat.tcon;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;

import com.whammich.sstow.utils.Register;

public class TCon {

	public static void MeltSoulium() {
		
		// Block
		Smeltery.addMelting(Register.BlockMaterials, 0, 800, new FluidStack(Register.souliumFluid, TConstruct.blockLiquidValue));
		
		// Ingot
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 2),
				Register.BlockMaterials, 0, 88, new FluidStack(Register.souliumFluid, TConstruct.ingotLiquidValue));
		
		// Nugget
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 1),
				Register.BlockMaterials, 0, 88, new FluidStack(Register.souliumFluid, TConstruct.nuggetLiquidValue));
	}

	@SuppressWarnings("static-access")
	public static void CastSoulium() {
		LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
		LiquidCasting basinCasting = TConstructRegistry.instance.getBasinCasting();
		
		// Ingot
		tableCasting.addCastingRecipe(new ItemStack(Register.ItemMaterials, 1, 2), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 0), false, 50);
		
		// Nugget
		tableCasting.addCastingRecipe(new ItemStack(Register.ItemMaterials, 1, 1), new FluidStack(Register.souliumFluid,
				TConstruct.nuggetLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 27), false, 50);

		// Block
		basinCasting.addCastingRecipe(new ItemStack(Register.BlockMaterials, 1, 0), new FluidStack(Register.souliumFluid,
				TConstruct.blockLiquidValue), 50);
	}

}
