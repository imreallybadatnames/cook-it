package toast.cook_it.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// The code you're about to see will scare you. Run while you still can!
public class FireExtinguisherItem extends Item {

    public FireExtinguisherItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        World world = context.getWorld();

        Vec3d pos = user.getPos();
        Vec3d hitPos = context.getHitPos();

        double playerPitch = Math.toRadians(user.getPitch());
        double playerYaw = Math.toRadians(user.getYaw());

        world.playSound(null, hitPos.x, hitPos.y, hitPos.z, SoundEvents.WEATHER_RAIN, SoundCategory.BLOCKS, 1f, 1f);
        if (world instanceof ServerWorld) {
            // Summons particles and removes fire wherever they land
            for (int i = 0; i < 200; i++) {
                double offsetDistance = 4;

                double offsetX = -MathHelper.sin((float) playerYaw) * MathHelper.cos((float) playerPitch) * offsetDistance;
                double offsetY = -MathHelper.sin((float) playerPitch) * offsetDistance;
                double offsetZ = MathHelper.cos((float) playerYaw) * MathHelper.cos((float) playerPitch) * offsetDistance;

                double particleX = pos.x + (hitPos.x - pos.x) * i / 1000 + offsetX + ((Math.random() * 4) - 2);
                double particleY = pos.y + 1 + (hitPos.y + 1 - pos.y) * i / 1000 + offsetY + Math.random() * 2.5;
                double particleZ = pos.z + (hitPos.z - pos.z) * i / 1000 + offsetZ + ((Math.random() * 4) - 2);

                extinguishFire(new BlockPos((int) particleX, (int) particleY, (int) particleZ), (ServerWorld) world);
                ((ServerWorld) world).spawnParticles(ParticleTypes.SPIT, particleX, particleY, particleZ, 1, 0.0f,0.125f,0.0f,0f);
            }
        }

        // Damage the item
        context.getStack().damage(1, user, playerEntity -> user.sendToolBreakStatus(user.getActiveHand()));

        return ActionResult.PASS;
    }

    private void extinguishFire(BlockPos pos, ServerWorld world) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.isIn(BlockTags.FIRE)) {
            world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 1f);
            world.breakBlock(pos, false, null);
        }
    }
}