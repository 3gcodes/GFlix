package com.gflix

import grails.test.*

class MovieTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(Movie)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testNullables() {
		def movieInstance = new Movie()
		
		assertFalse 'validation should fail because not-nullable properties are null', movieInstance.validate()
		assertEquals 'title is required', 'nullable', movieInstance.errors.title
		assertEquals 'releaseDate is required', 'nullable', movieInstance.errors.releaseDate

    }
}
