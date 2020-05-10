import org.scalatest.FunSuite

class CambiosMonedaTest extends FunSuite{
    test("Si la cantidad es 0 debería devolver una lista vacía"){
        assert(CambiosMoneda.listarCambiosPosibles(0,List(1,2)).head.isEmpty)
    }

    test("Si la cantidad es menor que las monedas disponibles debería devolver una lista vacía"){
        assert(CambiosMoneda.listarCambiosPosibles(1,List(2,4)).isEmpty)
    }

    test("Debería devolver los valores correctos dada una cantidad y monedas viables"){
        val res = CambiosMoneda.listarCambiosPosibles(4,List(1,2))
        val lista = List(List(1,1,1,1),List(2,1,1),List(2,2))
        assert(res == lista)
    }

    test("Debería devolver los valores correctos sin importar el orden de la lista"){
        val res = CambiosMoneda.listarCambiosPosibles(4,List(2,1))
        val lista = List(List(1,1,1,1),List(2,1,1),List(2,2))

        var cont = false
        res.foreach(r => if(!lista.contains(r)) cont = true )
        assert(cont)
    }

}
