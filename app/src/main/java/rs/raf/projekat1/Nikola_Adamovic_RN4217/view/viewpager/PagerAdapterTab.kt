package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment.*

class PagerAdapterTab (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
        //const val FRAGMENT_4 = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> CekaonicaFragment()
            FRAGMENT_2 -> HospFragment()
            //FRAGMENT_3 -> ListeFragment()
            else -> OtpFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_1 -> "Cekaonica"
            FRAGMENT_2 -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }



}