package com.pipypipys.firstmod.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * This class is responsible for saving and reading mana data from or to server
 */
public class RPGStorage implements IStorage<IRPG>
{
    @Override
    public NBTBase writeNBT(Capability<IRPG> capability, IRPG instance, EnumFacing side)
    {
        return new NBTTagString(instance.getPlayerClass());
    }

    @Override
    public void readNBT(Capability<IRPG> capability, IRPG instance, EnumFacing side, NBTBase nbt)
    {
        instance.setPlayerClass(((NBTTagString) nbt).getString());
    }
}