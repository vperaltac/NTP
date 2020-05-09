import org.scalacheck.Gen
import org.scalatest.FunSuite

class TrianguloPascalTest extends FunSuite {
    test("Valor en extremo debe ser 1 independientemente de la funcion") {
        assert(TrianguloPascal.calcularValorTrianguloPascal(5,5) == 1)
        assert(TrianguloPascal.calcularValorTrianguloPascalv2(5,0) == 1)
    }

    test("El primer valor de una fila cualquiera siempre es 1"){
        assert(TrianguloPascal.calcularValorTrianguloPascal(0,10) == 1)
        assert(TrianguloPascal.calcularValorTrianguloPascalv2(0,10) == 1)
    }

    test("fila 15 columna 5 debe devolver 3003"){
        assert(TrianguloPascal.calcularValorTrianguloPascal(15,5) == 3003)
        assert(TrianguloPascal.calcularValorTrianguloPascalv2(15,5) == 3003)
    }

    test("Si se pide una posición negativa, debería devolver -1"){
        assert(TrianguloPascal.calcularValorTrianguloPascal(0,-1) == -1)
        assert(TrianguloPascal.calcularValorTrianguloPascalv2(0,-1) == -1)
        assert(TrianguloPascal.calcularValorTrianguloPascal(-1,0) == -1)
        assert(TrianguloPascal.calcularValorTrianguloPascalv2(-1,0) == -1)
    }
}