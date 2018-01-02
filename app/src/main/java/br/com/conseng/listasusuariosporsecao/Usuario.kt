package br.com.conseng.listasusuariosporsecao

import java.security.InvalidParameterException
import java.util.*

/**
 * Contém os dados do usuário.
 * @constructor Os dados do usuário precisam ser definidos no momento de criação da classe, ou esta será vazia.
 */
class Usuario {
    /**
     *  Estabelece a indicação de como os dados dos usuários deverão ser comparados
     */
    enum class DefineDadoParaComparacao { SEM_ORDENACAO, NOME, SOBRENOME, IDADE }

    /**
     * O nome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    var nome: String = ""
        private set

    /**
     * O sobrenome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    var sobrenome: String = ""
        private set

    /**
     * A idade do usuário deve ser um valor entre 1 e 150.
     * Seu conteúdo será zero, apenas se a classe foi criada como EmptyClass.
     */
    var idade: Int = 0
        private set

    /**
     * Preserva os dados do usuário.
     * @constructor Os dados do usuário precisam ser definidos no momento de criação da class.
     * @param [nome] Nome do usuário.   A string não pode ser vazia e deve iniciar por uma letra.
     * @param [sobrenome] Sobrenome do usuário.  A string não pode ser vazia e deve iniciar por uma letra.
     * @param [idade] Idade do usuário.  O valor deve estar entre 1 e 150 anos.
     * @throws [InvalidParameterException] Dados do usuário fora dos limites especificados.
     */
    constructor(nome: String, sobrenome: String, idade: Int) : this() {
        if (nome.isNullOrEmpty() or !nome.get(0).isLetter()) {
            throw InvalidParameterException("O nome do usuário de ser iniciado por uma letra.")
        }
        if (sobrenome.isNullOrEmpty() or !sobrenome.get(0).isLetter()) {
            throw InvalidParameterException("O nome do usuário de ser iniciado por uma letra.")
        }
        if ((idade < 1) or (idade > 150)) {
            throw InvalidParameterException("A idade do usuário deve estar entre 1 e 150 anos.")
        }
        this.nome = nome
        this.sobrenome = sobrenome
        this.idade = idade
    }

    /**
     * Cria uma classe vazia.  ]
     * O campo de nome e sobrenome estarão vazios e a idade será zero, para diferenciar de uma classe completa.
     * Se quiser testar, use a função [isEmpty].
     */
    constructor()

    /**
     * Informa se a classe é vazia.
     * @return TRUE, se vazia.
     */
    fun isEmpty(): Boolean {
        return (0 == this.idade)
    }

    /**
     * Apresenta o conteúdo da classe.
     * @return "[nome] [sobrenome], [idade]"
     */
    override fun toString(): String {
        val texto = if (isEmpty()) "Usuário: VAZIO" else "Usuário: ${nome} ${sobrenome}, ${idade} anos"
        return texto
    }

    /**
     * Permite a comparação com base no Nome, Sobrenome e Idade.
     * Se os nomes forem iguais, decide a comparação pelos sobrenomes.
     * Se os nomes e os sobrenomes forem iguais, decide a comparação pelas idades.
     */
    class ComparatorByNome : Comparator<Usuario> {
        /**
         * Compara os dados de dois objetos [Usuario], utilizando a seguinte ordem de prioridade:
         * NOME, SOBRENOME e IDADE.
         * @param [u1] O primeiro objeto [Usuario] a ser comparado.
         * @param [u2] O segundo objeto [Usuario] a ser comparado.
         * @return 0, se [u1] == [u2].  <0 se [u1] < [u2].  >0 se [u1] > [u2]
         */
        override fun compare(u1: Usuario?, u2: Usuario?): Int {
            var res = 0
            if (null == u1) {
                res = if (null == u2) 0 else -1
            } else if (null == u2) {
                res = 1
            } else {
                res = u1.nome.compareTo(u2.nome)
                if (0 == res) {
                    res = u1.sobrenome.compareTo(u2.sobrenome)
                    if (0 == res) {
                        res = u1.idade.compareTo(u2.idade)
                    }
                }
            }
            return res
        }
    }

    /**
     * Permite a comparação com base no Sobrenome, Nome e Idade.
     * Se os sobrenomes forem iguais, decide a comparação pelos nomes.
     * Se os sobrenomes e os nomes forem iguais, decide a comparação pelas idades.
     */
    class ComparatorBySobrenome : Comparator<Usuario> {
        /**
         * Compara os dados de dois objetos [Usuario], utilizando a seguinte ordem de prioridade:
         * SOBRENOME, NOME e IDADE.
         * @param [u1] O primeiro objeto [Usuario] a ser comparado.
         * @param [u2] O segundo objeto [Usuario] a ser comparado.
         * @return 0, se [u1] == [u2].  <0 se [u1] < [u2].  >0 se [u1] > [u2]
         */
        override fun compare(u1: Usuario?, u2: Usuario?): Int {
            var res = 0
            if (null == u1) {
                res = if (null == u2) 0 else -1
            } else if (null == u2) {
                res = 1
            } else {
                res = u1.sobrenome.compareTo(u2.sobrenome)
                if (0 == res) {
                    res = u1.nome.compareTo(u2.nome)
                    if (0 == res) {
                        res = u1.idade.compareTo(u2.idade)
                    }
                }
            }
            return res
        }
    }

    /**
     * Permite a comparação com base no Idade, Nome e Sobrenome.
     * Se as idades forem iguais, decide a comparação pelos nomes.
     * Se as idades e os nomes forem iguais, decide a comparação pelos sobrenomes.
     */
    class ComparatorByIdade : Comparator<Usuario> {
        /**
         * Compara os dados de dois objetos [Usuario], utilizando a seguinte ordem de prioridade:
         * IDADE, NOME e  SOBRENOME.
         * @param [u1] O primeiro objeto [Usuario] a ser comparado.
         * @param [u2] O segundo objeto [Usuario] a ser comparado.
         * @return 0, se [u1] == [u2].  <0 se [u1] < [u2].  >0 se [u1] > [u2]
         */
        override fun compare(u1: Usuario?, u2: Usuario?): Int {
            var res = 0
            if (null == u1) {
                res = if (null == u2) 0 else -1
            } else if (null == u2) {
                res = 1
            } else {
                res = u1.idade.compareTo(u2.idade)
                if (0 == res) {
                    res = u1.nome.compareTo(u2.nome)
                    if (0 == res) {
                        res = u1.sobrenome.compareTo(u2.sobrenome)
                    }
                }
            }
            return res
        }
    }
}