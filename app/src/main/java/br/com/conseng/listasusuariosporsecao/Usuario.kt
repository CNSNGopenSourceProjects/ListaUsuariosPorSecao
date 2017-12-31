package br.com.conseng.listasusuariosporsecao

import java.security.InvalidParameterException

/**
 * Contém os dados do usuário.
 * @constructor Os dados do usuário precisam ser definidos no momento de criação da classe, ou esta será vazia.
 */
class Usuario {
    /**
     *  Estabelece a indicação de como os dados dos usuários deverão ser comparados
     */
    enum class DefineDadoParaComparacao { NOME, SOBRENOME, IDADE }

    /**
     * Disponibiliza o nome do usuário.
     * O nome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    var nome: String = ""
        get() {
            return nome
        }

    /**
     * Disponibiliza o sobrenome do usuário.
     * O sobrenome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    var sobrenome: String = ""
        get() {
            return sobrenome
        }

    /**
     * Disponibiliza a idade do usuário.
     * Seu conteúdo será zero, apenas se a classe foi criada como EmptyClass.
     */
    var idade: Int = 0
        get() {
            return idade
        }

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
        return (0 == idade)
    }

    /**
     * Compara os dados do [usuario] contra os dados desta classe, utilizando a seguinte ordem de prioridade:
     * NOME, SOBRENOME e IDADE.
     * @param [usuario] A classe a ser comparada com a classe atual.
     * @return 0, se mesmo nome, sobrenome e idades iguais.
     * <0 se o nome da classe atual for menor; ou se o nome for igual, mas o sobrenome for menor; ou se o nome e o sobrenome forem iguais, mas a idade for menor.
     * >0 se o nome da classe atual for maior; ou se o nome for igual, mas o sobrenome for maior; ou se o nome e o sobrenome forem iguais, mas a idade for maior.
     */
    fun comparatorByNome(usuario: Usuario): Int {
        var res = this.nome.compareTo(usuario.nome)
        if (0 == res) {
            res = this.sobrenome.compareTo(usuario.sobrenome)
        } else if (0 == res) {
            res = this.idade.compareTo(usuario.idade)
        }
        return res
    }

    /**
     * Compara os dados do [usuario] contra os dados desta classe, utilizando a seguinte ordem de prioridade:
     * SOBRENOME, NOME e IDADE.
     * @param [usuario] A classe a ser comparada com a classe atual.
     * @return 0, se mesmo nome, sobrenome e idades iguais.
     * <0 se o sobrenome da classe atual for menor; ou se o sobrenome for igual, mas o nome for menor; ou se o sobrenome e o nome forem iguais, mas a idade for menor.
     * >0 se o sobrenome da classe atual for maior; ou se o sobrenome for igual, mas o nome for maior; ou se o sobrenome e o nome forem iguais, mas a idade for maior.
     */
    fun comparatorBySobrenome(usuario: Usuario): Int {
        var res = this.sobrenome.compareTo(usuario.sobrenome)
        if (0 == res) {
            res = this.nome.compareTo(usuario.nome)
        } else if (0 == res) {
            res = this.idade.compareTo(usuario.idade)
        }
        return res
    }

    /**
     * Compara os dados do [usuario] contra os dados desta classe, utilizando a seguinte ordem de prioridade:
     * IDADE, NOME e SOBRENOME.
     * @param [usuario] A classe a ser comparada com a classe atual.
     * @return 0, se mesmo nome, sobrenome e idades iguais.
     * <0 se a idade da classe atual for menor; ou se a idade for igual, mas o nome for menor; ou se a idade e o nome forem iguais, mas o sobrenome for menor.
     * >0 se a idade da classe atual for maior; ou se a idade for igual, mas o nome for maior; ou se a idade e o nome forem iguais, mas o sobrenome for maior.
     */
    fun comparatorByIdade(usuario: Usuario): Int {
        var res = this.idade.compareTo(usuario.idade)
        if (0 == res) {
            res = this.nome.compareTo(usuario.nome)
        } else if (0 == res) {
            res = this.sobrenome.compareTo(usuario.sobrenome)
        }
        return res
    }

    /**
     * Apresenta o conteúdo da classe.
     * @return "[nome] [sobrenome], [idade]"
     */
    override fun toString(): String {
        return "$nome $sobrenome, $idade"
    }
}