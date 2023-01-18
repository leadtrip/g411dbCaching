package dbcaching

class Wheel {

    String name
    Integer diameter

    static mapping = {
        cache true
    }

    @Override
    String toString() {
        "$name - diameter:$diameter"
    }
}
