package projektor.blocks.projector;

import net.minecraft.tileentity.TileEntity;

public class ProjectorTileEntity extends TileEntity
{

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
        return false;
    }
}
