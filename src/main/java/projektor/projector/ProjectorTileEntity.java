package projektor.projector;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import projektor.schematic.BasicSchematic;

public class ProjectorTileEntity extends TileEntity implements IInventory
{
    private ItemStack schematic;

    public ProjectorTileEntity()
    {
        super();
        schematic = null;
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
        return schematic != null;
    }

    public ItemStack getSchematic()
    {
        return schematic;
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return schematic;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = this.getStackInSlot(slot);
        if (stack != null)
        {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        if (stack != null)
        {
            Item item = stack.getItem();
            if (item != null && item instanceof BasicSchematic)
            {
                schematic = stack;
                return;
            }
        }
        schematic = null;

    }

    @Override
    public String getInventoryName()
    {
        return "Projector";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void closeInventory()
    {
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (stack != null)
        {
            if (stack.getItem() instanceof BasicSchematic)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Schematic", Constants.NBT.TAG_COMPOUND);

        NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(0);
        schematic = ItemStack.loadItemStackFromNBT(nbttagcompound1);

    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();
        if (schematic != null)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            schematic.writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
        }

        nbttagcompound.setTag("Schematic", nbttaglist);
    }
}
