package dev.owiti.calculator_project

import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class CalculatorActivity : AppCompatActivity() {
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus: Button
    lateinit var btnDivide: Button
    lateinit var tilNumber: TextInputLayout
    lateinit var tilNumberDecimal: TextInputLayout
    lateinit var etNumber1 : EditText
    lateinit var etNumber2 : EditText
    lateinit var tvOutput: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        btnAdd = findViewById(R.id.btnAdd)
      btnSubtract = findViewById(R.id.btnSubtract)
      btnModulus = findViewById(R.id.btnModulus)
      btnDivide = findViewById(R.id.btnDivide)
        tilNumber = findViewById(R.id.tilNumber)
        tilNumberDecimal = findViewById(R.id.tilNumberDecimal)
        tvOutput = findViewById(R.id.tvOutput)
        etNumber1=findViewById(R.id.etNumber2)
        etNumber2=findViewById(R.id.etNumber2)


        btnAdd.setOnClickListener {
            val inputs = obtainInput()
            addition(inputs!!.number, inputs!!.numberDecimal)

        }
        btnSubtract.setOnClickListener {
            val inputs = obtainInput()
            subtraction(inputs!!.number, inputs!!.numberDecimal)
        }
        btnDivide.setOnClickListener {
            val inputs = obtainInput()
            divition(inputs!!.number, inputs!!.numberDecimal)
        }

        btnModulus.setOnClickListener {
            val inputs = obtainInput()
            modulus(inputs!!.number,inputs!!.numberDecimal)
        }
    }

    fun obtainInput(): Input?{
        val number = etNumber1.text.toString()
        val numberDecimal = etNumber2.text.toString()
        if (number.isBlank()) {
            tilNumber.setError("Number is required")
            return null
        }
        if (numberDecimal.isBlank()) {
            tilNumberDecimal.setError("NumberDecimal is required")
            return null
        }
        return Input(number.toInt(), numberDecimal.toInt())
    }

    data class Input(var number: Int, var numberDecimal: Int)



    fun addition(number: Int, numberDecimal: Int) {
        var add = number + numberDecimal
        tvOutput.text = add.toString()

    }

    fun subtraction(number: Int, numberDecimal: Int) {
        var sub = number - numberDecimal
        tvOutput.text = sub.toString()
    }

    fun divition(number:Int, numberDecimal:Int){
        var div=number*numberDecimal
        tvOutput.text=div.toString()
    }

    fun modulus(number:Int, numberDecimal:Int){
        var remainder=number%numberDecimal
        tvOutput.text=remainder.toString()
    }
}
