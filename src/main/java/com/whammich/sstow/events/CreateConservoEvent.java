package com.whammich.sstow.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.whammich.sstow.compat.baubles.Baubles;
import com.whammich.sstow.entity.EntityHarmlessLightningBolt;
import com.whammich.sstow.utils.Register;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CreateConservoEvent {

	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent event) {

		if (event.world.isRemote || event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			return;
		}

		if (event.entityPlayer.getHeldItem() == null || event.entityPlayer.getHeldItem().getItem() != Items.emerald || !event.entityPlayer.isSneaking()) {
			return;
		}

		if (event.world.getBlock(event.x, event.y, event.z) != Blocks.ender_chest) {
			return;
		}

		if (checkHorizontal(event.world, event.x, event.y, event.z)) {
			if (!event.entityPlayer.capabilities.isCreativeMode) {
				event.entityPlayer.getHeldItem().stackSize--;
			}

			event.world.func_147480_a(event.x, event.y, event.z, false);

			ForgeDirection dir = ForgeDirection.getOrientation(event.face);

//			event.entityPlayer.addChatComponentMessage(new ChatComponentText((char) 167 + "5" + (char) 167 + "o" + Utils.localize("chat.sstow.ritual.creep1")));
//			event.entityPlayer.addChatComponentMessage(new ChatComponentText((char) 167 + "5" + (char) 167 + "o" + Utils.localize("chat.sstow.ritual.creep2")));
//			event.world.playSoundEffect(event.x, event.y, event.z, "portal.trigger", 0.1F, 1.0F);
//			event.world.addWeatherEffect(new EntityHarmlessLightningBolt(event.world, event.x, event.y, event.z));

			event.world.spawnEntityInWorld(new EntityItem(event.world,
					event.x + (dir.offsetX * 1.75D), event.y
					+ (dir.offsetY * 1.75D) + 0.5D, event.z
					+ (dir.offsetZ * 1.75D), new ItemStack(Baubles.baubleGems, 1, 2)));
		}
	}

	private boolean checkHorizontal(World world, int x, int y, int z) {
		ForgeDirection[] VALID_DIRECTIONS = new ForgeDirection[] {
				ForgeDirection.NORTH, ForgeDirection.SOUTH,
				ForgeDirection.EAST, ForgeDirection.WEST };

		for (ForgeDirection dir : VALID_DIRECTIONS) {
			int newX = x + dir.offsetX;
			int newZ = z + dir.offsetZ;

			if (world.getBlock(newX, y, newZ) != Register.BlockMaterials 
					&& world.getBlockMetadata(newX, y, newZ) != 1) {
				return false;
			}

			if (world.getBlock(newX + dir.offsetX, y, newZ + dir.offsetZ) != Register.BlockXenolith 
					&& world.getBlockMetadata(newX + dir.offsetX, y, newZ + dir.offsetZ) != 0) {
				return false;
			}

			if (dir.offsetX == 0) {
				if (world.getBlock(newX + dir.offsetZ, y, newZ) != Register.BlockXenolith
						&& world.getBlockMetadata(newX + dir.offsetX, y, newZ + dir.offsetZ) != 0) {
					return false;
				}
			} else if (dir.offsetZ == 0) {
				if (world.getBlock(newX, y, newZ - dir.offsetX) != Register.BlockXenolith 
						&& world.getBlockMetadata(newX + dir.offsetX, y, newZ + dir.offsetZ) != 0) {
					return false;
				}
			}
		}

		return true;
	}

}
