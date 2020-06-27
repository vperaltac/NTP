case class NodoRaiz(var valor: Int, izq: ArbolBinario, dcha: ArbolBinario) extends ArbolBinario{
    val profundidad = 0

    /**
     * Devuelve una lista representando el recorrido en preorden del arbol
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def preorden(): List[Any] = {
        List(valor) ::: izq.preorden() ::: dcha.preorden()
    }

    /**
     * Devuelve una lista representando el recorrido en postorden del arbol
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def postorden(): List[Any] = {
        izq.postorden() ::: dcha.postorden() ::: List(valor)
    }

    /**
     * Devuelve una lista de nodos representando el recorrido en postorden
     * Éste método se utiliza para generar el recorrido TopDown
     * @return Lista con los nodos del arbol de tipo ArbolBinario
     */
    override def nodosPostOrden(): List[ArbolBinario] = {
        izq.nodosPostOrden() ::: dcha.nodosPostOrden() ::: List(this)
    }

    /**
     * Calcula el número de hojas del árbol
     * @return número de hojas
     */
    override def numHojas(): Int = {
        izq.numHojas() + dcha.numHojas()
    }

    /**
     * Calcula el número de nodos internos del árbol
     * @return número de nodos internos
     */
    override def numNodosInternos(): Int = {
        izq.numNodosInternos() + dcha.numNodosInternos() + 1
    }

    /**
     * Calcula la suma de todas las hojas del árbol
     * @return suma de las hojas (Double)
     */
    override def sumarHojas(): Double = {
        izq.sumarHojas() + dcha.sumarHojas()
    }

    /**
     * Permite aplicar una función cualquiera a todas las hojas del arbol
     * @param op Función a aplicar
     */
    override def operacionHojas(op: Double => Double): Unit = {
        izq.operacionHojas(op)
        dcha.operacionHojas(op)
    }

    /**
     * Fusiona dos árboles binarios
     * @param arbol Arbol a fusionar
     * @return Arbol fusionado
     */
    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = {
        Nodo(0,this,arbol)
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

    /**
     * Asigna la profundidad del nodo actual
     * Este método siempre debe ser llamado desde un NodoRaiz
     * @param prof profundidad anterior
     */
    override def asignarProfundidad(prof: Int): Unit = {
        izq.asignarProfundidad(profundidad)
        dcha.asignarProfundidad(profundidad)
    }

    // getters utilizados para acceso de variables de padres a hijos
    override def getValor: Any = valor
    override def getNodoIzquierda: ArbolBinario = izq
    override def getNodoDerecha: ArbolBinario = dcha
    override def getProfundidad: Int = profundidad

    override def toString: String = {
        valor.toString
    }
}
