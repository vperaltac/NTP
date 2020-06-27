case class NodoHoja(var valor: Double) extends ArbolBinario {
    var profundidad: Int = 0

    /**
     * Devuelve una lista representando el recorrido en preorden del arbol
     * Cómo es un nodo hoja, devuelve una lista con 1 sólo valor
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def preorden(): List[Any] = List(valor)

    /**
     * Devuelve una lista representando el recorrido en postorden del arbol
     * Cómo es un nodo hoja, devuelve una lista con 1 sólo valor
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def postorden(): List[Any] = List(valor)

    /**
     * Devuelve una lista de nodos representando el recorrido en postorden
     * Éste método se utiliza para generar el recorrido TopDown
     * Cómo es un nodo hoja, devuelve una lista con 1 sólo valor
     * @return Lista con los nodos del arbol de tipo ArbolBinario
     */
    override def nodosPostOrden(): List[ArbolBinario] = List(this)

    /**
     * Calcula el número de hojas del árbol
     * @return número de hojas
     */
    override def numHojas(): Int = 1

    /**
     * Calcula el número de nodos internos del árbol
     * @return número de nodos internos
     */
    override def numNodosInternos(): Int = 0

    /**
     * Calcula la suma de todas las hojas del árbol
     * @return suma de las hojas (Double)
     */
    override def sumarHojas(): Double = valor

    /**
     * Permite aplicar una función cualquiera a todas las hojas del arbol
     * @param op Función a aplicar
     */
    override def operacionHojas(op: Double => Double): Unit = {valor = op(valor)}

    /**
     * Fusiona dos árboles binarios
     * @param arbol Arbol a fusionar
     * @return Arbol fusionado
     */
    override def mergeArboles(arbol: ArbolBinario): ArbolBinario = null

    /**
     * Asigna la profundidad del nodo actual
     * Este método siempre debe ser llamado desde un NodoRaiz
     * @param prof profundidad anterior
     */
    override def asignarProfundidad(prof: Int): Unit = {
        profundidad = prof+1
    }

    // getters utilizados para acceso de variables de padres a hijos
    override def getValor: Any = valor
    override def getNodoIzquierda: ArbolBinario = null
    override def getNodoDerecha: ArbolBinario = null
    override def getProfundidad: Int = profundidad

    override def toString: String = {
        valor.toString
    }
}