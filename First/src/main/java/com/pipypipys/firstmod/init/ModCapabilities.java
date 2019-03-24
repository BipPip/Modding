package com.pipypipys.firstmod.init;



import com.pipypipys.firstmod.capabilities.RPG;

import com.pipypipys.firstmod.capabilities.IRPG;
import com.pipypipys.firstmod.capabilities.RPG;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ModCapabilities {

	
	
	public static void registerCapabilities () {
		CapabilityManager.INSTANCE.register(IRPG.class, new CapabilitiyRPG(), RPG.class);
		
		
	}
	
	
	
	public static class CapabilitiyRPG implements IStorage<IRPG> {
		
		

		@Override
		public NBTBase writeNBT(Capability<IRPG> capability, IRPG instance, EnumFacing side) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void readNBT(Capability<IRPG> capability, IRPG instance, EnumFacing side, NBTBase nbt) {
			// TODO Auto-generated method stub
			
		}
	}
}
