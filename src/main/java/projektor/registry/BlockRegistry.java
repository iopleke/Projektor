package projektor.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import projektor.blocks.projector.ProjectorBlock;
import projektor.reference.Naming;

/**
 *
 * @author jakimfett
 */
public class BlockRegistry
{
    public static Block projectorBlock;

    public static void init()
    {
        GameRegistry.registerBlock(projectorBlock = new ProjectorBlock(), Naming.PROJECTOR);
    }
}
