package com.gflix

class Actor {
	
	String firstName
	String lastName

    static constraints = {
		firstName nullable:false, blank:false
		lastName nullable:false, blank:false
    }

	Set<Actor> getMovies() {
		MovieActor.findAllByActor(this).collect { it.movie } as Set
	}
}
