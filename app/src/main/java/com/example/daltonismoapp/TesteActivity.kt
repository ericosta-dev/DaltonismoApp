package com.example.daltonismoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.daltonismoapp.databinding.ActivityTesteBinding

class TesteActivity : AppCompatActivity() {
    lateinit var binding: ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)

        binding.apply {
            val params:Bundle? = intent.extras

            when(params?.getInt("teste")) {
                1 -> {
                    binding.imageTeste.setImageResource(R.drawable.teste1)
                }
                2 -> {
                    binding.imageTeste.setImageResource(R.drawable.teste2)
                }
                3 -> {
                    binding.imageTeste.setImageResource(R.drawable.teste3)
                }
            }

            confirmaButton.setOnClickListener {
                if(resposta.text.toString() != "") {
                    val intent = Intent()
                    intent.putExtra("resposta", resposta.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    Toast.makeText(this@TesteActivity, "Por favor, coloque uma resposta válida", Toast.LENGTH_SHORT).show()
                }
            }

            cancelButton.setOnClickListener {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }
}