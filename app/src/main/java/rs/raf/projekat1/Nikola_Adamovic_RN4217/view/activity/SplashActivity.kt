package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName,Context.MODE_PRIVATE)
        if(sharedPreferences.getString(MainActivity.LOGGED,"")=="true")
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else
        {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        finish()
    }

}