package com.whammich.sstow.compat.baubles;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Baubles {
	public static Item animusBauble = new BaubleAnimus();
	public static Item conservoBauble = new BaubleConservo();
	public static Item baubleGems = new ItemGems();
	public static Item baubleSockets = new ItemSockets();
	
	public static void registerBaubles() {
		GameRegistry.registerItem(animusBauble, animusBauble.getUnlocalizedName());
		GameRegistry.registerItem(conservoBauble, conservoBauble.getUnlocalizedName());
		GameRegistry.registerItem(baubleGems, baubleGems.getUnlocalizedName());
		GameRegistry.registerItem(baubleSockets, baubleSockets.getUnlocalizedName());
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baubleSockets, 1, 0), " N ", "NIN", "INI", 'N', 
				"nuggetSoulium", 'I', "ingotSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baubleSockets, 1, 1), "INI", "NIN", " N ", 'N', 
				"nuggetSoulium", 'I', "ingotSoulium"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(animusBauble), "SSS", "S S", " A ", 'A', 
				new ItemStack(Baubles.baubleGems, 1, 1), 'S', Items.string));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(conservoBauble), "SSS", "S S", " C ", 'C', 
				new ItemStack(Baubles.baubleGems, 1, 3), 'S', Items.string));
		
	}
}