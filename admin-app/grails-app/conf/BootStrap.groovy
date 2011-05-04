class BootStrap {

    def init = { servletContext ->
		environments {
			development {
				new Movie(title:"The Karate Kid", description: "Danial kicks Johnny's ass", releaseDate:new Date()).save(flush:true)
				new Movie(title:"The Karate Kid, Part II", description: "Danial kicks Chozen's ass", releaseDate:new Date()).save(flush:true)
				new Movie(title:"The Karate Kid, Part III", description: "Danial kicks Terry's ass", releaseDate:new Date()).save(flush:true)
				new Movie(title:"Braveheart", description: "Scottish guy kicks English ass", releaseDate:new Date()).save(flush:true)
				new Movie(title:"300", description: "Spartans kick Persian ass", releaseDate:new Date()).save(flush:true)
				new Movie(title:"Kick Ass", description: "Fake super hero gets his ass kicked", releaseDate:new Date()).save(flush:true)
				new Movie(title:"Crouching Tiger, Hidden Dragon", description: "Yu Shu Lien kicks everyone's ass", releaseDate:new Date()).save(flush:true)
			}
		}
    }
    def destroy = {
    }
}
