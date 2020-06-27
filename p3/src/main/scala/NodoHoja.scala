case class NodoHoja(var valor: Double) extends ArbolBinario {
    override def preorden(): List[Any] = List(valor)

    override def postorden(): List[Any] = List(valor)

    override def numHojas(): Int = 1

    override def numNodosInternos(): Int = 0

    override def sumarHojas(): Double = valor

    override def operacionHojas(op: Double => Double): Unit = {
        valor = op(valor)
    }

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = {
        this
    }
}