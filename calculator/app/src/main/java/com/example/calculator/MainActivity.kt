package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var lastNumeric=false
    var error=false
    var lastDot=false
    private lateinit var expression: Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onAllclearClick(view: View) {
        binding.textUpper.text=""
        binding.textResult.text=""
        error=false
        lastDot=false
        lastNumeric=false
        binding.textResult.visibility=View.GONE
    }
    fun onOperatorClick(view: View) {
        if(!error && lastNumeric){
            binding.textUpper.append((view as Button).text)
            lastDot=false
            lastNumeric=false
            onEqual()
        }
    }
    fun onBackClick(view: View) {
        binding.textUpper.text=binding.textUpper.text.toString().dropLast(1)
        try {
            var lastChar=binding.textUpper.text.toString().last()
            if(lastChar.isDigit()){
                onEqual()
            }
        }catch (e:Exception){
            binding.textResult.text=""
            binding.textResult.visibility=View.GONE
        }
    }
    fun onDigitClick(view: View) {
        if(error){
            binding.textUpper.text=(view as Button).text
            error=false
        }else{
            binding.textUpper.append((view as Button).text)
        }
        lastNumeric=true
        onEqual()
    }
    fun onEqualClick(view: View) {
        onEqual()
        binding.textUpper.text=binding.textResult.text.toString().drop(1)

    }
    fun onEqual(){
        if(lastNumeric && !error){
            val text=binding.textUpper.text.toString()
            expression=ExpressionBuilder(text).build()
            try {
                val ans=expression.evaluate()
                binding.textResult.visibility=View.VISIBLE
                binding.textResult.text="="+ans
            }catch (e:ArithmeticException){
                binding.textResult.text="Error"
                error=true
                lastNumeric=false// reset
            }
        }
    }
}