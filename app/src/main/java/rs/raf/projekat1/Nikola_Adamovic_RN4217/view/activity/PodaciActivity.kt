package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_podaci.*
import kotlinx.android.synthetic.main.activity_podaci.bolnica
import kotlinx.android.synthetic.main.activity_podaci.ime
import kotlinx.android.synthetic.main.activity_podaci.izmenibtn
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R


class PodaciActivity: AppCompatActivity(R.layout.activity_podaci) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init()
    {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        ime.setText(sharedPreferences.getString(MainActivity.IME,""))
        prezime.setText(sharedPreferences.getString(MainActivity.PREZIME,""))
        bolnica.setText(sharedPreferences.getString(MainActivity.BOLNICA,""))

        odustanibtn.setOnClickListener {

            finish()
        }
        izmenibtn.setOnClickListener {
            var flag = true
            if(ime.text.toString() == ""){
                flag=false
                tv1.visibility= View.VISIBLE
            }
            if(prezime.text.toString() == ""){
                flag=false
                tv2.visibility= View.VISIBLE
            }
            if(bolnica.text.toString() == ""){
                flag=false
                tv3.visibility= View.VISIBLE
            }

            if(flag)
            {
                val edit = sharedPreferences.edit()
                edit.putString(MainActivity.IME,ime.text.toString())
                edit.putString(MainActivity.PREZIME,prezime.text.toString())
                edit.putString(MainActivity.BOLNICA,bolnica.text.toString())
                edit.apply()

                finish()
            }
        }

    }
}