package com.plugin.grails.uberDateFormatter

public enum UberDateFormatterPrecision {
	SEASON('Season'),
	QUARTER('Quarter'),
	MONTH('Month'),
	DAY('Day')
	
	private final String value
	
	UberDateFormatterPrecision(value) {
		this.value = value
	}
	
	String getKey() {
		name()
	}
	
	String toString() {
		value
	}
}