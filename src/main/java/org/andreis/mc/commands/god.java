package org.andreis.mc.commands;

import org.andreis.mc.Admininstration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class god implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
            Player pl = Bukkit.getPlayer(sender.getName());
            if(args[0]==null){
                try {
                    if (Admininstration.godmap.containsKey(pl.getName())) {

                        if (Admininstration.godmap.get(pl.getName()).equals("on")) {
                            Admininstration.godmap.remove(pl.getName());
                            Admininstration.godmap.put(pl.getName(), "off");
                        } else {

                            Admininstration.godmap.remove(pl.getName());
                            Admininstration.godmap.put(pl.getName(), "on");
                        }

                    } else {
                        Admininstration.godmap.put(pl.getName(), "on");
                    }
                }
                catch(Exception ex){
                    sender.sendMessage(ex.toString());
                }

            }
            else if(args[0]!=null){
                if(Admininstration.godmap.containsKey(args[0])){

                    if(Admininstration.godmap.get(args[0]).equals("on")){
                        Admininstration.godmap.remove(args[0]);
                        Admininstration.godmap.put(args[0], "off");
                    }
                    else{

                        Admininstration.godmap.remove(args[0]);
                        Admininstration.godmap.put(args[0], "on");
                    }

                }
                else{
                    Admininstration.godmap.put(args[0], "on");
                }
            }

        }
        return false;
    }
}
