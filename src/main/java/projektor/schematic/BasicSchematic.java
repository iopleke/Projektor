package projektor.schematic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import projektor.Projektor;
import projektor.Reference;
import projektor.helper.RotationHelper;
import projektor.io.IO;
import projektor.projector.ProjectorTileEntity;
import projektor.proxy.WorldProxy;

/**
 *
 * @author jakimfett
 */
public class BasicSchematic extends Item
{

    private BlockWithMetaStorage[][][] schematicArray;

    public BasicSchematic(String schematicName)
    {
        super();
        this.setCreativeTab(Projektor.TAB);
        this.setUnlocalizedName(Reference.Naming.SCHEMATIC_DEFAULT + schematicName);

        schematicArray = IO.deserialize("defaultSchematic");
    }

    public final void setSchematic(BlockWithMetaStorage[][][] schematicArray)
    {
        this.schematicArray = iterateAndFill(schematicArray);
    }

    public BlockWithMetaStorage[][][] getSchematicArray()
    {
        return schematicArray;
    }

    public final BlockWithMetaStorage[][][] iterateAndFill(BlockWithMetaStorage[][][] schematicArray)
    {
        for (int xIndex = 0; xIndex < schematicArray.length; xIndex++)
        {
            for (int yIndex = 0; yIndex < schematicArray[xIndex].length; yIndex++)
            {
                for (int zIndex = 0; zIndex < schematicArray[xIndex][yIndex].length; zIndex++)
                {
                    if (schematicArray[xIndex][yIndex][zIndex] == null)
                    {
                        schematicArray[xIndex][yIndex][zIndex] = new BlockWithMetaStorage(Blocks.air, 0);
                    }
                }
            }
        }
        return schematicArray;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add(Reference.Colors.DarkCyan + "Size: " + this.schematicArray.length + "x" + this.schematicArray[0].length + "x" + this.schematicArray[0][0].length);
    }

    public RenderBlocks processSchematicArrayForRendering(ProjectorTileEntity tileEntity, int xCoord, int yCoord, int zCoord)
    {
        // create the fake world
        WorldProxy proxy = new WorldProxy(tileEntity.getWorldObj(), 15);

        // Initialize a fake render-blocks for our proxy world
        RenderBlocks renderBlocks = new RenderBlocks(proxy);

        // Get the direction the projector is pointing
        ForgeDirection dir = RotationHelper.getDirectionFromMetadata(tileEntity.getBlockMetadata());

        for (int xIndex = 0; xIndex < schematicArray.length; xIndex++)
        {
            for (int yIndex = 0; yIndex < schematicArray[xIndex].length; yIndex++)
            {
                for (int zIndex = 0; zIndex < schematicArray[xIndex][yIndex].length; zIndex++)
                {

                    int xRender;
                    int yRender = (int) yCoord + yIndex;
                    int zRender;

                    if (dir.offsetX > 0)
                    {
                        xRender = (int) xCoord + (xIndex * -1) + dir.offsetX + schematicArray.length;
                        zRender = (int) zCoord + zIndex - schematicArray[xIndex][yIndex].length / 2;

                    } else if (dir.offsetX < 0)
                    {
                        xRender = (int) xCoord + xIndex + dir.offsetX - schematicArray.length;
                        zRender = (int) zCoord + (zIndex * -1) + schematicArray[xIndex][yIndex].length / 2;

                    } else if (dir.offsetZ > 0)
                    {
                        xRender = (int) xCoord + (zIndex * -1) + schematicArray[xIndex][yIndex].length / 2;
                        zRender = (int) zCoord + (xIndex * -1) + dir.offsetZ + schematicArray.length;

                    } else // if (dir.offsetZ < 0)
                    {
                        xRender = (int) xCoord + zIndex - schematicArray[xIndex][yIndex].length / 2;
                        zRender = (int) zCoord + xIndex + dir.offsetZ - schematicArray.length;
                    }

                    proxy.setCoordinates(xRender, yRender, zRender);
                    proxy.setBlockMetadata(schematicArray[xIndex][yIndex][zIndex].getMeta());
                    renderBlocks.renderBlockByRenderType(schematicArray[xIndex][yIndex][zIndex].getBlock(), xRender, yRender, zRender);
                }
            }
        }
        return renderBlocks;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.Naming.ID + ":" + Reference.Naming.SCHEMATIC_DEFAULT);
    }
}
