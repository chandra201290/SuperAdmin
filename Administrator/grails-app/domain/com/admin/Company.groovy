package com.admin

class Company {

    String companyName
    String companyAddress
    String companyArea
    String companyDescription
    String companyWebsite
    String facebookPage
    String industry
    String info

    static hasMany = [modules: Modules]
    static belongsTo = [companies : Companies]

    static constraints = {
        companyName(nullable: true, blank: false)
        companyAddress(nullable: true, blank: false)
        companyArea(nullable: true, blank: false)
        companyDescription(nullable: true, blank: false)
        companyWebsite(nullable: true, blank: false)
        facebookPage(nullable: true, blank: false)
        industry(nullable: true, blank: false)
        info(nullable: true, blank: false)
    }
}
