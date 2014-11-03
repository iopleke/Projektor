package projektor.blocks.ghostblock;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameData;

public class GhostBlockTE extends TileEntity{
	
	private Block ghostBlock=null;
	
	public GhostBlockTE()
	{
		Iterable<Block> gameBlocks = GameData.getBlockRegistry().typeSafeIterable();
		int numBlocks=0;
		while (gameBlocks.iterator().hasNext()) 
		{
			gameBlocks.iterator().next();
			numBlocks++;
		}
		while (ghostBlock==null)
		{
			int val = this.worldObj.rand.nextInt(numBlocks);
			int i=0;
			Block thisBlock = null;
			while (i<val)
			{
				thisBlock = gameBlocks.iterator().next();
				i++;
			}
			if (thisBlock!=null&&thisBlock.createTileEntity(worldObj, 0)!=null) ghostBlock = thisBlock;
		}
	}
	
	public Block getRenderBlock()
	{
		return ghostBlock;
	}
}
