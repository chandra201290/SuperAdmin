package com.admin

class Companies {
    String companyName
    String companyLogo

    static hasOne = [company: Company]

    static constraints = {
        companyName(nullable: true, blank: false)
        companyLogo(nullable: true, blank: false)
    }
}
