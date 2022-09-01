package com.erdokrmn.catchthekenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var number=0
    var number2=0
    var runnable:Runnable=Runnable{}
    var runnable2:Runnable=Runnable{}
    var handler:Handler= Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number =0
        runnable=object:Runnable{
            override fun run() {
                number=number+1
                tvTime.text="Time : $number"
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
        runnable2=object :Runnable{
            override fun run() {
                val randomValues = List(1){Random.nextInt(1,10)}
                var num=randomValues
                if (randomValues[0]==1){
                    iv1.visibility=View.VISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==2){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.VISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==3){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.VISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==4){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.VISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==5){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.VISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==6){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.VISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==7){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.VISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==8){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.VISIBLE
                    iv9.visibility=View.INVISIBLE
                }
                else if (randomValues[0]==9){
                    iv1.visibility=View.INVISIBLE
                    iv2.visibility=View.INVISIBLE
                    iv3.visibility=View.INVISIBLE
                    iv4.visibility=View.INVISIBLE
                    iv5.visibility=View.INVISIBLE
                    iv6.visibility=View.INVISIBLE
                    iv7.visibility=View.INVISIBLE
                    iv8.visibility=View.INVISIBLE
                    iv9.visibility=View.VISIBLE
                }
                handler.postDelayed(this,500)
            }
        }
        handler.post(runnable2)
    }
    fun iv1_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv2_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv3_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv4_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv5_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv6_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv7_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv8_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
    fun iv9_Click(view:View){
        number2=number2+1
        tvScore.text="Score : $number2"
    }
}