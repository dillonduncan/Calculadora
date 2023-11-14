package com.example.calculadora2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculadora2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var txtResult: TextView?=null
    var num1: Double=0.0
    var num2:Double=0.0
    var operacion:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        txtResult=binding.txtResult
        var quitarCero= if(binding.txtResult.text=="0"){ binding.txtResult.text==""; }else{binding.txtResult.text==""}
        binding.apply {
            btnNum1.setOnClickListener { quitarCero; numPresionado( num="1") }
            btnNum2.setOnClickListener { quitarCero; numPresionado( num="2") }
            btnNum3.setOnClickListener { quitarCero; numPresionado( num="3") }
            btnNum4.setOnClickListener { quitarCero; numPresionado( num="4") }
            btnNum5.setOnClickListener { quitarCero; numPresionado( num="5") }
            btnNum6.setOnClickListener { quitarCero; numPresionado( num="6") }
            btnNum7.setOnClickListener { quitarCero; numPresionado( num="7") }
            btnNum8.setOnClickListener { quitarCero; numPresionado( num="8") }
            btnNum9.setOnClickListener { quitarCero; numPresionado( num="9") }
            btnNum0.setOnClickListener { quitarCero; numPresionado( num="0") }
            btnSuma.setOnClickListener { quitarCero; oprcnPresionada(Suma) }
            btnResta.setOnClickListener { quitarCero; oprcnPresionada(Resta) }
            btnDiv.setOnClickListener { quitarCero; oprcnPresionada(Division) }
            btnMulti.setOnClickListener { quitarCero; oprcnPresionada(Multiplicacion) }
            btnBorrar.setOnClickListener {
                quitarCero
                num1=0.0
                num2=0.0
                binding.txtResult.text=""
                operacion= Nada
            }
            btnResult.setOnClickListener {
                quitarCero
                var resultado = when (operacion) {
                    Suma -> num1 + num2
                    Resta -> num1 - num2
                    Multiplicacion -> num1 * num2
                    Division -> num1 / num2
                    else -> 0
                }
                binding.txtResult.text = resultado.toString()
                num1=0.0
                num2=0.0
                resultado=0
            }
        }
    }
    fun numPresionado(num:String){
        binding.txtResult.text="${txtResult!!.text}$num"
        if (operacion == Nada){
            num1=txtResult!!.text.toString().toDouble()
        }else{
            num2=txtResult!!.text.toString().toDouble()
        }
    }
    fun oprcnPresionada(opera:Int){
        operacion=opera
        binding.txtResult.text = ""
    }
    companion object{
        const val Suma=1
        const val Resta=2
        const val Multiplicacion=3
        const val Division=4
        const val Nada=0
    }
}