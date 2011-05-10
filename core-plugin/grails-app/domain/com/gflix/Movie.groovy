package com.gflix

class Movie {
	
	String title
	String description
	Date releaseDate
	Date expectedReleaseDate
	UberDateFormatterPrecision expectedPublishDatePrecision
	Date dateCreated
	Date lastUpdated

    static constraints = {
		title nullable:false, blank:false, maxSize: 150
		description nullable:true, maxSize: 4000
		releaseDate nullable:true
		expectedReleaseDate nullable:true
		expectedPublishDatePrecision nullable:true
		dateCreated nullable:true
		lastUpdated nullable:true
    }

	Set<Actor> getActors() {
		MovieActor.findAllByMovie(this).collect { it.actor } as Set
	}
}
