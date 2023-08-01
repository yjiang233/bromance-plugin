package com.yjcreate.bromance.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import static com.yjcreate.bromance.util.MessageUtils.BUNDLE;

/**
 * @author YJiang
 * @description The Fly Command
 * @date 2023/8/1 23:02
 */
public class CommandFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0] != null) {
            final Player player = Bukkit.getPlayerExact(args[0]);
            if (player == null) {
                sender.sendMessage(BUNDLE.getString("error.not.online"));
            } else {
                player.setFlying(!player.getAllowFlight());
                sender.sendMessage(BUNDLE.getString("fly.state.message") + ":" + (player.getAllowFlight()?BUNDLE.getString("state.on"):BUNDLE.getString("state.off")));
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setFlying(!player.getAllowFlight());
                player.sendMessage(BUNDLE.getString("fly.state.message") + ":" + (player.getAllowFlight()?BUNDLE.getString("state.on"):BUNDLE.getString("state.off")));
            } else {
                sender.sendMessage(BUNDLE.getString("error.not.player"));
                return false;
            }
        }
        return true;
    }
}
