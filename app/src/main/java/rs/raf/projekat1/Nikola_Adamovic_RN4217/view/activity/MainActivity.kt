package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.viewpager.PagerAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main){
    companion object {
        const val IME ="ime"
        const val PREZIME = "prezime"
        const val BOLNICA = "bolnica"
        const val LOGGED = "false"
    }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        init()
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_stanje ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false)
                }
                R.id.navigation_unos ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_2, false)
                }
                R.id.navigation_liste ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_3, false)
                }
                R.id.navigation_profil ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_4, false)
                }
            }
            true
        }
    }
}