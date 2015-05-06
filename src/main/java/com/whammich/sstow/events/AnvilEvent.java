package com.whammich.sstow.events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import amerifrance.guideapi.api.GuideRegistry;

import com.whammich.sstow.guide.DrJournal;
import com.whammich.sstow.item.ItemLootPage;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilEvent {
	@SubscribeEvent
	public void AnvilLore(AnvilUpdateEvent event) {

		String unlockKey;

		// If the slots are empty, do nothing
		if (event.left == null || event.right == null) {
			return;
		}

		// If the left slot is a loot page, and the right slot is the lore
		// book(s)
		if (event.left.getItem() instanceof ItemLootPage
				&& event.right.getItem() == GuideRegistry.getItemStackForBook(DrJournal.drjournal).getItem()) {

			unlockKey = event.left.stackTagCompound.getString("key");

			// Check the left slot for an NBT value, if false, return, if true
			// continue
			if (unlockKey == null) {
				return;
			}

			// Set and copy the right slot into a new instance
			ItemStack targetStack = event.right;
			ItemStack resultStack = targetStack.copy();

			// Set the unlock boolean to true for page x
			resultStack.stackTagCompound.setBoolean(unlockKey, true);

			// Place the updated book in the result slot
			event.output = resultStack;

			// Charge the player 5 XP levels
			event.cost = 5;
		}
	}
}
