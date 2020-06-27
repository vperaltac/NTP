trait ArbolBinario{
    def recorridoAnchura()
    def recorridoProfundidad()
    def tamArbol(): Int
    def sumarHojas(): Double
    def operacionHojas(op: Double => Double)
    def mergeArboles(arbol: ArbolBinario) : ArbolBinario
}