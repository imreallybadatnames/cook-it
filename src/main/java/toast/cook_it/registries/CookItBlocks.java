package toast.cook_it.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import toast.cook_it.CookIt;
import toast.cook_it.block.CuttingBoard;
import toast.cook_it.block.Toaster;
import toast.cook_it.block.appliances.microwave.Microwave;
import toast.cook_it.block.appliances.oven.Oven;
import toast.cook_it.block.containers.baking_sheet.BakingSheet;
import toast.cook_it.block.containers.plate.LargePlate;
import toast.cook_it.block.containers.plate.Plate;
import toast.cook_it.block.food_blocks.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class CookItBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block CUTTING_BOARD = registerBlock("cutting_board", new CuttingBoard(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)));
    public static final Block TOASTER = registerBlock("toaster", new Toaster(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));
    public static final Block BAKING_SHEET = registerBlock("baking_sheet", new BakingSheet(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block BENCH = registerBlock("bench", new Block(FabricBlockSettings.create()));
    public static final Block OVEN = registerBlock("oven", new Oven(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block MICROWAVE = registerBlock("microwave", new Microwave(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block PLATE = registerBlock("plate", new Plate(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)));
    public static final Block LARGE_PLATE = registerBlock("large_plate", new LargePlate(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)));
    public static final Block PIZZA = registerBlock("pizza", new Pizza(FabricBlockSettings.copyOf(Blocks.CAKE)));


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        CookItBlocks.BLOCKS.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(CookIt.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CookIt.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {

    }


}
