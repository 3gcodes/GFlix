package com.gflix

class MovieController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [movieInstanceList: Movie.list(params), movieInstanceTotal: Movie.count()]
    }

    def create = {
        def movieInstance = new Movie()
        movieInstance.properties = params
        return [movieInstance: movieInstance]
    }

    def save = {
        def movieInstance = new Movie(params)
        if (movieInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'movie.label', default: 'Movie'), movieInstance.id])}"
            redirect(action: "show", id: movieInstance.id)
        }
        else {
            render(view: "create", model: [movieInstance: movieInstance])
        }
    }

    def show = {
        def movieInstance = Movie.get(params.id)
        if (!movieInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
            redirect(action: "list")
        }
        else {
            [movieInstance: movieInstance]
        }
    }

    def edit = {
        def movieInstance = Movie.get(params.id)
        if (!movieInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [movieInstance: movieInstance]
        }
    }

    def update = {
        def movieInstance = Movie.get(params.id)
        if (movieInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (movieInstance.version > version) {
                    
                    movieInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'movie.label', default: 'Movie')] as Object[], "Another user has updated this Movie while you were editing")
                    render(view: "edit", model: [movieInstance: movieInstance])
                    return
                }
            }
            movieInstance.properties = params
            if (!movieInstance.hasErrors() && movieInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'movie.label', default: 'Movie'), movieInstance.id])}"
                redirect(action: "show", id: movieInstance.id)
            }
            else {
                render(view: "edit", model: [movieInstance: movieInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def movieInstance = Movie.get(params.id)
        if (movieInstance) {
            try {
                movieInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'movie.label', default: 'Movie'), params.id])}"
            redirect(action: "list")
        }
    }
}
