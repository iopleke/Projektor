package projektor.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import projektor.blocks.ghostblock.GhostBlock;
import projektor.reference.Reference;

public class Register
{

	public static Block ghostBlock;

	public static void blocks()
	{
		GameRegistry.registerBlock(ghostBlock = new GhostBlock(), Reference.GHOST_BLOCK_UNLOCALIZED);
	}

	public static void renderers()
	{
		//ClientRegistry.bindTileEntitySpecialRenderer(GhostBlockTE.class, new GhostBlockRenderer());
	}

}
