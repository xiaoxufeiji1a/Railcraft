package mods.railcraft.common.blocks.aesthetics.furnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRailcraftFurnace extends BlockContainer {

    public BlockRailcraftFurnace() {
        super(Material.rock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
        if (tileEntity != null && tileEntity instanceof TileRailcraftFurnace) {
            TileRailcraftFurnace tileRailcraftFurnace = (TileRailcraftFurnace) tileEntity;
            return tileRailcraftFurnace.getIcon(side);
        }
        int meta = blockAccess.getBlockMetadata(x, y, z);
        return getIcon(side, meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        for (EnumFurnace furnace : EnumFurnace.values()) {
            String[] iconTags = furnace.getIconTags();
            IIcon[] icons = new IIcon[iconTags.length];
            for (int i = 0; i < iconTags.length; i++) {
                String tag = iconTags[i];
                icons[i] = register.registerIcon(tag);
            }
            furnace.setIcons(icons);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        EnumFurnace furnace = EnumFurnace.fromMeta(meta);
        return new TileRailcraftFurnace(furnace);
    }
}
