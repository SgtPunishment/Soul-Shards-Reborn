package com.whammich.sstow.compat.tcon;

import java.util.Iterator;
import java.util.Map;

import com.whammich.sstow.utils.Register;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import tconstruct.modifiers.tools.ModBoolean;

public class ShardMod extends ModBoolean {

	public ShardMod(ItemStack[] items, int effect, String tag, String c, String tip) {
		super(items, effect, tag, c, tip);
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input) {
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool) {
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(key, true);
		addEnchantment(tool, Register.SOUL_STEALER, 1);
	}

	
	
	@SuppressWarnings("rawtypes")
	public void addEnchantment(ItemStack tool, Enchantment enchant, int level) {
		NBTTagList tags = new NBTTagList();
		Map enchantMap = EnchantmentHelper.getEnchantments(tool);
		Iterator iterator = enchantMap.keySet().iterator();
		int index;
		int lvl;
		boolean hasEnchant = false;
		while (iterator.hasNext()) {
			NBTTagCompound enchantTag = new NBTTagCompound();
			index = ((Integer) iterator.next()).intValue();
			lvl = (Integer) enchantMap.get(index);
			if (index == enchant.effectId) {
				hasEnchant = true;
				enchantTag.setShort("id", (short) index);
				enchantTag.setShort("lvl", (short) ((byte) level));
				tags.appendTag(enchantTag);
			} else {
				enchantTag.setShort("id", (short) index);
				enchantTag.setShort("lvl", (short) ((byte) lvl));
				tags.appendTag(enchantTag);
			}
		}
		if (!hasEnchant) {
			NBTTagCompound enchantTag = new NBTTagCompound();
			enchantTag.setShort("id", (short) enchant.effectId);
			enchantTag.setShort("lvl", (short) ((byte) level));
			tags.appendTag(enchantTag);
		}
		tool.stackTagCompound.setTag("ench", tags);
	}
}
