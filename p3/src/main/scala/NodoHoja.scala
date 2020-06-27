case class NodoHoja(var valor: Double) extends ArbolBinario {
    override def recorridoAnchura(): Unit = {

    }

    override def recorridoProfundidad(): Unit = {

    }

    override def tamArbol(): Int = 1

    override def sumarHojas(): Double = valor

    override def operacionHojas(op: Double => Double): Unit = {
        valor = op(valor)
    }

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = {
        this
    }
}