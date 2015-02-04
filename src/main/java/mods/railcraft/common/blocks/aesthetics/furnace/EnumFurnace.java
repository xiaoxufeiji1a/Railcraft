package mods.railcraft.common.blocks.aesthetics.furnace;

import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public enum EnumFurnace {

    FURNACE_ABYSSAL,
    FURNACE_BLEACHEDBONE,
    FURNACE_BLOODSTAINED,
    FURNACE_FROSTBOUND,
    FURNACE_INFERNAL,
    FURNACE_NETHER,
    FURNACE_QUARRIED,
    FURNACE_SANDY;

    private IIcon iconFrontOff;
    private IIcon iconFrontOn;
    private IIcon iconSide;
    private IIcon iconTop;

    public static EnumFurnace fromMeta(int meta) {
        return values()[meta];
    }

    public String[] getIconTags() {
        String[] tags = new String[4];
        String name = name().toLowerCase();
        tags[0] = "railcraft:furnaces/" + name + "_front_off";
        tags[1] = "railcraft:furnaces/" + name + "_front_on";
        tags[2] = "railcraft:furnaces/" + name + "_side";
        tags[3] = "railcraft:furnaces/" + name + "_top";
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
}
