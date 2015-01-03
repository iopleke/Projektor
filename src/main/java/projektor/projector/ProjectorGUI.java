package projektor.projector;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import projektor.Reference;

/**
 *
 * @author jakimfett
 */
public class ProjectorGUI extends GuiContainer
{

    public ProjectorGUI(InventoryPlayer inventoryPlayer, ProjectorTileEntity projector)
    {
        super(new ProjectorContainer(inventoryPlayer, projector));

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int mousex, int mousey)
    {
        this.mc.renderEngine.bindTexture(Reference.GUI.PROJECTOR);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

}
