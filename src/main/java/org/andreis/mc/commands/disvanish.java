package org.andreis.mc.commands;

import org.andreis.mc.Admininstration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class disvanish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
            Admininstration.vanishmap.remove(sender.getName());
            Admininstration.vanishmap.put(sender.getName(), "off");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.showPlayer(Admininstration.instance,Bukkit.getPlayer(sender.getName()));
                Bukkit.getPlayer(sender.getName()).setInvisible(false);
                player.sendMessage(ChatColor.YELLOW+sender.getName()+" присоединился к игре");
            }


        }
        return false;
    }
}
