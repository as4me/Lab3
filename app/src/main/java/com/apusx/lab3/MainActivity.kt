package com.apusx.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apusx.lab3.databinding.ActivityMainBinding
import java.lang.Math.floor
import java.lang.Math.log

class MainActivity : AppCompatActivity() {


    /*
        P = 10^-4 - мощность алфавита
        V = 15 паролей в минуту -  скорость пароля перебора злоумышленником
        T =  2 недели = 14 дней = 336 часов = 20160 минут максимальный срок действия пароля
        S =  A^A - число всевозможных паролей
        P =  VT/S = VT/ A^A

        S = VT/P = 15 * 20160 / 10^-4 = 3024000000

        L + LOG(S)/ LOG(A)

        S = A ^ L
        ! @ $ % ^ & * ( ) _ - +

     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var charset = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
        var charsetR = mutableListOf<String>("А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я")
        var charsetsmall = mutableListOf<String>("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
        var charsetsmallR = mutableListOf("а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я")
        var charsetnum = mutableListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        var charsetlust = mutableListOf("!", "”", "#", "$", "%", "&", "'", "(", ")", "*")
        var result = mutableListOf<String>()
        var resultAll = mutableListOf<String>()
        var A: Int = 0
        var L: Int = 0
        val s: Long = 3024000000

        binding.textViewA.text = "A мощность пароля $A"
        binding.c1.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 26
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()

                result.plusAssign(charset)
            } else {
                if (A > 0) {
                    A -= 26
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                    result.minusAssign(charset)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.c2.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 26
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()

                result.plusAssign(charsetsmall)
            } else {
                if (A > 0) {
                    A -= 26
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                    result.minusAssign(charsetsmall)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.c3.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 33
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()

                result.plusAssign(charsetR)
            } else {
                if (A > 0) {
                    A -= 33
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                    result.minusAssign(charsetR)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.c4.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 33
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()

                result.plusAssign(charsetsmallR)
            } else {
                if (A > 0) {
                    A -= 33
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                    result.minusAssign(charsetsmallR)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.c5.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 10
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"

                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                result.plusAssign(charsetnum)
            } else {
                if (A > 0) {
                    A -= 10
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                    result.minusAssign(charsetnum)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.c6.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                A += 10
                binding.textViewL.text = "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()
                result.plusAssign(charsetlust)
            } else {
                if (A > 0) {
                    A -= 10
                    binding.textViewL.text =
                        "L длина ${floor(log(s.toDouble()) / log(A.toDouble()))}"
                    L = floor(log(s.toDouble()) / log(A.toDouble())).toInt()

                    result.minusAssign(charsetlust)
                } else {
                    A = 0
                    binding.textViewL.text = "L длина 0"
                    L = 0
                }
            }
            binding.textViewA.text = "A мощность пароля $A"
        }

        binding.generate.setOnClickListener {
            binding.result.text = ""
            result.shuffle()
            for (i in result.take(L)){
                resultAll.add(i)
            }
            var l: String = ""
            for (i in resultAll){
                l += i
            }
            Log.d("LIST", l.toString())
            Log.d("LIST",L.toString())
            binding.result.text = l

            resultAll.clear()
        }
    }

}