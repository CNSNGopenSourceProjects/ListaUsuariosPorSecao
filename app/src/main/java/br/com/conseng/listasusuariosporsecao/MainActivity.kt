package br.com.conseng.listasusuariosporsecao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: UsuariosAdapter? = null
    val todosUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populaListaUsuarios()

        btnOrdenarPeloNome.setOnClickListener{ordenarPeloNome()}
        btnOrdenarPeloSobrenome.setOnClickListener{ordenarPeloSobreome()}
        btnOrdenarPelaIdade.setOnClickListener{ordenarPelaIdade()}

        adapter = UsuariosAdapter(this, todosUsuarios)
        viewsUsuarios.adapter = adapter
    }

    /**
     * Apresenta a lista de usuários ordenada pelo nome.
     */
    fun ordenarPeloNome() {
        Toast.makeText(this,"Ordenar os usuários pelo nome", Toast.LENGTH_LONG).show()
        adapter?.ordenaUsuarios(Usuario.DefineDadoParaComparacao.NOME)
    }

    /**
     * Apresenta a lista de usuários ordenada pelo sobrenome.
     */
    fun ordenarPeloSobreome() {
        Toast.makeText(this, "Ordenar os usuários pelo sobrenome", Toast.LENGTH_LONG).show()
        adapter?.ordenaUsuarios(Usuario.DefineDadoParaComparacao.SOBRENOME)
    }

    /**
     * Apresenta a lista de usuários ordenada pela idade.
     */
    fun ordenarPelaIdade() {
        Toast.makeText(this,"Ordenar os usuários pela idade", Toast.LENGTH_LONG).show()
        adapter?.ordenaUsuarios(Usuario.DefineDadoParaComparacao.IDADE)
    }

    /**
     *  Carrega [todosUsuarios] com uma lista de usuários fictícia para o exercício.
     */
    private fun populaListaUsuarios() {
        todosUsuarios.add(Usuario("Edson", "Silva", 33))
        todosUsuarios.add(Usuario("Edson", "Silva", 22))
        todosUsuarios.add(Usuario("Luiz", "Silva Neto", 11))
        todosUsuarios.add(Usuario("José", "Figueiredo", 99))
        todosUsuarios.add(Usuario("Anette", "Silva", 88))
        todosUsuarios.add(Usuario("Tadeu", "Silva", 77))
        todosUsuarios.add(Usuario("Thadeu", "Veiga", 66))
        todosUsuarios.add(Usuario("Wilson", "Albuquerque", 55))
        todosUsuarios.add(Usuario("Edson", "Xavante", 44))
        todosUsuarios.add(Usuario("Luiza", "Castro", 33))
        todosUsuarios.add(Usuario("Antonio", "Silva", 22))
        todosUsuarios.add(Usuario("Marcio", "Antunes", 11))
        todosUsuarios.add(Usuario("Mário", "Silva", 99))
        todosUsuarios.add(Usuario("Marcos", "Veiga", 88))
        todosUsuarios.add(Usuario("Fagundes", "Silva", 77))
        todosUsuarios.add(Usuario("Maria", "Xavante", 66))
        todosUsuarios.add(Usuario("Douglas", "Silva", 55))
        todosUsuarios.add(Usuario("Edison", "Figueiredo", 44))
        todosUsuarios.add(Usuario("Herodes", "Silva", 33))
        todosUsuarios.add(Usuario("Edson", "Castro", 22))
        todosUsuarios.add(Usuario("Manoel", "Antunes", 11))
    }
}
