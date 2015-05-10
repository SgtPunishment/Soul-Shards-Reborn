package com.whammich.sstow.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;

import com.whammich.sstow.compat.baubles.BaubleAnimus;
import com.whammich.sstow.compat.baubles.BaubleConservo;
import com.whammich.sstow.utils.Config;
import com.whammich.sstow.utils.ModLogger;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BaubleEvents {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerDeath(LivingDeathEvent event) {

		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			
			if(player == null || player instanceof FakePlayer) {
				return;
			}
			
			InventoryBaubles phyBaubles = PlayerHandler.getPlayerBaubles(player);
			ItemStack stack = phyBaubles.stackList[0];
			if (stack != null) {
				if (stack.getItem() instanceof BaubleAnimus) {
					event.setCanceled(true);
					phyBaubles.stackList[0] = null;
					PlayerHandler.setPlayerBaubles(player, phyBaubles);
					if (!player.worldObj.isRemote) {
						Minecraft
								.getMinecraft()
								.getSoundHandler()
								.playSound(
										PositionedSoundRecord.func_147674_a(
												new ResourceLocation("dig.glass"), 1.0F));
					}
					player.setHealth(Config.crystalHeal);
					if (Config.crystalResistEnable) {
						player.addPotionEffect(new PotionEffect(
								Potion.resistance.id,
								Config.crystalResistTimer, 5));
					}
					if (Config.crystalRegenEnable) {
						player.addPotionEffect(new PotionEffect(
								Potion.regeneration.id,
								Config.crystalRegenTimer,
								Config.crystalRegenLevel));
					}
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerDrops(PlayerDropsEvent event) {
		
		if(event.entityPlayer == null || event.entityPlayer instanceof FakePlayer) {
			return;
		}
		if(event.entityPlayer.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
			return;
		}
		
		if (event.entityLiving instanceof EntityPlayer) {
			ModLogger.logInfo("EntityPlayer");
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(player.isDead && player.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
				InventoryBaubles inventoryBaubles = PlayerHandler.getPlayerBaubles(player);
				ModLogger.logInfo("GetPlayerBaubles");
				ItemStack stack = inventoryBaubles.stackList[0];
				if (stack != null) {
					ModLogger.logInfo("Stack isn't Null");
					if (stack.getItem() instanceof BaubleConservo) {
						ModLogger.logInfo("It's the inventory bauble");
						event.setCanceled(true);
						ModLogger.logInfo("Event Canceled");
						inventoryBaubles.stackList[0] = null;
						ModLogger.logInfo("Bauble Nulled");
						PlayerHandler.setPlayerBaubles(player, inventoryBaubles);
						ModLogger.logInfo("Set Null Bauble");
						if (!player.worldObj.isRemote) {
							ModLogger.logInfo("Player is not remote");
							Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("dig.glass"), 1.0F));
							ModLogger.logInfo("Sound Played");
						}
						player.worldObj.getGameRules().setOrCreateGameRule("keepInventory", "false");
						ModLogger.logInfo("set keepInventory false");
					}
				}
			}
		}
	}



}
