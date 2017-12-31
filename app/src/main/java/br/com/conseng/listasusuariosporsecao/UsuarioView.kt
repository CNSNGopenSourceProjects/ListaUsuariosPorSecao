package br.com.conseng.listasusuariosporsecao

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import br.com.conseng.listasusuariosporsecao.Usuario.DefineDadoParaComparacao
import kotlinx.android.synthetic.main.view_usuario.view.*

/**
 * Mostra um usuário na tela.  Se for o primeiro do grupo, apresenta a legenda de identificação do grupo.
 * Os dados do usuário serão apresentados de acordo com a definição do campo de ordenação [Usuario.DefineDadoParaComparacao].
 */
class UsuarioView : LinearLayout {

    /**
     * Mostra um usuário na tela.  Se for o primeiro do grupo, apresenta a legenda de identificação do grupo.
     *
     * @param [context] The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @see [LinearLayout(Context)]
     */
    constructor(context: Context)
            : super(context) {
        init()
    }

    /**
     * Mostra um usuário na tela.  Se for o primeiro do grupo, apresenta a legenda de identificação do grupo.
     *
     * @param [context] The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param [attrs] The attributes of the XML tag that is inflating the view.
     * @see [LinearLayout(Context, AttributeSet)]
     */
    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) {
        init()
    }

    /**
     * Nome do grupo.  Por default é GONE.
     */
    private val nomeDoGrupo = txt_usuario_nome_grupo
    /**
     * Nome do usuário. Por defualt é vazio.
     */
    private val nomeDoUsuario = txt_usuario_nome

    /**
     * Mostra um usuário na tela.  Se for o primeiro do grupo, apresenta a legenda de identificação do grupo.
     *
     * @param [context] The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param [attrs] The attributes of the XML tag that is inflating the view.
     * @param [defStyleAttr] An attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     * @see [LinearLayout(Context, AttributeSet, Int)]
     */
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        init()
    }

    /**
     * Mostra um usuário na tela.  Se for o primeiro do grupo, apresenta a legenda de identificação do grupo.
     *
     * @param [context] The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param [attrs] The attributes of the XML tag that is inflating the view.
     * @param [defStyleAttr] An attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     * @param [defStyleRes] A resource identifier of a style resource that
     *        supplies default values for the view, used only if
     *        defStyleAttr is 0 or can not be found in the theme. Can be 0
     *        to not look for defaults.
     * @see [LinearLayout(Context, AttributeSet, Int, Int)]
     */
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    /**
     * Inicializa a view sem nenhum texto carregado.
     */
    private fun init() {
        View.inflate(getContext(), R.layout.view_usuario, this)
    }

    /**
     * Atualiza os dados do usuário na tela.  Se o [novoUsuario] não pertencer ao grupo do [usuarioAnterior],
     * deixa o identificador de grupo visível com o título do novo grupo.
     * @param [novoUsuario] Dados do usuário a serem apresentados na tela.  Este usuário não pode ser vazio.
     * @param [usuarioAnterior] Dados do usuário anterior para identificar o grupo atual.
     * Deve ser uma classe vazia se não houver um [usuarioAnterior] listado.
     */
    fun mostraUsuario(novoUsuario: Usuario, usuarioAnterior: Usuario, ordem: Usuario.DefineDadoParaComparacao) {
        var mostrarGrupo = false
        if (usuarioAnterior.isEmpty()) {
            mostrarGrupo = true
        } else {
            when (ordem) {
                Usuario.DefineDadoParaComparacao.NOME -> {
                    mostrarGrupo = novoUsuario.nome.get(0) != usuarioAnterior.nome.get(0)
                }
                Usuario.DefineDadoParaComparacao.IDADE -> {
                    mostrarGrupo = novoUsuario.idade != usuarioAnterior.idade
                }
                Usuario.DefineDadoParaComparacao.SOBRENOME -> {
                    mostrarGrupo = novoUsuario.sobrenome.get(0) != usuarioAnterior.sobrenome.get(0)
                }
            }
        }
        nomeDoUsuario.text = identificaUsuario(novoUsuario, ordem)
        nomeDoGrupo.text = identificaGrupo(novoUsuario, ordem)
        nomeDoGrupo.visibility = if (mostrarGrupo) View.VISIBLE else View.GONE
    }

    /**
     * Retorna o texto de identificação do grupamento.
     * @param [usuario] Dados do usuário.
     * @param [ordem] Campo utilizado no grupamento.
     * @return Nome do grupamento.
     */
    private fun identificaGrupo(usuario: Usuario, ordem: Usuario.DefineDadoParaComparacao): String {
        when (ordem) {
            DefineDadoParaComparacao.IDADE -> {
                return String().format("%i anos", usuario.idade)
            }
            DefineDadoParaComparacao.SOBRENOME -> {
                return String().format("Sobrenome %c", usuario.sobrenome)
            }
            Usuario.DefineDadoParaComparacao.NOME -> {
                return String().format("Nome %c", usuario.nome)
            }
        }
    }

    /**
     * Apresenta os dados do usuário no formato que o conteúdo da classe deve ser apresentado.
     * @param [usuario] Dados do usuário.
     * @param [ordem] Define o formato de apresentação dos dados do usuário.
     * @return Se [ordem]=[DefineDadoParaComparacao.NOME], utiliza o formato "[nome] [sobrenome] - [idade] anos".
     * Se [ordem]=[DefineDadoParaComparacao.IDADE], utiliza o formato "[idade] anos - [nome] [sobrenome]".
     * Se [ordem]=[DefineDadoParaComparacao.SOBRENOME], utiliza o formato "[sobrenome], [nome] - [idade] anos".
     */
    private fun identificaUsuario(usuario: Usuario, ordem: DefineDadoParaComparacao): String {
        when (ordem) {
            DefineDadoParaComparacao.IDADE -> {
                return String().format("%s %s: %i anos", usuario.nome, usuario.sobrenome, usuario.idade)
            }
            DefineDadoParaComparacao.SOBRENOME -> {
                return String().format("%s, %s: %i anos", usuario.sobrenome, usuario.nome, usuario.idade)
            }
            Usuario.DefineDadoParaComparacao.NOME -> {
                return String().format("%i anos: %s %s", usuario.idade, usuario.nome, usuario.sobrenome)
            }
        }
    }
}