package com.gildedrose.tests;

import java.util.ArrayList;
import java.util.List;

import com.gildedrose.builder.ItemBuilder;
import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.qualitycontrol.QualityControlFactory;
import com.gildedrose.sellincontrol.SellInControl;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        List<Item> items = new ArrayList<>();
        
        items.add(ItemBuilder.anItem().withName("+5 Dexterity Vest").withQuality(20).withSellIn(10).build());
        items.add(ItemBuilder.anItem().withName("Aged Brie").withQuality(0).withSellIn(2).build());
        items.add(ItemBuilder.anItem().withName("Elixir of the Mongoose").withQuality(7).withSellIn(5).build());
        items.add(ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(80).withSellIn(0).build());
        items.add(ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(80).withSellIn(-1).build());
        items.add(ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(20).withSellIn(15).build());
        items.add(ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(49).withSellIn(10).build());
        items.add(ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(49).withSellIn(5).build());
        items.add(ItemBuilder.anItem().withName("Conjured Mana Cake").withQuality(6).withSellIn(3).build());

        
       GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQualityFor(items);
        }
    }

}
