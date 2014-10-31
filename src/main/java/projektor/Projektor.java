package projektor;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import projektor.proxy.CommonProxy;
import projektor.reference.MetaData;
import projektor.reference.Reference;
import projektor.utils.LogHelper;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION_FULL, acceptedMinecraftVersions = "[1.7.10,)", dependencies = "required-after:Forge@[10.13.0.1180,)")
public class Projektor
{
    // Instancing
    @Mod.Instance(value = Reference.ID)
    public static Projektor INSTANCE;

    // Public extra data about our mod that Forge uses in the mods listing page for more information.
    @Mod.Metadata(Reference.ID)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "projektor.proxy.ClientProxy", serverSide = "projektor.proxy.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        INSTANCE = this;

        LogHelper.info("Setting up metaData...");
        metadata = MetaData.init(metadata);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
