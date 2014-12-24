package projektor.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import projektor.schematic.BasicSchematic;
import projektor.schematic.BlockWithMetaStorage;

/**
 *
 * @author jakimfett
 */
public class DemoSchematicRegistry
{
    public void init()
    {
        BasicSchematic threeByOneByThreeSchematic = new BasicSchematic();
        threeByOneByThreeSchematic.setSchematic(this.threeByOneByThree());
        GameRegistry.registerItem(threeByOneByThreeSchematic, threeByOneByThreeSchematic.getUnlocalizedName());

    }

    public BlockWithMetaStorage[][][] threeByOneByThree()
    {
        BlockWithMetaStorage[][][] threeByOneByThree = new BlockWithMetaStorage[3][1][3];

        threeByOneByThree[0][0][0] = new BlockWithMetaStorage(Blocks.anvil, 0);
        threeByOneByThree[0][0][1] = new BlockWithMetaStorage(Blocks.stone, 0);
        threeByOneByThree[0][0][2] = new BlockWithMetaStorage(Blocks.bedrock, 0);
        threeByOneByThree[1][0][0] = new BlockWithMetaStorage(Blocks.clay, 0);
        threeByOneByThree[1][0][1] = new BlockWithMetaStorage(Blocks.brick_block, 0);
        threeByOneByThree[1][0][2] = new BlockWithMetaStorage(Blocks.wool, 2);
        threeByOneByThree[2][0][0] = new BlockWithMetaStorage(Blocks.cobblestone, 0);
        threeByOneByThree[2][0][1] = new BlockWithMetaStorage(Blocks.soul_sand, 0);
        threeByOneByThree[2][0][2] = new BlockWithMetaStorage(Blocks.bookshelf, 0);

        return threeByOneByThree;
    }

}
