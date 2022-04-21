package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

import java.util.function.Consumer;

/**
 * Author: Autovw
 */
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        rubyBlockRecipes(consumer);
    }

    private void rubyBlockRecipes(Consumer<FinishedRecipe> consumer) {
        // Ruby item to Ruby Block
        ShapedRecipeBuilder.shaped(ItemInit.RUBY_BLOCK.get(), 1)
                .define('#', ItemInit.RUBY.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_ruby", has(ItemInit.RUBY.get()))
                .save(consumer);

        // Ruby Block to Ruby item
        ShapelessRecipeBuilder.shapeless(ItemInit.RUBY.get(), 9)
                .requires(ItemInit.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", has(ItemInit.RUBY_BLOCK.get()))
                .save(consumer, new ResourceLocation(Simplicity.MOD_ID, "ruby_from_block"));
    }
}