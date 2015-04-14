package com.iterrychao.robinhood.argument;

public class AttributeItem {
	private String mKey;
	private String mValue;
	public AttributeItem(String key, String value) {
		mKey = key;
		mValue = value;
	}
	
	public String getKey() {
		return mKey;
	}
	
	public String getValue() {
		return mValue;
	}
}
