package org.andreis.mc.commands;

import org.andreis.mc.Admininstration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
            if(Admininstration.vanishmap.containsKey(sender.getName())){
                Admininstration.vanishmap.remove(sender.getName());
                Admininstration.vanishmap.put(sender.getName(), "on");
            }
            else{
                Admininstration.vanishmap.put(sender.getName(), "on");
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(Admininstration.instance, Bukkit.getPlayer(sender.getName()));

                player.sendMessage(ChatColor.YELLOW+sender.getName()+" покинул игру");

            }



        }
        return false;
    }
}
