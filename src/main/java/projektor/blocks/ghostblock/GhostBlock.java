package projektor.blocks.ghostblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import projektor.reference.Reference;

public class GhostBlock extends BlockContainer{

	public GhostBlock() {
		super(Material.air);
		this.setBlockName(Reference.GHOST_BLOCK_UNLOCALIZED);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new GhostBlockTE();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,int side, float hitX, float hitY,float hitZ) {
		if (!player.isSneaking())
		{
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof GhostBlockTE)
			{
				Block thisBlock = ((GhostBlockTE)te).getRenderBlock();
				int meta = world.getBlockMetadata(x, y, z);
				ItemStack dropped = new ItemStack(thisBlock,1,thisBlock.damageDropped(meta));
				int current = player.inventory.currentItem;
				ItemStack currentStack = player.inventory.getStackInSlot(current);
				if (currentStack.isItemEqual(dropped))
				{
					world.removeTileEntity(x, y, z);
					world.setBlock(x, y, z, thisBlock,meta,3);
					if (!player.capabilities.isCreativeMode)
					{
						player.inventory.decrStackSize(current, 1);
					}
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

}
