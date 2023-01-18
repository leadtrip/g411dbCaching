package dbcaching

import grails.gorm.services.Service

@Service(CarManufacturer)
abstract class CarManufacturerService implements ICarManufacturerService{

    def findByName( String name ) {
        log.info("================= Dynamic finder CarManufacturer =================")
        Manufacturer.findByName( name )
    }

    def readCarManufacturer( Serializable id ) {
        log.info("================= Read CarManufacturer =================")
        CarManufacturer.read(id)
    }

    def getCarManufacturer( Serializable id ) {
        log.info("================= Get CarManufacturer =================")
        CarManufacturer.get(id)
    }

    def findCarManufacturerByName( String name ) {
        log.info("================= Getting CarManufacturer withCriteria query =================")
        CarManufacturer.withCriteria {
            eq 'name', name
            cache true
        }[0]
    }

    def findCarManufacturersByNameAndAddress( String name, String address ) {
        log.info("================= Finding CarManufacturer createCriteria query =================")
        CarManufacturer.createCriteria().list {
            cache true
            eq 'name', name
            eq 'address', address
            order 'name', 'desc'
        }
    }
}
