object SeriesRecurrentes {
    @scala.annotation.tailrec
    def fibonacci(n:Int, l0:Int, l1:Int) : Int = {
        if(n == 0) l0
        else fibonacci(n-1, l1, l0+l1)
    }

    // NOTE: alternativa muy valida para ahorrar duplicado de codigo
    // ATENCION!!! TENER EN CUENTA
    // IMPORTANTE!!
    // REPASAR!
    @scala.annotation.tailrec
    def fibb(n:Int, l0:Int, l1:Int, op : (Int,Int) => Int) : Int = {
        if(n == 0) l0
        else fibb(n-1, l1,op(l0,l1),op)
    }


    def suma(v1: Int, v2: Int) : Int = {
        v1 + v2
    }

    @scala.annotation.tailrec
    def lucas(n:Int, l0:Int, l1:Int) : Int = {
        if(n == 0) l0
        else lucas(n-1, l1, l0+l1)
    }

    @scala.annotation.tailrec
    def pell(n:Int, l0:Int, l1:Int) : Int = {
        if(n == 0) l0
        else pell(n-1, l1,(2*l0)+l1)
    }

    @scala.annotation.tailrec
    def jacobsthal(n:Int, l0:Int, l1:Int) : Int = {
        if(n == 0) l0
        else jacobsthal(n-1, l1,l0+(2*l1))
    }


    def serie(l0: Int, l1: Int, n: Int, operacion : (Int,Int,Int) => Int): Int ={
        operacion(n,l0,l1)
    }

    def main(args: Array[String]): Unit ={
        println(".......................Series Recurrentes.......................")
        // Serie de Fibonacci
        println("Fibonacci de 8: " + serie(0,1,8,fibonacci))

        // Serie de Lucas
        println("Lucas de 8: " + serie(2,1,8,lucas))

        // Serie de Pell
        println("Pell de 8: " + serie(2,6,8,pell))

        // Serie de Pell-Lucas
        println("Pell-Lucas de 8: " + serie(2,2,8,pell))

        // Serie de Jacobsthal
        println("Jacobsthal de 8: " + serie(0,1,8,jacobsthal))

        // TEST FIBB
        println(fibb(8,0,1,suma))
    }
}