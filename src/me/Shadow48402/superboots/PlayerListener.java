package me.Shadow48402.superboots;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener{
	public Superboots plugin;
	public PlayerListener(Superboots plugin){
		this.plugin = plugin;
	}

	/*
	 * New updates:
	 * - Double Jump fix
	 */

	public HashMap<Player, String> wearingBoots = new HashMap<Player, String>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if (p.getInventory().getBoots() != null){
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.GOLD_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Fly Boots"))){
				p.setAllowFlight(true);
				wearingBoots.put(p, "FLY");
			}
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Vanish Boots"))){
				for(Player o : Bukkit.getOnlinePlayers()){
					o.hidePlayer(p);
				}
				if(!wearingBoots.containsKey(p)){
					wearingBoots.put(p, "VANISH");
				}
			}
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Run Boots"))){

				p.setSprinting(true);
				if(!wearingBoots.containsKey(p)){
					wearingBoots.put(p, "RUN");
				}
			}
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.IRON_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Sneak Boots"))){
				
				if(!wearingBoots.containsKey(p)){
					p.setSneaking(true);
					wearingBoots.put(p, "SNEAK");
				} 
			}
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Double Jump Boots"))){
				if(p.getGameMode() != GameMode.CREATIVE
						&& p.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR
						&& !p.isFlying()){
					if(!p.isOnGround()){
						p.setAllowFlight(true);
					}
				}
			}
			if(wearingBoots.containsKey(p)){
				if (!p.getInventory().getBoots().hasItemMeta() || 
						p.getInventory().getBoots().getType() != Material.GOLD_BOOTS || 
						!p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Fly Boots")){
					if(wearingBoots.get(p) == "FLY"){
						p.setFlying(false);
						p.setAllowFlight(false);
					}
				}
				if (!p.getInventory().getBoots().hasItemMeta() || 
						p.getInventory().getBoots().getType() != Material.LEATHER_BOOTS || 
						!p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Vanish Boots")){
					if(wearingBoots.get(p) == "VANISH"){
						for(Player o : Bukkit.getOnlinePlayers()){
							o.showPlayer(p);
						}
					}
				}
				if (!p.getInventory().getBoots().hasItemMeta() || 
						p.getInventory().getBoots().getType() != Material.LEATHER_BOOTS || 
						!p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Run Boots")){
					if(wearingBoots.get(p) == "RUN"){
						wearingBoots.remove(p);
						p.setSprinting(false);
					}
				}
				if (!p.getInventory().getBoots().hasItemMeta() || 
						p.getInventory().getBoots().getType() != Material.IRON_BOOTS || 
						!p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Sneak Boots")){
					if(wearingBoots.get(p) == "SNEAK"){
						wearingBoots.remove(p);
						p.setSneaking(false);
					}
				}
			}
			if ((p.getInventory().getBoots().hasItemMeta()) && 
					(p.getInventory().getBoots().getType() == Material.GOLD_BOOTS) && 
					(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Speed Boots"))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));
			}
			if(p.getInventory().getBoots().hasItemMeta()
					&& p.getInventory().getBoots().getType() == Material.GOLD_BOOTS
					&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Jump Boots")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 1));
			}
			if(p.getInventory().getBoots().hasItemMeta()
					&& p.getInventory().getBoots().getType() == Material.IRON_BOOTS
					&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Heal Boots")){
				int c = plugin.sm.getSettings().getInt("HealChange");
				Random r = new Random();
				if(r.nextInt(c) == 1){
					if(((CraftPlayer)p).getHealth() != 20.0D){
						p.setHealth(((CraftPlayer)p).getHealth() + 0.5D);
					}
				}
			}
		} else {
			if(wearingBoots.containsKey(p)){
				if(wearingBoots.get(p).equalsIgnoreCase("FLY")){
					p.setFlying(false);
					p.setAllowFlight(false);
					wearingBoots.remove(p);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(p.getInventory().getBoots().hasItemMeta()
					&& p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS
					&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Defence Boots")){
				e.setDamage(e.getDamage()/2);
			}
		}
	}

	@EventHandler
	public void onEntityonEntityDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			if(p.getInventory().getBoots().hasItemMeta()
					&& p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS
					&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Damage Boots")){
				e.setDamage(e.getDamage()*1.5);
			}
		}
	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e){
		Player p = (Player) e.getEntity();
		if(p.getInventory().getBoots().hasItemMeta()
				&& p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS
				&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "FoodBoost Boots")){
			if(p.getFoodLevel() <= 19){
				p.setFoodLevel(p.getFoodLevel() + 1);
				e.setCancelled(true);
			} else {
				p.setFoodLevel(20);
				e.setCancelled(true);
			}
		}
		if(p.getInventory().getBoots().hasItemMeta()
				&& p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS
				&& p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Run Boots")){
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMine(BlockBreakEvent e){
		Block b = e.getBlock();
		Player p = e.getPlayer();
		Material t = b.getType();
		List<Material> l = Arrays.asList(
				Material.STONE, 
				Material.COBBLESTONE, 
				Material.DIAMOND_ORE, 
				Material.IRON_ORE, 
				Material.GOLD_ORE, 
				Material.EMERALD_ORE,
				Material.COAL_ORE);

		if ((p.getInventory().getBoots().hasItemMeta()) && 
				(p.getInventory().getBoots().getType() == Material.IRON_BOOTS) && 
				(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Mine Boots"))){
			for(Material m : l){
				if(m == t){
					e.setExpToDrop(e.getExpToDrop()*2);

					if(t == Material.STONE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.COBBLESTONE));
					}
					if(t == Material.COBBLESTONE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.COBBLESTONE));
					}
					if(t == Material.IRON_ORE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.IRON_ORE));
					}
					if(t == Material.GOLD_ORE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.GOLD_ORE));
					}
					if(t == Material.COAL_ORE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.COAL));
					}
					if(t == Material.EMERALD_ORE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.EMERALD));
					}
					if(t == Material.DIAMOND_ORE){
						World w = b.getWorld();
						w.dropItem(b.getLocation(), new ItemStack(Material.DIAMOND));
					}
				}
			}
		}
	}

	@EventHandler
	public void onDoubleJumpBoots(PlayerToggleFlightEvent e){
		Player p = e.getPlayer();

		if (p.getInventory().getBoots().hasItemMeta() && 
				p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS && 
				p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Double Jump Boots")){
			
			if(p.getGameMode() != GameMode.CREATIVE){
				p.setVelocity(p.getLocation().getDirection().multiply(1.5)
						.setY(1));
				p.setAllowFlight(false);
				p.setFlying(false);
				e.setCancelled(true);
				return;
				
			}

		}
		if (p.getInventory().getBoots().hasItemMeta() && 
				p.getInventory().getBoots().getType() == Material.GOLD_BOOTS && 
				p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Fly Boots")){
			return;
		}
	}
}
