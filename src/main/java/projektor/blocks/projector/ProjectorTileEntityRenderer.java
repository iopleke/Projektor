package projektor.blocks.projector;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import projektor.proxy.BlockContainerProxy;
import projektor.proxy.WorldProxy;

public class ProjectorTileEntityRenderer extends TileEntitySpecialRenderer
{
    ProjectorModel model;
    private RenderBlocks renderBlocks;
    private World world;

    public ProjectorTileEntityRenderer()
    {
        this.model = new ProjectorModel();
        this.world = null;
        this.renderBlocks = new RenderBlocks();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
    {
        if (tileEntity instanceof ProjectorTileEntity)
        {

//			ProjectorTileEntity blueprintProjector = (ProjectorTileEntity) tileEntity;
//			int facing = blueprintProjector.getFacing();
//			GL11.glPushMatrix();
//			GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
//			GL11.glRotatef(180f, 0f, 0f, 1f);
//			GL11.glRotatef((facing * 90.0F), 0.0F, 1.0F, 0.0F);
//			if (blueprintProjector.hasBlueprint())
//			{
//				bindTexture(Resource.Model.PROJECTOR_ON);
//			} else
//			{
//				bindTexture(Resource.Model.PROJECTOR_OFF);
//			}
//			model.render(0.0625F);
//			GL11.glPopMatrix();
//            this.world = tileEntity.getWorldObj();
//            this.renderBlocks = new RenderBlocks((IBlockAccess) world);
            System.out.println("Rendering block at: x" + tileEntity.xCoord + ", y" + tileEntity.yCoord + ", z" + tileEntity.zCoord);
//            renderBlocks.renderBlockByRenderType(Blocks.stone, tileEntity.xCoord, (int) tileEntity.yCoord, (int) tileEntity.zCoord);

            Block skinBlock = Blocks.dirt;
            int skinBlockMetadata = 0;
            RenderBlocks proxyRender = new RenderBlocks(new WorldProxy(world, skinBlockMetadata, 7));
            proxyRender.setRenderBoundsFromBlock(skinBlock);
            if (skinBlockMetadata != 0)
            {
                BlockContainerProxy proxyContainer;
                for (int i = 0; i < 6; i++)
                {
                    proxyRender.setOverrideBlockTexture(skinBlock.getIcon(i, skinBlockMetadata));
                    proxyContainer = new BlockContainerProxy(skinBlock, i);
                    proxyRender.renderStandardBlock(proxyContainer, (int) x, (int) y, (int) z);
                }
            } else
            {
                proxyRender.renderStandardBlock(skinBlock, (int) x, (int) y, (int) z);
            }
            proxyRender.clearOverrideBlockTexture();
        }
    }

}
