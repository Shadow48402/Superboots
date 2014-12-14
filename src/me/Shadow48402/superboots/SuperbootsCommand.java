package me.Shadow48402.superboots;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SuperbootsCommand implements CommandExecutor{
	
	/*
	 * Last updated on 14/12/2014
	 */
	
	public Superboots plugin;
	public SuperbootsCommand(Superboots plugin){
		this.plugin = plugin;
	}

	public String[] existingBoots = new String[]{"fly", "speed", "jump", "defence", "food", "damage", "heal", "vanish", "mine", "dj", "run", "sneak"};

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if ((sender instanceof Player)){
			Player p = (Player)sender;
			if (args.length == 0){
				p.sendMessage(ChatColor.BLACK + "--------------------------------------------------");
				p.sendMessage(ChatColor.GREEN + "Plugin made by Shadow48402");
				p.sendMessage(ChatColor.GREEN + "Version: " + plugin.getDescription().getVersion() + " | '/superboots help' for help.");
				p.sendMessage(ChatColor.BLACK + "--------------------------------------------------");
			}
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("help")){
					p.sendMessage(ChatColor.BLACK + ")=-----------------------------------------------=(");
					p.sendMessage(ChatColor.GRAY + "- Get command:" + ChatColor.GREEN + " /superboots get <BootType>");
					p.sendMessage(ChatColor.GRAY + "- Give command:" + ChatColor.GREEN + " /superboots give <BootType> <player>");
					p.sendMessage(ChatColor.BLACK + "--------------------------------------------------");
					p.sendMessage(ChatColor.GRAY + "List of all boots: " + ChatColor.GREEN + "/superboots list");
					p.sendMessage(ChatColor.BLACK + ")=-----------------------------------------------=(");
				}
				if (args[0].equalsIgnoreCase("list")){
					p.sendMessage(ChatColor.GRAY + "All availeble boots: " + ChatColor.GREEN + "fly, speed, jump, defence, food, damage, heal, vanish, mine, dj(double jump), run, sneak");
					p.sendMessage(ChatColor.GRAY + "Coming Soon: " + ChatColor.GREEN + "spider, teleport");
				}
			}

			if(args.length == 2){
				if(args[0].equalsIgnoreCase("get")){
					giveBoots(p, args[1], args[0]);
				}
			}

			if(args.length == 3){
				if(args[0].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if(t == null){
						p.sendMessage(ChatColor.RED + "That player is not online!");
						return true;
					}
					giveBoots(t, args[0], args[1]);
				}
			}

		}
		return false;
	}

	/**
	 * @param p = The player that gets the boots
	 * @param b = The boots' name
	 * @param g = Get/Give, for permission check
	 */
	public void giveBoots(Player p, String b, String g){
		if(!doesBootsExists(b)){
			p.sendMessage(ChatColor.RED + "That type of boots does not exist!");
			return;
		}

		if(p.getInventory().firstEmpty() == -1){
			p.sendMessage(ChatColor.RED + "Your inventory is full!");
			return;
		}

		if(!p.hasPermission("superboots." + g + b)){
			p.sendMessage(ChatColor.RED + "You are not allowed to do this!");
			return;
		}

		switch(b){
			case"fly": p.getInventory().addItem(new ItemStack[]{plugin.flyboots()});
			case"speed": p.getInventory().addItem(new ItemStack[]{plugin.speedboots()});
			case"jump": p.getInventory().addItem(new ItemStack[]{plugin.jumpboots()});
			case"defence": p.getInventory().addItem(new ItemStack[]{plugin.defenceboots()});
			case"food": p.getInventory().addItem(new ItemStack[]{plugin.foodboots()});
			case"damage": p.getInventory().addItem(new ItemStack[]{plugin.damageboots()});
			case"heal": p.getInventory().addItem(new ItemStack[]{plugin.healboots()});
			case"vanish": p.getInventory().addItem(new ItemStack[]{plugin.vanishboots()});
			case"mine": p.getInventory().addItem(new ItemStack[]{plugin.mineboots()});
			case"dj": p.getInventory().addItem(new ItemStack[]{plugin.doublejumpboots()});
			case"run": p.getInventory().addItem(new ItemStack[]{plugin.runboots()});
			case"sneak":p.getInventory().addItem(new ItemStack[]{plugin.sneakboots()});
		}
		p.sendMessage(ChatColor.GREEN + "You have now " + b + " boots in your inventory!");
	}

	/**
	 * @param s = Boots' name
	 * @return true if existingBoots contains String s
	 * @return false if existingBoots doesn't contain String s
	 */
	public boolean doesBootsExists(String s){
		for(String b : existingBoots){
			if(b.toLowerCase().equalsIgnoreCase(s))
				return true;
			return false;
		}
		return false;
	}
}
