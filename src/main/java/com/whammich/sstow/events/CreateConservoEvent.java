package com.whammich.sstow.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.whammich.sstow.compat.baubles.Baubles;
import com.whammich.sstow.utils.Register;

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
					|| world.getBlockMetadata(newX, y, newZ) != 1) {
				return false;
			}

			if (world.getBlock(newX + dir.offsetX, y, newZ + dir.offsetZ) != Register.BlockXenolith 
					|| world.getBlockMetadata(newX + dir.offsetX, y, newZ + dir.offsetZ) != 0) {
				return false;
			}


			if (dir.offsetX == 0) {
				if (world.getBlock(newX + dir.offsetZ, y, newZ) != Register.BlockXenolith
						|| world.getBlockMetadata(newX + dir.offsetZ, y, newZ) != 0) {
					return false;
				}
			} else if (dir.offsetZ == 0) {
				if (world.getBlock(newX, y, newZ - dir.offsetX) != Register.BlockXenolith 
						|| world.getBlockMetadata(newX, y, newZ - dir.offsetX) != 0) {
					return false;
				}
			}
		}
		// SOUTH EAST
		if(world.getBlock(x + 2, y, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 1, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 1, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 2, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 2, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 3, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 3, z + 2) != 6){
			return false;
		}

		// SOUTH EAST
		if(world.getBlock(x + 2, y, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 1, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 1, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 2, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 2, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x + 2, y + 3, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x + 2, y + 3, z + 2) != 6){
			return false;
		}

		// SOUTH WEST
		if(world.getBlock(x - 2, y, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 1, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 1, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 2, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 2, z + 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 3, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 3, z + 2) != 6){
			return false;
		}

		// NORTH
		if(world.getBlock(x - 2, y, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 1, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 1, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 2, z - 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 2, z - 2) != 0){
			return false;
		}

		if(world.getBlock(x - 2, y + 3, z + 2) != Register.BlockXenolith 
				|| world.getBlockMetadata(x - 2, y + 3, z - 2) != 6){
			return false;
		}

		return true;
	}

}
