import org.scalatest.FunSuite

class SeriesRecurrentesTest extends FunSuite{
    test("Fibonacci debe devolver correctamente los números iniciales y 1 valor calculado") {
        assert(SeriesRecurrentes.serie(0,0,1,SeriesRecurrentes.suma) == 0)
        assert(SeriesRecurrentes.serie(1,0,1,SeriesRecurrentes.suma) == 1)
        assert(SeriesRecurrentes.serie(8,0,1,SeriesRecurrentes.suma) == 21)
    }

    test("Lucas debe devolver correctamente los números iniciales y 1 valor calculado") {
        assert(SeriesRecurrentes.serie(0,2,1,SeriesRecurrentes.suma) == 2)
        assert(SeriesRecurrentes.serie(1,2,1,SeriesRecurrentes.suma) == 1)
        assert(SeriesRecurrentes.serie(8,2,1,SeriesRecurrentes.suma) == 47)
    }

    test("Pell debe devolver correctamente los números iniciales y 1 valor calculado") {
        assert(SeriesRecurrentes.serie(0,2,6,SeriesRecurrentes.operacion1) == 2)
        assert(SeriesRecurrentes.serie(1,2,6,SeriesRecurrentes.operacion1) == 6)
        assert(SeriesRecurrentes.serie(4,2,6,SeriesRecurrentes.operacion1) == 82)
    }

    test("Pell-Lucas debe devolver correctamente los números iniciales y 1 valor calculado") {
        assert(SeriesRecurrentes.serie(0,2,2,SeriesRecurrentes.operacion1) == 2)
        assert(SeriesRecurrentes.serie(1,2,2,SeriesRecurrentes.operacion1) == 2)
        assert(SeriesRecurrentes.serie(4,2,2,SeriesRecurrentes.operacion1) == 34)
    }

    test("Jacobsthal debe devolver correctamente los números iniciales y 1 valor calculado") {
        assert(SeriesRecurrentes.serie(0,0,1,SeriesRecurrentes.operacion2) == 0)
        assert(SeriesRecurrentes.serie(1,0,1,SeriesRecurrentes.operacion2) == 1)
        assert(SeriesRecurrentes.serie(9,0,1,SeriesRecurrentes.operacion2) == 171)
    }
}