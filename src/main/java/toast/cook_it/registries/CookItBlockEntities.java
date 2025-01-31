package toast.cook_it.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import toast.cook_it.CookIt;
import toast.cook_it.block.appliances.fryer.FryerEntity;
import toast.cook_it.block.appliances.fryer.FryerEntityRenderer;
import toast.cook_it.block.appliances.microwave.MicrowaveEntity;
import toast.cook_it.block.appliances.microwave.MicrowaveEntityRenderer;
import toast.cook_it.block.appliances.oven.OvenEntity;
import toast.cook_it.block.appliances.oven.OvenEntityRenderer;
import toast.cook_it.block.containers.baking_sheet.BakingSheetEntity;
import toast.cook_it.block.containers.baking_sheet.BakingSheetEntityRenderer;
import toast.cook_it.block.containers.cutting_board.CuttingBoardEntity;
import toast.cook_it.block.containers.cutting_board.CuttingBoardEntityRenderer;
import toast.cook_it.block.containers.muffin_tin.MuffinTinEntity;
import toast.cook_it.block.containers.muffin_tin.MuffinTinEntityRenderer;
import toast.cook_it.block.containers.plate.PlateEntity;
import toast.cook_it.block.containers.plate.PlateEntityRenderer;


public class CookItBlockEntities {
    public static BlockEntityType<MuffinTinEntity> MUFFIN_TIN_ENTITY;
    public static BlockEntityType<BakingSheetEntity> BAKING_SHEET_ENTITY;
    public static BlockEntityType<MicrowaveEntity> MICROWAVE_ENTITY;
    public static BlockEntityType<OvenEntity> OVEN_ENTITY;
    public static BlockEntityType<PlateEntity> PLATE_ENTITY;
    public static BlockEntityType<FryerEntity> FRYER_ENTITY;
    public static BlockEntityType<CuttingBoardEntity> CUTTING_BOARD_ENTITY;

    public static void registerEntities() {
        BAKING_SHEET_ENTITY = registerBlockEntities("baking_sheet", BakingSheetEntity::new, new Block[]{CookItBlocks.BAKING_SHEET});
        MUFFIN_TIN_ENTITY =registerBlockEntities("muffin_tin", MuffinTinEntity::new, new Block[]{CookItBlocks.MUFFIN_TIN});
        MICROWAVE_ENTITY = registerBlockEntities("microwave", MicrowaveEntity::new, new Block[]{CookItBlocks.MICROWAVE});
        OVEN_ENTITY = registerBlockEntities("oven", OvenEntity::new, new Block[]{CookItBlocks.OVEN});
        PLATE_ENTITY = registerBlockEntities("plate", PlateEntity::new, CookItBlocks.PLATES.toArray(Block[]::new));
        FRYER_ENTITY = registerBlockEntities("fryer", FryerEntity::new, new Block[]{CookItBlocks.FRYER});
        CUTTING_BOARD_ENTITY = registerBlockEntities("cutting_board", CuttingBoardEntity::new, new Block[]{CookItBlocks.CUTTING_BOARD});

    }

    public static void registerRenderers() {
        BlockEntityRendererFactories.register(BAKING_SHEET_ENTITY, BakingSheetEntityRenderer::new);
        BlockEntityRendererFactories.register(MUFFIN_TIN_ENTITY, MuffinTinEntityRenderer::new);
        BlockEntityRendererFactories.register(MICROWAVE_ENTITY, MicrowaveEntityRenderer::new);
        BlockEntityRendererFactories.register(OVEN_ENTITY, OvenEntityRenderer::new);
        BlockEntityRendererFactories.register(PLATE_ENTITY, PlateEntityRenderer::new);
        BlockEntityRendererFactories.register(FRYER_ENTITY, FryerEntityRenderer::new);
        BlockEntityRendererFactories.register(CUTTING_BOARD_ENTITY, CuttingBoardEntityRenderer::new);

    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntities(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block[] block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CookIt.MOD_ID, name), FabricBlockEntityTypeBuilder.create(factory, block).build());
    }
}
