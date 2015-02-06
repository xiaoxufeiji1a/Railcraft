package mods.railcraft.common.blocks.aesthetics.furnace;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class TileRailcraftFurnace extends TileEntityFurnace {

    private final EnumFurnace furnace;
    private ForgeDirection facingDirection = ForgeDirection.NORTH; // todo remove default value

    public TileRailcraftFurnace(EnumFurnace furnace) {
        this.furnace = furnace;
    }

    public IIcon getIcon(int side) {
        return furnace.getIcon(side, facingDirection, isBurning());
    }

    public void setFacingDirection(ForgeDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        String facingName = tagCompound.getString("facing");
        facingDirection = ForgeDirection.valueOf(facingName);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        String facingName = facingDirection.name();
        tagCompound.setString("facing", facingName);
    }
}
