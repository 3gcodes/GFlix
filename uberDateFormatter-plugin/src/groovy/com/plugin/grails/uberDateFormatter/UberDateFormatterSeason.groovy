package com.plugin.grails.uberDateFormatter

public enum UberDateFormatterSeason {

  	WINTER("Winter", Arrays.asList(12, 1, 2)),
  	SPRING("Spring", Arrays.asList(3, 4)),
  	SUMMER("Summer", Arrays.asList(5, 6, 7, 8)),
  	FALL("Fall", Arrays.asList(9, 10, 11));

  	UberDateFormatterSeason(String value, List<Integer> months) {
    	this.monthList = months
    	this.value = value
  	}

  	private List<Integer> monthList;
  	private final String value

  	public boolean inSeason(int month) {
    	return this.monthList.contains(month+1)  // if months are 0 based, then insert +1 before the )
  	}

  	public static UberDateFormatterSeason seasonForMonth(int month) {
    	for (UberDateFormatterSeason s: UberDateFormatterSeason.values()) {
      		if (s.inSeason(month))
        	return s
    	}
    	throw new IllegalArgumentException("Unknown month")
  	}

  	String getKey() {
    	name()
  	}

  	String toString() {
    	value
  	}
}