package dbcaching

import dbcaching.car.Car
import dbcaching.car.CarManufacturer
import dbcaching.car.Engine
import dbcaching.car.SparkPlug
import dbcaching.car.Wheel
import dbcaching.sale.BaseSaleTranslation
import dbcaching.sale.HotelSale
import dbcaching.sale.Territory
import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addCars()
        addSales()
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

    @Transactional
    void addSales() {
        def territory = new Territory(name: 'terr1')

        def baseSaleTranslation1 = new BaseSaleTranslation( title: 'bs1', url: 'bs1url' )
        def baseSaleTranslation2 = new BaseSaleTranslation( title: 'bs2', url: 'bs2url' )

        def hotelSale1 = new HotelSale(start: new Date(), end: new Date())
        hotelSale1.territory = territory
        hotelSale1.addToTranslations(baseSaleTranslation1)
        hotelSale1.addToTranslations(baseSaleTranslation2)
        hotelSale1.save(failOnError: true)

        def hotelSale2 = new HotelSale(start: new Date(), end: new Date())
        hotelSale2.territory = territory
        hotelSale1.addToTranslations(baseSaleTranslation1)
        hotelSale2.save(failOnError: true)
    }

    def destroy = {
    }
}
