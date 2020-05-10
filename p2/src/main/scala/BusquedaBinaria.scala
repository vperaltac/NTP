object BusquedaBinaria {
    /**
     * Búsqueda binaria en un array
     * esta función está parametrizada
     * por tanto, se puede utilizar para buscar sobre arrays de múltiples tipos de datos
     */
    def BB[A](coleccion: Array[A], aBuscar: A, criterio : (A,A) => Boolean) : Int ={
        @scala.annotation.tailrec
        def buscar(inicio: Int, fin: Int): Int ={
            val mid = inicio + (fin-inicio)/2
            if(inicio > fin)
                -1
            else if(coleccion(mid) == aBuscar)
                mid
            else if(criterio(coleccion(mid),aBuscar)) // aBuscar > coleccion(mid)
                buscar(mid+1,fin)
              else // aBuscar < coleccion(mid)
              buscar(inicio, mid-1)
        }

        buscar(0,coleccion.length-1)
    }

    def main(args: Array[String]): Unit ={
        println("....................... Búsqueda binaria .......................")
        println("Deberia devolver posición 0: " + BB[Int](Array(1,2,3),1,_ < _))
        println("Debería devolver posición 2: " + BB[Int](Array(1,2,3),3,_ < _))
        println("Debería devolver -1 (no se encuentra): " + BB[Int](Array(1,2,3),4,_ < _))
    }
}
