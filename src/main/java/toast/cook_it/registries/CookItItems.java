package toast.cook_it.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import toast.cook_it.CookIt;
import toast.cook_it.item.FireExtinguisherItem;
import toast.cook_it.item.Fries;
import toast.cook_it.item.FryerBasket;

import java.util.ArrayList;
import java.util.List;

import static toast.cook_it.registries.CookItBlocks.BLOCKS;

public class CookItItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    // -- Utensils --
    public static final Item ROLLING_PIN = registerItem("rolling_pin", new Item(new FabricItemSettings()));
    public static final Item KITCHEN_KNIFE = registerItem("knife", new SwordItem(ToolMaterials.IRON, 1, -2, new FabricItemSettings()));
    public static final Item BUTCHER_KNIFE = registerItem("butcher_knife", new SwordItem(ToolMaterials.IRON, 1, -1, new FabricItemSettings()));
    public static final Item SPATULA = registerItem("spatula", new Item(new FabricItemSettings()));
    public static final Item WHISK = registerItem("whisk", new Item(new FabricItemSettings()));
    public static final Item DONUT_CUTTER = registerItem("donut_cutter", new Item(new FabricItemSettings()));
    public static final Item FRYER_BASKET = registerItem("fryer_basket", new FryerBasket(new FabricItemSettings().maxCount(1)));

    // -- Ingredients --
    public static final Item DOUGH = registerItem("dough", new Item(new FabricItemSettings()));
    public static final Item DOUGH_ROLLED = registerItem("dough_rolled", new Item(new FabricItemSettings()));
    public static final Item UNCOOKED_FRENCH_FRIES = registerItem("uncooked_french_fries", new Fries(new FabricItemSettings()));

    // -- Food --
    public static final Item TOAST = registerItem("toast", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).build())));
    public static final Item RAW_CROISSANT = registerItem("raw_croissant", new Item(new FabricItemSettings()));
    public static final Item CROISSANT = registerItem("croissant", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).build())));
    public static final Item PIZZA_SLICE = registerItem("pizza_slice", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).build())));
    public static final Item FRENCH_FRIES = registerItem("french_fries", new Fries(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    public static final Item RAW_DONUT = registerItem("raw_donut", new Item(new FabricItemSettings()));
    public static final Item DONUT = registerItem("plain_donut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).build())));
    public static final Item CHOCOLATE_GLAZED_DONUT = registerItem("chocolate_glazed_donut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    public static final Item CHOCOLATE_GLAZED_DONUT_FROSTED = registerItem("chocolate_glazed_donut_frosted", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    public static final Item PINK_GLAZED_DONUT = registerItem("pink_glazed_donut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    public static final Item VANILLA_GLAZED_DONUT = registerItem("vanilla_glazed_donut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    public static final Item VANILLA_GLAZED_DONUT_FROSTED = registerItem("vanilla_glazed_donut_frosted", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));
    private static final Item DONUT_WITH_NUTS = registerItem("peanut_donut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));

    public static final Item MUFFIN = registerItem("plain_muffin", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).build())));
    public static final Item BLUEBERRY_MUFFIN = registerItem("blueberry_muffin", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).build())));
    public static final Item CHOCOLATE_CHIP_MUFFIN = registerItem("chocolate_chip_muffin", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).build())));
    public static final Item CHOCOLATE_MUFFIN = registerItem("chocolate_muffin", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).build())));

    public static final Item CINNAMON_ROLL = registerItem("cinnamon_roll", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).build())));
    public static final Item CINNAMON_ROLL_GLAZED = registerItem("cinnamon_roll_glazed", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));


    // -- Miscellaneous --
    public static final Item FIRE_EXTINGUISHER = registerItem("fire_extinguisher", new FireExtinguisherItem(new FabricItemSettings().maxDamage(256)));
    public static final Item CHEF_HAT = registerItem("chef_hat", new Item(new FabricItemSettings().equipmentSlot(stack -> EquipmentSlot.HEAD)));

    // public static final Item MILK = registerItem("milk", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        CookItItems.ITEMS.add(item);

        return Registry.register(Registries.ITEM, new Identifier(CookIt.MOD_ID, name), item);
    }
    public static void registerItems() {
    }
     public static final ItemGroup COOK_IT_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CHEF_HAT))
            .displayName(Text.translatable("itemGroup.cook-it.items"))
            .entries((context, entries) -> {
                for (Item item : ITEMS) {
                    entries.add(item);
                }
                for (Block block : BLOCKS) {
                    entries.add(block);
                }
            })
            .build();
}

