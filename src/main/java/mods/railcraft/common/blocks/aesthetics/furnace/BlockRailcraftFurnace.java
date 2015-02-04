package mods.railcraft.common.blocks.aesthetics.furnace;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRailcraftFurnace extends BlockContainer {

    public BlockRailcraftFurnace() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileRailcraftFurnace();
    }
}
