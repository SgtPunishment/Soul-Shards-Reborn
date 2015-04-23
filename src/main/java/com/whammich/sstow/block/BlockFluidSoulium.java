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

	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
	
	public BlockFluidSoulium(Fluid fluid) {
		super(fluid, Material.water);
		setCreativeTab(Register.CREATIVE_TAB);
		setBlockName("sstow.fluidblock.soulium");
		setTemperature(300);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		stillIcon = iconRegister.registerIcon(Reference.MOD_ID + ":liquid_soulium");
		flowingIcon = iconRegister.registerIcon(Reference.MOD_ID + ":liquid_soulium_flow");
		Register.souliumFluid.setIcons(stillIcon, flowingIcon);
        this.blockIcon = stillIcon;
	}

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
            return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
            return false;
        return super.displaceIfPossible(world, x, y, z);
    }
	
}
