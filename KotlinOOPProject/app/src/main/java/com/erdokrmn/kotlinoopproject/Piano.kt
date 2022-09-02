package com.erdokrmn.kotlinoopproject

class Piano : HouseDecor , Instrument
{
    override var roomNama: String
        get() = "Kitchen"
        set(value) {}

    var brand:String?=null
    var digital :Boolean?=null

}