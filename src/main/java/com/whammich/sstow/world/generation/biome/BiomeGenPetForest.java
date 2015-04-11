package com.whammich.sstow.world.generation.biome;

import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.whammich.sstow.utils.Register;

public class BiomeGenPetForest extends BiomeGenBase {

	@SuppressWarnings("unchecked")
	public BiomeGenPetForest(int id) {
		super(id);
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 5, 2, 10));
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.topBlock = Register.BlockXenolith;
		this.enableRain = false;
		this.enableSnow = false;
	}
	
}
