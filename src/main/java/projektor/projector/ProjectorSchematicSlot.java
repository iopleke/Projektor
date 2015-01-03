package projektor.projector;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import projektor.schematic.BasicSchematic;

/**
 *
 * @author jakimfett
 */
public class ProjectorSchematicSlot extends Slot
{

    public ProjectorSchematicSlot(IInventory inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        if (stack.getItem() instanceof BasicSchematic)
        {
            return true;
        }
        return false;
    }

}
