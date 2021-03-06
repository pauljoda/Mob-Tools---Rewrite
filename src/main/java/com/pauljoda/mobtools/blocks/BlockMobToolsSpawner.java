package com.pauljoda.mobtools.blocks;

import java.util.Random;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.item.ItemManager;
import com.pauljoda.mobtools.item.MobToolsItemPowerCore;
import com.pauljoda.mobtools.tileentities.MobToolsSpawnerLogic;
import com.pauljoda.mobtools.tileentities.TileEntityMobToolsSpawner;
import com.pauljoda.mobtools.tools.ToolManager;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMobToolsSpawner extends BlockContainer {

	public BlockMobToolsSpawner() {
		super( Material.iron);
		setBlockName("mobToolsSpawner");
		setCreativeTab(MobTools.tabMobTools);
		this.setHardness(3.0F);	
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMobToolsSpawner();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntityMobToolsSpawner spawner = (TileEntityMobToolsSpawner) world.getTileEntity(x, y, z);
		if(player.inventory.getCurrentItem() != null)
		{
			if(player.inventory.getCurrentItem().getItem() == ItemManager.powerCore && !spawner.isActive)
			{
				if(player.inventory.getCurrentItem().stackTagCompound != null)
				{
					if(spawner.inv[0] == null)
					{
						ItemStack powerCore = player.inventory.getCurrentItem();
						spawner.mobName = powerCore.stackTagCompound.getString("mobName");
						spawner.maxCoolDown = MobToolsSpawnerLogic.getMaxCoolDown(powerCore.stackTagCompound.getInteger("tier"));
						spawner.spawnRate = powerCore.stackTagCompound.getInteger("tier") + 1;
						spawner.dimension = MobToolsItemPowerCore.getDimension(powerCore.stackTagCompound.getString("mobName"));
						spawner.tier = powerCore.stackTagCompound.getInteger("tier");
						spawner.inv[0] = powerCore;
						player.setCurrentItemOrArmor(0, null);
						return true;
					}
				}
			}
		}
		if(player.isSneaking())
		{
			player.inventory.addItemStackToInventory(spawner.inv[0]);
			spawner.inv[0] = null;
			spawner.tier = 0;
		}
		return true;
	}
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		TileEntityMobToolsSpawner spawner = (TileEntityMobToolsSpawner)par1World.getTileEntity(par2, par3, par4);
		if(spawner.isActive)
		{
			for(int i = 0; i < 4; i++)
			{
				double d1 = (double)((float)par2 + par1World.rand.nextFloat());
				double d2 = (double)((float)par3 + par1World.rand.nextFloat());
				double d0 = (double)((float)par4 + par1World.rand.nextFloat());
				par1World.spawnParticle("smoke", d1, d2, d0, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d1, d2, d0, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("mob_spawner");
	}
}
