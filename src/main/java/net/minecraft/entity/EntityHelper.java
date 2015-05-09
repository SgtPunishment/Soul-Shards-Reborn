package net.minecraft.entity;

import net.minecraft.entity.player.EntityPlayer;

public class EntityHelper {
	public static int getExperience(EntityLivingBase entity, EntityPlayer player) {
		return entity.getExperiencePoints(player);
	}

	public static int getRawExperience(EntityLiving entity) {
		return entity.experienceValue;
	}

	public static void setRawExperience(EntityLiving entity, int value) {
		entity.experienceValue = value;
	}
}