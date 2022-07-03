package org.andreis.mc.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gm implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args[0]!=null  && Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){


            Player pl  = Bukkit.getPlayer(sender.getName());
            if(Integer.parseInt(args[0])==1) {
                pl.setGameMode(GameMode.SURVIVAL);
            }
            if(Integer.parseInt(args[0])==2) {
                pl.setGameMode(GameMode.CREATIVE);
            }
            if(Integer.parseInt(args[0])==3) {
                pl.setGameMode(GameMode.SPECTATOR);
            }
        }

        return false;
    }
}
