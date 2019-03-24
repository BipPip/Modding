package com.pipypipys.firstmod.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Mana provider
 *
 * This class is responsible for providing a capability. Other modders may 
 * attach their own provider with implementation that returns another 
 * implementation of IMana to the target's (Entity, TE, ItemStack, etc.) disposal.
 */
public class RPGProvider implements ICapabilitySerializable<NBTBase>
{
    @CapabilityInject(IRPG.class)
    public static final Capability<IRPG> CAPABILTIY_RPG = null;

    private IRPG instance = CAPABILTIY_RPG.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
    	
        return capability == CAPABILTIY_RPG;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == CAPABILTIY_RPG ? CAPABILTIY_RPG.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return CAPABILTIY_RPG.getStorage().writeNBT(CAPABILTIY_RPG, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
    	CAPABILTIY_RPG.getStorage().readNBT(CAPABILTIY_RPG, this.instance, null, nbt);
    }
}