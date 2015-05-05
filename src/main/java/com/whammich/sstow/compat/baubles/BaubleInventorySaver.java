package com.whammich.sstow.compat.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

public class BaubleInventorySaver  extends Item implements IBauble {

	public BaubleInventorySaver() {
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(Register.CREATIVE_TAB);
		this.setUnlocalizedName("sstow.bauble.invent");
		this.setTextureName(Reference.MOD_ID + ":tier5");
	}
	
	@Override
	public boolean canEquip(ItemStack arg0, EntityLivingBase entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack arg0, EntityLivingBase entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		// TODO Auto-generated method stub
		return BaubleType.AMULET;
	}

	@Override
	public void onEquipped(ItemStack arg0, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			player.worldObj.getGameRules().setOrCreateGameRule("keepInventory", "true");
		}
	}

	@Override
	public void onUnequipped(ItemStack arg0, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			player.worldObj.getGameRules().setOrCreateGameRule("keepInventory", "false");
		}
	}

	@Override
	public void onWornTick(ItemStack arg0, EntityLivingBase entity) {
		// TODO Auto-generated method stub
		
	}

}
