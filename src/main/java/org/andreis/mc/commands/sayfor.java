package org.andreis.mc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class sayfor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
                if(args[0]!=null && args[1]!=null) {
                    String message = args[1];
                    int amount=-1;
                    for (String arg : args){
                        amount++;
                    }
                    for (int i = 2; i<amount+1; i++){
                        message=message+" "+args[i];
                    }
                    Bukkit.getPlayer(args[0]).chat(message);
                }
            }
        }
        catch (Exception e){

        }

        return false;
    }
}
