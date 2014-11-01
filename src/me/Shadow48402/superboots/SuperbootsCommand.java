package me.Shadow48402.superboots;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SuperbootsCommand implements CommandExecutor{
	public Superboots plugin;
	public SuperbootsCommand(Superboots plugin){
		this.plugin = plugin;
	}

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
					p.sendMessage(ChatColor.GRAY + "- Get command:" + ChatColor.GREEN + " /superboots <BootType> get");
					p.sendMessage(ChatColor.GRAY + "- Give command:" + ChatColor.GREEN + " /superboots <BootType> give <player>");
					p.sendMessage(ChatColor.BLACK + "--------------------------------------------------");
					p.sendMessage(ChatColor.GRAY + "List of all boots: " + ChatColor.GREEN + "/superboots list");
					p.sendMessage(ChatColor.BLACK + ")=-----------------------------------------------=(");
				}
				if (args[0].equalsIgnoreCase("list")){
					p.sendMessage(ChatColor.GRAY + "All availeble boots: " + ChatColor.GREEN + "fly, speed, jump, defence, food, damage, heal, vanish, mine, dj(double jump), run, sneak");
					p.sendMessage(ChatColor.GRAY + "Coming Soon: " + ChatColor.GREEN + "spider, teleport");
				}
			}
			if (args.length == 2){
				if ((args[0].equalsIgnoreCase("fly")) && 
						(args[1].equalsIgnoreCase("get"))) {
					if (p.hasPermission("superboots.fly.get")){
						if (p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[] { this.plugin.flyboots() });
							p.sendMessage(ChatColor.GREEN + "You've now flyboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if ((args[0].equalsIgnoreCase("speed")) && 
						(args[1].equalsIgnoreCase("get"))) {
					if (p.hasPermission("superboots.speed.get")){
						if (p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[] { this.plugin.speedboots() });
							p.sendMessage(ChatColor.GREEN + "You've now speedboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("jump")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.jump.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.jumpboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now jumpboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("defence")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.defence.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.defenceboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now defenceboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("food")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.food.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.foodboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now foodboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("damage")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.damage.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.damageboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now foodboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("heal")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.heal.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.healboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now healboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("vanish")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.vanish.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.vanishboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now vanishboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("mine")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.mine.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.mineboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now mineboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("run")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.run.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.runboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now runboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("sneak")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.sneak.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.sneakboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now sneakboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
				if(args[0].equalsIgnoreCase("dj")
						&& args[1].equalsIgnoreCase("get")){
					if(p.hasPermission("superboots.dj.get")){
						if(p.getInventory().firstEmpty() != -1){
							p.getInventory().addItem(new ItemStack[]{
									this.plugin.doublejumpboots()	
							});
							p.sendMessage(ChatColor.GREEN + "You've now doublejumpboots in your inventory!");
						} else {
							p.sendMessage(ChatColor.RED + "Your inventory is full!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do that!");
					}
				}
			}
			if (args.length == 3){
				if ((args[0].equalsIgnoreCase("fly")) && 
						(args[1].equalsIgnoreCase("give"))){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.fly.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] { this.plugin.flyboots() });
								t.sendMessage(ChatColor.GREEN + "You've now fly boots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + ChatColor.GREEN + " has now fly boots in his inventory!");
							} else {
								p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " his inventory is full!");
							}
						}
						else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if ((args[0].equalsIgnoreCase("speed")) && 
						(args[1].equalsIgnoreCase("give"))){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.speed.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] { this.plugin.speedboots() });
								t.sendMessage(ChatColor.GREEN + "You've now speed boots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now speed boots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("jump")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.jump.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.jumpboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now speed boots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now jumpboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("defence")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.defence.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.defenceboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now defenceboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now defenceboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("food")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.food.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.foodboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now foodboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now foodboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("damage")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.damage.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.damageboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now damageboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now damageboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("vanish")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.vanish.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.vanishboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now vanishboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now vanishboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("heal")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.heal.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.healboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now healboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now healboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("mine")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.mine.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.mineboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now mineboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now mineboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("run")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.run.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.runboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now runboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now runboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("sneak")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.sneak.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.sneakboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now sneakboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now sneakboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
				if(args[0].equalsIgnoreCase("dj")
						&& args[1].equalsIgnoreCase("give")){
					Player t = Bukkit.getPlayer(args[2]);
					if (p.hasPermission("superboots.dj.give")){
						if (t != null){
							if (t.getInventory().firstEmpty() != -1){
								t.getInventory().addItem(new ItemStack[] {
										this.plugin.doublejumpboots() 
								});
								t.sendMessage(ChatColor.GREEN + "You've now doublejumpboots in your inventory!");
								p.sendMessage(ChatColor.DARK_GREEN + t.getName() + " has now doublejumpboots in his inventory!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not online!");
						}
					} else {
						p.sendMessage(ChatColor.RED + "You're not allowed to do this!");
					}
				}
			}
		} else {
			this.plugin.logger.info("You're not allowed to run Superboots commands!");
		}
		return false;
	}
}
