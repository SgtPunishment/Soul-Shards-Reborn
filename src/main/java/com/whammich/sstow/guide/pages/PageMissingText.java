package com.whammich.sstow.guide.pages;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import amerifrance.guideapi.pages.PageUnlocText;

public class PageMissingText extends PageUnlocText {

	public String unlockkey;
	public PageMissingText(String unlocText, String key) {
		super(unlocText);
		this.unlockkey = key;
	}

    @Override
    public boolean canSee(EntityPlayer player, ItemStack bookStack) {
    	NBTTagCompound tags = bookStack.getTagCompound().getCompoundTag("MissingPage");
    	if(tags.getBoolean(unlockkey)){
    		return true;
    	}
        return false;
    }
	
}
