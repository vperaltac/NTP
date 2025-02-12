import BusquedaBinaria.BB
import org.scalatest.FunSuite

class BusquedaBinariaTest extends FunSuite{
    test("Debería devolver -1 si el array está vacío"){
        assert(BB[Int](Array(),1,_ < _) == Array().toList.indexOf(1))
    }

    test("Debería devolver posición 0"){
        assert(BB[Int](Array(1,2,3),1,_ < _) == Array(1,2,3).toList.indexOf(1))
    }

    test("Debería devolver posición 2"){
        assert(BB[Int](Array(1,2,3),3,_ < _) == Array(1,2,3).toList.indexOf(3))
    }

    test("Debería devolver -1 si no encuentra el valor"){
        assert(BB[Int](Array(1,2,3),4,_ < _) == Array(1,2,3).toList.indexOf(4))
    }

    test("Debería funcionar con tamaños diferentes"){
        assert(BB[Int](Array(1,2,3,4,6),4,_ < _) == Array(1,2,3,4,6).toList.indexOf(4))
        assert(BB[Int](Array(1,2,3,4,6,10,12),10,_ < _) == Array(1,2,3,4,6,10,12).toList.indexOf(10))
        assert(BB[Int](Array(1,2,3,4,6,16,41,100,200,345),100,_ < _) == Array(1,2,3,4,6,16,41,100,200,345).toList.indexOf(100))
    }

    test("Debería funcionar con arrays de tipo String"){
        assert(BB[String](Array("amor","barco","casa","dedo"),"dedo",_ < _) == 3)
    }
}
