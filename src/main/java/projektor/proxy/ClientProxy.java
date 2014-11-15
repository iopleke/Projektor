package projektor.proxy;

import projektor.registry.Register;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		Register.renderers();
	}

}
