package com.whammich.sstow.compat.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaublePhylactery extends Item implements IBauble {

	public BaublePhylactery() {
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(Register.CREATIVE_TAB);
		this.setUnlocalizedName("sstow.bauble.phylac");
		this.setTextureName(Reference.MOD_ID + ":tier5");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.AMULET;
	}

	@Override
	public void onEquipped(ItemStack arg0, EntityLivingBase arg1) {
		
	}

	@Override
	public void onUnequipped(ItemStack arg0, EntityLivingBase arg1) {
		
	}

	@Override
	public void onWornTick(ItemStack arg0, EntityLivingBase arg1) {
		
	}

	@Override
	public boolean canEquip(ItemStack arg0, EntityLivingBase arg1) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack arg0, EntityLivingBase arg1) {
		return true;
	}
}
