case class NodoRaiz(var valor: Int, izq: ArbolBinario, dcha: ArbolBinario) extends ArbolBinario{
    val profundidad = 0

    override def preorden(): List[Any] = {
        List(valor) ::: izq.preorden() ::: dcha.preorden()
    }

    override def postorden(): List[Any] = {
        izq.postorden() ::: dcha.postorden() ::: List(valor)
    }

    override def nodosPostOrden(): List[ArbolBinario] = {
        izq.nodosPostOrden() ::: dcha.nodosPostOrden() ::: List(this)
    }

    override def numHojas(): Int = {
        izq.numHojas() + dcha.numHojas()
    }

    override def numNodosInternos(): Int = {
        izq.numNodosInternos() + dcha.numNodosInternos() + 1
    }

    override def sumarHojas(): Double = {
        izq.sumarHojas() + dcha.sumarHojas()
    }

    override def operacionHojas(op: Double => Double): Unit = {
        izq.operacionHojas(op)
        dcha.operacionHojas(op)
    }

    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = {
        Nodo(0,this,arbol)
    }

    override def toString: String = {
        valor.toString
    }

    def topDown: List[Any] = {
        // dar valores de profundidad a todos los nodos respecto de este nodo raiz
        asignarProfundidad(0)

        val nodos: List[ArbolBinario] = nodosPostOrden()
        var datos = List.empty[Any]
        val max = nodos.map(_.getProfundidad).max

        var i = 0
        while(i <= max){
            nodos.foreach(n => {
                if(n.getProfundidad == i) datos = datos :+ n.getValor
            })

            i = i+1
        }

        datos
    }

    override def asignarProfundidad(prof: Int): Unit = {
        izq.asignarProfundidad(profundidad)
        dcha.asignarProfundidad(profundidad)
    }

    override def getValor: Any = valor
    override def getNodoIzquierda: ArbolBinario = izq
    override def getNodoDerecha: ArbolBinario = dcha
    override def getProfundidad: Int = profundidad
}
