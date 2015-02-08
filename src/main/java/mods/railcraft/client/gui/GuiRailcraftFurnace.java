package mods.railcraft.client.gui;

import mods.railcraft.common.blocks.aesthetics.furnace.TileRailcraftFurnace;
import mods.railcraft.common.gui.containers.ContainerRailcraftFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiRailcraftFurnace extends TileGui {

    public GuiRailcraftFurnace(InventoryPlayer inventoryPlayer, TileRailcraftFurnace tileRailcraftFurnace) {
        super(tileRailcraftFurnace, new ContainerRailcraftFurnace(), "");
    }
}
