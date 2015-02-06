package mods.railcraft.common.items;

import mods.railcraft.common.blocks.ItemBlockRailcraftMultiType;
import mods.railcraft.common.blocks.aesthetics.furnace.EnumFurnace;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemRailcraftFurnace extends ItemBlockRailcraftMultiType {

    public ItemRailcraftFurnace(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int itemDamage = itemStack.getItemDamage();
        return EnumFurnace.fromMeta(itemDamage).getUnlocalizedName();
    }
}
