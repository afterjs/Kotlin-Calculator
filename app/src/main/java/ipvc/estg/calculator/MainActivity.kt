package ipvc.estg.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nine(view: android.view.View) {
        var num = findViewById<Button>(R.id.num9)
        appendTo(num.text)
    }

    fun eight(view: android.view.View) {
        var num = findViewById<Button>(R.id.num8)
        appendTo(num.text)
    }

    fun seven(view: android.view.View) {
        var num = findViewById<Button>(R.id.num7)
        appendTo(num.text)
    }

    fun six(view: android.view.View) {
        var num = findViewById<Button>(R.id.num6)
        appendTo(num.text)
    }

    fun five(view: android.view.View) {
        var num = findViewById<Button>(R.id.num5)
        appendTo(num.text)
    }

    fun four(view: android.view.View) {
        var num = findViewById<Button>(R.id.num4)
        appendTo(num.text)
    }

    fun three(view: android.view.View) {
        var num = findViewById<Button>(R.id.num3)
        appendTo(num.text)
    }

    fun two(view: android.view.View) {
        var num = findViewById<Button>(R.id.num2)
        appendTo(num.text)
    }

    fun one(view: android.view.View) {
        var num = findViewById<Button>(R.id.num1)
        appendTo(num.text)
    }

    fun zero(view: android.view.View) {
        var num = findViewById<Button>(R.id.num0)
        var resultRow = findViewById<TextView>(R.id.result)

        if(!resultRow.text.toString().isBlank()) {
            appendTo(num.text)
        }

    }

    fun clear(view: android.view.View) {
        findViewById<TextView>(R.id.result).setText("")
    }

    private fun String.isDigitsOnly() = all(Char::isDigit) && isNotEmpty()

    private fun check(operator: String): Boolean {

        var resultRow = findViewById<TextView>(R.id.result)

        if(!resultRow.text.toString().isBlank()) {

            var resLgt = resultRow.length()
            var resultSubStr: String = resultRow.text.subSequence(resLgt-1, resLgt).toString()

            if (resultSubStr!=operator && resultSubStr.isDigitsOnly()) {
                return true
            }

        }

        return false
    }

    fun sum(view: android.view.View) {
        if (check("+")) {
            appendTo("+")
        }
    }

    fun multi(view: android.view.View) {
        if (check("X")) {
            appendTo("X")
        }
    }

    fun dec(view: android.view.View) {
        if (check("-")) {
            appendTo("-")
        }
    }

    fun division(view: android.view.View) {
        if (check("/")) {
            appendTo("/")
        }
    }

    fun doResult(view: android.view.View) {

       var resultRow = findViewById<TextView>(R.id.result)

        if(!resultRow.text.contains(":")) {
            if(!resultRow.text.toString().isBlank()) {
                var result = resultRow.text.toString().lowercase()

                when{
                    result.contains("+") -> {
                        val indexOfOperator =  result.indexOf("+", 0)
                        var firstNum  = result.subSequence(0,indexOfOperator).toString()
                        var secondNum = result.subSequence(indexOfOperator+1, result.length).toString()

                        finalValue(firstNum.toInt()+secondNum.toInt())

                    }
                    result.contains("-") -> {
                        val indexOfOperator =  result.indexOf("-", 0)
                        var firstNum  = result.subSequence(0,indexOfOperator).toString()
                        var secondNum = result.subSequence(indexOfOperator+1, result.length).toString()

                        finalValue(firstNum.toInt()-secondNum.toInt())

                    }
                    result.contains("*") -> {
                        val indexOfOperator =  result.indexOf("*", 0)
                        var firstNum  = result.subSequence(0,indexOfOperator).toString()
                        var secondNum = result.subSequence(indexOfOperator+1, result.length).toString()

                        finalValue(firstNum.toInt()*secondNum.toInt())

                    }
                    result.contains("/") -> {
                        val indexOfOperator =  result.indexOf("/", 0)
                        var firstNum  = result.subSequence(0,indexOfOperator).toString()
                        var secondNum = result.subSequence(indexOfOperator+1, result.length).toString()

                        finalValue(firstNum.toInt()/secondNum.toInt())

                    }
                }

            }

        }else{
            Toast.makeText(this, "Pls, use AC", Toast.LENGTH_SHORT).show()
        }

    }

    fun finalValue(value: Int) {
        findViewById<TextView>(R.id.result).setText("Resultado: " + value)
    }

    fun appendTo(char: Any) {

         var resultRow = findViewById<TextView>(R.id.result)
         val foo = (resultRow.text).toString()
         val bar = char.toString()
         var newValue = foo.plus(bar)

        findViewById<TextView>(R.id.result).setText(newValue)

    }

}