package com.pipypipys.firstmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGioZombie extends EntityZombie {

	public EntityGioZombie(World worldIn) {
		super(worldIn);
		//this.setSize(3F, 3F);
		
		
	}
	

	
	@Override
	protected SoundEvent getAmbientSound() {
		return super.getAmbientSound();
		
	}
	
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return super.getHurtSound(source);
		
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();
		
	}

	
	// Use these if it extends entity and not EntityZombie
	
	/*
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}
	*/

}
