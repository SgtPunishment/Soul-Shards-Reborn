package com.whammich.sstow.compat.baubles;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.whammich.sstow.utils.Config;
import com.whammich.sstow.utils.ModLogger;
import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BaublesConfig {
	public static Configuration config;

	public static File configDirectory;
	
	public static boolean hurtOnBind;

	public static void load(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new Config());
		configDirectory = new File(event.getModConfigurationDirectory() + "/Whammich/");
		if (!configDirectory.exists()) {
			configDirectory.mkdir();
		}
		File configFile = new File(configDirectory, "Soul-Shards-TOW-Baubles.cfg");
		config = new Configuration(configFile);
		syncConfig();
	}

	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent event) {
		if (event.modID.equals(Reference.MOD_ID)) {
			ModLogger.logInfo(Utils.localize("chat.sstow.util.configupdate"));
			syncConfig();
		}
	}

	public static void syncConfig() {
		try {

			hurtOnBind = config.getBoolean("Hurt player when binding baubles", null, true, "If true, this will set player health to half a heart when equiping Animus or Conservo baubles");
			
			ModLogger.logInfo(Utils.localize("chat.sstow.util.configload"));
		} catch (Exception e) {
			ModLogger.logFatal(Utils.localize("chat.sstow.util.configloadfail"));
			e.printStackTrace();
		} finally {
			if (config.hasChanged()) {
				config.save();
			}

		}
	}

}
