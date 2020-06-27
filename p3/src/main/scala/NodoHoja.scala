case class NodoHoja(var valor: Double) extends ArbolBinario {
    var profundidad: Int = 0

    override def preorden(): List[Any] = List(valor)

    override def postorden(): List[Any] = List(valor)

    override def nodosPostOrden(): List[ArbolBinario] = List(this)

    override def numHojas(): Int = 1

    override def numNodosInternos(): Int = 0

    override def sumarHojas(): Double = valor

    override def operacionHojas(op: Double => Double): Unit = {valor = op(valor)}

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = null

    override def asignarProfundidad(prof: Int): Unit = {
        profundidad = prof+1
    }

    override def toString: String = {
        valor.toString
    }

    def getValor: Any = valor

    override def getNodoIzquierda: ArbolBinario = null
    override def getNodoDerecha: ArbolBinario = null
    override def getProfundidad: Int = profundidad
}