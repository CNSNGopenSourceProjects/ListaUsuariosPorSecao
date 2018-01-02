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
     * Disponibiliza o nome do usuário.
     * O nome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    private var nome: String = ""
    /**
     * O nome do usuário será vazio, apenas se a classe foi criada como EmptyClass.
     * @return Nome do usuário.
     */
    fun getNome(): String {
        return this.nome
    }

    /**
     * Disponibiliza o sobrenome do usuário.
     * O sobrenome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    private var sobrenome: String = ""
    /**
     * O sobrenome do usuário será vazio, apenas se a classe foi criada como EmptyClass.
     * @return Sobrenome do usuário.
     */
    fun getSobrenome(): String {
        return this.sobrenome
    }

    /**
     * Disponibiliza a idade do usuário.
     * Seu conteúdo será zero, apenas se a classe foi criada como EmptyClass.
     */
    private var idade: Int = 0
    /**
     * A idade do usuário será vazio, apenas se a classe foi criada como EmptyClass.
     * @return Idade do usuário.
     */
    fun getIdade(): Int {
        return this.idade
    }

    /**
     * Identificador UUID único instância desta classe.
     */
    private val idUsuario =  UUID.randomUUID()
    /**
     * Identificador único da instância desta classe.
     */
    fun getThisInstanceId(): Long {
        return this.idUsuario.hashCode().toLong()
    }

    /**
     * Preserva a posição da classe na array.  Deve ser inicializado pela aplicação.
     * Valores negativos indica que nenhuma posição foi salva.
     */
    var posUsuario: Int = -1

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
     * Compara os dados do [usuario] contra os dados desta classe, utilizando a seguinte ordem de prioridade:
     * NOME, SOBRENOME e IDADE.
     * @param [usuario] A classe a ser comparada com a classe atual.
     * @return 0, se mesmo nome, sobrenome e idades iguais.
     * <0 se o nome da classe atual for menor; ou se o nome for igual, mas o sobrenome for menor; ou se o nome e o sobrenome forem iguais, mas a idade for menor.
     * >0 se o nome da classe atual for maior; ou se o nome for igual, mas o sobrenome for maior; ou se o nome e o sobrenome forem iguais, mas a idade for maior.
     */
    fun comparatorByNome(usuario: Usuario): Int {
        var res = this.nome.compareTo(usuario.getNome())
        if (0 == res) {
            res = this.sobrenome.compareTo(usuario.getSobrenome())
        } else if (0 == res) {
            res = this.idade.compareTo(usuario.getIdade())
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
        var res = this.sobrenome.compareTo(usuario.getSobrenome())
        if (0 == res) {
            res = this.nome.compareTo(usuario.getNome())
        } else if (0 == res) {
            res = this.idade.compareTo(usuario.getIdade())
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
        var res = this.idade.compareTo(usuario.getIdade())
        if (0 == res) {
            res = this.nome.compareTo(usuario.getNome())
        } else if (0 == res) {
            res = this.sobrenome.compareTo(usuario.getSobrenome())
        }
        return res
    }

    /**
     * Apresenta o conteúdo da classe.
     * @return "[idUsuario][nome] [sobrenome], [idade]"
     */
    override fun toString(): String {
        return "[$this.idUsuario] $this.nome $this.sobrenome, $this.idade"
    }
}