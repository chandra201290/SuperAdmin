package com.admin

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured('permitAll')
class ModulesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Modules.list(params), model:[modulesCount: Modules.count()]
    }

    def show(Modules modules) {
        respond modules
    }

    def create() {
        respond new Modules(params)
    }

    @Transactional
    def save(Modules modules) {
        if (modules == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modules.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modules.errors, view:'create'
            return
        }

        modules.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'modules.label', default: 'Modules'), modules.id])
                redirect modules
            }
            '*' { respond modules, [status: CREATED] }
        }
    }

    def edit(Modules modules) {
        respond modules
    }

    @Transactional
    def update(Modules modules) {
        if (modules == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modules.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modules.errors, view:'edit'
            return
        }

        modules.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'modules.label', default: 'Modules'), modules.id])
                redirect modules
            }
            '*'{ respond modules, [status: OK] }
        }
    }

    @Transactional
    def delete(Modules modules) {

        if (modules == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        modules.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'modules.label', default: 'Modules'), modules.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modules.label', default: 'Modules'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
