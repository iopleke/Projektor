package projektor.projector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import projektor.Projektor;
import projektor.Reference;
import projektor.proxy.CommonProxy;

public class ProjectorBlock extends BlockContainer
{
    public ProjectorBlock()
    {
        super(Material.iron);
        this.setHardness(2F);
        this.setResistance(50F);
        this.setBlockName(Reference.Naming.PROJECTOR);
        this.setCreativeTab(Projektor.TAB);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase el, ItemStack is)
    {
        super.onBlockPlacedBy(world, x, y, z, el, is);
        int facing = MathHelper.floor_double(el.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, facing, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(Reference.IIcon.DUMMY);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new ProjectorTileEntity();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return CommonProxy.RENDER_ID;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
