package com.pauljoda.mobtools.tools;

import java.util.List;

import com.pauljoda.mobtools.MobTools;
import com.pauljoda.mobtools.handlers.ToolHandler;
import com.pauljoda.mobtools.tileentities.TileEntityMobToolsSpawner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class MobToolsItem extends Item {

	boolean rare;
	
	@SideOnly(Side.CLIENT)
	public static Icon backGround;

	public MobToolsItem(int par1, String unlocalized, boolean rare, int stackSize) {
		super(par1);
		this.setUnlocalizedName(unlocalized);
		this.rare = rare;
		this.setCreativeTab(MobTools.tabMobTools);
		this.maxStackSize = stackSize;

	}


	@Override
	public EnumRarity getRarity(ItemStack is)
	{ 
		if(rare)
			return EnumRarity.epic;
		else
			return EnumRarity.uncommon;
	}

	@Override
	public boolean hasEffect(ItemStack is)
	{ 
		if(rare)
			return true;
		else
			return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		//Information Types
		//Sword: 1
		//Pick: 2
		//Shovel: 3
		//Hoe: 4
		//Axe: 5
		//Wand: 6
		//Items: 7

		par3List.add("\u00a76" + ToolHandler.getInformation(7, this.itemID));

		if(this.itemID == ToolManager.infuser.itemID)
		{
			if (par1ItemStack.stackTagCompound != null)
			{
				String owner = par1ItemStack.stackTagCompound.getString("owner");
				par3List.add(EnumChatFormatting.AQUA + "Owner: " + owner);
				par3List.add("Creeper: " + (par1ItemStack.stackTagCompound.getInteger("creeperKills") * 4) + "%");
				par3List.add("Enderman: " + (par1ItemStack.stackTagCompound.getInteger("enderKills") * 4) + "%");
				par3List.add("Spider: " + (par1ItemStack.stackTagCompound.getInteger("spiderKills") * 4) + "%");
				par3List.add("Blaze: " + (par1ItemStack.stackTagCompound.getInteger("blazeKills") * 4) + "%");

				if(par1ItemStack.stackTagCompound.getBoolean("done") != false)
					par3List.add("Right Click to Take 30 Levels and Activate");
			}
			else
				par3List.add("Right Click Claim");
		}
	}


	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(par1ItemStack.stackTagCompound != null)
		{
			if(par1ItemStack.stackTagCompound.getBoolean("done") && par3EntityPlayer.experienceLevel > 29)
			{
				par3EntityPlayer.addExperienceLevel(-29);
				par1ItemStack.stackSize--;
				par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ToolManager.infuserComplete, 1));
				return par1ItemStack;
			}
			return par1ItemStack;
		}
		
		if(this.itemID == ToolManager.infuser.itemID)
		{
			par1ItemStack.stackTagCompound = new NBTTagCompound();
			par1ItemStack.stackTagCompound.setString("owner", par3EntityPlayer.username);
		}

		return par1ItemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("mobtools:" + (this.getUnlocalizedName().substring(5)));
		this.backGround = iconRegister.registerIcon("mobtools:repairAlterSlotBackground");

	}

}
