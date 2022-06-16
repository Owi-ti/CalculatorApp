package dev.owiti.calculator_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCalc :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalc = findViewById(R.id.btnCalc)
      btnCalc.setOnClickListener {
          val intent = Intent(this,CalculatorActivity::class.java)
          startActivity(intent)
        }

    }
}