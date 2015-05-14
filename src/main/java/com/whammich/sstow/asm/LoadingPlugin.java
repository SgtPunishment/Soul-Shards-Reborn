package com.whammich.sstow.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"com.whammich.sstow.asm."})
public class LoadingPlugin implements IFMLLoadingPlugin
{
    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"com.whammich.sstow.asm.SoulTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return null;//return FullChestsDummyContainer.class.getName();
    }

    @Override
    public String getSetupClass()
    {
        return null;//return FullChestsDummyContainer.class.getName();
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }

}
