package com.erdokrmn.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val myDatabase=this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INT)")

            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('James',50)")
            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Lars',60)")

            //myDatabase.execSQL("UPDATE musicians SET age =61 WHERE name='Lars'")
            //myDatabase.execSQL("UPDATE musicians SET name='Erdinç Karaman' WHERE id=3")
            //myDatabase.execSQL("DELETE FROM musicians WHERE name='Lars'")
            val cursor=myDatabase.rawQuery("SELECT * FROM musicians" ,null)



            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx=cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                println("Name:"+cursor.getString(nameIx))
                println("Age:"+cursor.getInt(ageIx))
                println("Id:"+cursor.getInt(idIx))
            }
            cursor.close()

        }catch (e:Exception){
            //Alttaki kod neden hata aldığımızı gösteriyor
            e.printStackTrace()
        }
    }
}