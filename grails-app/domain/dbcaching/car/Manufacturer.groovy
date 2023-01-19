package dbcaching.car

import dbcaching.Trackable

abstract class Manufacturer implements Trackable{
    String name

    static mapping = {
        cache true
    }
}
