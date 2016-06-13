package com.gildedrose.qualitycontrol;

import com.gildedrose.core.Item;

public interface QualityControl {
	int MAX_QUALITY_ALLOWED = 50;
	int DEFAULT_QUALITY_HIKE = 1;
	int DEFAULT_QUALITY_DROP = 1;
	
	void updateQualityFor(Item item);

}
