package moze_intel.ssr.gameObjs;

import moze_intel.ssr.SSRCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CorruptedEssenceItem extends Item {

	public CorruptedEssenceItem() {
		this.setUnlocalizedName("corrupted_essence");
		this.setCreativeTab(ObjHandler.CREATIVE_TAB);
		this.setMaxStackSize(64);
		this.setMaxDamage(0);
	}

	public String getUnlocalizedName(ItemStack stack) {
		return "item.ssr.corrupted_essence";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("ssr:corrupted_essence");
	}
}
