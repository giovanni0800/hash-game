import java.util.Scanner

class MetodosDoJogo {
    //Última posição do Array (índice 9) recebe 'N' de Null ou 'V' de Valid
    private val posicoes: Array<Char> = arrayOf('V', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')

    private fun introducaoAoJogo(){
        println("\nPara selecionar o local aonde deseja adicionar a letra, considere uma das posições:")
        print("\n")
        println("\t1 | 2 | 3")
        println("\t----------")
        println("\t4 | 5 | 6")
        println("\t----------")
        println("\t7 | 8 | 9\n")
    }

    private fun resetarPosicoes(){
        var repetirLaco = 1
        do{
            this.posicoes[repetirLaco] = ' '
            repetirLaco++
        }while (repetirLaco <= 9)
    }

    private fun tabuleiro(posicao: Array<Char>){
        print("\n")
        println("\t${posicao[1]} | ${posicao[2]} | ${posicao[3]}")
        println("\t----------")
        println("\t${posicao[4]} | ${posicao[5]} | ${posicao[6]}")
        println("\t----------")
        println("\t${posicao[7]} | ${posicao[8]} | ${posicao[9]}\n")
    }

    private fun leituraLinhaEColuna(): Int?{
        val leitor = try{
            print("Selecione a posicao a qual deseja realizar a jogada: ")
            val posicao: Int = Scanner(System.`in`).nextInt()
            if(posicao < 1 || posicao > 9) null
            else posicao

        } catch (exception: Exception){
            println("\nOpção selecionada inválida... Por favor, tente novamente!\n")
            null
        }

        return leitor
    }

    private fun leituraLinhaEColunaValidada(): Int{
        var validador: Int?

        do{
            validador = leituraLinhaEColuna()
        }while(validador == null)

        return validador
    }

    private fun definicaoValoresJogoDaVelha(posicaoLetra: Int, letra: Char): Array<Char>{
        if (this.posicoes[posicaoLetra] != ' '){
            println("Posição $posicaoLetra já ocupada!\n")
            //Retorna 'N' de NULL
            this.posicoes[0] = 'N'

        } else {
            this.posicoes[posicaoLetra] = letra
            //Retorna 'V' de VALID
            this.posicoes[0] = 'V'
        }

        return this.posicoes
    }

    private fun validaVencedor(posicoesASeremValidadas: Array<Char>): Int{
        var jogadorVitorioso = 0

        //Apresenta o vencedor do X
        if(posicoesASeremValidadas[1] == 'X' && posicoesASeremValidadas[2] == 'X' && posicoesASeremValidadas[3] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        } else if (posicoesASeremValidadas[4] == 'X' && posicoesASeremValidadas[5] == 'X' && posicoesASeremValidadas[6] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        } else if (posicoesASeremValidadas[7] == 'X' && posicoesASeremValidadas[8] == 'X' && posicoesASeremValidadas[9] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        }else if (posicoesASeremValidadas[1] == 'X' && posicoesASeremValidadas[4] == 'X' && posicoesASeremValidadas[7] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        }else if (posicoesASeremValidadas[2] == 'X' && posicoesASeremValidadas[5] == 'X' && posicoesASeremValidadas[8] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        }else if (posicoesASeremValidadas[3] == 'X' && posicoesASeremValidadas[6] == 'X' && posicoesASeremValidadas[9] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        }else if (posicoesASeremValidadas[1] == 'X' && posicoesASeremValidadas[5] == 'X' && posicoesASeremValidadas[9] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1
        }else if (posicoesASeremValidadas[3] == 'X' && posicoesASeremValidadas[5] == 'X' && posicoesASeremValidadas[7] == 'X'){
            println("Letra 'X' Venceu!!\n")
            jogadorVitorioso = 1

        //Apresenta o vencedor do O
        }else if(posicoesASeremValidadas[1] == 'O' && posicoesASeremValidadas[2] == 'O' && posicoesASeremValidadas[3] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        } else if (posicoesASeremValidadas[4] == 'O' && posicoesASeremValidadas[5] == 'O' && posicoesASeremValidadas[6] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        } else if (posicoesASeremValidadas[7] == 'O' && posicoesASeremValidadas[8] == 'O' && posicoesASeremValidadas[9] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }else if (posicoesASeremValidadas[1] == 'O' && posicoesASeremValidadas[4] == 'O' && posicoesASeremValidadas[7] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }else if (posicoesASeremValidadas[2] == 'O' && posicoesASeremValidadas[5] == 'O' && posicoesASeremValidadas[8] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }else if (posicoesASeremValidadas[3] == 'O' && posicoesASeremValidadas[6] == 'O' && posicoesASeremValidadas[9] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }else if (posicoesASeremValidadas[1] == 'O' && posicoesASeremValidadas[5] == 'O' && posicoesASeremValidadas[9] == 'O'){
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }else if (posicoesASeremValidadas[3] == 'O' && posicoesASeremValidadas[5] == 'O' && posicoesASeremValidadas[7] == 'O') {
            println("Letra 'O' Venceu!!\n")
            jogadorVitorioso = 2
        }

        return jogadorVitorioso
    }

    private fun vezCadaJogador(){
        var rodada = 1
        var letra: Char
        var validaPosicao: Array<Char>
        var defineVencedor: Int

        while(rodada <= 9){
            letra = if (rodada % 2 != 0) {
                println("Jogador: X")
                'X'
            } else {
                println("Jogador: O")
                'O'
            }

            // validaPosicao recebe o retorno de definicao dos valores do jogo da velha e avalia se
            // temos a jogada de uma posição já ocupada ou se podemos armazenar uma letra no array de 9 indices
            // Junto da letra que é definida quando é a vez do primeiro ou do segundo jogador
            validaPosicao = definicaoValoresJogoDaVelha(leituraLinhaEColunaValidada(), letra)
            if (validaPosicao[0] != 'N'){
                tabuleiro(validaPosicao)
                rodada++
            }

            // Vai definir se teve um vencedor entre 'X' ou 'O', ou se deu 'VELHA'
            defineVencedor = validaVencedor(validaPosicao)

            if(defineVencedor == 0 && rodada == 9){
                println("Tivemos um Empate!!\nDeu Velha! #\n")
                break
            }else if(defineVencedor == 1){
                break
            }else if(defineVencedor == 2){
                break
            }
        }
    }

    private fun executarJogo(){
        introducaoAoJogo()
        vezCadaJogador()
    }

    fun repetirJogo(){
        var opcao: String

        do {
            executarJogo()
            resetarPosicoes()
            print("Gostaria de jogar novamente? [S-N]: ")
            opcao = Scanner(System.`in`).next()

            if(opcao.uppercase() == "N") {
                println("\n##############")
                println("### Finalizando Aplicação... ####")
                println("##############")

            } else if(opcao.uppercase() != "S" && opcao.uppercase() != "N"){
                println("\n\t\t##### Resposta Inválida... Finalizando o Jogo da Velha... #####")
            }

        } while (opcao.uppercase() == "S")
    }
}