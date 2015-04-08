package com.whammich.sstow.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.whammich.sstow.SSTheOldWays;
import com.whammich.sstow.block.BlockCage;
import com.whammich.sstow.block.BlockForge;
import com.whammich.sstow.block.BlockGlassObsidian;
import com.whammich.sstow.block.BlockPetrified;
import com.whammich.sstow.block.BlockPetrified2;
import com.whammich.sstow.block.BlockPlankPetrified;
import com.whammich.sstow.block.BlockSoulium;
import com.whammich.sstow.block.BlockXenoLight;
import com.whammich.sstow.block.BlockXenolith;
import com.whammich.sstow.enchantment.EnchantmentSoulStealer;
import com.whammich.sstow.guihandler.GuiHandler;
import com.whammich.sstow.item.ItemAxeSoul;
import com.whammich.sstow.item.ItemHoeSoul;
import com.whammich.sstow.item.ItemMaterials;
import com.whammich.sstow.item.ItemPickaxeSoul;
import com.whammich.sstow.item.ItemShardSoul;
import com.whammich.sstow.item.ItemSpadeSoul;
import com.whammich.sstow.item.ItemSwordSoul;
import com.whammich.sstow.item.blocks.ItemBlockForge;
import com.whammich.sstow.item.blocks.ItemBlockPetrified;
import com.whammich.sstow.item.blocks.ItemBlockPetrified2;
import com.whammich.sstow.item.blocks.ItemBlockPlankPetrified;
import com.whammich.sstow.item.blocks.ItemBlockXenolith;
import com.whammich.sstow.tileentity.TileEntityCage;
import com.whammich.sstow.tileentity.TileEntityForge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {
	// Tool material for the soul tools/sword
	public static ToolMaterial SOULIUM = EnumHelper.addToolMaterial("SOULIUM", 3, 3122, 12.0F, 6F, 30);

	// Setting up the enchantment details from the config
	public static Enchantment SOUL_STEALER = new EnchantmentSoulStealer(Config.ENCHANT_ID, Config.ENCHANT_WEIGHT);

	// Set the creative tab
	public static SoulShardTab CREATIVE_TAB = new SoulShardTab();

	// Set up the mod items
	public static Item ItemMaterials = new ItemMaterials();
	public static Item ItemShardSoul = new ItemShardSoul();
	public static Item ItemSwordSoul = new ItemSwordSoul(SOULIUM);
	public static Item ItemPickaxeSoul = new ItemPickaxeSoul(SOULIUM);
	public static Item ItemAxeSoul = new ItemAxeSoul(SOULIUM);
	public static Item ItemHoeSoul = new ItemHoeSoul(SOULIUM);
	public static Item ItemSpadeSoul = new ItemSpadeSoul(SOULIUM);
	
	// Set up the mod blocks
	public static Block BlockCage = new BlockCage();
	public static Block BlockForge = new BlockForge(false).setCreativeTab(CREATIVE_TAB);
	public static Block BlockForgeActive = new BlockForge(true).setBlockName("sstow.forge_block_active");
	public static Block BlockSoulium = new BlockSoulium();
	public static Block BlockXenoLight = new BlockXenoLight();
	
	public static Block BlockXenolith = new BlockXenolith();
	public static Block BlockPetrified = new BlockPetrified();
    public static Block BlockPetrified2 = new BlockPetrified2();
    public static Block BlockPetrifiedPlanks = new BlockPlankPetrified();
    public static Block BlockObsidianGlass = new BlockGlassObsidian(Material.rock, false);
    
	public static void registerObjs() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SSTheOldWays.modInstance, new GuiHandler());

		registerItems();
		registerBlocks();
		registerOreDictEntries();
		registerTileEntities();
		registerRecipes();

	}

	private static void registerItems() {

		GameRegistry.registerItem(ItemMaterials, "ItemMaterialsSoul");
		GameRegistry.registerItem(ItemSwordSoul, "ItemSwordSoul");
		GameRegistry.registerItem(ItemPickaxeSoul, "ItemPickaxeSoul");
		GameRegistry.registerItem(ItemAxeSoul, "ItemAxeSoul");
		GameRegistry.registerItem(ItemHoeSoul, "ItemHoeSoul");
		GameRegistry.registerItem(ItemSpadeSoul, "ItemSpadeSoul");
		GameRegistry.registerItem(ItemShardSoul, "ItemShardSoul");
		
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(BlockForge, ItemBlockForge.class, "BlockForge");
		GameRegistry.registerBlock(BlockForgeActive, BlockForgeActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockSoulium, "sstow_soulium_block");
		GameRegistry.registerBlock(BlockXenoLight, "BlockXenoLight");
		GameRegistry.registerBlock(BlockCage, "sstow_soul_cage");
		GameRegistry.registerBlock(BlockObsidianGlass, "BlockObsidGlass");
		GameRegistry.registerBlock(BlockXenolith, ItemBlockXenolith.class, "BlockXenolith");
		GameRegistry.registerBlock(BlockPetrified, ItemBlockPetrified.class, "BlockPetrifiedLog");
		GameRegistry.registerBlock(BlockPetrified2, ItemBlockPetrified2.class, "BlockPetrifiedLog2");
		GameRegistry.registerBlock(BlockPetrifiedPlanks, ItemBlockPlankPetrified.class, "BlockPetrifiedPlanks");
	}

	private static void registerOreDictEntries() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(ItemMaterials, 1, 0));
		OreDictionary.registerOre("nuggetSoulium", new ItemStack(ItemMaterials, 1, 1));
		OreDictionary.registerOre("ingotSoulium", new ItemStack(ItemMaterials, 1, 2));
		OreDictionary.registerOre("dustVile", new ItemStack(ItemMaterials, 1, 3));
		OreDictionary.registerOre("essenceCorrupted", new ItemStack(ItemMaterials, 1, 4));
		OreDictionary.registerOre("stickPetrified", new ItemStack(ItemMaterials, 1, 5));
		OreDictionary.registerOre("stickWood", new ItemStack(ItemMaterials, 1, 5));

		// Petrified Logs OreDict
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified, 1, 0));
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified, 1, 1));
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified, 1, 2));
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified, 1, 3));
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified2, 1, 0));
		OreDictionary.registerOre("treeStone", new ItemStack(BlockPetrified2, 1, 1));

		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified, 1, 0));
		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified, 1, 1));
		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified, 1, 2));
		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified, 1, 3));
		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified2, 1, 0));
		OreDictionary.registerOre("treeWood", new ItemStack(BlockPetrified2, 1, 1));

		// Petrified Planks OreDict
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 0));
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 1));
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 2));
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 3));
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 4));
		OreDictionary.registerOre("plankStone", new ItemStack(BlockPetrifiedPlanks, 1, 5));
		
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(BlockPetrifiedPlanks, 1, 5));
	}

	private static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityForge.class, "sstow_soul_forge_tile");
		GameRegistry.registerTileEntity(TileEntityCage.class, "sstow_soul_cage_tile");
	}

	private static void registerRecipes() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 2), BlockSoulium));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 1), "ingotSoulium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 0), "ingotIron"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 0), new ItemStack(BlockPetrified, 1, 0)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 1), new ItemStack(BlockPetrified, 1, 1)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 2), new ItemStack(BlockPetrified, 1, 2)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 3), new ItemStack(BlockPetrified, 1, 3)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 4), new ItemStack(BlockPetrified2, 1, 0)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 5), new ItemStack(BlockPetrified2, 1, 1)));
		

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemMaterials, 4, 5),"P", "P", 'P', "plankStone"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockForge), "SSS", "SCS", "OOO", 'S', "cobblestone", 'C', "essenceCorrupted", 'O', Blocks.obsidian));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemMaterials, 1, 2), "AAA", "AAA", "AAA", 'A', "nuggetSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.iron_ingot), "AAA", "AAA", "AAA", 'A', "nuggetIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockSoulium), "AAA", "AAA", "AAA", 'A', "ingotSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemSwordSoul), "A", "A", "B", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemPickaxeSoul), "AAA", "CBC", "CBC", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemAxeSoul), "AA", "AB", "CB", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemHoeSoul), "AA", "CB", "CB", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemSpadeSoul), "A", "B", "B", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockCage), "SIS", "IXI", "SIS", 'I', Blocks.iron_bars, 'S', "ingotSoulium"));

		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 0), new ItemStack(BlockPetrified, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 1), new ItemStack(BlockPetrified, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 2), new ItemStack(BlockPetrified, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 3), new ItemStack(BlockPetrified, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 4), new ItemStack(BlockPetrified2, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 5), new ItemStack(BlockPetrified2, 1, 1));

		
		if (Loader.isModLoaded("Natura")) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 2, 3), Blocks.soul_sand, "dustGlowstone"));
			GameRegistry.addSmelting(new ItemStack(ItemMaterials, 1, 3), new ItemStack(ItemMaterials, 1, 4), 0.35F);
		} else {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 1, 4), "dustGlowstone", "dustVile"));
			GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(ItemMaterials, 1, 3), 0.35F);
		}
	}
	
}
