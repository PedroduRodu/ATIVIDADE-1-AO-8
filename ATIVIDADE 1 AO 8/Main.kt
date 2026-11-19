/*
 * ATIVIDADE DE LABORATORIO - CONTROLE DE FLUXO AVANCADO EM KOTLIN
 * Questoes 1 a 8
 *
 * Cada exercicio foi separado em uma funcao para facilitar a leitura,
 * os testes e a apresentacao em sala.
 */

fun main() {
    while (true) {
        println("\n============================================")
        println(" CONTROLE DE FLUXO AVANCADO - KOTLIN")
        println("============================================")
        println("1 - O Filtro de Vogais")
        println("2 - O Primeiro Multiplo Comum")
        println("3 - Somador com Limite de Carga")
        println("4 - Simulador de Caixa Eletronico")
        println("5 - Deteccao de Numeros Primos")
        println("6 - O Menu Teimoso")
        println("7 - Pula-Obstaculos Numerico")
        println("8 - Cofre com Bloqueio Progressivo")
        println("0 - Sair")

        print("Escolha uma questao para executar: ")
        val opcao = readLine()?.trim()?.toIntOrNull()

        when (opcao) {
            1 -> questao1()
            2 -> questao2()
            3 -> questao3()
            4 -> questao4()
            5 -> questao5()
            6 -> questao6()
            7 -> questao7()
            8 -> questao8()
            0 -> {
                println("Programa encerrado.")
                return
            }
            else -> println("Opcao invalida. Escolha um numero de 0 a 8.")
        }
    }
}

// QUESTAO 1 - O FILTRO DE VOGAIS
// Percorre a palavra e usa continue para ignorar as vogais.
fun questao1() {
    val palavra = "Universidade"
    val vogais = "aeiouAEIOU"

    print("Consoantes da palavra $palavra: ")
    for (caractere in palavra) {
        if (caractere in vogais) {
            continue // Pula a vogal e segue para o proximo caractere.
        }
        print(caractere)
    }
    println()
}

// QUESTAO 2 - O PRIMEIRO MULTIPLO COMUM
// Procura o primeiro numero divisivel por 7 e por 13 ao mesmo tempo.
fun questao2() {
    var numero = 1

    while (true) {
        if (numero % 7 == 0 && numero % 13 == 0) {
            println("Primeiro multiplo comum de 7 e 13: $numero")
            break // Encerra o while assim que encontrar o numero.
        }
        numero++
    }
}

// QUESTAO 3 - SOMADOR COM LIMITE DE CARGA
// Soma de 1 a 100, ignorando multiplos de 10 e parando quando passar de 500.
fun questao3() {
    var total = 0

    for (numero in 1..100) {
        if (numero % 10 == 0) {
            continue // Multiplos de 10 nao entram na soma.
        }

        total += numero

        if (total > 500) {
            break // Interrompe o for quando o total ultrapassa 500.
        }
    }

    println("Valor final da soma: $total")
}

// QUESTAO 4 - SIMULADOR DE CAIXA ELETRONICO
// Realiza saques de R$ 150,00 ate nao haver saldo suficiente.
fun questao4() {
    var saldo = 1000.0
    val valorSaque = 150.0
    var quantidadeSaques = 0

    while (true) {
        if (saldo >= valorSaque) {
            saldo -= valorSaque
            quantidadeSaques++
            println("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f".format(valorSaque, saldo))
        } else {
            println("Saldo Insuficiente")
            break // Encerra a operacao quando nao existe saldo para outro saque.
        }
    }

    println("Quantidade de saques realizados: $quantidadeSaques")
    println("Saldo final: R$ %.2f".format(saldo))
}

// QUESTAO 5 - DETECCAO DE NUMEROS PRIMOS
// Testa divisores entre 2 e alvo - 1. Se encontrar divisor, usa break.
fun questao5() {
    val alvo = 29
    var ehPrimo = true

    if (alvo < 2) {
        ehPrimo = false
    } else {
        for (divisor in 2 until alvo) {
            if (alvo % divisor == 0) {
                ehPrimo = false
                break // Nao precisa testar os demais divisores.
            }
        }
    }

    if (ehPrimo) {
        println("$alvo e um numero primo.")
    } else {
        println("$alvo nao e um numero primo.")
    }
}

// QUESTAO 6 - O MENU TEIMOSO
// Le opcoes do usuario em um loop infinito. A opcao 3 usa continue.
fun questao6() {
    while (true) {
        println("\n--- MENU ---")
        println("1 - Opcao 1")
        println("2 - Opcao 2")
        println("3 - Modulo em manutencao")
        println("0 - Sair do menu")
        print("Digite uma opcao: ")

        val opcao = readLine()?.trim()?.toIntOrNull()

        when (opcao) {
            1, 2 -> println("Processando...")
            3 -> {
                println("Modulo em manutencao")
                continue // Volta imediatamente ao inicio do menu.
            }
            0 -> {
                println("Saindo do menu...")
                break // Encerra somente o loop deste menu.
            }
            else -> println("Opcao invalida. Tente novamente.")
        }
    }
}

// QUESTAO 7 - PULA-OBSTACULOS NUMERICO
// Imprime de 1 a 50, pulando os numeros terminados em 7.
fun questao7() {
    print("Numeros de 1 a 50, exceto os que terminam em 7: ")

    for (numero in 1..50) {
        if (numero % 10 == 7) {
            continue // Pula 7, 17, 27, 37 e 47.
        }
        print("$numero ")
    }
    println()
}

// QUESTAO 8 - COFRE COM BLOQUEIO PROGRESSIVO
// O usuario tem ate cinco tentativas, mas o cofre trava apos tres erros.
fun questao8() {
    val senhaCorreta = "1234" // Senha simulada para a atividade.
    var acessoConcedido = false

    for (tentativa in 1..5) {
        print("Digite a senha do cofre (tentativa $tentativa de 5): ")
        val senhaDigitada = readLine()?.trim() ?: ""

        if (senhaDigitada == senhaCorreta) {
            println("Senha correta! Acesso concedido.")
            acessoConcedido = true
            break // Encerra o for quando a senha estiver correta.
        } else {
            println("Senha incorreta.")

            if (tentativa == 3) {
                println("Cofre travado administrativamente")
                break // Apos o terceiro erro, bloqueia as tentativas restantes.
            }
        }
    }

    if (!acessoConcedido) {
        println("Acesso nao autorizado.")
    }
}
