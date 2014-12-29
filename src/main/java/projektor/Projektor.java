package projektor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import projektor.handler.GUIHandler;
import projektor.helper.LogHelper;
import projektor.proxy.CommonProxy;
import projektor.registry.BlockRegistry;
import projektor.registry.CreativeTabRegistry;
import projektor.registry.DemoSchematicRegistry;

@Mod(modid = Reference.Naming.ID, name = Reference.Naming.NAME, version = Reference.Versioning.VERSION_FULL, acceptedMinecraftVersions = "[1.7.10,)", dependencies = "required-after:Forge@[10.13.0.1180,)")
public class Projektor
{

    // Instancing
    @Mod.Instance(value = Reference.Naming.ID)
    public static Projektor INSTANCE;

    // Public extra data about our mod that Forge uses in the mods listing page for more information.
    @Mod.Metadata(Reference.Naming.ID)
    public static ModMetadata metadata;

    // Creative tab instantiation
    public static CreativeTabs TAB = new CreativeTabRegistry(Reference.Naming.NAME);

    @SidedProxy(clientSide = "projektor.proxy.ClientProxy", serverSide = "projektor.proxy.CommonProxy")
    public static CommonProxy PROXY;

    public static GUIHandler guiHandler = new GUIHandler();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        INSTANCE = this;

        LogHelper.info("Setting up metaData...");
        metadata = Reference.MetaData.init(metadata);

        LogHelper.info("Registering Blocks...");
        BlockRegistry.init();

        DemoSchematicRegistry demo = new DemoSchematicRegistry();
        demo.init();

        // Register GUI handler
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Registering Renderers...");
        PROXY.initRenderers();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Nothing being done here yet
    }
}
