package dbcaching

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CarManufacturerController {

    CarManufacturerService carManufacturerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def testCaching() {
        log.info("================= Getting CarManufacturer with data service =================")
        def merc = carManufacturerService.get(1)
        [dataServiceResult: merc,
         getCarManufacturerResult: carManufacturerService.getCarManufacturer(1),
         readCarManufacturerResult: carManufacturerService.readCarManufacturer(1),
         dynamicFinderResult: carManufacturerService.findByName(merc.name),
         criteriaResult: carManufacturerService.findCarManufacturerByName(merc.name),
         criteriaListResult: carManufacturerService.findCarManufacturersByNameAndAddress(merc.name, merc.address)
        ]
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carManufacturerService.list(params), model:[carManufacturerCount: carManufacturerService.count()]
    }

    def show(Long id) {
        respond carManufacturerService.get(id)
    }

    def create() {
        respond new CarManufacturer(params)
    }

    def save(CarManufacturer carManufacturer) {
        if (carManufacturer == null) {
            notFound()
            return
        }

        try {
            carManufacturerService.save(carManufacturer)
        } catch (ValidationException e) {
            respond carManufacturer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carManufacturer.label', default: 'CarManufacturer'), carManufacturer.id])
                redirect carManufacturer
            }
            '*' { respond carManufacturer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carManufacturerService.get(id)
    }

    def update(CarManufacturer carManufacturer) {
        if (carManufacturer == null) {
            notFound()
            return
        }

        try {
            carManufacturerService.save(carManufacturer)
        } catch (ValidationException e) {
            respond carManufacturer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carManufacturer.label', default: 'CarManufacturer'), carManufacturer.id])
                redirect carManufacturer
            }
            '*'{ respond carManufacturer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carManufacturerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carManufacturer.label', default: 'CarManufacturer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carManufacturer.label', default: 'CarManufacturer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
