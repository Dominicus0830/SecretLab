package org.domi.timer;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.domi.SecretLab;

//경고 메시지 안보이게
public class StartCountDown {
    private static BossBar bossBar;
    private static final SecretLab plugin = SecretLab.getInstance();

    public static void startCountDown() {
        bossBar = Bukkit.createBossBar("카운트다운", BarColor.BLUE, BarStyle.SEGMENTED_10);
        bossBar.setProgress(1.0);
        for(Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(player);
        }

        new BukkitRunnable() {
            int counter = 10;
            @Override
            public void run() {
                if(counter > 0) {
                    bossBar.setProgress(counter / 10.0);
                    if(counter <= 3) {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("", String.valueOf(counter), 10, 20, 10);
                        }
                    }
                    counter--;
                } else {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle("", "끝!", 10, 20, 10);
                        bossBar.removePlayer(player);
                    }
                    bossBar = null;
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0L, 20L); //20 ticks = 1 second
    }
}
