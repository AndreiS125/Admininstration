package org.andreis.mc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class strike implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args[0]!=null  && Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){


            Player pl  = Bukkit.getPlayer(args[0]);
            pl.getWorld().strikeLightning(pl.getLocation());


        }

        return false;
    }
}
