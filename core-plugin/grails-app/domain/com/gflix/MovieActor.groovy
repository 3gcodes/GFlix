package com.gflix

import org.apache.commons.lang.builder.HashCodeBuilder

class MovieActor implements Serializable {
	
	Movie movie
	Actor actor
	
	boolean equals(other) {
		if (!(other instanceof MovieActor)) {
			return false
		}
		other.movie?.id == movie?.id && other.actor?.id == actor?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (movie) builder.append(movie.id)
		if (actor) builder.append(actor.id)
		builder.toHashCode()
	}
	
	static mapping = {
		id composite: ['movie','actor']
		version false
	}
	
	static MovieActor get(long movieId, long actorId) {
		find 'from MovieActor where movie.id=:movieId and actor.id=:actorId',
		[movieId:movieId, actorId:actorId]
	}
	
	static MovieActor create(Movie movie, Actor actor, boolean flush = false) {
		new MovieActor(movie:movie, actor:actor).save(flush:flush, insert:true)
	}
	
	static boolean remove(Movie movie, Actor actor, boolean flush = false) {
		MovieActor instance = MovieActor.findByMovieAndActor(movie, actor)
		instance ? instance.delete(flush:flush) : false
	}
	
	static void removeAll(Movie movie) {
		executeUpdate('DELETE FROM MovieActor WHERE movie=:movie', [movie:movie])
	}
	
	static void removeAll(Actor actor) {
		executeUpdate('DELETE FROM MovieActor WHERE actor=:actor', [actor:actor])
	}

    
}
