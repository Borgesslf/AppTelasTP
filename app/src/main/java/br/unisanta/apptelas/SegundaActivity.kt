package br.unisanta.apptelas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {

    private lateinit var textTitulo: TextView
    private lateinit var textAutor: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        // Inicializar os componentes
        textTitulo = findViewById(R.id.textTitulo)
        textAutor = findViewById(R.id.textAutor)
        btnVoltar = findViewById(R.id.btnVoltar)

        // Receber os dados da Intent
        val titulo = intent.getStringExtra("titulo")
        val autor = intent.getStringExtra("autor")

        // Exibir os dados
        textTitulo.text = "Título: $titulo"
        textAutor.text = "Autor: $autor"

        // Configurar o botão voltar
        btnVoltar.setOnClickListener {
            finish() // Fecha a atividade atual e volta para a anterior
        }
    }
}