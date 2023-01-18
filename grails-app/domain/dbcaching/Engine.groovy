package dbcaching

class Engine {

    String name
    Integer bhp

    static hasMany = [sparkPlugs: SparkPlug]

    static mapping = {
        cache true
    }

    @Override
    String toString() {
        "$name - bhp:$bhp - spark plugs($sparkPlugs)"
    }
}
