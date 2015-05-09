package com.whammich.sstow.compat.baubles;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Baubles {
	public static Item animusBauble = new BaubleAnimus();
	public static Item conservoBauble = new BaubleConservo();
	public static Item baubleGems = new ItemGems();
	
	public static void registerBaubles() {
		GameRegistry.registerItem(animusBauble, animusBauble.getUnlocalizedName());
		GameRegistry.registerItem(conservoBauble, conservoBauble.getUnlocalizedName());
		GameRegistry.registerItem(baubleGems, baubleGems.getUnlocalizedName());
	}
}
