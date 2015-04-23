package com.whammich.sstow.block;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidSoulium extends BlockFluidClassic {

	public BlockFluidSoulium(Fluid fluid, Material material) {
		super(fluid, material);
		// TODO Auto-generated constructor stub
		setCreativeTab(Register.CREATIVE_TAB);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":liquid_soulium");
        Register.souliumFluid.setFlowingIcon(blockIcon);
        Register.souliumFluid.setStillIcon(blockIcon);
    }
	
}
