package com.gildedrose.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gildedrose.builder.ItemBuilder;
import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.qualitycontrol.QualityControlFactory;
import com.gildedrose.sellincontrol.SellInControl;

public class GildedRoseTest {
    
    @Test
    public void Testragnaros(){
    	List<Item> items = new ArrayList<>();
    	items.add(ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(80).withSellIn(0).build());
    	GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());
    	
    	app.updateQualityFor(items);
    	
    	assertEquals(80, items.get(0).quality);
    	assertEquals(0, items.get(0).sellIn);
    	
    }
    
    
    @Test
    public void TestAgedBrie(){
    	List<Item> items = new ArrayList<>();
    	items.add(ItemBuilder.anItem().withName("Aged Brie").withQuality(0).withSellIn(2).build());
    	GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());
    	
    	app.updateQualityFor(items);
    	
    	assertTrue(items.get(0).quality > 0);
    	assertTrue(items.get(0).sellIn < 2);
    	
    }
    
    
    @Test
    public void TestConjuredItem(){
    	List<Item> items = new ArrayList<>();
    	items.add(ItemBuilder.anItem().withName("Conjured Mana Cake").withQuality(2).withSellIn(2).build());
    	GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());
    	
    	app.updateQualityFor(items);
    	
    	assertTrue(items.get(0).quality == 0);
    	assertTrue(items.get(0).sellIn < 2);
    	
    }
    
    @Test
    public void TestBackstagePass(){
    	List<Item> items = new ArrayList<>();
    	items.add(ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(20).withSellIn(15).build());
        GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());
    	
    	app.updateQualityFor(items);
    	
    	assertTrue(items.get(0).quality > 20);
    	assertTrue(items.get(0).sellIn < 15);
    	
    }
    
    @Test
    public void testDefaultItem(){
    	List<Item> items = new ArrayList<>();
    	items.add(ItemBuilder.anItem().withName("a default item").withQuality(20).withSellIn(15).build());
        GildedRose app = new GildedRose(new QualityControlFactory(), new SellInControl());
    	
    	app.updateQualityFor(items);
    	
    	assertTrue(items.get(0).quality == 19);
    	assertTrue(items.get(0).sellIn == 14);
    	
    }
}
