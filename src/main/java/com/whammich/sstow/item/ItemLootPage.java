package com.whammich.sstow.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.whammich.sstow.utils.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLootPage extends Item {

	public String book;
	public String category;
	public String page;
	public String key;

	public ItemLootPage(String book, String category, String page, String key) {
		this.book = book;
		this.category = category;
		this.page = page;
		this.key = key;

		setUnlocalizedName("guide." + book + ".book." + page + "." + key);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":lootPage");
	}
}
