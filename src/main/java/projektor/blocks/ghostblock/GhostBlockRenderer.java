package projektor.blocks.ghostblock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class GhostBlockRenderer extends TileEntitySpecialRenderer
{

    private static RenderBlocks renderBlocks = new RenderBlocks();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
    {
        Block render = Blocks.dirt;
        renderBlocks.renderBlockByRenderType(render, (int) x, (int) y, (int) z);
    }

}
