package toast.cook_it.block.containers.cutting_board;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import toast.cook_it.CookIt;

import static toast.cook_it.block.appliances.microwave.Microwave.FACING;


@Environment(EnvType.CLIENT)
public class CuttingBoardEntityRenderer implements BlockEntityRenderer<CuttingBoardEntity> {

    public CuttingBoardEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(CuttingBoardEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        final MinecraftClient client = MinecraftClient.getInstance();

        ItemStack stack = blockEntity.getStack(0);


        if (!stack.isEmpty()) {
            Direction facing = blockEntity.getCachedState().get(FACING);
            float x, y, z;
            int dir = 0;
            switch (facing) {
                case NORTH -> {
                    x = 0.5f;
                    y = 0.625f;
                    z = -0.125f;
                }
                case SOUTH -> {
                    x = -0.5f;
                    y = -0.375f;
                    z = -0.125f;
                    dir = 2;
                }
                case EAST -> {
                    x = 0.5f;
                    y = -0.375f;
                    z = -0.125f;
                    dir = 3;
                }
                case WEST -> {
                    x = -0.5f;
                    y = 0.625f;
                    z = -0.125f;
                    dir = 1;
                }
                default -> {
                    CookIt.LOGGER.error("Cutting board is confused");
                    x = 0.0f;
                    y = 0.0f;
                    z = 0.0f;
                }
            }
            if (Registries.ITEM.getId(stack.getItem()).getNamespace().equals("minecraft")) {
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90 * (dir)));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
                matrices.translate(x, y, z);
            } else {
                matrices.translate(0.5f, 0.5625f, 0.5f);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90 * dir));
            }
            matrices.push();
            matrices.scale(1.0f, 1.0f, 1.0f);

            client.getItemRenderer().renderItem(stack, ModelTransformationMode.NONE, light, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0);
            matrices.pop();
        }
    }
}