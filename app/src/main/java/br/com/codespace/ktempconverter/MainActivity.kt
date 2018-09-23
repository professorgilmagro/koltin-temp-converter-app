package br.com.codespace.ktempconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editText:EditText
    lateinit var optCelcius:RadioButton
    lateinit var optFahreinheit:RadioButton
    lateinit var btnConverter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.txtValorTemp)
        optCelcius = findViewById(R.id.optCelcius)
        optFahreinheit = findViewById(R.id.optFahreinheit)
        btnConverter = findViewById(R.id.btnConvert)

        btnConverter.setOnClickListener{convert(it)}
    }

    /**
     * Faz a conversão de graus
     */
    fun convert(view: View) {
        if (editText.text.isEmpty()) {
            val msg = Toast.makeText(view.context, "Digite o valor a ser convertido.", Toast.LENGTH_LONG)
            msg.show()
            return
        }

        var temp:Double = editText.text.toString().toDouble()
        temp = if (optCelcius.isChecked) {
            (temp - 32) * 5/9
        } else {
            temp * 9/5 + 32
        }

        editText.setText(temp.toString())
    }
}
