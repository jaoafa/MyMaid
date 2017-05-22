package xyz.jaoafa.mymaid.EventHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

import xyz.jaoafa.mymaid.Method;
import xyz.jaoafa.mymaid.MyMaid;
import xyz.jaoafa.mymaid.Pointjao;
import xyz.jaoafa.mymaid.Discord.Discord;
import xyz.jaoafa.mymaid.Jail.Jail;

public class OnVotifierEvent implements Listener {
	JavaPlugin plugin;
	public OnVotifierEvent(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onVotifierEvent(VotifierEvent event) {
		final int VOTEPOINT = 20;

        Vote vote = event.getVote();
        String name = vote.getUsername();
        String i;
        if (Bukkit.getPlayer(vote.getUsername()) == null) {
        	i = Method.url_jaoplugin("vote", "p="+name);
        	String uuid = Method.url_jaoplugin("point", "p="+name);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date Date = new Date();
        	Pointjao.addjao("" + uuid, VOTEPOINT, sdf.format(Date) + "の投票ボーナス");
        } else {
        	Player player;
        	if (Bukkit.getPlayer(name) == null) {
        		player = Bukkit.getOfflinePlayer(name).getPlayer();
            } else {
            	player = Bukkit.getPlayer(name);
            }

        	UUID uuid = player.getUniqueId();
        	i = Method.url_jaoplugin("vote", "p="+name+"&u="+uuid);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date Date = new Date();
        	Pointjao.addjao(player, VOTEPOINT, sdf.format(Date) + "の投票ボーナス");

        	//SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
        	/*
    		if(date.format(Date).equalsIgnoreCase("2017-02")){
    			Random rnd = new Random();
    			int random = rnd.nextInt(50)+1;

    			Pointjao.addjao(player, random, sdf.format(Date) + "の投票ボーナス(2月ポイント補填ボーナス)");
    			Bukkit.broadcastMessage("[MyMaid] " + ChatColor.GREEN + player.getName() + "さんが投票し、2月ポイント補填ボーナスを" + random + "ポイント追加しました。");
    			Discord.send(player.getName() + "さんが投票し、2月ポイント補填ボーナスを" + random + "ポイント追加しました。");
    		}
        	 */
        	if(player.hasPermission("mymaid.pex.limited")){
				player.setPlayerListName(ChatColor.BLACK + "■" + ChatColor.WHITE + player.getName());
			}else if(Jail.isJail(player)){
				player.setPlayerListName(ChatColor.DARK_GRAY + "■" + ChatColor.WHITE + player.getName());
			}else if(MyMaid.chatcolor.containsKey(player.getName())){
				int i1 = Integer.parseInt(i);
				if(i1 >= 0 && i1 <= 5){
					player.setPlayerListName(ChatColor.WHITE + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 6 && i1 <= 19){
					player.setPlayerListName(ChatColor.DARK_BLUE + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 20 && i1 <= 33){
					player.setPlayerListName(ChatColor.BLUE + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 34 && i1 <= 47){
					player.setPlayerListName(ChatColor.AQUA + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 48 && i1 <= 61){
					player.setPlayerListName(ChatColor.DARK_AQUA  + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 62 && i1 <= 76){
					player.setPlayerListName(ChatColor.DARK_GREEN + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 77 && i1 <= 89){
					player.setPlayerListName(ChatColor.GREEN + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 90 && i1 <= 103){
					player.setPlayerListName(ChatColor.YELLOW + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 104 && i1 <= 117){
					player.setPlayerListName(ChatColor.GOLD + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 118 && i1 <= 131){
					player.setPlayerListName(ChatColor.RED + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 132 && i1 <= 145){
					player.setPlayerListName(ChatColor.DARK_RED + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 146 && i1 <= 159){
					player.setPlayerListName(ChatColor.DARK_PURPLE + "■" + ChatColor.WHITE + player.getName());
				}else if(i1 >= 160){
					player.setPlayerListName(ChatColor.LIGHT_PURPLE + "■" + ChatColor.WHITE + player.getName());
				}
			}else{
				player.setPlayerListName(ChatColor.GRAY + "■" + ChatColor.WHITE + player.getName());
			}
        }
        Bukkit.broadcastMessage("[MyMaid] " + ChatColor.GREEN + "プレイヤー「" + name + "」が投票をしました！(現在の投票数:" + i + "回)");
        Bukkit.broadcastMessage("[MyMaid] " + ChatColor.GREEN + "投票をよろしくお願いします！ https://bitly.com/jfvote");
        Discord.send("プレイヤー「" + name + "」が投票をしました！(現在の投票数:" + i + "回)");
        Discord.send("投票をよろしくお願いします！ https://bitly.com/jfvote");
    }
}
