package dbcaching

class Car {

    String name
    Engine engine

    static hasMany = [wheels: Wheel]

    static mapping = {
        cache true
        wheels cache: true
    }
}
