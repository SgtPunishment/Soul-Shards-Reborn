package com.whammich.sstow.compat.tcon;

import static net.minecraft.util.EnumChatFormatting.DARK_PURPLE;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;
import tconstruct.util.config.PHConstruct;

import com.whammich.sstow.utils.Register;

public class TCon {

	public static void registerTCon() {
		Melting();
		Casting();
		Tools();
		ToolParts();
		Modifiers();
	}
	
	public static void Tools() {
		TConstructRegistry.addToolMaterial(19, "Soulium", 3, 650, 800, 3, 1.50F, 2, 0f, DARK_PURPLE.toString(), 0x4D048A);
		
	}
	
	public static void ToolParts() {
		TConstructRegistry.addDefaultToolPartMaterial(19);
		if(PHConstruct.craftMetalTools) {
            TConstructRegistry.addDefaultShardMaterial(19);
        }
	}
	
	public static void Melting() {
		
		// Block
		Smeltery.addMelting(Register.BlockMaterials, 0, 800, new FluidStack(Register.souliumFluid, TConstruct.blockLiquidValue));
		
		// Ingot
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 2),
				Register.BlockMaterials, 0, 88, new FluidStack(Register.souliumFluid, TConstruct.ingotLiquidValue));
		
		// Nugget
		Smeltery.addMelting(new ItemStack(Register.ItemMaterials, 1, 1),
				Register.BlockMaterials, 0, 88, new FluidStack(Register.souliumFluid, TConstruct.nuggetLiquidValue));
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public static void Casting() {
		LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
		LiquidCasting basinCasting = TConstructRegistry.instance.getBasinCasting();
		
		// Materials
		// Ingot
		tableCasting.addCastingRecipe(new ItemStack(Register.ItemMaterials, 1, 2), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 0), false, 50);
		
		// Nugget
		tableCasting.addCastingRecipe(new ItemStack(Register.ItemMaterials, 1, 1), new FluidStack(Register.souliumFluid,
				TConstruct.nuggetLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 27), false, 50);

		// Block
		basinCasting.addCastingRecipe(new ItemStack(Register.BlockMaterials, 1, 0), new FluidStack(Register.souliumFluid,
				TConstruct.blockLiquidValue), 50);
		
		// Tool Parts
		// Rod
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.toolRod, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 1), false, 50);
		
		// Pickaxe
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.pickaxeHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 2), false, 50);
		
		// Shovel
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.shovelHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 3), false, 50);
		
		// Hatchet
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.hatchetHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 4), false, 50);
		
		// Sword Blade
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.swordBlade, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 5), false, 50);
		
		// Wide Guard
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.wideGuard, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 6), false, 50);
		
		// Hand Guard
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 7), false, 50);
		
		// Crossbar
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.crossbar, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 8), false, 50);
		
		// Binding
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.binding, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 9), false, 50);
		
		// Frying Pan
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.frypanHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 10), false, 50);
		
		// Battle Sign
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.signHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 11), false, 50);
		
		// Knife Blade
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.knifeBlade, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 12), false, 50);
		
		// Chisel
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.chiselHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 13), false, 50);
		
		// Tough Rod
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.toughRod, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 3), new ItemStack(TinkerSmeltery.metalPattern, 1, 14), false, 50);
		
		// Tough Binding
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.toughBinding, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 3), new ItemStack(TinkerSmeltery.metalPattern, 1, 15), false, 50);
		
		// Large Plate
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.largePlate, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 16), false, 50);
		
		// Broad Axe
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.broadAxeHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 17), false, 50);
		
		// Scythe
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.scytheBlade, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 18), false, 50);
		
		// Excavator
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.excavatorHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 19), false, 50);
		
		// Large Sword Blade
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.largeSwordBlade, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 20), false, 50);
		
		// Hammer
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.hammerHead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 21), false, 50);
		
		// Full Guard
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.fullGuard, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue * 3), new ItemStack(TinkerSmeltery.metalPattern, 1, 22), false, 50);
		
//		// Unknown
//		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, 19), new FluidStack(Register.souliumFluid,
//				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 23), false, 50);
//		
//		// Unknown
//		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, 19), new FluidStack(Register.souliumFluid,
//				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 24), false, 50);
		
		// Arrow Head
		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.arrowhead, 1, 19), new FluidStack(Register.souliumFluid,
				TConstruct.ingotLiquidValue), new ItemStack(TinkerSmeltery.metalPattern, 1, 25), false, 50);
		
//		// Gem
//		tableCasting.addCastingRecipe(new ItemStack(TinkerTools.arrowhead, 1, 19), new FluidStack(Register.souliumFluid,
//				TConstruct.ingotLiquidValue / 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 26), false, 50);
		
		
	}

	public static void Modifiers() {
		ModifyBuilder.registerModifier(new ShardMod(new ItemStack[] { 
				new ItemStack(Register.ItemShardSoul) }, 52, "Soul Stealer", "\u00A75", StatCollector.translateToLocal("modifier.tool.shard")));
	}
	
}
