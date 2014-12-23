package projektor.proxy;

import projektor.registry.RenderRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void initRenderers()
    {
        RenderRegistry.init();
    }

}
