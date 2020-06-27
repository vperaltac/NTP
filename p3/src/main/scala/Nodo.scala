case class Nodo(var valor: Int, izq: ArbolBinario, dcha: ArbolBinario) extends ArbolBinario{
    override def preorden(): List[Any] = {
        List(valor) ::: izq.preorden() ::: dcha.preorden()
    }

    override def postorden(): List[Any] = {
        izq.postorden() ::: dcha.postorden() ::: List(valor)
    }

    override def tamArbol(): Int = {
        izq.tamArbol() + dcha.tamArbol() + 1
    }

    override def sumarHojas(): Double = {
        izq.sumarHojas() + dcha.sumarHojas()
    }

    override def operacionHojas(op: Double => Double): Unit = {
        izq.operacionHojas(op)
        dcha.operacionHojas(op)
    }

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = {
        this
    }
}