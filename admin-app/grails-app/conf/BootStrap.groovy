import com.gflix.Movie

class BootStrap {

    def init = { servletContext ->
		environments {
			development {
				def dateFormat = "yyyy-MM-dd"
				new Movie(title:"The Karate Kid", description: "Danial kicks Johnny's ass", releaseDate:new Date().parse(dateFormat, '1984-06-22')).save(flush:true)
				new Movie(title:"The Karate Kid, Part II", description: "Danial kicks Chozen's ass", releaseDate:new Date().parse(dateFormat, '1986-06-20')).save(flush:true)
				new Movie(title:"The Karate Kid, Part III", description: "Danial kicks Terry's ass", releaseDate:new Date().parse(dateFormat, '1989-06-30')).save(flush:true)
				new Movie(title:"Braveheart", description: "Scottish guy kicks English ass", releaseDate:new Date().parse(dateFormat, '1995-05-24')).save(flush:true)
				new Movie(title:"300", description: "Spartans kick Persian ass", releaseDate:new Date().parse(dateFormat, '2007-03-09')).save(flush:true)
				new Movie(title:"Kick Ass", description: "Fake super hero gets his ass kicked", releaseDate:new Date().parse(dateFormat, '2010-04-16')).save(flush:true)
				new Movie(title:"Crouching Tiger, Hidden Dragon", description: "Yu Shu Lien kicks everyone's ass", releaseDate:new Date().parse(dateFormat, '2000-12-22')).save(flush:true)
			}
		}
    }
    def destroy = {
    }
}
