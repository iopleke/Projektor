package projektor.registry;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import projektor.blocks.projector.ProjectorItemRenderer;
import projektor.blocks.projector.ProjectorTileEntity;
import projektor.blocks.projector.ProjectorTileEntityRenderer;
import projektor.proxy.CommonProxy;

public class RenderRegistry
{

    public static void init()
    {
        CommonProxy.RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        ProjectorTileEntityRenderer render = new ProjectorTileEntityRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(ProjectorTileEntity.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.projectorBlock), new ProjectorItemRenderer(render, new ProjectorTileEntity()));
    }

}
