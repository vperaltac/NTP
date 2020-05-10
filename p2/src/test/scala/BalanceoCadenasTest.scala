import org.scalatest.FunSuite

class BalanceoCadenasTest extends FunSuite{
    // Prueba 1
    test("chequear balance '(if (zero? x) max (/ 1 x))' esta balanceada"){
        assert(BalanceoCadenas.chequearBalance("(if (zero? x) max (/ 1 x))".toList))
    }

    // Prueba 2
    test("chequear balance 'Te lo dije ...' esta balanceada"){
        assert(BalanceoCadenas.chequearBalance("Te lo dije (eso esta (todavia) hecho)".toList))
    }

    // Prueba 3
    test("chequear balance ':-)' no esta balanceada"){
        assert(!BalanceoCadenas.chequearBalance(":-)".toList))
    }

    // Prueba 4
    test("chequear balance: no basta con contar sin mas"){
        assert(!BalanceoCadenas.chequearBalance("())(".toList))
    }

    // Prueba 5
    test("(if (a > b) (b/a) else (a/(b*b)))"){
        assert(BalanceoCadenas.chequearBalance("(if (a > b) (b/a) else (a/(b*b)))".toList))
    }

    // Prueba 6
    test("(ccc(ccc)cc((ccc(c))))"){
        assert(BalanceoCadenas.chequearBalance("(ccc(ccc)cc((ccc(c))))".toList))
    }

    // Prueba 7
    test("(if (a > b) b/a) else (a/(b*b)))"){
        assert(!BalanceoCadenas.chequearBalance("(if (a > b) b/a) else (a/(b*b)))".toList))
    }

    // Prueba 8
    test("())()())"){
        assert(!BalanceoCadenas.chequearBalance("())()())".toList))
    }
}
