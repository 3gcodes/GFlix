package com.plugin.grails.uberDateFormatter

public enum UberDateFormatterQuarter {

  	Q1("Q1", [1,2,3]),
  	Q2("Q2", [4,5,6]),
  	Q3("Q3", [7,8,9]),
  	Q4("Q4", [10,11,12]);

  	UberDateFormatterQuarter(String value, List<Integer> months) {
    	this.monthList = months
    	this.value = value
  	}

  	private List<Integer> monthList;
  	private final String value

  	public boolean inSeason(int month) {
    	return this.monthList.contains(month+1)  // if months are 0 based, then insert +1 before the )
  	}

  	public static UberDateFormatterQuarter quarterForMonth(int month) {
    	for (UberDateFormatterQuarter s: UberDateFormatterQuarter.values()) {
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