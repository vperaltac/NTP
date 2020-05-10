object SeriesRecurrentes {
    //
    /**
     * función general para series recurrentes.
     * Se utilizará la función op para calcular los valores de la serie
     *
     * @param n  Posición de la serie a calcular
     * @param l0 Primer valor de la serie
     * @param l1 Segundo valor de la serie
     * @param op Operación para obtener el valor en la posición n
     * @return
     */
    @scala.annotation.tailrec
    def serie(n:Int, l0:Int, l1:Int, op : (Int,Int) => Int) : Int = {
        if(n == 0) l0
        else serie(n-1, l1,op(l0,l1),op)
    }

    /*
     * Operación suma para Fibonacci y Lucas
     */
    def suma(v1: Int, v2: Int) : Int = {
        v1 + v2
    }

    // utilizada por Pell y Pell-Lucas
    /*
     * 2*Li-1 + Li-2 para Pell y Pell-Lucas
     */
    def operacion1(v1: Int, v2: Int) : Int = {
        v1 + 2*v2
    }

    /**
     * Li-1 + 2*Li-2 para Jabobsthal
     */
    def operacion2(v1: Int, v2: Int) : Int = {
        2*v1 + v2
    }

    def main(args: Array[String]): Unit ={
        println(".......................Series Recurrentes.......................")
        // Serie de Fibonacci
        println("Fibonacci de 8: " + serie(8,0,1,suma))

        // Serie de Lucas
        println("Lucas de 8: " + serie(8,2,1,suma))

        // Serie de Pell
        println("Pell de 8: " + serie(5,2,6,operacion1))

        // Serie de Pell-Lucas
        println("Pell-Lucas de 8: " + serie(8,2,2,operacion1))

        // Serie de Jacobsthal
        println("Jacobsthal de 8: " + serie(5,0,1,operacion2))
    }
}