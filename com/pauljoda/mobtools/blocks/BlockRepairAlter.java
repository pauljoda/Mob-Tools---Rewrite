package com.pauljoda.mobtools.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.tileentities.TileEntityRepairAlter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRepairAlter extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private Icon alterSide;
	@SideOnly(Side.CLIENT)
	private Icon alterTop;
	@SideOnly(Side.CLIENT)
	private Icon alterBottom;

	public BlockRepairAlter(int par1) {
		super(par1, Material.iron);
		setUnlocalizedName("repairAlter");
		setCreativeTab(MobTools.tabMobTools);
		this.setHardness(3.0F);	
	}


	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityRepairAlter();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityRepairAlter tileentityfurnace = (TileEntityRepairAlter)par1World.getBlockTileEntity(par2, par3, par4);

			if (tileentityfurnace != null)
			{
				par5EntityPlayer.openGui(MobTools.instance, 0, par1World, par2, par3, par4);
			}

			return true;
		}
	}
	
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random r)
	{
		TileEntityRepairAlter alter = (TileEntityRepairAlter) par1World.getBlockTileEntity(par2, par3, par4);
		if(alter.isActive)
		{
			for(int i = 0; i < 20; i++)
			{
				double xVar = r.nextGaussian();
				double zVar = r.nextGaussian();
				par1World.spawnParticle("portal", alter.xCoord + .5D, alter.yCoord, alter.zCoord + .5D, xVar, .5D, zVar);
			}
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{

		Random furnaceRand = new Random();
		TileEntityRepairAlter var7 = (TileEntityRepairAlter)par1World.getBlockTileEntity(par2, par3, par4);

		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = furnaceRand.nextFloat() * 0.8F + 0.1F;
					float var11 = furnaceRand.nextFloat() * 0.8F + 0.1F;
					float var12 = furnaceRand.nextFloat() * 0.8F + 0.1F;

					while (var9.stackSize > 0)
					{
						int var13 = furnaceRand.nextInt(21) + 10;

						if (var13 > var9.stackSize)
						{
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

						if (var9.hasTagCompound())
						{
							var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
						}

						float var15 = 0.05F;
						var14.motionX = (double)((float)furnaceRand.nextGaussian() * var15);
						var14.motionY = (double)((float)furnaceRand.nextGaussian() * var15 + 0.2F);
						var14.motionZ = (double)((float)furnaceRand.nextGaussian() * var15);
						par1World.spawnEntityInWorld(var14);
					}
				}
			}
		}


		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}


	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.alterTop : (par1 == 0 ? this.alterBottom :this.blockIcon);
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("mobtools:repairAlter");
		this.alterBottom = iconRegister.registerIcon("mobtools:repairAlterBottom");
		this.alterTop = iconRegister.registerIcon("mobtools:repairAlterTop");
	}

}
