package com.pauljoda.mobtools.amulets;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.blocks.BlockManager;
import com.pauljoda.mobtools.tools.ToolManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MobToolsBlazeAmulet extends MobToolsAmulet {

	public MobToolsBlazeAmulet() {
		super();
		this.setUnlocalizedName("blazeAmulet");
		this.setCreativeTab(MobTools.tabMobTools);
		this.setMaxDamage(1000);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{

		if (par7 == 0)
		{
			--y;
		}

		if (par7 == 1)
		{
			++y;
		}

		if (par7 == 2)
		{
			--z;
		}

		if (par7 == 3)
		{
			++z;
		}

		if (par7 == 4)
		{
			--x;
		}

		if (par7 == 5)
		{
			++x;
		}
		if(world.getBlock(x, y, z) == Blocks.air)
		{
			world.playSoundAtEntity(player, "random.wood_click", 1.0F, 1.0F);
			world.setBlock(x, y, z, BlockManager.blazeTorch);
			world.markBlockForUpdate(x, y, z);
			itemstack.damageItem(1, player);
			return true;
		}
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World par2World, EntityPlayer player)
	{

		if(player.isSneaking())
		{
			if(itemstack.stackTagCompound == null)
			{
				itemstack.stackTagCompound = new NBTTagCompound();
				itemstack.stackTagCompound.setBoolean("Active", true);
				if(!par2World.isRemote)
					player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Auto-Lighting Enabled"));
			}
			else
			{
				if(itemstack.stackTagCompound.getBoolean("Active"))
				{
					itemstack.stackTagCompound.setBoolean("Active", false);
					if(!par2World.isRemote)
						player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Auto-Lighting Disabled"));
				}
				else
				{
					itemstack.stackTagCompound.setBoolean("Active", true);
					if(!par2World.isRemote)
						player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Auto-Lighting Enabled"));
				}

			}
		}
		return itemstack;
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		EntityPlayer player = (EntityPlayer)entity;

		if(itemstack.getItemDamage() >= this.getMaxDamage())
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).equals(itemstack))
					{
						player.inventory.setInventorySlotContents(i, null);
					}
				}
			}
			return;
		}

		if(itemstack.stackTagCompound != null)
		{

			if(world.getLightBrightness((int)player.posX, (int)player.posY, (int)player.posZ)  < .5 && itemstack.stackTagCompound.getBoolean("Active")
					&& world.getBlock((int)player.posX, (int)player.posY, (int)player.posZ) == Blocks.air)
			{
				world.setBlock((int)player.posX, (int)player.posY, (int)player.posZ, BlockManager.blazeTorch);
				world.markBlockForUpdate((int)player.posX, (int)player.posY, (int)player.posZ);
				itemstack.damageItem(1, player);

			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{

		par3List.add(EnumChatFormatting.GOLD + "Shift-Right Click to Toggle Auto-Lighting");
		if (par1ItemStack.stackTagCompound != null)
		{
			if(par1ItemStack.stackTagCompound.getBoolean("Active"))
				par3List.add(EnumChatFormatting.GREEN + "Active");
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("mobtools:" + (this.getUnlocalizedName().substring(5)));
	}

}
