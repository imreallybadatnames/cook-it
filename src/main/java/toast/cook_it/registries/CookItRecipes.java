package toast.cook_it.registries;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import toast.cook_it.recipes.MicrowaveRecipe;

public class CookItRecipes {

    public static void registerRecipes() {

        Registry.register(Registries.RECIPE_SERIALIZER,MicrowaveRecipe.Serializer.ID,
                MicrowaveRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, MicrowaveRecipe.Type.ID,
                MicrowaveRecipe.Type.INSTANCE);

    }
}