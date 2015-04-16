package com.whammich.sstow.guide;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.whammich.sstow.guide.pages.PageSoulForge;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import amerifrance.guideapi.api.GuideRegistry;
import amerifrance.guideapi.api.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.abstraction.EntryAbstract;
import amerifrance.guideapi.api.abstraction.IPage;
import amerifrance.guideapi.api.base.Book;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.categories.CategoryItemStack;
import amerifrance.guideapi.entries.EntryUniText;

import com.whammich.sstow.utils.Register;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.common.registry.GameRegistry;

public class SoulGuide {

	public static Book soulGuide;
	public static List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();

	public static void registerguide() {
		createBook();
		soulGuide = new Book(categories, "guide.SoulGuide.book.title", "guide.SoulGuide.book.welcomMessage", "guide.SoulGuide.book.name", new Color(102, 0, 102));
		GuideRegistry.registerBook(soulGuide);
		GameRegistry.addRecipe(new ShapedOreRecipe(GuideRegistry.getItemStackForBook(soulGuide), "C", "B", 'C', "essenceCorrupted", 'B', Items.writable_book));
	}
	
	public static void createBook(){
		List<EntryAbstract> entries = new ArrayList<EntryAbstract>();
		ArrayList<IPage> testPage = new ArrayList<IPage>();
        PageSoulForge pageSoulForge = new PageSoulForge(new ItemStack(Items.iron_ingot));
        PageSoulForge pageSoulForge2 = new PageSoulForge(new ItemStack(Blocks.iron_block));
        PageSoulForge pageSoulForge3 = new PageSoulForge(new ItemStack(Blocks.log, 1, 0));
        PageSoulForge pageSoulForge4 = new PageSoulForge(new ItemStack(Blocks.log, 1, 1));
		testPage.addAll(PageHelper.pagesForLongText(Utils.localize("Bleh?"))); //Second
        testPage.add(pageSoulForge);
        testPage.add(pageSoulForge2);
        testPage.add(pageSoulForge3);
        testPage.add(pageSoulForge4);
		entries.add(new EntryUniText(testPage, Utils.localize("Blu?"))); //First
		categories.add(new CategoryItemStack(entries, Utils.localize("guide.SoulGuide.book.crafting"), new ItemStack(Register.ItemPickaxeSoul)));
	}
}
