package com.gildedrose.core;

import java.util.List;

import com.gildedrose.qualitycontrol.QualityControl;
import com.gildedrose.qualitycontrol.QualityControlFactory;
import com.gildedrose.sellincontrol.SellInControl;

public class GildedRose {

	private QualityControlFactory qualityControlFactory;
	private SellInControl sellInControl;
	
	public GildedRose(QualityControlFactory qualityControl, SellInControl sellInControl) {
		this.qualityControlFactory = qualityControl;
		this.sellInControl = sellInControl;
	}

	public void updateQualityFor(List<Item> items) {
		for (Item item : items) {
			udpateSellInFor(item);
			updateQualityFor(item);
		}
	}
	
	private void updateQualityFor(Item item) {
		QualityControl qualityControl = qualityControlFactory.qualityControlFor(item);
		qualityControl.updateQualityFor(item);
	}

	private void udpateSellInFor(Item item) {
		sellInControl.updateSellInFor(item);
	}

}