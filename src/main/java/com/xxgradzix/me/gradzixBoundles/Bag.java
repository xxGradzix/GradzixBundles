package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final String id;
    private final ItemStack bundleItem;

    private final Map<ItemStack, Double> itemsWithChances;

    private final String openBagMessage;

    public Bag(String id, ItemStack bundleItem, String openBagMessage) {
        this.id = id;
        this.openBagMessage = openBagMessage;

        ItemStack item = new ItemStack(bundleItem);
        ItemMeta meta = item.getItemMeta();
        NbtItemUtil.setItemCustomId(meta, id);
        item.setItemMeta(meta);
        this.bundleItem = item;

        this.itemsWithChances = new HashMap<>();
    }

    public ItemStack getBundleItem() {
        return bundleItem;
    }

    public String getId() {
        return id;
    }

    public void addItem(ItemStack item, double chance) {
        itemsWithChances.put(item, chance);
    }

    public Map<ItemStack, Double> getItemsWithChances() {
        return itemsWithChances;
    }

    public String getOpenBagMessage() {
        return openBagMessage;
    }
}