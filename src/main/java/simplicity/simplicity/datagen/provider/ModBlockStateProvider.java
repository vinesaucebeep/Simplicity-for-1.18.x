package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.common.properties.blocks.BlueberryBushBlock;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

/**
 * Author: Autovw
 */
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeAllModBlock(BlockInit.RUBY_ORE.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ruby_ore"));
        cubeAllModBlock(BlockInit.DEEPSLATE_RUBY_ORE.get(), new ResourceLocation(Simplicity.MOD_ID, "block/deepslate_ruby_ore"));
        cubeAllModBlock(BlockInit.RUBY_BLOCK.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ruby_block"));

        logModBlock(BlockInit.EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log_top"));
        logModBlock(BlockInit.STRIPPED_EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log_top"));

        flowerModBlock(BlockInit.RED_CORNFLOWER.get(), new ResourceLocation(Simplicity.MOD_ID, "block/red_cornflower"));

        bushModBlock(BlockInit.BLUEBERRY_BUSH.get(), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage0"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage1"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage2"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage3"), ItemInit.BLUEBERRIES.get(), new ResourceLocation(Simplicity.MOD_ID, "item/blueberries"));
    }

    /**
     * Generates an item model, block model and blockstate for a block at once
     * @param block     Block you want to generate models and blockstates for
     * @param texture   Block texture
     */
    protected void cubeAllModBlock(Block block, ResourceLocation texture) {
        String path = block.getRegistryName().getPath();
        simpleBlock(block, models().cubeAll(path, texture));
        itemModels().withExistingParent(path, new ResourceLocation(block.getRegistryName().getNamespace(), "block/" + path));
    }

    /**
     * Generates an item model, block model and blockstate for a log block at once
     * @param log           Log you want to generate models and blockstates for
     * @param textureSide   Side texture
     * @param textureTop    Top texture
     */
    protected void logModBlock(Block log, ResourceLocation textureSide, ResourceLocation textureTop) {
        String path = log.getRegistryName().getPath();
        axisBlock((RotatedPillarBlock) log, textureSide, textureTop);
        itemModels().withExistingParent(path, new ResourceLocation(log.getRegistryName().getNamespace(), "block/" + path));
    }

    /**
     * Generates an item model, block model and blockstate for a flower block at once
     * @param flower    Flower block you want to generate models and blockstates for
     * @param texture   Flower texture
     */
    protected void flowerModBlock(Block flower, ResourceLocation texture) {
        String path = flower.getRegistryName().getPath();
        simpleBlock(flower, models().cross(path, texture));
        itemModels().withExistingParent(path, new ResourceLocation("item/generated")).texture("layer0", "block/" + path);

    }

    protected void bushModBlock(Block bush, ResourceLocation textureStage0, ResourceLocation textureStage1, ResourceLocation textureStage2, ResourceLocation textureStage3, Item itemVariant, ResourceLocation itemTexture) {
        String path = bush.getRegistryName().getPath();
        String itemPath = itemVariant.getRegistryName().getPath();
        ConfiguredModel stage0 = new ConfiguredModel(models().cross(path + "_stage0", textureStage0));
        ConfiguredModel stage1 = new ConfiguredModel(models().cross(path + "_stage1", textureStage1));
        ConfiguredModel stage2 = new ConfiguredModel(models().cross(path + "_stage2", textureStage2));
        ConfiguredModel stage3 = new ConfiguredModel(models().cross(path + "_stage3", textureStage3));
        getVariantBuilder(bush).partialState().setModels(stage0, stage1, stage2, stage3);
        itemModels().withExistingParent(itemPath, new ResourceLocation("item/generated")).texture("layer0", itemTexture);
    }

}
