object ArbolBinario{
    private var cont = 0
    private def id = {cont += 1; cont}
}

trait ArbolBinario{
    val id: Int = ArbolBinario.id

    def preorden(): List[Any]
    def postorden(): List[Any]
    def numHojas(): Int
    def numNodosInternos(): Int
    def sumarHojas(): Double
    def operacionHojas(op: Double => Double)
    def mergeArboles(arbol: ArbolBinario) : ArbolBinario
}