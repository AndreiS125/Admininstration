package org.andreis.mc.commands;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class become implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")) {
            if(args[0]!=null){
                PlayerProfile p = Bukkit.getPlayer(sender.getName()).getPlayerProfile();

                p.setName(args[0]);


                Bukkit.getPlayer(sender.getName()).setPlayerProfile(p);

            }

        }

        return false;
    }
}
