package projektor.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabRegistry extends CreativeTabs
{

    public CreativeTabRegistry(String tabName)
    {
        super(tabName);
    }

    @Override
    public Item getTabIconItem()
    {
        return null;
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(Items.painting);
    }
}
