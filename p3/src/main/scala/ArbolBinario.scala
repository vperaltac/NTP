trait ArbolBinario{
    def add(valor: Either[Int,Double]): ArbolBinario
    def buscar(valor: Either[Int,Double]): Boolean
    def eliminar(valor: Either[Int,Double]): ArbolBinario
    def recorridoAnchura(): List[Any]
    def recorridoProfundidad(): List[Any]
    def operacionHojas()
    def mergeArboles(arbol: ArbolBinario) : ArbolBinario
}