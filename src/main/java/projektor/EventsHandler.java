package projektor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class EventsHandler
{

	public static EventsHandler INSTANCE = new EventsHandler();
	private static final RenderBlocks renderBlocks = new RenderBlocks();

	@SubscribeEvent
	public void RenderWorld(RenderWorldLastEvent event)
	{
		renderBlocks.renderBlockByRenderType(Blocks.dirt, 100, 100, 100);
	}
}
