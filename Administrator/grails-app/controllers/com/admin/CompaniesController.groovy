package com.admin

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured('permitAll')
class CompaniesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Companies.list(params), model:[companiesCount: Companies.count()]
    }

    def show(Companies companies) {
        respond companies
    }

    def create() {
        respond new Companies(params)
    }

    @Transactional
    def save(Companies companies) {
        if (companies == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (companies.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond companies.errors, view:'create'
            return
        }

        companies.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companies.label', default: 'Companies'), companies.id])
                redirect companies
            }
            '*' { respond companies, [status: CREATED] }
        }
    }

    def edit(Companies companies) {
        respond companies
    }

    @Transactional
    def update(Companies companies) {
        if (companies == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (companies.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond companies.errors, view:'edit'
            return
        }

        companies.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'companies.label', default: 'Companies'), companies.id])
                redirect companies
            }
            '*'{ respond companies, [status: OK] }
        }
    }

    @Transactional
    def delete(Companies companies) {

        if (companies == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        companies.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'companies.label', default: 'Companies'), companies.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companies.label', default: 'Companies'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
