package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ModTags;

import java.util.Collection;

/**
 * Author: Autovw
 */
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    /**
     * Add block tags here
     */
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockInit.EBONY_PLANKS.get())
                .add(BlockInit.EBONY_LOG.get())
                .add(BlockInit.STRIPPED_EBONY_LOG.get());


        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.RUBY_ORE.get())
                .add(BlockInit.BLUE_NETHER_BRICKS.get())
                .add(BlockInit.DEEPSLATE_RUBY_ORE.get())
                .add(BlockInit.RUBY_BLOCK.get());

        tag(BlockTags.SMALL_FLOWERS)
                .add(BlockInit.RED_CORNFLOWER.get());

        tag(BlockTags.REPLACEABLE_PLANTS)
                .add(BlockInit.BLUEBERRY_BUSH.get());

        tag(BlockTags.PLANKS)
                .add(BlockInit.EBONY_PLANKS.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockInit.STRIPPED_EBONY_LOG.get())
                .add(BlockInit.EBONY_LOG.get());


    }


}
