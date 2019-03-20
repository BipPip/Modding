package com.pipypipys.firstmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityTurtle extends EntityPig {

	public EntityTurtle(World worldIn) {
		super(worldIn);
		this.setSize(0.3F, 0.3F);
		
		
	}
	

	@Override
	public EntityPig createChild(EntityAgeable ageable) {
		return new EntityTurtle(world);
	}
	
	@Override
	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10D);
	    }

	@Override   
	protected ResourceLocation getLootTable()
	    {
	        return null;
	    }

	
	
	@Override
	protected SoundEvent getAmbientSound() {
		//return super.getAmbientSound();
		return null;
		
	}
	
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		//return super.getHurtSound(source);
		return null;
		
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		//return super.getDeathSound();
		return null;
		
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
