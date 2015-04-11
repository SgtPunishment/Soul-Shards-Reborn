package com.whammich.sstow.commands;

import java.util.List;

import com.whammich.sstow.utils.Register;
import com.whammich.sstow.utils.TierHandler;
import com.whammich.sstow.utils.Utils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class CommandSSTOW extends CommandBase {
	@Override
	public String getCommandName() {
		return "sstow";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/sstow help";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 4;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void processCommand(ICommandSender sender, String[] params) {

		if ((params.length > 0) && (params.length <= 7)) {
			if (params[0].equals("help")) {
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.help")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.killall")));
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.settier")));
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.addkills")));
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.removekills")));

			} else if (params[0].equals("killall")) {
				int killCounter = 0;

				for (Entity ent : (List<Entity>) sender.getEntityWorld().loadedEntityList) {
					if (ent.getEntityData().getBoolean("SSTOW")) {
						ent.setDead();
						killCounter++;
					}
				}

				if (killCounter == 0) {
					sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.notfound")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
				} else {
					sender.addChatMessage(new ChatComponentText(Utils.localizeFormatted("chat.sstow.command.killed","" + killCounter)).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
				}
			} else if (params[0].equals("settier")) {

				if (params.length == 2) {
					int tierAmount = Integer.parseInt(params[1]);
					int minKills = TierHandler.getMinKills(tierAmount);
					if (((EntityPlayerMP) sender).getHeldItem() != null
							&& ((EntityPlayerMP) sender).getHeldItem()
									.getItem() == Register.ItemShardSoul) {
						ItemStack shard = ((EntityPlayerMP) sender)
								.getHeldItem();
						for (int i = 1; i <= tierAmount; i++) {

							Utils.setShardTier(shard, (byte) 1);
							Utils.setShardKillCount(shard, (short) minKills);

						}
					}
				} else {
					sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.setwrong")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
				}
			} else if (params[0].equals("addkills")) {

				int killAmount = 1000;

				if (params.length >= 2) {
					killAmount = Integer.parseInt(params[1]);

				} else {
					sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.addkillwrong")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
				}

				if (((EntityPlayerMP) sender).getHeldItem() != null
						&& ((EntityPlayerMP) sender).getHeldItem().getItem() == Register.ItemShardSoul) {
					ItemStack shard = ((EntityPlayerMP) sender).getHeldItem();
					for (int i = 1; i <= killAmount; i++) {

						Utils.increaseShardKillCount(shard, (short) 1);
					}
				}
			} else if (params[0].equals("removekills")) {
				if (params.length == 2) {
					int killAmount = Integer.parseInt(params[1]);

				} else {
					sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.remkillwrong")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
				}
			} else {
				sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sstow.command.wrongcommand")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
			}
		}
	}
}