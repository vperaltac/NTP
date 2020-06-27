/**
 * Companion para id de nodos
 * Permite que cada nodo tenga un id único
 */
object ArbolBinario{
    private var cont = 0
    private def id = {cont += 1; cont}
}

/**
 * Todos los nodos del proyecto heredan de este trait ArbolBinario
 */
trait ArbolBinario{
    val id: Int = ArbolBinario.id

    // Recorridos de arboles binarios
    def preorden: List[Any]
    def postorden: List[Any]

    def nodosPostOrden: List[ArbolBinario]

    // cálculos para tamaño del arbol
    def numHojas: Int
    def numNodosInternos: Int

    // operaciones con hojas (double)
    def sumarHojas: Double
    def operacionHojas(op: Double => Double)

    // operaciones con árboles
    def mergeArboles(arbol: ArbolBinario) : ArbolBinario

    // getters
    def getValor: Any
    def getNodoIzquierda: ArbolBinario
    def getNodoDerecha: ArbolBinario
    def getProfundidad: Int

    // operaciones auxiliares
    def asignarProfundidad(prof: Int) : Unit
}