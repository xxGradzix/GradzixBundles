package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagManager {
    private final Map<String, Bag> bags;

    public BagManager() {
        this.bags = new HashMap<>();
    }

    public void registerBag(Bag bag) {
        bags.put(bag.getId(), bag);
    }

    public Bag getBag(String id) {
        return bags.get(id);
    }

    public boolean bagExists(String id) {
        return bags.containsKey(id);
    }

    public boolean isBag(ItemStack item) {
        String id = NbtItemUtil.getCustomId(item.getItemMeta()).orElse("");

        if (id.isEmpty()) {
            return false;
        }
        if (bags.containsKey(id)) {
            return true;
        } else {
            item.setAmount(0); // Remove the item if it's not a valid bag
            return false;
        }
    }

    public String getBagID(ItemStack item) {
        return NbtItemUtil.getCustomId(item.getItemMeta()).orElse("");
    }

    public List<String> getAllBagIds() {
        return new ArrayList<>(bags.keySet());
    }
}