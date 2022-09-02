package com.erdokrmn.kotlinoopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myUser = User("James",50)
        //myUser.age=25
        //myUser.name="James"
        println(myUser.age.toString())
        println(myUser.name)

        // encapsulation
        var james= Musician("Ahmet","Guitar",55)
        println(james.age.toString())
        println(james.returnBandName("Karaman"))
        println(james.returnBandName("Kahraman"))
        //intheritance
        var lars = SuperMusician("Lars","Piano",40)
        println(lars.name)
        println(lars.returnBandName("Karaman"))
        lars.sing()

        //static polymorphism

        var math =Math()
        println(math.sum())
        println(math.sum(2,3))
        println(math.sum(2,3,4))

        //dynamic polymorphism
        val animal=Animal()
        animal.sing()

        val barley=Dog()
        barley.test()
        barley.sing()

        //abstract and interface

        var myPiano=Piano()
        myPiano.brand="Yamaha"
        myPiano.digital=false
        println(myPiano.roomNama)
        myPiano.info()

        //Lambda expressions
        fun printString(myString:String){
            println(myString)
        }
        printString("My test string")
        val testString={myString:String->println(myString)}
        testString("My lambda string")

        val multiplyLambda ={a:Int,b:Int->a*b}
        println(multiplyLambda(5,4))

        val multiplyLambda2:(Int,Int)->Int={a,b->a*b}
        println(multiplyLambda2(5,4))

        //async
        fun dowlandMusicians(url:String,completion:(Musician)->Unit){
            val kirkHammet=Musician("Kirk","Guitar",60)
            completion(kirkHammet)
        }
        dowlandMusicians("erdokrmn.com",{ println(it.name)})


    }

}