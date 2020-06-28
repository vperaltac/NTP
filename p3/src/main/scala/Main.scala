object Main extends App{
    // Profundidad 3
    val g: NodoHoja = NodoHoja(43)
    val h: NodoHoja = NodoHoja(54)
    val i: NodoHoja = NodoHoja(65)
    val j: NodoHoja = NodoHoja(73.4)

    // Profundidad 2
    val c: Nodo = Nodo(10,g,h)
    val d: NodoHoja = NodoHoja(5)
    val e: NodoHoja = NodoHoja(4)
    val f: Nodo = Nodo(3,i,j)

    // Profundidad 1
    val a: Nodo = Nodo(7,c,d)
    val b: Nodo = Nodo(6,e,f)

    // Profundidad 0
    val root: NodoRaiz = NodoRaiz(12,a,b)

    // Segundo arbol para combinar con arbol anterior
    val cc: NodoHoja = NodoHoja(103)
    val bb: NodoHoja = NodoHoja(204)
    val aa: NodoRaiz = NodoRaiz(1,bb,cc)

    println("Número de hojas: " + root.numHojas)
    println("Número de nodos internos: " + root.numNodosInternos)
    println("Recorrido preorden: " + root.preorden)
    println("Recorrido postorden: " + root.postorden)
    println("Recorrido topdown: " + root.topDown)

    val nuevo_arbol = root.mergeArboles(aa)
    println("Recorrido preorden de arboles combinados: " + nuevo_arbol.preorden)

    println("Suma de hojas: " + root.sumarHojas)
    root.operacionHojas(x => x*2)
    println("Suma de hojas tras multiplicar por 2: " + root.sumarHojas)

}