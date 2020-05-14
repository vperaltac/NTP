import org.scalatest.FunSuite

// Ya que tanto BusquedaSaltos cómo BusquedaBinaria realizan la misma acción y tienen la misma interfaz
// podemos aprovechar los tests desarrollados para busqueda binaria
// y deberían pasar sin modificar nada
class BusquedaSaltosTest extends FunSuite {
    test("Debería devolver -1 si el array está vacío"){
        assert(BusquedaSaltos.BS[Int](Array(),1,_ < _) == Array().toList.indexOf(1))
    }

    test("Debería devolver posición 0"){
        assert(BusquedaSaltos.BS[Int](Array(1,2,3),1,_ < _) == Array(1,2,3).toList.indexOf(1))
    }

    test("Debería devolver posición 2"){
        assert(BusquedaSaltos.BS[Int](Array(1,2,3),3,_ < _) == Array(1,2,3).toList.indexOf(3))
    }

    test("Debería devolver -1 si no encuentra el valor"){
        assert(BusquedaSaltos.BS[Int](Array(1,2,3),4,_ < _) == Array(1,2,3).toList.indexOf(4))
    }
}