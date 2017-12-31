package br.com.conseng.listasusuariosporsecao

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Popula a vista com os dados do usuário ordenados pelo nome, ou pelo sobrenome, ou pela idade.
 */
class UsuariosAdapter : BaseAdapter() {

    private var listaUsuarios: ArrayList<Usuario>? = null

    override fun getCount(): Int {
        return if (null == listaUsuarios) 0 else listaUsuarios.size
    }

    override fun getItem(position: Int): Usuario {
        return if (null == listaUsuarios) null else listaUsuarios.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : UsuarioView
        if (null == convertView) {
            view = UsuarioView(parent?.getContext()!!)
        } else {
            view = convertView as UsuarioView
        }
        return view.bind(view,)
    }

    fun setList(usuarios:ArrayList<Usuario>) {
Collection<UsuarioView>
        listaUsuarios=usuarios
    }
}