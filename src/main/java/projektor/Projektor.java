package projektor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import projektor.proxy.CommonProxy;
import projektor.reference.MetaData;
import projektor.reference.Naming;
import projektor.registry.CreativeTabProjektor;
import projektor.registry.Register;
import projektor.utils.LogHelper;

@Mod(modid = Naming.ID, name = Naming.NAME, version = Naming.VERSION_FULL, acceptedMinecraftVersions = "[1.7.10,)", dependencies = "required-after:Forge@[10.13.0.1180,)")
public class Projektor
{

	// Instancing
	@Mod.Instance(value = Naming.ID)
	public static Projektor INSTANCE;

	// Public extra data about our mod that Forge uses in the mods listing page for more information.
	@Mod.Metadata(Naming.ID)
	public static ModMetadata metadata;

	// Creative tab instantiation
	public static CreativeTabs TAB = new CreativeTabProjektor(Naming.NAME);

	@SidedProxy(clientSide = "projektor.proxy.ClientProxy", serverSide = "projektor.proxy.CommonProxy")
	public static CommonProxy PROXY;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		INSTANCE = this;

		LogHelper.info("Setting up metaData...");
		metadata = MetaData.init(metadata);

		LogHelper.info("Registering Blocks...");
		Register.blocks();

		LogHelper.info("Registering Renderers...");
		PROXY.initRenderers();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(EventsHandler.INSTANCE);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
