object BalanceoCadenas {
    /**
     * Chequea el balance de paréntesis en una lista de caracteres
     */
    def chequearBalance(cadena: List[Char]) : Boolean ={
        if(cadena.isEmpty)
            true
        else{
            // generar una nueva cadena únicamente con los paréntesis
            val cadena_filtrada = cadena.filter(s => s == '(' || s == ')')

            @annotation.tailrec
            def go(cadena: List[Char], contador: Int = 0): Boolean = {
                if(cadena.isEmpty) contador == 0
                else{
                    if(contador < 0)
                        false
                    else if(cadena.head == '(')
                        go(cadena.tail,contador+1)
                    else
                        go(cadena.tail,contador-1)
                }
            }

            go(cadena_filtrada,0)
        }
    }

    def main(args: Array[String]) : Unit = {
        println(".......................Balanceo de Cadenas con Paréntesis.......................")
        println("Debería devolver true: " + chequearBalance("((cccc)ccc)".toList))
        println("Debería devolver false: " + chequearBalance("((c)ccc)ccc)".toList))
        println("Debería devolver false: " + chequearBalance("())(".toList))
    }
}
