package projektor.projector;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 *
 * @author jakimfett
 */
public class ProjectorContainer extends Container
{
    private final ProjectorTileEntity projector;

    public ProjectorContainer(InventoryPlayer inventoryPlayer, ProjectorTileEntity projector)
    {
        this.projector = projector;

        this.bindPlayerInventory(inventoryPlayer);
        this.addSlotToContainer(new ProjectorSchematicSlot(this.projector, 0, 118, 28));
    }

    private void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return true;
    }

}
