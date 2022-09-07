package com.erdokrmn.artbook

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.erdokrmn.artbook.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Manifest


class ArtActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
    }

    fun btnSave_Click(view: View){

    }
    fun iVSelectImage_Click(view: View){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            // İzin yoksa izin istiyoruz
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                Snackbar.make(view,"Permission need for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",View.OnClickListener {
                    //İzin isteme
                })

            }else{

            }

        }else{
            //İzin verildiyse(Kullanıcı galerisine ulaşmamıza izin verdiyse)

            val intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        }
    }
}