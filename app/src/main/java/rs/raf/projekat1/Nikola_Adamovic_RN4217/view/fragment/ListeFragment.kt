package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tabs.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.viewpager.PagerAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.viewpager.PagerAdapterTab

class ListeFragment: Fragment(R.layout.fragment_tabs)
{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPagerTab.adapter = PagerAdapterTab(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerTab)
    }

}
