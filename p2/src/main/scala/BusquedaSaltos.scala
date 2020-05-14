object BusquedaSaltos {
    /**
     * Búsqueda a saltos
     * Buscará el valor en bloques de tamaño sqrt(tam coleccion)
     * Una vez encontrado el bloque donde supuestamente se encuentra el valor (puede no estar)
     * realiza una búsqueda lineal sobre ese bloque
     */
    def BS[A](coleccion: Array[A], aBuscar: A, criterio : (A,A) => Boolean) : Int ={
        val tam_bloque = Math.sqrt(coleccion.length).toInt

        @scala.annotation.tailrec
        def buscar(pos: Int): Int ={
            if(pos == coleccion.length-1) // si hemos llegado al final, la única posibilidad es el último bloque
                busqueda_lineal(coleccion,aBuscar)
            else if(coleccion(pos) == aBuscar)
                pos
            else if(criterio(coleccion(pos),aBuscar))
                buscar(pos+tam_bloque)
            else // si el valor en pos es mayor que el buscado, el buscado se encuentra en el bloque actual
                busqueda_lineal(coleccion,aBuscar)
        }

        buscar(tam_bloque-1)
    }

    def busqueda_lineal[A](coleccion: Array[A], aBuscar: A): Int ={
        coleccion.indexOf(aBuscar)
    }

    def main(args: Array[String]): Unit ={
        println("....................... Búsqueda binaria .......................")
        println("Deberia devolver posición 0: " + BS[Int](Array(1,2,3),1,_ < _))
        println("Debería devolver posición 2: " + BS[Int](Array(1,2,3),3,_ < _))
        println("Debería devolver -1 (no se encuentra): " + BS[Int](Array(1,2,3),4,_ < _))
    }
}
