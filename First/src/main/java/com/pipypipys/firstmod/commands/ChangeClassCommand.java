/*package com.pipypipys.firstmod.commands;

import com.pipypipys.firstmod.capabilities.CapabilityHandler;
import com.pipypipys.firstmod.capabilities.RPGProvider;


import java.util.ArrayList;
import java.util.List;


import com.pipypipys.firstmod.init.ModCapabilities;
import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.network.messages.MessageCapabilities;
import com.pipypipys.firstmod.network.messages.MessageInvisibilityEffect;
import com.pipypipys.firstmod.util.Reference;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import scala.Int;

public class ChangeClassCommand implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "changeclass";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// Command Help
		
		return null;
	}

	@Override
	public List<String> getAliases() {
		// Extra names
		List<String> commandAliases = new ArrayList();
		commandAliases.add("cc");
		return commandAliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			
			System.out.println("test1: " + args[0]);		
				
			//!args[0].isEmpty() || 
			int playerClassInt = 0;
			if(args[0].equals("Warrior") || args[0].equals("Rogue") || args[0].equals("Mage")) {
				
				
				if(args[0].equals("Warrior")) {
					playerClassInt = 1;
				}
				else if (args[0].equals("Rogue")) {
					playerClassInt = 2;
				}
				else if (args[0].equals("Mage")) {
					playerClassInt = 3;
				}
				
				
				// Not used
				ICapabilityProvider playerProvider = (ICapabilityProvider) player;
				RPGProvider playerRPG = new RPGProvider();
				
				
				
						
				System.out.println("test2: " + playerClassInt);
				//player.getCapability(RPGProvider.RPG, null).setPlayerClass(playerClassInt);
				//NetworkHandler.sendToServer(new MessageCapabilities(player.getCapability(RPGProvider.CAPABILTIY_RPG, null)));	
			
				//player.sendMessage(new TextComponentString(Integer.toString(player.getCapability(RPGProvider.CAPABILTIY_RPG, null).getPlayerClass())));
				
				//player.sendMessage(new TextComponentString(Boolean.toString(player.hasCapability(RPGProvider.CAPABILTIY_RPG, null))));
				
			player.sendMessage(new TextComponentString("Class Changed to " + args[0]));
			
			}
			else {
			
				player.sendMessage(new TextComponentString("Please enter in a class name"));
			}
		}
		
		
		
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		List<String> commandTabs = new ArrayList();
		commandTabs.add("Warrior");
		commandTabs.add("Rogue");
		commandTabs.add("Mage");
		return commandTabs;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
*/