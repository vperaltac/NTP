object Main extends App{
    val A = NodoHoja(10)
    val B = NodoHoja(5)
    val C = NodoHoja(4)
    val D = NodoHoja(3)

    val AB = Nodo(7,A,B)
    val CD = Nodo(6,C,D)
    val root = Nodo(12,AB,CD)

    println(root.sumarHojas())

    def mult2(x: Double) = {
        x*2
    }

    //root.operacionHojas(mult2)
    //println(root.sumarHojas())
    //println(root.tamArbol())

    println(root.preorden())
    println(root.postorden())
}
