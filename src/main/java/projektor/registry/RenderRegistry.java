package projektor.registry;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import projektor.blocks.projector.ProjectorTileEntity;
import projektor.blocks.projector.ProjectorTileEntityRenderer;
import projektor.proxy.CommonProxy;

public class RenderRegistry
{

    public static void init()
    {
        CommonProxy.RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer(ProjectorTileEntity.class, new ProjectorTileEntityRenderer());
    }

}
