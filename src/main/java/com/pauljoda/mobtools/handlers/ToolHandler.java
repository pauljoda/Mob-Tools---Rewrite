package com.pauljoda.mobtools.handlers;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.pauljoda.mobtools.item.ItemManager;
import com.pauljoda.mobtools.tools.ToolManager;

import cpw.mods.fml.common.eventhandler.Event.Result;

public class ToolHandler {

	static Random itemRand = new Random();


	public static void wandEffect(ItemStack itemstack, World world, EntityPlayer entityplayer, int type)
	{
		//Wand Types:
		//1: Creeper
		//2: Ender
		//3: Spider
		//4: Blaze

		switch(type)
		{

		case 1:
			if(!world.isRemote)
				world.createExplosion(entityplayer, entityplayer.posX, entityplayer.posY, entityplayer.posZ, 2.0F, true);

			if(!entityplayer.capabilities.isCreativeMode)
				itemstack.damageItem(1, entityplayer);

			break;

		case 2:  
			break;


		case 3:
			//Always active, does not need effect on click
			break;

		case 4: 
			if (!world.isRemote)
			{
				Vec3 look = entityplayer.getLookVec();
				EntitySmallFireball fireball2 = new EntitySmallFireball(world, entityplayer, 1, 1, 1);
				fireball2.setPosition(
						entityplayer.posX + look.xCoord,
						entityplayer.posY + look.yCoord + entityplayer.getEyeHeight(),
						entityplayer.posZ + look.zCoord);
				fireball2.accelerationX = look.xCoord * 0.1;
				fireball2.accelerationY = look.yCoord * 0.1;
				fireball2.accelerationZ = look.zCoord * 0.1;
				world.spawnEntityInWorld(fireball2);

			}
			itemstack.damageItem(1, entityplayer);
			break;

		default: break;

		}





	}

	public static void swordEffect(int swordType, ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		//Sword Types:
		//1: Creeper
		//2: Ender
		//3: Spider
		//4: Blaze

		switch(swordType)
		{
		case (1) : break;
		case (2) : break;
		case (3) : break;
		case (4) : 	par2EntityLivingBase.setFire(10);
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		break;

		default : break;


		}
	}

	public static void swordBlockEffect(int swordType, ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		//Sword Types:
		//1: Creeper
		//2: Ender
		//3: Spider
		//4: Blaze

		switch(swordType)
		{
		case (1) :
			par2World.createExplosion(par3EntityPlayer, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 2.0F, false);
		par1ItemStack.damageItem(5, par3EntityPlayer);
		break;

		case (2) : 
			if(par3EntityPlayer.isSneaking())
			{
				if (par3EntityPlayer.capabilities.isCreativeMode)
				{
					par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

					if (!par2World.isRemote)
					{
						par2World.spawnEntityInWorld(new EntityEnderPearl(par2World, par3EntityPlayer));
					}

					par1ItemStack.damageItem(10, par3EntityPlayer);
				}

				else if (par3EntityPlayer.ridingEntity != null)
				{
					break;
				}

				else
				{

					par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

					if (!par2World.isRemote)
					{
						par2World.spawnEntityInWorld(new EntityEnderPearl(par2World, par3EntityPlayer));
					}

					par1ItemStack.damageItem(10, par3EntityPlayer);
				}
			}
		break;

		case (3) : 
			if(par3EntityPlayer.isSneaking())
			{
				if(par3EntityPlayer.isInvisible())
				{
					par3EntityPlayer.setInvisible(false);
					par3EntityPlayer.playSound("random.pop", 2.0F, 1.0F);
				}
				else
				{
					par3EntityPlayer.setInvisible(true);
					par3EntityPlayer.playSound("random.pop", 2.0F, 1.0F);
				}
			}

		par1ItemStack.damageItem(1, par3EntityPlayer);
		break;

		case (4) : 
			if(par3EntityPlayer.isSneaking())
			{
				par3EntityPlayer.extinguish();
				par3EntityPlayer.playSound("random.extinguish", 2.0F, 1.0F);
				par1ItemStack.damageItem(1, par3EntityPlayer);
			}
		break;

		default : break;

		}
	}


	public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
	{
		Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

		BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
		if (MinecraftForge.EVENT_BUS.post(event))
		{
			return false;
		}

		if (event.getResult() == Result.ALLOW)
		{
			if (!p_150919_1_.isRemote)
			{
				p_150919_0_.stackSize--;
			}
			return true;
		}

		if (block instanceof IGrowable)
		{
			IGrowable igrowable = (IGrowable)block;

			if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote))
			{
				if (!p_150919_1_.isRemote)
				{
					if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_))
					{
						igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
					}

