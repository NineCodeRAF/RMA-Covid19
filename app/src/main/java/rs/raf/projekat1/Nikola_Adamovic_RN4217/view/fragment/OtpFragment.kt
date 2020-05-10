package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_otp.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter.OtpAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel.RecyclerViewModel

class OtpFragment: Fragment(R.layout.recycler_otp){
    private val recyclerViewModel: RecyclerViewModel by activityViewModels()

    private lateinit var otpAdapter: OtpAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initListeners()
        initRecycler()
    }

    private fun initRecycler() {
        recycler_otp.layoutManager = LinearLayoutManager(this.context)
        otpAdapter = OtpAdapter(PatientDiff())
        recycler_otp.adapter = otpAdapter
    }

    private fun initListeners(){
        search_otp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                recyclerViewModel.filterCekaonica(search_otp.query.toString())
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
    }


    private fun initObservers() {
        recyclerViewModel.getOtp().observe(viewLifecycleOwner, Observer {
            otpAdapter.submitList(it)
        })
    }
}