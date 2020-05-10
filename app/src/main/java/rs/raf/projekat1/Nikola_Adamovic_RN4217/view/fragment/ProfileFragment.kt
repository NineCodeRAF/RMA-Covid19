package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity.LogInActivity
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity.MainActivity
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity.PodaciActivity

class ProfileFragment: Fragment(R.layout.fragment_profile)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = this.requireActivity().getSharedPreferences(this.context?.packageName, Context.MODE_PRIVATE)
        ime_P.text=sharedPreferences.getString(MainActivity.IME,"dsa")
        prezime_p.text=sharedPreferences.getString(MainActivity.PREZIME,"")
        bolnica_P.text=sharedPreferences.getString(MainActivity.BOLNICA,"")
    }

    public fun init()
    {
        val sharedPreferences = this.requireActivity().getSharedPreferences(this.context?.packageName, Context.MODE_PRIVATE)
        ime_P.text=sharedPreferences.getString(MainActivity.IME,"dsa")
        prezime_p.text=sharedPreferences.getString(MainActivity.PREZIME,"")
        bolnica_P.text=sharedPreferences.getString(MainActivity.BOLNICA,"")
        odjavabtn.setOnClickListener {
            val edit = sharedPreferences.edit()
            edit.putString(MainActivity.IME,"ime")
            edit.putString(MainActivity.PREZIME,"prezime")
            edit.putString(MainActivity.BOLNICA,"bolnica")
            edit.putString(MainActivity.LOGGED,"false")
            edit.apply()
            val intent = Intent(this.context,LogInActivity::class.java)
            startActivity(intent)
            this.requireActivity().finish()
        }

        izmenibtn.setOnClickListener {
            val intent = Intent(this.context,PodaciActivity::class.java)
            startActivity(intent)
        }
    }

}