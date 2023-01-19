package dbcaching.car

interface ICarManufacturerService {

    CarManufacturer get(Serializable id)

    List<CarManufacturer> list(Map args)

    Long count()

    void delete(Serializable id)

    CarManufacturer save(CarManufacturer carManufacturer)

}