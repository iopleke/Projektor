package projektor.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * World proxy class. Allows worlds to behave differently to default (ie, return fake blocks, etc).
 *
 * @author AfterLifeLochie
 */
public class WorldProxy implements IBlockAccess
{

    IBlockAccess world;
    Block block;
    int meta;
    int brightness;
    int x, y, z;

    public WorldProxy(IBlockAccess world, int x, int y, int z, int brightness)
    {
        this.world = world;
        this.block = Blocks.air;
        this.meta = 0;
        this.brightness = brightness;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Block getBlock(int x, int y, int z)
    {
        return Blocks.air;
    }

    @Override
    public TileEntity getTileEntity(int x, int y, int z)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getLightBrightnessForSkyBlocks(int var1, int var2, int var3, int var4)
    {
        return (brightness >= 0 && brightness < 16) ? brightness << 20 : 15 << 20;
    }

    @Override
    public int getBlockMetadata(int x, int y, int z)
    {
        if (x == this.x && y == this.y && z == this.z)
        {
            return meta;
        }
        return 0;
    }

    public void setBlockMetadata(int meta)
    {
        this.meta = meta;
    }

    @Override
    public boolean isAirBlock(int x, int y, int z)
    {
        if (x == this.x && y == this.y && z == this.z)
        {
            return false;
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z)
    {
        return world.getBiomeGenForCoords(x, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getHeight()
    {
        return world.getHeight();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean extendedLevelsInChunkCache()
    {
        return world.extendedLevelsInChunkCache();
    }

    @Override
    public int isBlockProvidingPowerTo(int var1, int var2, int var3, int var4)
    {
        return 0;
    }

    @Override
    public boolean isSideSolid(int x, int y, int z, ForgeDirection side, boolean _default)
    {
        return true;
    }

}
