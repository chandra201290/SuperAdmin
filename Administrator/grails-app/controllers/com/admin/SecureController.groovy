package com.admin

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class SecureController {

    def index() {
        def companyObj = Company.list()
        render (view: 'mainPage', model: [companyName: companyObj])
    }
    def comp() {
        render view: 'company'
    }
}
