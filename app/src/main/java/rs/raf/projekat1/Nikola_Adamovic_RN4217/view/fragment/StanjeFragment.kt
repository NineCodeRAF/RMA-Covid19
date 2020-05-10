package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel.RecyclerViewModel
import androidx.fragment.app.activityViewModels


class StanjeFragment: Fragment(R.layout.fragment_stanje)
{
    private val recyclerViewModel: RecyclerViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        initObservers()
    }

    private fun initObservers() {

        brojCekaonica.text = recyclerViewModel.getCekaonicaList().size.toString()
        brojHosp.text = recyclerViewModel.getHospList().size.toString()
        brojOtp.text = recyclerViewModel.getOtpList().size.toString()


    }
}