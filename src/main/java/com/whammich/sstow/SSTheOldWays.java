package com.whammich.sstow;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import com.whammich.sstow.commands.CommandSSTOW;
import com.whammich.sstow.compat.baubles.BaublesConfig;
import com.whammich.sstow.compat.guideapi.CultistBook;
import com.whammich.sstow.compat.guideapi.GameManual;
import com.whammich.sstow.compat.guideapi.JournalBook;
import com.whammich.sstow.events.AnvilEvent;
import com.whammich.sstow.events.BaubleEvents;
import com.whammich.sstow.events.CreateAnimusEvent;
import com.whammich.sstow.events.CreateConservoEvent;
import com.whammich.sstow.events.CreateShardEvent;
import com.whammich.sstow.events.PlayerKillEntityEvent;
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
		if(Loader.isModLoaded("Baubles")){
			BaublesConfig.load(event);
		}
		Config.load(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModLogger.logDebug("Registering PlayerKill Event");
		MinecraftForge.EVENT_BUS.register(new PlayerKillEntityEvent());
		
		ModLogger.logDebug("Registering CreateShard Event");
		MinecraftForge.EVENT_BUS.register(new CreateShardEvent());
		
		ModLogger.logDebug("Registering Anvil Events");
		MinecraftForge.EVENT_BUS.register(new AnvilEvent());
		
		if (Loader.isModLoaded("Baubles")){
			ModLogger.logDebug("Registering CreateConservo Event");
			MinecraftForge.EVENT_BUS.register(new CreateConservoEvent());
			
			ModLogger.logDebug("Registering CreateAnimus Event");
			MinecraftForge.EVENT_BUS.register(new CreateAnimusEvent());
			
			ModLogger.logDebug("Registering Bauble Events");
			MinecraftForge.EVENT_BUS.register(new BaubleEvents());
		}
		
		FMLInterModComms.sendMessage("Waila", "register", Reference.Waila_callBack);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ModLogger.logDebug("Registering Objects");
		Register.registerObjs();
		
		if(Loader.isModLoaded("guideapi")){
			ModLogger.logDebug("Registering Manual");
			GameManual.registerguide();
			
			ModLogger.logDebug("Registering Journal");
			JournalBook.registerguide();
			
			ModLogger.logDebug("Registering Cultist");
			CultistBook.registerguide();
		}
		
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
