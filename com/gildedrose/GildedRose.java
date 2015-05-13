package com.gildedrose;

class GildedRose {
	
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {

            } else {
                decreaseSellInItem(i);

                if (BACKSTAGE_PASSES.equals(items[i].name)) {
                    increaseQualityItem(i);

                    if (items[i].sellIn < 11) {
                        increaseQualityItem(i);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQualityItem(i);
                    }

                    if (hasSellInDatePassed(i)) {
                		items[i].quality = 0;
                	}

                }

                if (AGED_BRIE.equals(items[i].name)) {
                    increaseQualityItem(i);
                	if (hasSellInDatePassed(i)) {
                		increaseQualityItem(i);
                	}

                } else if (!BACKSTAGE_PASSES.equals(items[i].name)) {
                    decreaseQualityItem(i);
                  	if (hasSellInDatePassed(i)) {
                		decreaseQualityItem(i);
                	}
                }

            }
        }
    }

	private boolean hasSellInDatePassed(int i) {
		return items[i].sellIn < 0;
	}

	private void decreaseSellInItem(int i) {
		items[i].sellIn = items[i].sellIn - 1;
	}

    private void decreaseQualityItem(int i) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

	private void increaseQualityItem(int i) {
		if (items[i].quality < 50) {
		    items[i].quality = items[i].quality + 1;
		}
	}
}
