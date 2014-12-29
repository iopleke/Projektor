package projektor.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import projektor.projector.ProjectorContainer;
import projektor.projector.ProjectorGUI;
import projektor.projector.ProjectorTileEntity;

/**
 *
 * @author jakimfett
 */
public class GUIHandler implements IGuiHandler
{

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null)
        {
            if (tileEntity instanceof ProjectorTileEntity)
            {
                return new ProjectorGUI(player.inventory, (ProjectorTileEntity) tileEntity);

            }
        }
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null)
        {
            if (tileEntity instanceof ProjectorTileEntity)
            {
                return new ProjectorContainer(player.inventory, (ProjectorTileEntity) tileEntity);

            }
        }
        return null;
    }

}
