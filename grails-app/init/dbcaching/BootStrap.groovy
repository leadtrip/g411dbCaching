package dbcaching

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addCars()
    }

    @Transactional
    void addCars() {
        new CarManufacturer(name: 'Mercedes', address: 'Spooner street').save()

        def engine = new Engine(name: 'MERCENG1', bhp: 200)
        engine.addToSparkPlugs(new SparkPlug(name: 'SP1'))
        engine.addToSparkPlugs(new SparkPlug(name: 'SP2'))
        engine.addToSparkPlugs(new SparkPlug(name: 'SP3'))
        engine.addToSparkPlugs(new SparkPlug(name: 'SP4'))
        def merc = new Car(name: 'Mercedes c250', engine: engine)
        merc.addToWheels(new Wheel(name: 'FL', diameter: 18))
        merc.addToWheels(new Wheel(name: 'FR', diameter: 18))
        merc.addToWheels(new Wheel(name: 'RL', diameter: 18))
        merc.addToWheels(new Wheel(name: 'RR', diameter: 18))
        merc.save(failOnError: true, flush: true)
    }

    def destroy = {
    }
}