					p_150919_0_.damageItem(1, player);
				}

				return true;
			}
		}

		return false;
	}

	public static String getInformation(int i, int type, String itemName) 
	{
		//Information Types
		//Sword: 1
		//Pick: 2
		//Shovel: 3
		//Hoe: 4
		//Axe: 5
		//Wand: 6
		//Items: 7

		//Types:
		//1: Creeper
		//2: Ender
		//3: Spider
		//4: Blaze

		//Items
		String creepium = ItemManager.creepium.getUnlocalizedName();
		String endium = ItemManager.endium.getUnlocalizedName();
		String spidium = ItemManager.spidium.getUnlocalizedName();
		String blazium = ItemManager.blazium.getUnlocalizedName();
		String inertCore = ItemManager.inertWandCore.getUnlocalizedName();
		String goldenRod = ItemManager.goldenrod.getUnlocalizedName();
		String creeperCore = ItemManager.creeperWandCore.getUnlocalizedName();
		String enderCore = ItemManager.enderWandCore.getUnlocalizedName();
		String spiderCore = ItemManager.spiderWandCore.getUnlocalizedName();
		String blazeCore = ItemManager.blazeWandCore.getUnlocalizedName();
		String infuser = ItemManager.infuser.getUnlocalizedName();
		String infuserComplete = ItemManager.infuserComplete.getUnlocalizedName();
		String enderMail = ItemManager.enderMail.getUnlocalizedName();

		switch(i)
		{
		case 1: 
			switch(type)
			{
			case 1: return "Right click For an Explosion";
			case 2: return "Shift Right Click For Teleport";
			case 3: return "Shift Right Click to Become Invisible";
			case 4: return "Right Click to Extinguish Yourself";
			}
		case 2: 
			switch(type)
			{
			case 1: return "On Right Click Mines a 3x3 area, Uses Gunpowder";
			case 2: return "Teleports Items to Your Inventory";
			case 3: return "Silk Touch";
			case 4: return "Auto-Smelting";
			}
		case 3: 
			switch(type)
			{
			case 1: return "On Right Click Digs a 3x3 area,Uses Gunpowder";
			case 2: return "Teleports Items to Your Inventory";
			case 3: return "It's a Shovel";
			case 4: return "Kinda Cool Looking";
			}
		case 4: 
			switch(type)
			{
			case 1: return "Tills a 3x3 Area";
			case 2: return "Scary Looking";
			case 3: return "Shift Right Click Crops To Grow Them";
			case 4: return "Can Till Dirt";
			}
		case 5: 
			switch(type)
			{
			case 1: return "On Right Click Chops a 3x3 Area,Uses Gunpowder";
			case 2: return "Teleports Items to Your Inventory";
			case 3: return "Kinda Like Shears";
			case 4: return "Burns Logs";
			}
		case 6: 
			switch(type)
			{
			case 1: return "Right Click to Unleash Destruction";
			case 2: return "Trade Blocks From Your Inventory";
			case 3: return "Hold This to Prevent Fall Damage";
			case 4: return "Shoot Fireballs";
			}
		case 7: 

			if(itemName.equals(creepium))
				return "Used to Repair Creepium Tools";
			if(itemName.equals(endium))
				return "Used to Repair Endium Tools";
			if(itemName.equals(spidium))
				return "Used to Repair Spidium Tools";
			if(itemName.equals(blazium))
				return "Used to Repair Blazium Tools";
			if(itemName.equals(inertCore))
				return "Infuse this to get wand cores";
			if(itemName.equals(goldenRod))
				return "Used to Make Wands";
			if(itemName.equals(creeperCore))
				return "Infuse with Goldenrods";
			if(itemName.equals(enderCore))
				return "Infuse with Goldenrods";
			if(itemName.equals(spiderCore))
				return "Infuse with Goldenrods";
			if(itemName.equals(blazeCore))
				return "Infuse with Goldenrods";
			if(itemName.equals(infuser))
				return "Kill Mobs to Charge";
			if(itemName.equals(infuserComplete))
				return "Completed! Use This to Craft an Infuser";
			if(itemName.equals(enderMail))
				return "Mails Things!";
		}

		return "It's a thingy!";
	}


	public static boolean  creeperMine(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, String tool, int level)
	{
		Block block = world.getBlock(x, y, z);
		int localMeta = world.getBlockMetadata(x, y, z);
		if(block != Blocks.bedrock)
		{
			if(block.getHarvestTool(localMeta) != null)
			{
				if(block.getHarvestTool(localMeta).equals(tool) && block.getHarvestLevel(localMeta) <= level)
				{

					if(player.inventory.hasItem(Items.gunpowder) || player.capabilities.isCreativeMode)
					{
						if(!player.capabilities.isCreativeMode)
						{
							player.inventory.consumeInventoryItem(Items.gunpowder);
						}

						int p = 2; 
						for(int time = 0; time < p; time++)
						{
							int size = time;
							for(int i = -size; i <= size; i++)
							{
								for(int j = -size; j <= size; j++)
								{
									int xPos = x;
									int yPos = y;
									int zPos = z;

									switch(side)
									{
									case 0 :
									case 1 :
										xPos = xPos + i;
										zPos = zPos + j;
										break;
									case 2 :
									case 3 : 
										xPos = xPos + i;
										yPos = yPos + j;
										break;
									case 4 :
									case 5 : 
										yPos = yPos + j;
										zPos = zPos + i;
										break;
									}

									Block localBlock = world.getBlock(xPos, yPos, zPos);
									int metaLocal = world.getBlockMetadata(xPos, yPos, zPos);

									if(localBlock != Blocks.air && localBlock != Blocks.bedrock)
									{
										if(localBlock.getHarvestTool(metaLocal) != null)
										{
											if(localBlock.getHarvestTool(metaLocal).equals(tool) && localBlock.getHarvestLevel(metaLocal) <= level)
											{
												ArrayList<ItemStack> items = localBlock.getDrops(world, x, y, z, localMeta, 0);
												if(items == null || items.size() == 0)
												{
													return false;
												}
												for (ItemStack item : items)
												{
													if (item == null)
													{
														return false;
													}

													ItemStack copy = item.copy();

													world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F,
															localBlock.stepSound.getBreakSound(),
															(localBlock.stepSound.getVolume() + 1.0F) / 2.0F,
															localBlock.stepSound.getPitch() * 0.8F);

													world.setBlockToAir(xPos, yPos, zPos);
													if(!world.isRemote)
													{
														world.spawnEntityInWorld(new EntityItem(world, xPos, yPos, zPos, copy));
													}
													itemStack.damageItem(1, player);
												}	
											}
										}
									}
								}
							}
						}
					}
				}
				return true;
			}
		}
		return false;
	}


	public static boolean  exhangeBlocks(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, Block blockid, int meta)
	{
		if(blockid == Blocks.air)
			return false;

		if(blockid.hasTileEntity(meta))
			return false;

		Block block = world.getBlock(x, y, z);

		int localMeta = world.getBlockMetadata(x, y, z);

		boolean hasMeta = (meta == localMeta);
		if(block == blockid && hasMeta)
			return false;

		if(block != Blocks.air || block != Blocks.bedrock)
		{
			if(block.isNormalCube())
			{
				if(itemStack.stackTagCompound != null)
				{
					int p = itemStack.stackTagCompound.getInteger("layers"); 
					for(int time = 0; time < p; time++)
					{
						int size = time;

						world.playSoundAtEntity(player, "mob.endermen.portal", 1.0F, 1.0F);
						for(int i = -size; i <= size; i++)
						{
							for(int j = -size; j <= size; j++)
							{
								int xPos = x;
								int yPos = y;
								int zPos = z;

								switch(side)
								{
								case 0 :
								case 1 :
									xPos = xPos + i;
									zPos = zPos + j;
									break;
								case 2 :
								case 3 : 
									xPos = xPos + i;
									yPos = yPos + j;
									break;
								case 4 :
								case 5 : 
									yPos = yPos + j;
									zPos = zPos + i;
									break;
								}

								if(hasItem(player, blockid, 1, meta) || player.capabilities.isCreativeMode)
								{
									Block localBlock = world.getBlock(xPos, yPos, zPos);
									int metaLocal = world.getBlockMetadata(xPos, yPos, zPos);
									boolean metaBoolean = (meta != metaLocal);
									boolean metaCheck = metaBoolean ? (block == localBlock) : (block == localBlock && blockid != localBlock);
									boolean areaCheck = localBlock == block ? ((metaLocal == localMeta || metaLocal == 0) ? true : false) : false;
									if(localBlock != null)
									{
										if(!localBlock.hasTileEntity(metaLocal)
												&& metaCheck && areaCheck)
										{

											world.setBlock(xPos, yPos, zPos, blockid);
											world.setBlockMetadataWithNotify(xPos, yPos, zPos, meta, 2);
											world.markBlockForUpdate(xPos, yPos, zPos);
											if(!player.capabilities.isCreativeMode)
											{
												removeItem(player, blockid, 1, meta);
												player.inventory.addItemStackToInventory(new ItemStack(localBlock, 1, localMeta));
											}
										}
									}
								}

							}
						}
					}
				}
				return true;

			}
		}
		return false;
	}

	public static void removeItem(EntityPlayer ep, Block removeitem, int remove, int metadata) 
	{
		IInventory inv = ep.inventory;
		for(int i=0; i < inv.getSizeInventory(); i++)
		{
			if(inv.getStackInSlot(i) != null)
			{
				ItemStack j = inv.getStackInSlot(i);
				if(j.getItem() != null && j.getItem() == Item.getItemFromBlock(removeitem) && j.getItemDamage() == metadata)
				{
					inv.decrStackSize(i, remove);
					return;
				}
				if(ep.inventory.hasItem(Item.getItemFromBlock(removeitem)) && metadata == 0)
				{
					ep.inventory.consumeInventoryItem(Item.getItemFromBlock(removeitem));
					return;
				}
			}

		}
	}

	public static boolean hasItem(EntityPlayer ep, Block removeitem, int remove, int metadata) 
	{
		IInventory inv = ep.inventory;
		for(int i=0; i < inv.getSizeInventory(); i++)
		{
			if(inv.getStackInSlot(i) != null)
			{
				ItemStack j = inv.getStackInSlot(i);
				if(j.getItem() != null && j.getItem() == Item.getItemFromBlock(removeitem) && j.getItemDamage() == metadata)
				{
					return true;
				}
				if(ep.inventory.hasItem(Item.getItemFromBlock(removeitem)) && metadata == 0)
					return true;
			}

		}
		return false;
	}

}



