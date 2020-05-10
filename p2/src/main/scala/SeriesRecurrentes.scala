object SeriesRecurrentes {
    // función general para series recurrentes
    @scala.annotation.tailrec
    def serie(n:Int, l0:Int, l1:Int, op : (Int,Int) => Int) : Int = {
        if(n == 0) l0
        else serie(n-1, l1,op(l0,l1),op)
    }

    // Fibonacci y Lucas utilizan suma
    def suma(v1: Int, v2: Int) : Int = {
        v1 + v2
    }

    // utilizada por Pell y Pell-Lucas
    def operacion1(v1: Int, v2: Int) : Int = {
        2*v1 + v2
    }

    // utilizada por Jacobsthal
    def operacion2(v1: Int, v2: Int) : Int = {
        v1 + 2*v2
    }

    def main(args: Array[String]): Unit ={
        println(".......................Series Recurrentes.......................")
        // Serie de Fibonacci
        println("Fibonacci de 8: " + serie(8,0,1,suma))

        // Serie de Lucas
        println("Lucas de 8: " + serie(8,2,1,suma))

        // Serie de Pell
        println("Pell de 8: " + serie(8,2,6,operacion1))

        // Serie de Pell-Lucas
        println("Pell-Lucas de 8: " + serie(8,2,2,operacion1))

        // Serie de Jacobsthal
        println("Jacobsthal de 8: " + serie(8,0,1,operacion2))
    }
}