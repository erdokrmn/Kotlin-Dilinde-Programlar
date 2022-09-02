package com.erdokrmn.kotlinoopproject

open class Musician(name: String, instrument: String, age: Int) {

    var name: String?= name
        private set
        get

    private var instrument : String?= instrument
    var age : Int?= age
        private set
        get

    private val bandName : String="Metallica"

    fun returnBandName(password : String) : String{
        if (password== "Karaman")
        {
            return bandName
        }
        else
        {
            return "wrong password"
        }

    }
}