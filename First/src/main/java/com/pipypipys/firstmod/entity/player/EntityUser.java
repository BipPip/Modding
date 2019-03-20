package com.pipypipys.firstmod.entity.player;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class EntityUser extends EntityPlayer {

	public EntityUser(World worldIn, GameProfile gameProfileIn) {
		super(worldIn, gameProfileIn);
		
		
		
	
		
	}
	
	
	@Override
	public void setGameType(GameType gameType) {
		
		System.out.println(this.capabilities);
		
		
		
	}
	

	@Override
	public boolean isSpectator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCreative() {
		// TODO Auto-generated method stub
		return false;
	}

}
