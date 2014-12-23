package projektor.blocks.projector;

import net.minecraft.tileentity.TileEntity;

public class ProjectorTileEntity extends TileEntity
{

    public int getFacing()
    {
        return worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }

    public boolean hasBlueprint()
    {
        return false;
    }
}
