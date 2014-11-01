package me.Shadow48402.superboots;

import java.util.Arrays;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Superboots extends JavaPlugin{
	public PlayerListener pl = new PlayerListener(this);
	public final Logger logger = Logger.getLogger("Minecraft");
	public SettingsManager sm = new SettingsManager(this);

	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this.pl, this);
		getCommand("superboots").setExecutor(new SuperbootsCommand(this));
		sm.setup();
	}

	public ItemStack flyboots(){
		ItemStack i = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Fly Boots");
		im.setLore(Arrays.asList(new String[] { ChatColor.AQUA + "Fly as high as you can!" }));
		i.setItemMeta(im);

		return i;
	}

	public ItemStack speedboots(){
		ItemStack i = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Speed Boots");
		im.setLore(Arrays.asList(new String[] { ChatColor.AQUA + "Run as fast as you can!" }));
		i.setItemMeta(im);

		return i;
	}
	
	public ItemStack jumpboots(){
		ItemStack i = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Jump Boots");
		im.setLore(Arrays.asList(new String[]{
				ChatColor.AQUA + "Jump as high as you can!"
		}));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack defenceboots(){
		ItemStack i = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Defence Boots");
		im.setLore(Arrays.asList(new String[]{
				ChatColor.AQUA + "More armor :o"
		}));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack foodboots(){
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "FoodBoost boots");
		im.setLore(Arrays.asList(new String[]{
				ChatColor.AQUA + "Restore food like a boss"
		}));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack damageboots(){
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Damage Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "+ 50% Damage"));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack vanishboots(){
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Vanish Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "* Vanished *"));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack healboots(){
		ItemStack i = new ItemStack(Material.IRON_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Heal Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "1/" + sm.getSettings().getInt("HealChange") +" change to heal 0.5 health"));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack mineboots(){
		ItemStack i = new ItemStack(Material.IRON_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Mine Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "Mine more => Get more"));
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack runboots(){
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Run Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "Stay running..."));
		i.setItemMeta(im);
		return i;
	}
	
	public ItemStack sneakboots(){
		ItemStack i = new ItemStack(Material.IRON_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Sneak Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "Be quiet..."));
		i.setItemMeta(im);
		return i;
	}
	
	public ItemStack doublejumpboots(){
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Double Jump Boots");
		im.setLore(Arrays.asList(ChatColor.GREEN + "Jump, jump peeeew"));
		i.setItemMeta(im);
		return i;
	}
}
