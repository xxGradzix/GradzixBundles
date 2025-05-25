package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GetBagCommand implements CommandExecutor, TabCompleter {

    private final BagManager bagManager;

    public GetBagCommand(BagManager bagManager) {
        this.bagManager = bagManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if(!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("§cThis command can only be used by players.");
            return false;
        }

        if(strings.length == 0) {
            commandSender.sendMessage("§cUsage: /getbag <bag_id>");
            return false;
        }
        String bagId = strings[0];

        if(!bagManager.bagExists(bagId)) {
            commandSender.sendMessage("§cBag with ID " + bagId + " does not exist.");
            return false;
        }

        Bag bag = bagManager.getBag(bagId);

        if(bag == null) {
            commandSender.sendMessage("§cBag with ID " + bagId + " does not exist.");
            return false;
        }

        Player player = (Player) commandSender;

        player.getInventory().addItem(bag.getBundleItem());

        return false;
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (strings.length == 1) {

            return bagManager.getAllBagIds();
        }
        return List.of();
    }
}
