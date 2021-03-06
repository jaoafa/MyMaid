package xyz.jaoafa.mymaid.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.jaoafa.mymaid.Method;
import xyz.jaoafa.mymaid.Discord.Discord;

public class WTP implements CommandExecutor {
	JavaPlugin plugin;
	public WTP(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		// /wtp <World> <X> <Y> <Z> : 4
		// /wtp <Player> <World> <X> <Y> <Z> : 5

		if(args.length == 4){
			if (!(sender instanceof Player)) {
				Method.SendMessage(sender, cmd, "このコマンドはゲーム内から実行してください。");
				return true;
			}
			Player player = (Player) sender;
			// /wtp <World> <X> <Y> <Z> : 4
			String worldname = args[0];
			World world = plugin.getServer().getWorld(worldname);
			if(world == null){
				Method.SendMessage(sender, cmd, "指定されたワールドは見つかりません。");
				return true;
			}

			int x;
			try{
				x = Integer.parseInt(args[1]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "x座標には数値を指定してください。");
				return true;
			}

			int y;
			try{
				y = Integer.parseInt(args[2]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "y座標には数値を指定してください。");
				return true;
			}

			int z;
			try{
				z = Integer.parseInt(args[3]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "z座標には数値を指定してください。");
				return true;
			}

			Location location = new Location(world, x, y, z);
			player.teleport(location);
			String locstr = x + ", " + y + ", " + z;
			Discord.send("*[" + player.getName() + ": " + player.getName() + " to " + locstr + "]*");
			Bukkit.broadcastMessage(ChatColor.GRAY + "[" + player.getName() + ": " + player.getName() + " は " + locstr + " にワープしました]");
			return true;
		}else if(args.length == 5){
			// /wtp <Player> <World> <X> <Y> <Z> : 5
			Player tpplayer = plugin.getServer().getPlayer(args[0]);
			if(tpplayer == null){
				Method.SendMessage(sender, cmd, "指定されたプレイヤーはオフラインか見つかりませんでした。");
				return true;
			}
			String worldname = args[1];
			World world = plugin.getServer().getWorld(worldname);
			if(world == null){
				Method.SendMessage(sender, cmd, "指定されたワールドは見つかりません。");
				return true;
			}

			int x;
			try{
				x = Integer.parseInt(args[2]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "x座標には数値を指定してください。");
				return true;
			}

			int y;
			try{
				y = Integer.parseInt(args[3]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "y座標には数値を指定してください。");
				return true;
			}

			int z;
			try{
				z = Integer.parseInt(args[4]);
			}catch(NumberFormatException e){
				Method.SendMessage(sender, cmd, "z座標には数値を指定してください。");
				return true;
			}

			Location location = new Location(world, x, y, z);
			tpplayer.teleport(location);
			String locstr = x + ", " + y + ", " + z;
			Discord.send("*[" + sender.getName() + ": " + tpplayer.getName() + " to " + locstr + "]*");
			Bukkit.broadcastMessage(ChatColor.GRAY + "[" + sender.getName() + ": " + tpplayer.getName() + " は " + locstr + " にワープしました]");
			return true;
		}
		Method.SendMessage(sender, cmd, "----- WTP -----");
		Method.SendMessage(sender, cmd, "/wtp <World> <X> <Y> <Z>: <World>の<X> <Y> <Z>座標にテレポートします。");
		Method.SendMessage(sender, cmd, "/wtp <Player> <World> <X> <Y> <Z>: <Player>を<World>の<X> <Y> <Z>座標にテレポートします。");
		return true;
	}
}
