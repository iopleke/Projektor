package projektor.schematic;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import projektor.helper.RotationHelper;
import projektor.proxy.WorldProxy;

/**
 *
 * @author jakimfett
 */
public class BasicSchematic
{
    BlockWithMetaStorage[][][] schematicArray;
    private static final int offset = 2;

    public void BasicSchematic()
    {
        schematicArray = new BlockWithMetaStorage[1][1][1];

        schematicArray[0][0][0] = new BlockWithMetaStorage(Blocks.anvil, 0);
    }

    public void BasicSchematic(BlockWithMetaStorage[][][] schematicArray)
    {
        this.schematicArray = schematicArray;
    }

    public RenderBlocks processSchematicArrayForRendering(TileEntity tileEntity, int xCoord, int yCoord, int zCoord, int side)
    {
        /* create the fake world */
        WorldProxy proxy = new WorldProxy(tileEntity.getWorldObj(), (int) xCoord, (int) yCoord, (int) zCoord, 15);
        ForgeDirection dir = RotationHelper.getDirectionFromMetadata(tileEntity.getBlockMetadata());

        /* Initialize a fake render-blocks for our proxy world */
        RenderBlocks renderBlocks = new RenderBlocks(proxy);

        schematicArray = new BlockWithMetaStorage[1][1][1];

        schematicArray[0][0][0] = new BlockWithMetaStorage(Blocks.anvil, 0);
        int xSize = schematicArray.length;

        for (int xFor = 0; xFor < xSize; xFor++)
        {
            int ySize = schematicArray[xFor].length;
            for (int yFor = 0; yFor < ySize; yFor++)
            {
                int zSize = schematicArray[xFor][yFor].length;
                for (int zFor = 0; zFor < zSize; zFor++)
                {
                    Block blockFor = schematicArray[xFor][yFor][zFor].getBlock();
                    proxy.setBlockMetadata(schematicArray[xFor][yFor][zFor].getMeta());
                    proxy.setBlock(blockFor);
                    // this is going to render starting at the "middle", because the offset isn't being halved (in the array 0,0,0 is the corner, for rendering it's middle bottom)

                    renderBlocks.renderBlockByRenderType(blockFor, (int) xCoord + xFor + dir.offsetX, (int) yCoord + yFor + dir.offsetY, (int) zCoord + zFor + dir.offsetZ);
                }
            }
        }
        return renderBlocks;

    }

}
