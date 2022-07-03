package org.andreis.mc.commands;

import org.andreis.mc.Admininstration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class unmute implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
                Player pl=Bukkit.getPlayer(sender.getName());
                if(args[0]!=null) {
                    if (Admininstration.mutemap.containsKey(args[0])) {
                        Admininstration.mutemap.remove(args[0]);
                    }
                    Admininstration.mutemap.putIfAbsent(args[0], "off");
                    sender.sendMessage(ChatColor.GREEN+"В успешно размутили игрока.");
                }
                sender.sendMessage(ChatColor.RED+"Вы не указали имя.");
            }
        }
        catch (Exception e){

        }

        return false;
    }
}
