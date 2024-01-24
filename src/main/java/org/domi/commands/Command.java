package org.domi.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.domi.timer.StartCountDown;

@SuppressWarnings("unused")
public class Command {
    public static void bossBar(CommandSender commandSender,  String string) {
        if (commandSender instanceof Player p) {
            System.out.println("test");
            StartCountDown.startCountDown();
        }
    }
}
