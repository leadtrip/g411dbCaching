package dbcaching

abstract class Manufacturer {
    String name

    static mapping = {
        cache true
    }
}
