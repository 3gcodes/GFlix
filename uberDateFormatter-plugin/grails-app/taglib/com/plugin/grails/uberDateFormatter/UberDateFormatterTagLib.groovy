package com.plugin.grails.uberDateFormatter

class UberDateFormatterTagLib {

  	static namespace = "udf"

  	def formatDate = { attrs ->

    	def date = attrs['date']
    	def format = attrs['format']
    	def precision = attrs['precision']
    	if (date) {

      		def newDate = date
      		if (date instanceof String) {
        		newDate = new Date().parse(format, date);
      		}

      		if (precision == UberDateFormatterPrecision.SEASON) {
        		out << "${UberDateFormatterSeason.seasonForMonth(newDate.month)} ${newDate.format('yyyy')}"
      		} else if (precision == UberDateFormatterPrecision.QUARTER) {
        		out << "${UberDateFormatterQuarter.quarterForMonth(newDate.month)} ${newDate.format('yyyy')}"
      		} else if (precision == UberDateFormatterPrecision.MONTH) {
        		out << "${newDate.format('MMMM yyyy')}"
      		} else if (precision == UberDateFormatterPrecision.DAY) {
        		out << "${newDate.format('MMMM dd, yyyy')}"
      		} else {
        		out << "${newDate.format('MMMM dd, yyyy')}"
      		}
    	} else {
      		out << ""
    	}
  	}
}