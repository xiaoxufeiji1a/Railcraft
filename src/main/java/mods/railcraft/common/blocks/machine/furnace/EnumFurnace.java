package mods.railcraft.common.blocks.machine.furnace;

import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.blocks.machine.IEnumMachine;
import mods.railcraft.common.gui.tooltips.ToolTip;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public enum EnumFurnace implements IEnumMachine {

    FURNACE_ABYSSAL,
    FURNACE_BLEACHEDBONE,
    FURNACE_BLOODSTAINED,
    FURNACE_FROSTBOUND,
    FURNACE_INFERNAL,
    FURNACE_NETHER,
    FURNACE_QUARRIED,
    FURNACE_SANDY;



    @Override
    public String getTag() {
        return null;
    }

    @Override
    public boolean isAvaliable() {
        return false;
    }

    @Override
    public ItemStack getItem() {
        return getItem(1);
    }

    @Override
    public ItemStack getItem(int qty) {
        Block block = getBlock();
        if (block == null)
            return null;
        return new ItemStack(block, qty, ordinal());
    }

    @Override
    public IIcon getTexture(int side) {
        return null;
    }

    @Override
    public Class getTileClass() {
        return TileRailcraftFurnace.class;
    }

    @Override
    public TileEntity getTileEntity() {
        return new TileRailcraftFurnace();
    }

    @Override
    public ToolTip getToolTip(ItemStack stack, EntityPlayer player, boolean adv) {
        return null;
    }

    @Override
    public Block getBlock() {
        return RailcraftBlocks.getBlockMachineZeta();
    }

    @Override
    public boolean isDepreciated() {
        return false;
    }


    public static IEnumMachine fromId(int meta) {
        return EnumFurnace.values()[meta];
    }
}
