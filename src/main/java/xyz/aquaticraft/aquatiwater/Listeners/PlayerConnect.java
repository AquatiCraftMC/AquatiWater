package xyz.aquaticraft.aquatiwater.Listeners;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerConnect implements Listener {
    TextUtils t = new TextUtils();
    AquatiWaterPlugin plugin = AquatiWaterPlugin.getPlugin(AquatiWaterPlugin.class);

    public void playerPreConnect(AsyncPlayerPreLoginEvent e) {
        Player p = Bukkit.getPlayer(e.getUniqueId());
        ViaAPI api = Via.getAPI();
        int version = api.getPlayerVersion(p);
        if (version == 47) {
            e.setKickMessage(ChatColor.translateAlternateColorCodes('&', "&3(&b!&3) &bYou are not on the correct version! Please connect with version &31.18&b."));
            e.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
        }
    }
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        if (e.getPlayer().getName().startsWith(".")) {
            Player p = e.getPlayer();
            t.sendMessage(p, "You have connected with &3&lBEDROCK EDITION&b. Welcome to our server!", true);
        }
        else {
            Player p = e.getPlayer();
            t.sendMessage(p, "&bYou have connected with &3&lJAVA EDITION&b. Remember, our sever supports &3&lBEDROCK EDITION&b! Type &3/bedrock&b to learn more.", true);
        }
        //Create a new BossBar
        BossBar b = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("BossBarMessage")), BarColor.BLUE, BarStyle.SOLID);
        b.setVisible(true);
        b.addPlayer(e.getPlayer());
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7[&a+&7] " + e.getPlayer().getName()));
        String message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ActionBarMessage"));
        Player player = Bukkit.getPlayer("ExamplePlayer");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));


    }


}
