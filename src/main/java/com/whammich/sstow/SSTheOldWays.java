package com.whammich.sstow;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import com.whammich.sstow.commands.CommandSSTOW;
import com.whammich.sstow.events.AnvilShardEvent;
import com.whammich.sstow.events.CreateShardEvent;
import com.whammich.sstow.events.PlayerDeathEvent;
import com.whammich.sstow.events.PlayerKillEntityEvent;
import com.whammich.sstow.guide.SoulManual;
import com.whammich.sstow.utils.Config;
import com.whammich.sstow.utils.EntityMapper;
import com.whammich.sstow.utils.Entitylist;
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
		MinecraftForge.EVENT_BUS.register(new PlayerKillEntityEvent());
		MinecraftForge.EVENT_BUS.register(new CreateShardEvent());
		MinecraftForge.EVENT_BUS.register(new AnvilShardEvent());
		if (Loader.isModLoaded("Baubles")){
			MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
		}
		FMLInterModComms.sendMessage("Waila", "register", Reference.Waila_callBack);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Register.registerObjs();
		SoulManual.registerguide();
		EntityMapper.init();
		Entitylist.init(new File(Config.configDirectory + "/entitylist.cfg"));
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandSSTOW());

	}
}
