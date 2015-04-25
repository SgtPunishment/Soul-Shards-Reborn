package com.whammich.sstow.item;
import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
public class ItemSouliumBucket extends ItemBucket {
	
	public ItemSouliumBucket(Block block) {
        super(block);
        this.maxStackSize = 1;
        this.setContainerItem(Items.bucket);
        this.setTextureName(Reference.MOD_ID + ":bucket_soulium");
        this.setCreativeTab(Register.CREATIVE_TAB);
        this.setUnlocalizedName("sstow.soultool.bucket.soulium");
    }
}
