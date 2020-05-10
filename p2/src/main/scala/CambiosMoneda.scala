object CambiosMoneda {
    /**
     * genera una lista de listas de cambios posibles para la cantidad dada
     */
    def listarCambiosPosibles(cantidad: Int, monedas: List[Int]): List[List[Int]] ={
        var cambios = List[List[Int]]()

        // genera las diferentes posibilidades para la cantidad y monedas dadas
        def cambiosPosibles(cantidad: Int, monedas: List[Int], cambio: List[Int]): Int ={
            // cambio exacto encontrado
            if(cantidad == 0){
                cambios = cambio::cambios
                1
            }
            // nos quedamos sin monedas o nos hemos pasado de la cantidad
            else if(cantidad < 0 || (monedas.isEmpty && cantidad > 0))
                0
            else{
                cambiosPosibles(cantidad, monedas.tail, cambio)
                + cambiosPosibles(cantidad - monedas.head, monedas, monedas.head::cambio)
            }
        }

        cambiosPosibles(cantidad, monedas,Nil)
        cambios
    }

    def main(args: Array[String]) : Unit ={
        println("....................... Contador de posibles cambios moneda .......................")
        println(listarCambiosPosibles(4,List(1,2)))
        println(listarCambiosPosibles(5,List(1,2)))

    }
}
