package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import timber.log.Timber

class LogInActivity: AppCompatActivity(R.layout.activity_login){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login()
    }
    private fun login(){
        loginbtn.setOnClickListener {
            var flag = true
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            if(edit1.text.toString() == ""){
                flag=false
                tv1.visibility= View.VISIBLE
            }
            if(edit2.text.toString() == ""){
                flag=false
                tv2.visibility= View.VISIBLE
            }
            if(edit3.text.toString() == ""){
                flag=false
                tv3.visibility= View.VISIBLE
            }
            if(edit4.text.toString().length != 4){
                flag=false
                tv4.visibility= View.VISIBLE
            }

            if(flag)
            {
                val edit = sharedPreferences.edit()
                edit.putString(MainActivity.IME,edit1.text.toString())
                edit.putString(MainActivity.PREZIME,edit2.text.toString())
                edit.putString(MainActivity.BOLNICA,edit3.text.toString())
                edit.putString(MainActivity.LOGGED,"true")
                edit.commit()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}