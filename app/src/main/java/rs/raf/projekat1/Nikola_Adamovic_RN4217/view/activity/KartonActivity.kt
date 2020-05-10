package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_karton.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient

class KartonActivity: AppCompatActivity(R.layout.activity_karton) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        odustanibtn.setOnClickListener {
            finish()
        }
    }


}