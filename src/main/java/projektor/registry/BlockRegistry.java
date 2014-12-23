package projektor.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import projektor.Reference;
import projektor.blocks.projector.ProjectorBlock;

/**
 *
 * @author jakimfett
 */
public class BlockRegistry
{
    public static Block projector;

    public static void init()
    {
        projector = new ProjectorBlock();
        GameRegistry.registerBlock(projector, Reference.Naming.PROJECTOR);
    }
}
