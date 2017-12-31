package br.com.conseng.listasusuariosporsecao

import java.security.InvalidParameterException

/**
 *  Estabelece a indicação de como os dados dos usuários deverão ser comparados
 */
enum class DefineDadoParaComparacao { NOME, SOBRENOME, IDADE }

/**
 * Contém os dados do usuário.
 * @constructor os dados do usuário precisam ser definidos no momento de criação da classe, ou esta será vazia.
 */
class Usuario {
    /**
     * Disponibiliza o nome do usuário.
     * O nome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    private var nome: String = ""
        get() {
            return nome
        }

    /**
     * Disponibiliza o sobrenome do usuário.
     * O sobrenome do usuário não pode ser vazio e deve iniciar por uma letra.
     * Seu conteúdo será vazio, apenas se a classe foi criada como EmptyClass.
     */
    private var sobrenome: String = ""
        get() {
            return sobrenome
        }

    /**
     * Disponibiliza a idade do usuário.
     * Seu conteúdo será zero, apenas se a classe foi criada como EmptyClass.
     */
    private var idade: Int = 0
        get() {
            return idade
        }

    /**
     * Preserva os dados do usuário.
     * @constructor os dados do usuário precisam ser definidos no momento de criação da class.
     * @param [nome] nome do usuário.   A string não pode ser vazia e deve iniciar por uma letra.
     * @param [sobrenome] sobrenome do usuário.  A string não pode ser vazia e deve iniciar por uma letra.
     * @param [idade] idade do usuário.  O valor deve estar entre 1 e 150 anos.
     * @throws [InvalidParameterException] dados do usuário fora dos limites especificados.
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

    /***
     * Compares this object with the specified object for order by the name. Returns zero if this object is equal
     * to the specified [usuario]'s name, a negative number if it's less than [usuario]'s name, or a positive number
     * if it's greater than [usuario]'s name.
     * @param [usuario] classe a ter o nome comparado com o nome da classe atual.
     * @return 0, se mesmo nome e sobrenome. <0 se o nome da classe atual for menor. >0 se o nome da classe atual for maior.
     */
    fun comparatorByNome(usuario: Usuario): Int {
        return this.nome.compareTo(usuario.nome)
    }

    /***
     * Compares this object with the specified object for order by the lastname. Returns zero if this object is equal
     * to the specified [usuario]'s lastname, a negative number if it's less than [usuario]'s lastname, or a positive number
     * if it's greater than [usuario]'s lastname.
     * @param [usuario] classe a ter o sobrenome comparado com o nome da classe atual.
     * @return 0, se mesmo nome e sobrenome. <0 se o sobrenome da classe atual for menor. >0 se o sobrenome da classe atual for maior.
     */
    fun comparatorBySobrenome(usuario: Usuario): Int {
        return this.sobrenome.compareTo(usuario.sobrenome)
    }

    /**
     * Compares this object with the specified object for order by the age. Returns zero if this object is equal
     * to the specified [usuario]'s age, a negative number if it's less than [usuario]'s age, or a positive number
     * if it's greater than [usuario]'s age.
     * @param [usuario] classe a ter a idade comparada com a idade da classe atual.
     * @return 0, se mesma idade. <0 se a idade da classe atual for menor. >0 se a idade da classe atual for maior.
     */
    fun comparatorByIdade(usuario: Usuario): Int {
        return this.idade.compareTo(usuario.idade)
    }

    /**
     * Apresenta o conteúdo da classe no formato "nome sobrenome - idade"
     * @return "[nome] [sobrenome] - [idade] anos"
     */
    override fun toString(): String {
        return toString(DefineDadoParaComparacao.NOME)
    }

    /**
     * Define o formato que o conteúdo da classe deve ser apresentado.
     * @param [ordem] define o formato de apresentação dos dados do usuário.
     * @return se [ordem]=[DefineDadoParaComparacao.NOME], utiliza o formato "[nome] [sobrenome] - [idade] anos".
     * se [ordem]=[DefineDadoParaComparacao.IDADE], utiliza o formato "[idade] anos - [nome] [sobrenome]".
     * se [ordem]=[DefineDadoParaComparacao.SOBRENOME], utiliza o formato "[sobrenome], [nome] - [idade] anos".
     */
    fun toString(ordem: DefineDadoParaComparacao): String {
        when (ordem) {
            DefineDadoParaComparacao.IDADE -> {
                return "$idade anos - $nome $sobrenome"
            }
            DefineDadoParaComparacao.SOBRENOME -> {
                return "$sobrenome, $nome - $idade anos"
            }
            else -> {           // deixa DefineDadoParaComparacao.NOME como defauld
                return "$nome $sobrenome - $idade anos"
            }
        }
    }
}