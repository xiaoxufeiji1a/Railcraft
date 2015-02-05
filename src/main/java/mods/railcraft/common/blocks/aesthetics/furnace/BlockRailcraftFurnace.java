package mods.railcraft.common.blocks.aesthetics.furnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft.common.core.RailcraftConfig;
import mods.railcraft.common.items.ItemRailcraftFurnace;
import mods.railcraft.common.plugins.forge.CreativePlugin;
import mods.railcraft.common.plugins.forge.RailcraftRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockRailcraftFurnace extends BlockContainer {

    public static final String TAG = "railcraft.furnace";
    private static Block block;

    public BlockRailcraftFurnace() {
        super(Material.rock);
        setCreativeTab(CreativePlugin.RAILCRAFT_TAB);
    }

    public static Block getBlock() {
        return block;
    }

    public static void registerBlock() {
        if (block == null && RailcraftConfig.isBlockEnabled(TAG)) {
            block = new BlockRailcraftFurnace();
            RailcraftRegistry.register(block, ItemRailcraftFurnace.class);
        }
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (EnumFurnace furnace : EnumFurnace.values()) {
            list.add(new ItemStack(block, 1, furnace.ordinal()));
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int itemDamage = itemStack.getItemDamage();
        world.setBlockMetadataWithNotify(x, y, z, itemDamage, 2);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        entityLivingBase.
        if (tileEntity != null && tileEntity instanceof TileRailcraftFurnace)
            ((TileRailcraftFurnace) tileEntity).setFacingDirection();
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
