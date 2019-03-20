package com.pipypipys.firstmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class KoichiBlock extends BlockBase {

	public KoichiBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, tab);
		
		// ALl of these settings are optional
		
		// Sound when walking over block
		setSoundType(SoundType.SNOW);
		
		// How long it takes to break block
		setHardness(5.0F);
		
		// Explosion Resistance
		setResistance(15.0F);
		
		// Tool used to break block (The second input is the harvest level, or the level of tool needed to harvest)
		setHarvestLevel("pickaxe", 0);
		
		// Light Level
		setLightLevel(7.0F);
		
		// How much light passes through
		//setLightOpacity(1);
		
		// Makes block unbreakable
		// setBlockUnbreakable();
	}

}
