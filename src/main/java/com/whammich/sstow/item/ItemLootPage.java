package com.whammich.sstow.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLootPage extends Item {

	public ItemLootPage() {
		setUnlocalizedName("guide.book.missing");
		setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":pages/0");
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean held) {
		if (Utils.displayShiftForDetail && !Utils.isShiftKeyDown())
			list.add(Utils.shiftForDetails());

		if (Utils.isShiftKeyDown()) {
			list.add(stack.stackTagCompound.getString("book"));
			list.add(Utils.localize("info.sstow.tooltip.page") + " " + stack.stackTagCompound.getInteger("page"));
		}
	}
}
