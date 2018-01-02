package br.com.conseng.listasusuariosporsecao

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Popula a vista com os dados do usuário ordenados pelo nome, ou pelo sobrenome, ou pela idade.
 * @param [context] Contexto do programa
 * @param [usuarios] Lista dos usuários a serem apresentados na tela.
 */
class UsuariosAdapter(context: Context, usuarios: ArrayList<Usuario>) : BaseAdapter() {

    private val listaUsuarios = ArrayList<Usuario>()
    private var inflator:LayoutInflater?=null

    /**
     * Como os dados devem ser ordenados na tela.
     */
    private var ordenacao = Usuario.DefineDadoParaComparacao.SEM_ORDENACAO

    /**
     * Executa o construtor da classe.
     */
    init {
        listaUsuarios.clear()
        listaUsuarios.addAll(usuarios)
        inflator= LayoutInflater.from(context)
        mostraUsuarios()
    }

    /**
     * How many items are in the data set represented by this Adapter.     *
     * @return Count of items.
     */
    override fun getCount(): Int {
        return listaUsuarios.size
    }

    /**
     * Get the data item associated with the specified position in the data set.     *
     * @param [position] Position of the item whose data we want within the adapter's data set.
     * @return The data at the specified position.
     */
    override fun getItem(position: Int): Usuario {
        return if (position<0) Usuario() else listaUsuarios.get(position)
    }

    /**
     * Get the row id associated with the specified position in the list.     *
     * @param [position] The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * @return true if this adapter doesn't contain any data.  This is used to determine
     * whether the empty view should be displayed.  A typical implementation will return
     * getCount() == 0 but since getCount() includes the headers and footers, specialized
     * adapters might want a different behavior.
     */
    override fun isEmpty(): Boolean {
        return 0 == listaUsuarios.size
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.     *
     * @param [position] The position of the item within the adapter's data set of the item whose view
     *        we want.
     * @param [convertView] The old view to reuse, if possible. Note: You should check that this view
     *        is non-null and of an appropriate type before using. If it is not possible to convert
     *        this view to display the correct data, this method can create a new view.
     *        Heterogeneous lists can specify their number of view types, so that this View is
     *        always of the right type (see {@link #getViewTypeCount()} and
     *        {@link #getItemViewType(int)}).
     * @param [parent] The parent that this view will eventually be attached to.
     * @return A View corresponding to the data at the specified position.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: UsuarioView

        if (null == convertView) {
            view = UsuarioView(parent?.getContext()!!)
        } else {
            view = convertView as UsuarioView
        }
        view.mostraUsuario(getItem(position),getItem(position-1), ordenacao)
        return view
    }

    /**
     * Apresenta os dados dos usuários na tela devidamente ordenados.
     */
    private fun mostraUsuarios() {
        // TODO: como invalidar a tela e garantir seu refrescamento?
    }

    /**
     * Atualiza os dados dos usuários na tela ordenandos como definido.
     * @param [ordem] Como os dados do usuários devem ser ordenados: pelo NOME, pelo SOBRENOME ou pela idade.
     */
    fun ordenaUsuarios(ordem: Usuario.DefineDadoParaComparacao) {
        // TODO: ordenar a tabela --- Collection<UsuarioView>
        ordenacao = ordem
        mostraUsuarios()
    }

    /**
     * Informa quantos usuários estão registrados.
     */
    override fun toString(): String {
        return "$this.listaUsuarios.size usuários"
    }
}