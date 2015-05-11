package com.whammich.sstow.compat.baubles;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.whammich.sstow.utils.ModLogger;
import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BaublesConfig {
	public static Configuration baubleConfig;

	public static File baubleConfigDirectory;
	
	public static boolean hurtOnBind;

	public static void load(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new BaublesConfig());
		baubleConfigDirectory = new File(event.getModConfigurationDirectory() + "/Whammich/");
		if (!baubleConfigDirectory.exists()) {
			baubleConfigDirectory.mkdir();
		}
		File baubleConfigFile = new File(baubleConfigDirectory, "Soul-Shards-TOW-Baubles.cfg");
		baubleConfig = new Configuration(baubleConfigFile);
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

			hurtOnBind = baubleConfig.getBoolean("Hurt player when equpping the Animus", "baubles", true, "If True, take damage upon equipping the Animus");
			
			ModLogger.logInfo(Utils.localize("chat.sstow.util.configload"));
		} catch (Exception e) {
			ModLogger.logFatal(Utils.localize("chat.sstow.util.configloadfail"));
			e.printStackTrace();
		} finally {
			if (baubleConfig.hasChanged()) {
				baubleConfig.save();
			}

		}
	}

}
