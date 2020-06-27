case object NodoVacio extends ArbolBinario {
    override def add(valor: Either[Int, Double]): ArbolBinario = ???

    override def buscar(valor: Either[Int, Double]): Boolean = ???

    override def eliminar(valor: Either[Int, Double]): ArbolBinario = ???

    override def recorridoAnchura(): List[Any] = ???

    override def recorridoProfundidad(): List[Any] = ???

    override def operacionHojas(): Unit = ???

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = ???
}