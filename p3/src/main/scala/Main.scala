object Main extends App{
    val n = NodoHoja(43)
    val m = NodoHoja(54)
    val A = Nodo(10,n,m)

    val B = NodoHoja(5)
    val C = NodoHoja(4)

    val j = NodoHoja(65)
    val k = NodoHoja(73.4)
    val D = Nodo(3,j,k)

    val AB = Nodo(7,A,B)
    val CD = Nodo(6,C,D)
    val root = NodoRaiz(12,AB,CD)

    val E = NodoHoja(20)
    val F = NodoHoja(21)
    val G = NodoHoja(22)
    val H = NodoHoja(23)

    val EF = Nodo(24,E,F)
    val GH = Nodo(25,G,H)
    val root2 = NodoRaiz(26,EF,GH)

    println(root.sumarHojas())

    def mult2(x: Double) = {
        x*2
    }

    //root.operacionHojas(mult2)
    //println(root.sumarHojas())
    //println(root.tamArbol())

    println("Recorrido preorden: " + root.preorden())
    println("Recorrido postorden: " + root.postorden())
    println("Número de hojas: " + root.numHojas())
    println("Número de nodos internos: " + root.numNodosInternos())

    val nuevo = root.mergeArboles(root2)
    println("preorden arboles combinados: " + nuevo.preorden())
    println(root.topDown)
}