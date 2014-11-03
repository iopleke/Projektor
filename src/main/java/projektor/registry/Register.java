package projektor.registry;

import net.minecraft.block.Block;
import projektor.blocks.ghostblock.GhostBlock;
import projektor.blocks.ghostblock.GhostBlockRenderer;
import projektor.blocks.ghostblock.GhostBlockTE;
import projektor.reference.Reference;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {

	public static Block ghostBlock;
	
	public static void blocks()
	{
		GameRegistry.registerBlock(ghostBlock = new GhostBlock(), Reference.GHOST_BLOCK_UNLOCALIZED);
		GameRegistry.registerTileEntity(GhostBlockTE.class, ghostBlock.getUnlocalizedName());		
	}
	
	public static void renderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(GhostBlockTE.class, new GhostBlockRenderer());	
	}
	
}
