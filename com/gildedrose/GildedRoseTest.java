package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test  public void 
    testAnItemWithPositiveQualityShouldDecreaseQuality() {
        Item[] items = new Item[] { new Item("Executionner", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
    
    @Test public void
    testUpdateQualityForFreshAgedBrieItemShouldIncreaseQuality() {
    	Item[] items = new Item[]  { new Item("Aged Brie", 1, 1) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(2, items[0].quality);
    }

    @Test public void
    testUpdateQualityForNotFreshAgedBrieItemShouldIncreaseQuality() {
    	Item[] items = new Item[]  { new Item("Aged Brie", -1, 1) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(3, items[0].quality);
    }
}
