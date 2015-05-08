package net.minecraft.entity;

import net.minecraft.entity.player.EntityPlayer;

public class EntityHelper { 
	public static int getXP(EntityLiving entity, EntityPlayer player) { 
		return entity.getExperiencePoints(player);
	}
}