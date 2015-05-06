package com.whammich.sstow.guide;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

import com.whammich.sstow.guide.pages.PageMissingText;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.common.registry.GameRegistry;

public class DrJournal {
	public static Book drjournal;
	public static List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();

	public static void registerguide() {
		createBook();
		drjournal = new Book(categories, "guide.drjournal.book.title", "guide.drjournal.book.welcomMessage", "guide.drjournal.book.name", new Color(102, 0, 102));
		GuideRegistry.registerBook(drjournal);
		GameRegistry.addRecipe(new ShapedOreRecipe(GuideRegistry.getItemStackForBook(drjournal), "C", "B", 'C', "dustRedstone", 'B', Items.writable_book));
	}
	
	public static void createBook(){
		List<EntryAbstract> entries = new ArrayList<EntryAbstract>();
		ArrayList<IPage> journalPages = new ArrayList<IPage>();
		ArrayList<IPage> journalPages01 = new ArrayList<IPage>();
		PageMissingText missingJournalN2P2 = new PageMissingText(Utils.localize("guide.drjournal.book.note2.page02"), "drjournal:notes:note2:02");
		PageMissingText missingJournalN2P4 = new PageMissingText(Utils.localize("guide.drjournal.book.note2.page04"), "drjournal:notes:note2:04");
		// Third
		journalPages.addAll(PageHelper.pagesForLongText(Utils.localize("guide.drjournal.book.note1.page01")));
		journalPages.addAll(PageHelper.pagesForLongText(Utils.localize("guide.drjournal.book.note1.page02")));
		
		journalPages01.addAll(PageHelper.pagesForLongText(Utils.localize("guide.drjournal.book.note2.page01")));
		journalPages01.add(missingJournalN2P2);
		journalPages01.addAll(PageHelper.pagesForLongText(Utils.localize("guide.drjournal.book.note2.page03")));
		journalPages01.add(missingJournalN2P4);
		// Second
		entries.add(new EntryUniText(journalPages, Utils.localize("guide.drjournal.book.note1")));
		entries.add(new EntryUniText(journalPages01, Utils.localize("guide.drjournal.book.note2")));
		// First
		categories.add(new CategoryItemStack(entries, Utils.localize("guide.drjournal.book.notes"), new ItemStack(Items.paper, 1)));
	}
	
}
