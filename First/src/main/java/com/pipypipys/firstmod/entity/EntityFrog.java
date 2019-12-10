package com.pipypipys.firstmod.entity;

import com.pipypipys.firstmod.util.handlers.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityFrog extends EntityRabbit {

	public EntityFrog(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 0.4F);
		
		
	}
	
	@Override
	public EntityFrog createChild(EntityAgeable ageable) {
		return new EntityFrog(world);
	}

	
	
	@Override
	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
	    }

	@Override   
	protected ResourceLocation getLootTable()
	    {
	        return null;
	    }

	
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundsHandler.ENTITY_FROG_CROAK;
		
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
    {
        //this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
		this.playSound(null, 0.15F, 1.0F);
    }

	
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		//return super.getHurtSound(source);
		return SoundsHandler.ENTITY_RAT_HURT;
		
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		//return super.getDeathSound();
		return SoundsHandler.ENTITY_RAT_HURT;
		
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
