package projektor.helper;

import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StackHelper
{
    public static final Random random = new Random();

    public static void throwItemStack(World world, ItemStack itemStack, double x, double y, double z)
    {
        if (itemStack != null)
        {
            float f = random.nextFloat() * 0.8F + 0.1F;
            float f1 = random.nextFloat() * 0.8F + 0.1F;
            float f2 = random.nextFloat() * 0.8F + 0.1F;

            EntityItem entityitem = new EntityItem(world, (float) x + f, (float) y + f1, (float) z + f2, itemStack);
            float f3 = 0.05F;
            entityitem.motionX = (float) random.nextGaussian() * f3;
            entityitem.motionY = (float) random.nextGaussian() * f3 + 0.2F;
            entityitem.motionZ = (float) random.nextGaussian() * f3;
            world.spawnEntityInWorld(entityitem);
        }
    }
}
