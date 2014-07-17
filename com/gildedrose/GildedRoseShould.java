package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseShould {

    @Test public void 
    increaseddAgedBrieQualityBy2WhenQualityIsLessThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("One item called Aged Brie", "Aged Brie", app.items[0].name);
        assertEquals("Updated Aged Brie quality=0 to 2", 2, app.items[0].quality);
    }

    @Test public void 
    decreaseAgedBrieSellInBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("One item called Aged Brie", "Aged Brie", app.items[0].name);
        assertEquals("Updated Aged Brie sellIn=0 to -1", -1, app.items[0].sellIn);
    }
    
    @Test public void 
    decreaseAnItemQualityBy2WhenQualityIsGreaterThan0() {
        Item[] items = new Item[] { new Item("an Item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Updated an Item quality=10 to 8", 8, app.items[0].quality);
    }
    
    @Test public void 
    decreaseAnItemSellInBy1() {
        Item[] items = new Item[] { new Item("an Item", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test public void 
    decreaseAnItemSellInNegativeAndNotDecreaseQuality() {
        Item[] items = new Item[] { new Item("an Item", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test public void 
    notDecreaseSulfurasSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }
    
    @Test public void 
    notChangeSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    
    @Test public void 
    decreaseBackstageSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
    }

    @Test public void 
    increaseBackstageQualityBy2AndDecreaseSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(42, app.items[0].quality);
    }

    @Test public void 
    decreaseBackstageSellInAndIncreaseQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test public void 
    decreaseBackStageSellInAndIncreaseQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }
    
    @Test public void 
    decreaseBackStageSellInAndQualitySetTo0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
