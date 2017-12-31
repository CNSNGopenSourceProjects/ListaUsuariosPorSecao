package br.com.conseng.listasusuariosporsecao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var apresentaUsuarios : UsuariosAdapter? = null
    val todosUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populaListaUsuarios()

        btnOrdenarPeloNome.setOnClickListener{ordenarPeloNome()}
        btnOrdenarPeloSobrenome.setOnClickListener{ordenarPeloSobreome()}
        btnOrdenarPelaIdade.setOnClickListener{ordenarPelaIdade()}

        apresentaUsuarios= UsuariosAdapter()
    }

    /**
     * Apresenta a lista de usuários ordenada pelo nome.
     */
    fun ordenarPeloNome() {
        Toast.makeText(this,"Por implementar a ordenação dos usuários pelo nome", Toast.LENGTH_LONG).show()
    }

    /**
     * Apresenta a lista de usuários ordenada pelo sobrenome.
     */
    fun ordenarPeloSobreome() {
        Toast.makeText(this, "Por implementar a ordenação dos usuários pelo sobrenome", Toast.LENGTH_LONG).show()
    }

    /**
     * Apresenta a lista de usuários ordenada pela idade.
     */
    fun ordenarPelaIdade() {
        Toast.makeText(this,"Por implementar a ordenação dos usuários pela idade", Toast.LENGTH_LONG).show()
    }

    /**
     *  Carrega [todosUsuarios] com uma lista de usuários fictícia para o exercício.
     */
    private fun populaListaUsuarios() {
        todosUsuarios.add(Usuario("Edson", "Silva", 32))
        todosUsuarios.add(Usuario("Edson", "Silva", 18))
        todosUsuarios.add(Usuario("Luiz", "Silva Neto", 23))
        todosUsuarios.add(Usuario("José", "Figueiredo", 34))
        todosUsuarios.add(Usuario("Anette", "Silva", 45))
        todosUsuarios.add(Usuario("Tadeu", "Silva", 56))
        todosUsuarios.add(Usuario("Thadeu", "Veiga", 67))
        todosUsuarios.add(Usuario("Wilson", "Albuquerque", 78))
        todosUsuarios.add(Usuario("Edson", "Xavante", 89))
        todosUsuarios.add(Usuario("Luiza", "Castro", 98))
        todosUsuarios.add(Usuario("Antonio", "Silva", 87))
        todosUsuarios.add(Usuario("Marcio", "Antunes", 76))
        todosUsuarios.add(Usuario("Mário", "Silva", 65))
        todosUsuarios.add(Usuario("Marcos", "Veiga", 54))
        todosUsuarios.add(Usuario("Fagundes", "Silva", 43))
        todosUsuarios.add(Usuario("Maria", "Xavante", 32))
        todosUsuarios.add(Usuario("Douglas", "Silva", 21))
        todosUsuarios.add(Usuario("Edison", "Figueiredo", 11))
        todosUsuarios.add(Usuario("Herodes", "Silva", 22))
        todosUsuarios.add(Usuario("Edson", "Castro", 33))
        todosUsuarios.add(Usuario("Manoel", "Antunes", 44))
    }
}
