package projektor.projector;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ProjectorTileEntity extends TileEntity
{
    private ItemStack blueprint;

    public ProjectorTileEntity()
    {
        blueprint = null;
    }

    public int getFacing()
    {
        if (this.getHasWorldObj())
        {
            return worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        }
        return 0;
    }

    public boolean getHasWorldObj()
    {
        return worldObj != null;
    }

    public boolean getHasBlueprint()
    {
        return blueprint != null;
    }

    public ItemStack getBluePrint()
    {
        return blueprint;
    }

}
