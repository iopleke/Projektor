package projektor.registry;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import projektor.blocks.ghostblock.GhostBlock;
import projektor.blocks.projector.ProjectorBlock;
import projektor.blocks.projector.ProjectorTileEntity;
import projektor.blocks.projector.ProjectorTileEntityRenderer;
import projektor.proxy.CommonProxy;
import projektor.reference.Naming;

public class Register
{

	public static Block ghostBlock;
	public static Block projectorBlock;

	public static void blocks()
	{
		GameRegistry.registerBlock(ghostBlock = new GhostBlock(), Naming.GHOSTBLOCK);
		GameRegistry.registerBlock(projectorBlock = new ProjectorBlock(), Naming.PROJECTOR);
	}

	public static void renderers()
	{
		CommonProxy.RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(ProjectorTileEntity.class, new ProjectorTileEntityRenderer());
	}

}
