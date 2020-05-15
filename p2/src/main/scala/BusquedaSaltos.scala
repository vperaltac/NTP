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
            if(pos == coleccion.length-1 || pos > coleccion.length-1) // si hemos llegado al final, la única posibilidad es el último bloque
                busqueda_lineal(coleccion.slice(pos-(tam_bloque+1),coleccion.length),aBuscar,pos-(tam_bloque+1))
            else if(coleccion(pos) == aBuscar)
                pos
            else if(criterio(coleccion(pos),aBuscar))
                buscar(pos+tam_bloque)
            else // si el valor en pos es mayor que el buscado, el buscado se encuentra en el bloque actual
                busqueda_lineal(coleccion.slice(pos-(tam_bloque+1),pos+1),aBuscar,pos-(tam_bloque+1))
        }

        buscar(tam_bloque-1)
    }

    /**
     * Búsqueda lineal de un valor en un Array
     * necesita recibir la posicion inicial de la colección para devolver la posición del array original
     */
    def busqueda_lineal[A](coleccion: Array[A], aBuscar: A, posInicial: Int): Int ={
        val pos = coleccion.indexOf(aBuscar)
        if(pos == -1)
            pos
        else
            pos + posInicial
    }

    def main(args: Array[String]): Unit ={
        println("....................... Búsqueda binaria .......................")
        println(BusquedaSaltos.BS[Int](Array(1,2,3,4,6,16,41,100,200),100,_ < _))
    }
}
