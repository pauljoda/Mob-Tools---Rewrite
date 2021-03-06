package com.pauljoda.mobtools.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.item.ItemManager;
import com.pauljoda.mobtools.lib.Reference;
import com.pauljoda.mobtools.tileentities.TileEntityRepairAlter;
import com.pauljoda.mobtools.tools.ToolManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRepairAlter extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon alterSide;
	@SideOnly(Side.CLIENT)
	private IIcon alterTop;
	@SideOnly(Side.CLIENT)
	private IIcon alterBottom;

	public BlockRepairAlter() {
		super(Material.iron);
		setBlockName("repairAlter");
		setCreativeTab(MobTools.tabMobTools);
		this.setHardness(3.0F);	
		this.setBlockBounds(.05F, 0F, .05F, .95F, 1.0F, .95F);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return Reference.repairAlterRenderID;
	}


	@Override
	public TileEntity createNewTileEntity(World world, int i) {
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
			TileEntityRepairAlter tileentityfurnace = (TileEntityRepairAlter)par1World.getTileEntity(par2, par3, par4);

			if (tileentityfurnace != null && par5EntityPlayer.isSneaking())
			{
				par5EntityPlayer.openGui(MobTools.instance, 0, par1World, par2, par3, par4);
			}

			if(par7 >= 0F && par7 <= .2F && par8 >= .9F && par8 <= 1.1F && par9 >= 0.0F && par9 <= 0.2F)
			{
				if(par5EntityPlayer.inventory.getCurrentItem() != null)
				{
					if(tileentityfurnace.inv[0] == null)
					{
						if(par5EntityPlayer.inventory.getCurrentItem().getItem() == ItemManager.creepium)
						{
							tileentityfurnace.inv[0] = par5EntityPlayer.inventory.getCurrentItem();
							par5EntityPlayer.setCurrentItemOrArmor(0, null);
							par1World.markBlockForUpdate(tileentityfurnace.xCoord, tileentityfurnace.yCoord, tileentityfurnace.zCoord);
							return true;
						}
					}
				}
			}

			if(par7 >= 0F && par7 <= .2F && par8 >= .9F && par8 <= 1.1F && par9 >= 0.8F && par9 <= 1.0F)
			{
				if(par5EntityPlayer.inventory.getCurrentItem() != null)
				{
					if(tileentityfurnace.inv[2] == null)
					{
						if(par5EntityPlayer.inventory.getCurrentItem().getItem() == ItemManager.spidium)
						{
							tileentityfurnace.inv[2] = par5EntityPlayer.inventory.getCurrentItem();
							par5EntityPlayer.setCurrentItemOrArmor(0, null);
							par1World.markBlockForUpdate(tileentityfurnace.xCoord, tileentityfurnace.yCoord, tileentityfurnace.zCoord);
							return true;
						}
					}
				}
			}

			if(par7 >= 0.8F && par7 <= 1.0F && par8 >= .9F && par8 <= 1.1F && par9 >= 0.0F && par9 <= 0.2F)
			{
				if(par5EntityPlayer.inventory.getCurrentItem() != null)
				{
					if(tileentityfurnace.inv[1] == null)
					{
						if(par5EntityPlayer.inventory.getCurrentItem().getItem() == ItemManager.endium)
						{
							tileentityfurnace.inv[1] = par5EntityPlayer.inventory.getCurrentItem();
							par5EntityPlayer.setCurrentItemOrArmor(0, null);
							par1World.markBlockForUpdate(tileentityfurnace.xCoord, tileentityfurnace.yCoord, tileentityfurnace.zCoord);
							return true;
						}
					}
				}
			}

			if(par7 >= 0.8F && par7 <= 1.0F && par8 >= .9F && par8 <= 1.1F && par9 >= 0.8F && par9 <= 1.0F)
			{
				if(par5EntityPlayer.inventory.getCurrentItem() != null)
				{
					if(tileentityfurnace.inv[3] == null)
					{
						if(par5EntityPlayer.inventory.getCurrentItem().getItem() == ItemManager.blazium)
						{
							tileentityfurnace.inv[3] = par5EntityPlayer.inventory.getCurrentItem();
							par5EntityPlayer.setCurrentItemOrArmor(0, null);
							par1World.markBlockForUpdate(tileentityfurnace.xCoord, tileentityfurnace.yCoord, tileentityfurnace.zCoord);
							return true;
						}
					}
				}
			}


			if(tileentityfurnace.inv[4] == null)
			{
				tileentityfurnace.inv[4] = par5EntityPlayer.inventory.getCurrentItem();
				par5EntityPlayer.setCurrentItemOrArmor(0, null);
				par1World.markBlockForUpdate(tileentityfurnace.xCoord, tileentityfurnace.yCoord, tileentityfurnace.zCoord);
				return true;
			}



			return true;
		}
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random r)
	{
		TileEntityRepairAlter alter = (TileEntityRepairAlter) par1World.getTileEntity(par2, par3, par4);
		if(alter.isActive)
		{
			for(int i = 0; i < 20; i++)
			{
				double xVar = r.nextGaussian();
				double zVar = r.nextGaussian();
				par1World.spawnParticle("portal", alter.xCoord + .5D, alter.yCoord + 1.5, alter.zCoord + .5D, xVar, .5D, zVar);
				par1World.spawnParticle("reddust", alter.xCoord + .1, alter.yCoord + 1.3, alter.zCoord + .1, 0D, 238D, 0D);
				par1World.spawnParticle("reddust", alter.xCoord + .9, alter.yCoord + 1.3, alter.zCoord + .1, 0D, 0D, 1D);
				par1World.spawnParticle("reddust", alter.xCoord + .1, alter.yCoord + 1.3, alter.zCoord + .9, 0D, 0D, 0D);
				par1World.spawnParticle("reddust", alter.xCoord + .9, alter.yCoord + 1.3, alter.zCoord + .9, 0D, .8D, .3D);
			}
		}
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{

		Random furnaceRand = new Random();
		TileEntityRepairAlter var7 = (TileEntityRepairAlter)par1World.getTileEntity(par2, par3, par4);

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
						EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

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
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.alterTop : (par1 == 0 ? this.alterBottom :this.blockIcon);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("mobtools:repairAlter");
		this.alterBottom = iconRegister.registerIcon("mobtools:repairAlterBottom");
		this.alterTop = iconRegister.registerIcon("mobtools:repairAlterTop");
	}

}
