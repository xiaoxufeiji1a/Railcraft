package mods.railcraft.common.blocks.machine.furnace;

import mods.railcraft.common.blocks.machine.IEnumMachine;
import mods.railcraft.common.blocks.machine.IMachineProxy;
import net.minecraft.client.renderer.texture.IIconRegister;

import java.util.List;

public class MachineProxyZeta implements IMachineProxy {

    @Override
    public IEnumMachine getMachine(int meta) {
        return EnumFurnace.fromId(meta);
    }

    @Override
    public List<? extends IEnumMachine> getCreativeList() {
        return null;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {

    }
}
