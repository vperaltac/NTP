object TrianguloPascal{
    /**
     * Primera versión de calcularValorTrianguloPascal
     * Esta función es recursiva, pero no es tail-recursive
     * Siempre que se tenga suficiente stack, el cálculo se realiza bastante rápido
     */
    def calcularValorTrianguloPascal(fil: Int, col: Int): Int ={
        if(fil < 0 || col < 0)
            -1
        else if(fil == 0 || fil == col || col == 0)
            1
        else
            calcularValorTrianguloPascal(fil-1,col-1) + calcularValorTrianguloPascal(fil-1,col)
    }


    /**
     * Segunda versión de calcularValorTrianguloPascal
     * Esta función utiliza una función auxiliar para calcular el factorial
     * ( f ) =    f!
     *        ----------
     * ( c )   c!(f-c)!
     *
     * Esta función se salta la restricción de stack de la anterior
     * sin embargo, para números grandes no es eficiente
     */
    def calcularValorTrianguloPascalv2(fil: Long, col: Long): Long ={
        if(fil < 0 || col < 0)
            -1
        else if(fil == 0 || fil == col || col == 0)
            1
        else
            factorial(fil)/(factorial(col)*factorial(fil-col))
    }

    /**
     * Cáculo del factorial de un número
     * IMPORTANTE: el máximo valor posible de Int no es suficiente para calcular factoriales de números
     * mayores de 12~. Es imperativo utilizar el tipo Long.
     *
     * Esta función aprovecha tail recursion para maximizar la eficiencia
     */
    def factorial(x : Long) : Long = {
        @annotation.tailrec
        def iterar(x: Long, acum : Long) : Long = {
            if(x == 0 || x == 1) acum
            else iterar(x-1,x*acum)
        }
        iterar(x,1)
    }

    /**
     * Metodo main: en realidad no es necesario porque el desarrollo
     * debería guiarse por los tests
     */
    def main(args: Array[String]): Unit ={
        println(".......................Triangulo de Pascal.......................")

        // Se muestran 10 filas del triángulo de Pascal
        for(row <- 0 to 10){
            // Se muestran 10 y 10 filas
            for(col <- 0 to row)
                print(calcularValorTrianguloPascalv2(row,col) + " ")

            // Salto de linea final para mejorar la presentación
            println()
        }

        // Se muestra el valor que debe ocupar la columna 5 en la fila 15
        print(calcularValorTrianguloPascalv2(15,5))
    }
}
