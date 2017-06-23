package com.admin

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	String username
	String password
	String contact
	String industry
	String email
	String company
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Role> getAuthorities() {
		(UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
	}

	static constraints = {
		industry(nullable: true, blank: false)
		username(nullable: true, blank: false)
		password(nullable: true, blank: false)
		contact(nullable: true, blank: false)
		email(nullable: true, blank: false)
		company(nullable: true, blank: false)
	}

	static mapping = {
		password column: '`password`'
	}
}
