trait ArbolBinario{
    def preorden(): List[Any]
    def postorden(): List[Any]
    def tamArbol(): Int
    def sumarHojas(): Double
    def operacionHojas(op: Double => Double)
    def mergeArboles(arbol: ArbolBinario) : ArbolBinario
}