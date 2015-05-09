package com.whammich.sstow;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import com.whammich.sstow.commands.CommandSSTOW;
import com.whammich.sstow.events.AnvilEvent;
import com.whammich.sstow.events.AnvilShardEvent;
import com.whammich.sstow.events.CreateShardEvent;
import com.whammich.sstow.events.PlayerDeathEvent;
import com.whammich.sstow.events.PlayerDropEvent;
import com.whammich.sstow.events.PlayerKillEntityEvent;
import com.whammich.sstow.guide.JournalBook;
import com.whammich.sstow.guide.GameManual;
import com.whammich.sstow.utils.Config;
import com.whammich.sstow.utils.EntityMapper;
import com.whammich.sstow.utils.Entitylist;
import com.whammich.sstow.utils.ModLogger;
import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GuiFactory_class)
public class SSTheOldWays {

	@Instance(Reference.MOD_ID)
	public static SSTheOldWays modInstance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModLogger.logDebug("Registering PlayerKill Event");
		MinecraftForge.EVENT_BUS.register(new PlayerKillEntityEvent());
		ModLogger.logDebug("Registering CreateShard Event");
		MinecraftForge.EVENT_BUS.register(new CreateShardEvent());
		ModLogger.logDebug("Registering AnvilShard Event");
		MinecraftForge.EVENT_BUS.register(new AnvilShardEvent());
		ModLogger.logDebug("Registering AnvilLore Event");
		MinecraftForge.EVENT_BUS.register(new AnvilEvent());
		if (Loader.isModLoaded("Baubles")){
			ModLogger.logDebug("Registering PlayerDeath Event");
			MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
			ModLogger.logDebug("Registering PlayerDrop Event");
			MinecraftForge.EVENT_BUS.register(new PlayerDropEvent());
		}
		FMLInterModComms.sendMessage("Waila", "register", Reference.Waila_callBack);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ModLogger.logDebug("Registering Objects");
		Register.registerObjs();
		ModLogger.logDebug("Registering Manual");
		GameManual.registerguide();
		ModLogger.logDebug("Registering Journal");
		JournalBook.registerguide();
		ModLogger.logDebug("Registering EntityMapper");
		EntityMapper.init();
		ModLogger.logDebug("Reading/Writing Entity List");
		Entitylist.init(new File(Config.configDirectory + "/Soul-Shards-TOW-Entitylist.cfg"));
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandSSTOW());

	}
}
