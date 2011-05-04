package com.gflix

class Movie {
	
	String title
	String description
	Date releaseDate
	Date dateCreated
	Date lastUpdated

    static constraints = {
		title nullable:false, blank:false, maxSize: 150
		description nullable:true, maxSize: 4000
		releaseDate nullable:false
		dateCreated nullable:true
		lastUpdated nullable:true
    }
}
