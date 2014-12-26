package projektor.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import projektor.io.IO;
import projektor.schematic.BasicSchematic;
import projektor.schematic.BlockWithMetaStorage;

/**
 *
 * @author jakimfett
 */
public class DemoSchematicRegistry
{

    public static BasicSchematic threeByOneByThreeSchematic;
    public static BasicSchematic threeByThreeByThreeSchematic;

    public void init()
    {
        threeByOneByThreeSchematic = new BasicSchematic("3x1x3");
        threeByOneByThreeSchematic.setSchematic(this.threeByOneByThree());
        GameRegistry.registerItem(threeByOneByThreeSchematic, threeByOneByThreeSchematic.getUnlocalizedName());

        threeByThreeByThreeSchematic = new BasicSchematic("3x3x3");
        threeByThreeByThreeSchematic.setSchematic(this.threeByThreeByThree());
        GameRegistry.registerItem(threeByThreeByThreeSchematic, threeByThreeByThreeSchematic.getUnlocalizedName());

        BlockWithMetaStorage[][][] schematicArray = new BlockWithMetaStorage[1][1][1];

        schematicArray[0][0][0] = new BlockWithMetaStorage(Blocks.anvil, 0);

        IO.serialize(schematicArray, "defaultSchematic");

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

    public BlockWithMetaStorage[][][] threeByThreeByThree()
    {
        BlockWithMetaStorage[][][] threeByThreeByThree = new BlockWithMetaStorage[3][3][3];

        threeByThreeByThree[0][0][0] = new BlockWithMetaStorage(Blocks.anvil, 0);
        threeByThreeByThree[0][0][1] = new BlockWithMetaStorage(Blocks.stone, 0);
        threeByThreeByThree[0][0][2] = new BlockWithMetaStorage(Blocks.bedrock, 0);
        threeByThreeByThree[1][0][0] = new BlockWithMetaStorage(Blocks.clay, 0);
        threeByThreeByThree[1][0][1] = new BlockWithMetaStorage(Blocks.brick_block, 0);
        threeByThreeByThree[1][0][2] = new BlockWithMetaStorage(Blocks.wool, 2);
        threeByThreeByThree[2][0][0] = new BlockWithMetaStorage(Blocks.cobblestone, 0);
        threeByThreeByThree[2][0][1] = new BlockWithMetaStorage(Blocks.soul_sand, 0);
        threeByThreeByThree[2][0][2] = new BlockWithMetaStorage(Blocks.bookshelf, 0);
        threeByThreeByThree[0][2][0] = new BlockWithMetaStorage(Blocks.anvil, 0);
        threeByThreeByThree[0][2][1] = new BlockWithMetaStorage(Blocks.stone, 0);
        threeByThreeByThree[0][2][2] = new BlockWithMetaStorage(Blocks.bedrock, 0);
        threeByThreeByThree[1][2][0] = new BlockWithMetaStorage(Blocks.clay, 0);
        threeByThreeByThree[1][2][1] = new BlockWithMetaStorage(Blocks.brick_block, 0);
        threeByThreeByThree[1][2][2] = new BlockWithMetaStorage(Blocks.wool, 2);
        threeByThreeByThree[2][2][0] = new BlockWithMetaStorage(Blocks.cobblestone, 0);
        threeByThreeByThree[2][2][1] = new BlockWithMetaStorage(Blocks.soul_sand, 0);
        threeByThreeByThree[2][2][2] = new BlockWithMetaStorage(Blocks.bookshelf, 0);

        return threeByThreeByThree;
    }

}
