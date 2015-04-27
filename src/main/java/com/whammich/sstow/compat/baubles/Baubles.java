package com.whammich.sstow.compat.baubles;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Baubles {
	public static Item PhylacteryCrystal = new BaublePhylactery();
	public static void registerBaubles() {
		GameRegistry.registerItem(PhylacteryCrystal, PhylacteryCrystal.getUnlocalizedName());
	}
}
