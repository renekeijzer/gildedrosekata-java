package com.gildedrose.qualitycontrol;

import com.gildedrose.core.Item;

public class DefaultQualityControl implements QualityControl { 
	
	@Override
	public void updateQualityFor(Item item) {
		item.setQuality(item.getQuality() - qualityDropFor(item));
	}
	
	private int qualityDropFor(Item item ){
		int defaultQualityDrop = defaultQualityDropFor(item);
		
		return item.getQuality() - defaultQualityDrop >= 0 
				? DEFAULT_QUALITY_DROP * 2 : DEFAULT_QUALITY_DROP;
	}
	
	private int defaultQualityDropFor(Item item){
		return item.getSellIn() < 0 
				? DEFAULT_QUALITY_DROP * 2: DEFAULT_QUALITY_DROP;
	}

}
