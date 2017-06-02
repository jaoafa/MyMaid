package xyz.jaoafa.mymaid.Command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import xyz.jaoafa.mymaid.BugReport;
import xyz.jaoafa.mymaid.Method;
import xyz.jaoafa.mymaid.Pointjao;
import xyz.jaoafa.mymaid.SKKColors.SKKColors;


public class Unko implements CommandExecutor {
	JavaPlugin plugin;
	public Unko(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		int count = 1;
		if (!(sender instanceof Player)) {
			Method.SendMessage(sender, cmd, "このコマンドはゲーム内から実行してください。");
			Bukkit.getLogger().info("ERROR! コマンドがゲーム内から実行されませんでした。");
			return true;
		}
		Player player = (Player) sender;
		Random rnd = new Random();
		List<String> chattext = new ArrayList<String>();
		chattext.add("jaoafa");
		chattext.add("砂利");
		chattext.add("XnZ");
		chattext.add("jaotake");
		chattext.add("かす");
		chattext.add("(((（ ´◔ ω◔`）)))ほおおおおおおおおおおおおおおおおおおおおおおおｗｗｗｗｗｗｗｗｗｗｗ");
		chattext.add("こわけた");
		chattext.add("ティッシュマン");
		chattext.add("遺書");
		chattext.add("にーな");
		chattext.add("新世紀スーパーハイパーウルトラエクストリームインセインギガンティックエピックアメージングアーサムビューティフォースペシャルスワッグ言語");
		chattext.add("ﾒｯｷｮﾘﾒｯｷｮﾘｼﾞｬﾘｼﾞｬｰﾘwwwwww");
		chattext.add("ぼくのめいど");
		chattext.add("めのにり");
		chattext.add("お開始く");
		chattext.add("ded");
		chattext.add("deb");
		chattext.add("└( ・з・)┘");
		chattext.add("╰( ・з・)و");
		chattext.add("doom");
		chattext.add("ゔ");
		chattext.add("も");
		chattext.add("ら");
		chattext.add("(‘o’) ﾍｲ ﾕﾉｫﾝﾜｲ ﾜｨｱｨﾜｨｬ?");
		chattext.add("(‘o’) ｲﾖｯﾊ ｲﾔﾊ ｲﾔﾊ ｲﾔﾊ ｲﾔﾊ ｲﾔﾊ ｲﾔﾊ … ｫﾎﾎｯﾊｰﾎﾎｯﾊｰﾎﾎｯﾊｰﾊﾊﾊﾊﾊﾎﾎ…");
		chattext.add("(‘o’) ィ～ッニャッハッハッハッハッハッハッハッハッハッ");
		chattext.add("(‘o’) ィ～ニャッハッハッハッハッハッハッハッハッ");
		chattext.add("(‘o’) ﾝィ～ッニャッハッハッハッハッハッハッハッハッハッハッ");
		chattext.add("(‘o’) ｲﾖ ｲﾖ ｲﾖ ﾎﾎ ｲﾖ ｲﾖ ｲﾖ ﾎﾎ ｲﾖ ｲﾖ ｲﾖ ﾎﾎ ｵｰﾎﾎ ｵｯﾎﾎ");
		chattext.add("(‘o’) ｲﾖ ｲﾖ ｲﾖ ﾎﾎ ｲﾖ ｲﾖ ｲﾖ ﾎﾎ ｲﾖ ｲﾖ ｲﾖ…ｲﾖ…ｲﾖ…ｲﾖ…");
		chattext.add("(‘o’) ィ～ニャッハッハッハッハッハハハッハッハハハッハッハッハハハッ(ﾋﾟｩｰﾝ)");
		chattext.add("(‘o’) ィ～ニャッハッハッハッハハハッハッハハハハハハッハッハッ(ｳｫｰｱｰ?ﾀﾞｨｬ)");
		chattext.add("(‘o’) ィ～ニャッハッハッハッハッハハハッハッハハハッハッハッハハハッ(ﾋﾟｩｰﾝ)");
		chattext.add("(‘o’) ィ～ニャッハッハッハッハハハッハッハハハハハハッハッハッ(ﾆｮﾝ)ウォオオオオウ！！！！！！");
		chattext.add("(‘o’) ＜ を");
		chattext.add("とまととまと");
		chattext.add("とまとぉwとまとぉw");
		chattext.add("アタマ");
		chattext.add(".t階段");
		chattext.add("スパション");
		chattext.add("ジークフェンディア!!");
		chattext.add("，あこたしぁり");
		chattext.add("エロブライン");
		chattext.add("unk");
		chattext.add("_t");
		chattext.add("(‘O’)<ﾀﾞﾒﾀﾞﾒﾀﾞﾒﾀﾞﾒいうからっダメなんでしょ！！");
		chattext.add("(‘o’)< 別にｱﾅﾀもｱﾅﾀもｱﾅﾀも！！！");
		chattext.add("(‘o’)< どなたにしてもねぇ！不便じゃないんですぅ！");
		chattext.add("(‘o’)< 怒鳴られると不便なんですよぉ！！！！！！！");
		chattext.add("(‘o’)< ﾜｬﾘﾏｽｩ？");
		chattext.add("(‘o’)< 貴方がいなくっても！！！");
		chattext.add("(‘o’)< 世の中なーんとも！問題ないんですぅ！");
		chattext.add("(‘o’)< ワタシがいないとねぇ！大変ですけどぉ！");
		chattext.add("(‘o’)< わかりまでゅー？");
		chattext.add("(‘o’)< どぅおうぞ歩いてください");
		chattext.add("wasded");
		chattext.add("クラン");
		chattext.add("人口密度は人口÷密度");
		chattext.add("ナス");
		chattext.add("ドノカ");
		chattext.add("jao6");
		chattext.add("めのにり");
		chattext.add("やっぱた");
		chattext.add("23 ふぁ");
		chattext.add("みすと");
		chattext.add("#えたきちで遊ぼう");
		chattext.add("えたきちすたー");
		chattext.add("twll2");
		chattext.add("きちもいもらしい");
		chattext.add("にらたけ");
		chattext.add("ニラ");
		chattext.add("見てマヨ");
		chattext.add("宇宙の刀");
		chattext.add("なてち");
		chattext.add("どわる");
		chattext.add("ストかー");
		chattext.add("顔文字作り合戦しまーす");
		chattext.add("存在");
		chattext.add("Gold ball");
		chattext.add("w@");
		chattext.add("ぼっちの空");
		chattext.add("チキン変えよ");
		chattext.add("roboot");
		chattext.add("きとまう！");
		chattext.add("さいきとまう！");
		chattext.add("マイクラは壊すために作る");
		chattext.add("ヌメ");
		chattext.add("臭ブロック");
		chattext.add("SKype");
		chattext.add("でか文字");
		chattext.add("るーるーる");
		chattext.add("メンテナス");
		chattext.add("サーセンシャープ");
		int ran = rnd.nextInt(chattext.size());
		String text = chattext.get(ran-1) + "[No." + ran + "]";

		int use = 15;
		if(!Pointjao.hasjao(player, use)){
		 	 Method.SendMessage(sender, cmd, "このコマンドを使用するためのjaoPointが足りません。");
		 	 return true;
		}
		Pointjao.usejao(player, use, "unkoコマンド実行の為");

		String Msg = SKKColors.getPlayerSKKChatColor(player) + "■" + ChatColor.WHITE + player.getName();
		Date Date = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Bukkit.broadcastMessage(ChatColor.GRAY + "["+ timeFormat.format(Date) + "]" + Msg + ": " + text);

		Throwable ex = null;

		for(Player to: Bukkit.getServer().getOnlinePlayers()) {
			try{
				new Unko_Unko(plugin, player, to).runTaskLater(plugin, (20 * count));
			}catch(java.lang.NoClassDefFoundError e){
				player.getWorld().playSound(to.getLocation().add(0, 2, 0), Sound.GHAST_SCREAM,10,1);
				player.getWorld().playEffect(to.getLocation().add(0, 2, 0), Effect.HEART, 0);
				ex = e;
			}
			count++;
		}
		if(ex != null){
			BugReport.report(ex);
		}
		return true;
	}
	private class Unko_Unko extends BukkitRunnable{
    	Player player;
    	Player to;
    	public Unko_Unko(JavaPlugin plugin, Player player, Player to) {
    		this.player = player;
    		this.to = to;
    	}
		@Override
		public void run() {
			player.teleport(to);
			player.getWorld().playSound(to.getLocation().add(0, 2, 0), Sound.GHAST_SCREAM,10,1);
			player.getWorld().playEffect(to.getLocation().add(0, 2, 0), Effect.HEART, 0);
		}
	}
}
