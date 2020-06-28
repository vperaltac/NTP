/**
 * Representa un nodo intermedio en un arbol
 * @param valor dato que almacena el nodo
 * @param izq apunta al hijo izquierdo del nodo
 * @param dcha apunta al hijo derecho del nodo
 */
case class Nodo(var valor: Int, izq: ArbolBinario, dcha: ArbolBinario) extends ArbolBinario{
    var profundidad: Int = 0

    /**
     * Devuelve una lista representando el recorrido en preorden del arbol
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def preorden: List[Any] = {
        List(valor) ::: izq.preorden ::: dcha.preorden
    }

    /**
     * Devuelve una lista representando el recorrido en postorden del arbol
     * @return Lista con los valores del arbol de tipo Any (puede ser Int y/o Double)
     */
    override def postorden: List[Any] = {
        izq.postorden ::: dcha.postorden ::: List(valor)
    }

    /**
     * Devuelve una lista de nodos representando el recorrido en postorden
     * Éste método se utiliza para generar el recorrido TopDown
     * @return Lista con los nodos del arbol de tipo ArbolBinario
     */
    override def nodosPostOrden: List[ArbolBinario] = {
        izq.nodosPostOrden ::: dcha.nodosPostOrden ::: List(this)
    }

    /**
     * Calcula el número de hojas del árbol
     * @return número de hojas
     */
    override def numHojas: Int = {
        izq.numHojas + dcha.numHojas
    }

    /**
     * Calcula el número de nodos internos del árbol
     * @return número de nodos internos
     */
    override def numNodosInternos: Int = {
        izq.numNodosInternos + dcha.numNodosInternos + 1
    }

    /**
     * Calcula la suma de todas las hojas del árbol
     * @return suma de las hojas (Double)
     */
    override def sumarHojas: Double = {
        izq.sumarHojas + dcha.sumarHojas
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
     * Asigna la profundidad del nodo actual
     * Este método siempre debe ser llamado desde un NodoRaiz
     * @param prof profundidad anterior
     */
    override def asignarProfundidad(prof: Int): Unit = {
        profundidad = prof+1

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