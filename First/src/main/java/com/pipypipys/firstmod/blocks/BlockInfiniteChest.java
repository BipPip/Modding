package com.pipypipys.firstmod.blocks;

import com.jcraft.jorbis.Block;
import com.pipypipys.firstmod.init.ModBlocks;
import com.pipypipys.firstmod.init.ModItems;

import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfiniteChest extends BlockChest {

	public BlockInfiniteChest(String name, CreativeTabs tab, Type chestTypeIn) {
		super(chestTypeIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	@Override
	/**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
       return true;
    }



		
	@Override
	public IBlockState checkForSurroundingChests(World worldIn, BlockPos pos, IBlockState state)
    {
		if (true)
			return null;
        if (worldIn.isRemote)
        {
            return state;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (iblockstate.getBlock() != this && iblockstate1.getBlock() != this)
            {
                boolean flag = iblockstate.isFullBlock();
                boolean flag1 = iblockstate1.isFullBlock();

                if (iblockstate2.getBlock() == this || iblockstate3.getBlock() == this)
                {
                    BlockPos blockpos1 = iblockstate2.getBlock() == this ? pos.west() : pos.east();
                    IBlockState iblockstate7 = worldIn.getBlockState(blockpos1.north());
                    IBlockState iblockstate6 = worldIn.getBlockState(blockpos1.south());
                    enumfacing = EnumFacing.SOUTH;
                    EnumFacing enumfacing2;

                    if (iblockstate2.getBlock() == this)
                    {
                        enumfacing2 = (EnumFacing)iblockstate2.getValue(FACING);
                    }
                    else
                    {
                        enumfacing2 = (EnumFacing)iblockstate3.getValue(FACING);
                    }

                    if (enumfacing2 == EnumFacing.NORTH)
                    {
                        enumfacing = EnumFacing.NORTH;
                    }

                    if ((flag || iblockstate7.isFullBlock()) && !flag1 && !iblockstate6.isFullBlock())
                    {
                        enumfacing = EnumFacing.SOUTH;
                    }

                    if ((flag1 || iblockstate6.isFullBlock()) && !flag && !iblockstate7.isFullBlock())
                    {
                        enumfacing = EnumFacing.NORTH;
                    }
                }
            }
            else
            {
                BlockPos blockpos = iblockstate.getBlock() == this ? pos.north() : pos.south();
                IBlockState iblockstate4 = worldIn.getBlockState(blockpos.west());
                IBlockState iblockstate5 = worldIn.getBlockState(blockpos.east());
                enumfacing = EnumFacing.EAST;
                EnumFacing enumfacing1;

                if (iblockstate.getBlock() == this)
                {
                    enumfacing1 = (EnumFacing)iblockstate.getValue(FACING);
                }
                else
                {
                    enumfacing1 = (EnumFacing)iblockstate1.getValue(FACING);
                }

                if (enumfacing1 == EnumFacing.WEST)
                {
                    enumfacing = EnumFacing.WEST;
                }

                if ((iblockstate2.isFullBlock() || iblockstate4.isFullBlock()) && !iblockstate3.isFullBlock() && !iblockstate5.isFullBlock())
                {
                    enumfacing = EnumFacing.EAST;
                }

                if ((iblockstate3.isFullBlock() || iblockstate5.isFullBlock()) && !iblockstate2.isFullBlock() && !iblockstate4.isFullBlock())
                {
                    enumfacing = EnumFacing.WEST;
                }
            }

            state = state.withProperty(FACING, enumfacing);
            worldIn.setBlockState(pos, state, 3);
            return state;
        }
    }
		
		
		
		
		
		
		
		
		
		
//		// ALl of these settings are optional
//		
//		// Sound when walking over block
//		setSoundType(SoundType.SNOW);
//		
//		// How long it takes to break block
//		setHardness(5.0F);
//		
//		// Explosion Resistance
//		setResistance(15.0F);
//		
//		// Tool used to break block (The second input is the harvest level, or the level of tool needed to harvest)
//		setHarvestLevel("pickaxe", 0);
//		
//		// Light Level
//		setLightLevel(7.0F);
//		
//		// How much light passes through
//		//setLightOpacity(1);
//		
//		// Makes block unbreakable
//		// setBlockUnbreakable();
	

}
