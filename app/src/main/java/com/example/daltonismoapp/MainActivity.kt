package com.example.daltonismoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.daltonismoapp.databinding.ActivityMainBinding
import com.example.daltonismoapp.models.Daltonico

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var daltonismo = Daltonico()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            daltonico = daltonismo

            val intent = Intent(this@MainActivity, TesteActivity::class.java)
            val param = Bundle()
            teste1.setOnClickListener {
                param.putInt("teste", 1)
                intent.putExtras(param)
                startActivityForResult(intent, 1)
            }
            teste2.setOnClickListener {
                param.putInt("teste", 2)
                intent.putExtras(param)
                startActivityForResult(intent, 2)
            }
            teste3.setOnClickListener {
                param.putInt("teste", 3)
                intent.putExtras(param)
                startActivityForResult(intent, 3)
            }

            verificar.setOnClickListener {
                if (resposta1.text == null ||
                    resposta2.text == null ||
                    resposta3.text == null
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "Preencha todas as respostas",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (resposta1.text == "29" &&
                        resposta2.text == "74" &&
                        resposta3.text == "2"
                    ) {
                        resultado.text = "Visão normal"
                        invalidateAll()
                    } else {
                        resultado.text = "Daltonismo"
                        invalidateAll()
                    }
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                1 -> {
                    binding.resposta1.text = data?.getStringExtra("resposta").toString()
                }
                2 -> {
                    binding.resposta2.text = data?.getStringExtra("resposta").toString()
                }
                3 -> {
                    binding.resposta3.text = data?.getStringExtra("resposta").toString()
                }
            }
        }

    }

    }