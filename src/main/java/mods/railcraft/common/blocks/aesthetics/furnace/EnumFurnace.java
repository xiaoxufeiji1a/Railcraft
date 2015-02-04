package mods.railcraft.common.blocks.aesthetics.furnace;

public enum EnumFurnace {

    FURNACE_ABYSSAL,
    FURNACE_BLEACHEDBONE,
    FURNACE_BLOODSTAINED,
    FURNACE_FROSTBOUND,
    FURNACE_INFERNAL,
    FURNACE_NETHER,
    FURNACE_QUARRIED,
    FURNACE_SANDY;

    public static EnumFurnace fromMeta(int meta) {
        return values()[meta];
    }

}
