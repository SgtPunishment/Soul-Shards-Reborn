package com.whammich.sstow.events;


import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;

import com.whammich.sstow.compat.baubles.BaublePhylactery;
import com.whammich.sstow.utils.Config;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathEvent {
	
	@SubscribeEvent
	public void onPlayerDeath(LivingDeathEvent event){
		
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			InventoryBaubles inventoryBaubles = PlayerHandler.getPlayerBaubles(player);
			ItemStack stack = inventoryBaubles.stackList[0];
			if(stack != null){
				if(stack.getItem() instanceof BaublePhylactery){
					event.setCanceled(true);
					inventoryBaubles.stackList[0] = null;
					PlayerHandler.setPlayerBaubles(player, inventoryBaubles);
					if(!player.worldObj.isRemote) {
						Minecraft.getMinecraft().getSoundHandler().playSound(
								PositionedSoundRecord.func_147674_a(
										new ResourceLocation("dig.glass"), 1.0F));
					}
					player.setHealth(Config.CrystalHeal);
					if(Config.CrystalResistEnable) {
						player.addPotionEffect(new PotionEffect(Potion.resistance.id, Config.CrystalResistTimer, 5));
					}
					if(Config.CrystalRegenEnable) {
						player.addPotionEffect(new PotionEffect(Potion.regeneration.id, Config.CrystalRegenTimer, Config.CrystalRegenLevel));
					}
				}
			}
		}
	}
	
}
