package projektor.schematic;

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
        setSchematic(schematicArray);
    }

    public void setSchematic(BlockWithMetaStorage[][][] schematicArray)
    {
        this.schematicArray = schematicArray;
    }

    public RenderBlocks processSchematicArrayForRendering(TileEntity tileEntity, int xCoord, int yCoord, int zCoord)
    {
        /* create the fake world */
        WorldProxy proxy = new WorldProxy(tileEntity.getWorldObj(), 15);
        /* Initialize a fake render-blocks for our proxy world */
        RenderBlocks renderBlocks = new RenderBlocks(proxy);

        ForgeDirection dir = RotationHelper.getDirectionFromMetadata(tileEntity.getBlockMetadata());

        for (int xIndex = 0; xIndex < schematicArray.length; xIndex++)
        {
            for (int yIndex = 0; yIndex < schematicArray[xIndex].length; yIndex++)
            {
                for (int zIndex = 0; zIndex < schematicArray[xIndex][yIndex].length; zIndex++)
                {

                    int xRender = (int) xCoord + xIndex - schematicArray.length / 2;
                    int yRender = (int) yCoord + yIndex;
                    int zRender = (int) zCoord + zIndex + dir.offsetZ - schematicArray[xIndex][yIndex].length;

                    if (dir.offsetX > 0)
                    {
                        xRender = (int) xCoord + (xIndex * -1) + dir.offsetX + schematicArray.length;
                        zRender = (int) zCoord + zIndex - schematicArray[xIndex][yIndex].length / 2;
                    }
                    if (dir.offsetX < 0)
                    {

                        xRender = (int) xCoord + xIndex + dir.offsetX - schematicArray.length;
                        zRender = (int) zCoord + (zIndex * -1) + schematicArray[xIndex][yIndex].length / 2;
                    }
                    if (dir.offsetZ > 0)
                    {
                        xRender = (int) xCoord + (xIndex * -1) + schematicArray.length / 2;
                        zRender = (int) zCoord + (zIndex * -1) + dir.offsetZ + schematicArray[xIndex][yIndex].length;
                    }

                    proxy.setCoordinates(xRender, yRender, zRender);
                    proxy.setBlockMetadata(schematicArray[xIndex][yIndex][zIndex].getMeta());
                    renderBlocks.renderBlockByRenderType(schematicArray[xIndex][yIndex][zIndex].getBlock(), xRender, yRender, zRender);
                }
            }
        }
        return renderBlocks;

    }

}
