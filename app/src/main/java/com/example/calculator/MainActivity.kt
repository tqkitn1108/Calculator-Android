package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textResult: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textResult)
        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.buttonClear).setOnClickListener(this)
        findViewById<Button>(R.id.buttonAdd).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener(this)
        findViewById<Button>(R.id.buttonProduct).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEqual).setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_fiber_manual_record_24)
            actionBar.title = "LifeCycle"
        }
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.buttonClear){
            textResult.text=""
            op=0
            op1=0
            op2=0
            state=1
        }else if (id == R.id.button0) {
            addDigit(0)
        } else if (id == R.id.button1) {
            addDigit(1)
        } else if (id == R.id.button2) {
            addDigit(2)
        } else if (id == R.id.button3) {
            addDigit(3)
        } else if (id == R.id.button4) {
            addDigit(4)
        } else if (id == R.id.button5) {
            addDigit(5)
        } else if (id == R.id.button6) {
            addDigit(6)
        } else if (id == R.id.button7) {
            addDigit(7)
        } else if (id == R.id.button8) {
            addDigit(8)
        } else if (id == R.id.button9) {
            addDigit(9)
        } else if (id == R.id.buttonAdd) {
            addString("+")
            op = 1
            state = 2
        } else if (id == R.id.buttonSubtract) {
            addString("-")
            op = 2
            state = 2
        } else if (id == R.id.buttonProduct) {
            addString("x")
            op = 3
            state = 2
        } else if (id == R.id.buttonDivide) {
            addString("/")
            op = 4
            state = 2
        } else if (id == R.id.buttonEqual) {
            addString("\n=")
            var result = 0
            if (op == 1) {
                result = op1 + op2
            } else if(op ==2) result = op1-op2
            else if(op ==3) result = op1*op2
            else if(op ==4) result = op1/op2
            addString("$result")
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        }

    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textResult.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            addString("$c")
        }
    }

    fun addString(s: String){
        val originalText = textResult.text.toString()
        val newText = originalText + s
        textResult.text = newText
    }

}