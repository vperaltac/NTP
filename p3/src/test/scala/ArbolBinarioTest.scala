import org.scalatest.FunSuite

class ArbolBinarioTest extends FunSuite{
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

    test("cada nodo debe tener un id único"){
        val nodos = List(root,a,b,c,d,e,f,g,h,i,j).map(_.id)
        assert(nodos.distinct.size == nodos.size)
    }

    test("debe poder calcular el número de hojas"){
        assert(root.numHojas == 6);
    }

    test("debe poder calcular el número de nodos internos"){
        assert(root.numNodosInternos == 5)
    }

    test("debe poder sumar todas los valores en las hojas del arbol"){
        assert(root.sumarHojas == 244.4)
    }

    test("se debe poder realizar un recorrido en preorden"){
        assert(root.preorden == List(root,a,c,g,h,d,b,e,f,i,j).map(_.getValor))
    }

    test("se debe poder realizar un recorrido en postorden"){
        assert(root.postorden == List(g,h,c,d,a,e,i,j,f,b,root).map(_.getValor))
    }

    test("se debe poder realizar un recorrido en TopDown"){
        assert(root.topDown == List(root,a,b,c,d,e,f,g,h,i,j).map(_.getValor))
    }

    test("se debe poder realizar una operación sobre las hojas de un arbol"){
        root.operacionHojas(x => x*2)
        assert(root.sumarHojas == 244.4*2)
    }
}
