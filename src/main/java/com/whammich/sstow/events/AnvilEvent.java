package com.whammich.sstow.events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import amerifrance.guideapi.api.GuideRegistry;

import com.whammich.sstow.guide.DrJournal;
import com.whammich.sstow.item.ItemLootPage;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilEvent {
	@SubscribeEvent
	public void handleAnvilStuff(AnvilUpdateEvent event) {
		
		
		boolean unlockkey = event.left.stackTagCompound.getBoolean("unlockkey");
		
		// If the slots are empty, do nothing
		if(event.left == null || event.right == null){
			return;
		}
		
		// If the left and right slots are soul shards proceed
		if(event.left.getItem() instanceof ItemLootPage && event.right.getItem() == GuideRegistry.getItemStackForBook(DrJournal.drjournal).getItem()) {
			
							
				// Set and copy the right slot into a new instance
				ItemStack targetStack = event.right;
				ItemStack resultStack = targetStack.copy();

				// Set the kill count NBT with the killResult variable
				resultStack.stackTagCompound.setBoolean("unlockkey", true);
				
				// Place the combined shard in the result slot
				event.output = resultStack;
				
				// Charge the player 5 XP levels
				event.cost = 5;
		}
	}
}
