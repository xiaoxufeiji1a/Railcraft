package mods.railcraft.common.blocks.aesthetics.furnace;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public enum EnumFurnace {

    ABYSSAL,
    BLEACHEDBONE,
    BLOODSTAINED,
    FROSTBOUND,
    INFERNAL,
    NETHER,
    QUARRIED,
    SANDY;

    private IIcon iconFrontOff;
    private IIcon iconFrontOn;
    private IIcon iconSide;
    private IIcon iconTop;

    public static EnumFurnace fromMeta(int meta) {
        return values()[meta];
    }

    public String[] getIconTags() {
        String[] tags = new String[4];
        String prefix = "railcraft:furnaces/furnace_";
        String name = name().toLowerCase();
        tags[0] = prefix + name + "_front_off";
        tags[1] = prefix + name + "_front_on";
        tags[2] = prefix + name + "_side";
        tags[3] = prefix + name + "_top";
        return tags;
    }

    public IIcon getIcon(int side, ForgeDirection facingDirection, boolean burning) {
        ForgeDirection direction = ForgeDirection.getOrientation(side);
        if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN) {
            return iconTop;
        } else if (direction == facingDirection || direction == facingDirection.getOpposite()) {
            if (burning) {
                return iconFrontOn;
            } else {
                return iconFrontOff;
            }
        } else {
            return iconSide;
        }
    }

    public void setIcons(IIcon[] icons) {
        iconFrontOff = icons[0];
        iconFrontOn = icons[1];
        iconSide = icons[2];
        iconTop = icons[3];
    }

    public String getUnlocalizedName() {
        return "item.railcraft.furnace." + name().toLowerCase();
    }

    public ItemStack getItemStack() {
        return new ItemStack(BlockRailcraftFurnace.getBlock(), 1, ordinal());
    }
}
