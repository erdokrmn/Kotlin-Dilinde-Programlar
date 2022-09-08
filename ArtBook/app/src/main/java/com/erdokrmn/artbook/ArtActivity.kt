package com.erdokrmn.artbook

import android.content.Intent
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.erdokrmn.artbook.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest


class ArtActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtBinding
    private lateinit var  activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    var selectedBitmap : Bitmap? = null
    private lateinit var database: SQLiteDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        registerLauncher()

        //veri tabanını oluşturduk
        database=this.openOrCreateDatabase("Arts", MODE_PRIVATE,null)

        val intent=intent
        val info=intent.getStringExtra("info")
        if (info.equals("new")){

            binding.etArtName.setText("")
            binding.etArtistName.setText("")
            binding.etYear.setText("")
            binding.btnSave.visibility=View.VISIBLE

        }else{
            binding.btnSave.visibility=View.INVISIBLE
            val selectedId=intent.getIntExtra("id",1)

            val cursor=database.rawQuery("SELECT * FROM arts WHERE id=?", arrayOf(selectedId.toString()))
            val artNameIx=cursor.getColumnIndex("artname")
            val artistNameIx=cursor.getColumnIndex("artistname")
            val yearIx=cursor.getColumnIndex("year")
            val imageIx=cursor.getColumnIndex("image")

            while (cursor.moveToNext()){
                binding.etArtName.setText(cursor.getString(artNameIx))
                binding.etArtistName.setText(cursor.getString(artistNameIx))
                binding.etYear.setText(cursor.getString(yearIx))

                val byteArray=cursor.getBlob(imageIx)
                val bitmap=BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
                binding.imageView.setImageBitmap(bitmap)
            }
            cursor.close()
        }

    }

    fun btnSave_Click(view: View){


        //Kullanıcıdan verileri aldık
        val artName= binding.etArtName.text.toString()
        val artistName=binding.etArtistName.text.toString()
        val year=binding.etYear.text.toString()

        if (selectedBitmap!=null){
            val smallBitmap=makeSmallerBitmap(selectedBitmap!!,300)

            //görseli veriye dönüştürme
            val outputStream=ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
            val byteArray=outputStream.toByteArray()

            try {
                //veritabanına ekledik
                database.execSQL("CREATE TABLE IF NOT EXISTS arts(id INTEGER PRIMARY KEY,artname VARCHAR,artistname VARCHAR,year VARCHAR,image BLOB)")
                val sqlString="INSERT INTO arts(artname,artistname,year,image) VALUES (?,?,?,?)"
                val statement=database.compileStatement(sqlString)
                statement.bindString(1,artName)
                statement.bindString(2,artistName)
                statement.bindString(3,year)
                statement.bindBlob(4,byteArray)
                statement.execute()

            }catch (e:Exception){
                e.printStackTrace()
            }

            //Kayıt işlemini yaptıktan sonra arka plandaki aktiviteleri kapatıp main aktiviteye dönüyoruz
            val intent =Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
    private fun makeSmallerBitmap(image : Bitmap,maximumSize:Int): Bitmap{
        //gelen resmi küçültmek için

        var width=image.width
        var height=image.height
        val bitmapRatio:Double=width.toDouble()/height.toDouble()
        if (bitmapRatio>1){
            // Yatay bir resim
            width=maximumSize
            val scaledHeight=width/bitmapRatio
            height=scaledHeight.toInt()
        }else{
            height=maximumSize
            val scaledWidth=height*bitmapRatio
            width=scaledWidth.toInt()
        }
        return  Bitmap.createScaledBitmap(image,100,100,true)
    }

    fun iVSelectImage_Click(view: View){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            // Eğer kullanıcı ilk başta izin vermezse altta bir snackbar oluşuyor ve orda give permision diyor.Bu izin kontrolü yukarıdaki if içinde
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                Snackbar.make(view,"Permission need for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",View.OnClickListener {
                    //İzin isteme
                    permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }).show()
            }else{
                permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }

        }else{
            //İzin verildiyse(Kullanıcı galerisine ulaşmamıza izin verdiyse)

            val intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            activityResultLauncher.launch(intentToGallery)
        }
    }
    private fun registerLauncher(){
        //Bu alttaki kod kullanıcının galerisine gidip görseli seçmesi ile alakalı

        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            if (result.resultCode== RESULT_OK){
                val intentFromResult=result.data
                if (intentFromResult!=null){
                    val imageData= intentFromResult.data
                    //binding.imageView.setImageURI(imageData)
                    if(imageData!=null){
                        try {
                            if (Build.VERSION.SDK_INT>=28){
                                val source=ImageDecoder.createSource(contentResolver,imageData)
                                selectedBitmap=ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }else{
                                selectedBitmap=MediaStore.Images.Media.getBitmap(contentResolver,imageData)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }

                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }

                }

            }
        }

        permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission(),){
            result->
            if (result){
                //Bize ilk başta burayı soruyor ve ilk kabul edersek izni alt satır çalışıyor
                val intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }else{

                Toast.makeText(this,"Permission needed!",Toast.LENGTH_LONG).show()
            }
        }
    }
}