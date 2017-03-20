package xyz.jaoafa.mymaid.EventHandler;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SpawnEggRegulation implements Listener {
	JavaPlugin plugin;
	public SpawnEggRegulation(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	public static Map<String,String> old = new HashMap<String,String>();
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if ((event.getAction() != Action.RIGHT_CLICK_AIR) && (event.getAction() != Action.RIGHT_CLICK_BLOCK)) {
			return;
		}
		if(event.isCancelled()){
			return;
		}
		Player player = event.getPlayer();
		ItemStack is = player.getInventory().getItemInHand();
		if(is.getType() != Material.MONSTER_EGG){
			return;
		}
		MobType type = getMobTypeFromId(is.getDurability());
		if(PermissionsEx.getUser(player).inGroup("Limited") || PermissionsEx.getUser(player).inGroup("QPPE")){
			event.setCancelled(true);
			if(old.containsKey(player.getName())){
				if(old.get(player.getName()).equalsIgnoreCase(type.name())){
					return;
				}
			}
			old.put(player.getName(), type.name());
			for(Player p: Bukkit.getServer().getOnlinePlayers()) {
				if(PermissionsEx.getUser(p).inGroup("Admin") || PermissionsEx.getUser(p).inGroup("Moderator")) {
					p.sendMessage("[SPAWNEGG] " + ChatColor.GREEN + "「" + player.getName() + "」が「" + type.name() + "」をスポーンさせようとしましたが規制されました。");
				}
			}
		}

	}
	enum MobType
	{
		CREEPER(50),
		SKELETON(51),
		SPIDER(52),
		ZOMBIE(54),
		SLIME(55),
		GHAST(56),
		PIGZOMBIE(57),
		ENDERMAN(58),
		CAVESPIDER(59),
		SILVERFISH(60),
		BLAZE(61),
		MAGMACUBE(62),
		PIG(90),
		SHEEP(91),
		COW(92),
		CHICKEN(93),
		SQUID(94),
		WOLF(95),
		MOOSHROOM(96),
		OCELOT(98),
		VILLAGER(120),
		UNKNOWN(0);

		private int id = 0;
		MobType(int id)
		{
			this.id = id;
		}
		public int getEntityId()
		{
			return this.id;
		}
	}
	public static MobType getMobTypeFromId(int id)
	{
		for (MobType mobType : MobType.values())
		{
			if (id == mobType.getEntityId())
				return mobType;
		}

		return MobType.UNKNOWN;
	}
}
