package dbcaching.car


import grails.gorm.services.Service

@Service(Car)
abstract class CarService implements ICarService{

    def findByEngine(Engine engine ) {
        log.info("================= Getting car with dynamic finder =================")
        Car.findByEngine( engine )
    }

    def readCar( Serializable id ) {
        log.info("================= Read car =================")
        Car.read(id)
    }

    def getCar( Serializable id ) {
        log.info("================= Get car =================")
        Car.get(id)
    }

    def loadCar( Serializable id ) {
        log.info("================= Load car =================")
        Car.load(id)
    }

    def findCarByName( String name ) {
        log.info("================= Getting car withCriteria query =================")
        Car.withCriteria {
            eq('name', name)
            cache true
        }[0]
    }

    def findCarsByEngineBhpAndName( String name, Integer bhp ) {
        log.info("================= Finding cars createCriteria query =================")
        Car.createCriteria().list {
            cache true
            engine {
                eq 'bhp', bhp
            }
            eq 'name', name
            order 'name', 'desc'
        }
    }

}