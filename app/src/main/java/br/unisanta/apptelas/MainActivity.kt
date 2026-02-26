package br.unisanta.apptelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTitulo: EditText
    private lateinit var editAutor: EditText
    private lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar os componentes
        editTitulo = findViewById(R.id.editTitulo)
        editAutor = findViewById(R.id.editAutor)
        btnCadastrar = findViewById(R.id.btnCadastrar)

        // Configurar o botão
        btnCadastrar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val autor = editAutor.text.toString()

            // Validar se os campos não estão vazios
            if (titulo.isNotEmpty() && autor.isNotEmpty()) {
                // Criar o livro
                val livro = Livro(titulo, autor)

                // Criar Intent para abrir a segunda tela
                val intent = Intent(this, SegundaActivity::class.java)

                // Passar os dados do livro
                intent.putExtra("titulo", livro.titulo)
                intent.putExtra("autor", livro.autor)

                // Iniciar a segunda tela
                startActivity(intent)

                // Limpar os campos (opcional)
                editTitulo.text.clear()
                editAutor.text.clear()

            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}