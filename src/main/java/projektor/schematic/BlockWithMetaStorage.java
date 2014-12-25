package projektor.schematic;

import net.minecraft.block.Block;

/**
 *
 * @author jakimfett
 */
public class BlockWithMetaStorage
{
    private final Block block;
    private final int meta;

    public BlockWithMetaStorage(Block block, int meta)
    {
        this.block = block;
        this.meta = meta;
    }

    public Block getBlock()
    {
        return block;
    }

    public int getMeta()
    {
        return meta;
    }

    @Override
    public String toString()
    {
        return "Block:" + block.getUnlocalizedName() + " Meta:" + meta;
    }
}
