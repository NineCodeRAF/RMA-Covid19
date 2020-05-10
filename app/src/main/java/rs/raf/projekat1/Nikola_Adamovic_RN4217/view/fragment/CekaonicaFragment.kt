package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity.MainActivity
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter.CekaonicaAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel.RecyclerViewModel

class CekaonicaFragment: Fragment(R.layout.recycler){

    private val recyclerViewModel: RecyclerViewModel by activityViewModels()

    private lateinit var cekaonicaAdapter: CekaonicaAdapter

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
        recycler.layoutManager = LinearLayoutManager(this.context)
        cekaonicaAdapter = CekaonicaAdapter(PatientDiff(),onZdravBtnClicked,onHospBtnClicked)
        recycler.adapter = cekaonicaAdapter
    }

    private fun initListeners(){
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                recyclerViewModel.filterCekaonica(search.query.toString())
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
     }

    private val onZdravBtnClicked : (Patient) -> Unit = {
        //it.releasedDate = Date()
        recyclerViewModel.removeCek(it)
        recyclerViewModel.addOtp(it)
    }

    private val onHospBtnClicked : (Patient) -> Unit = {
        //it.hospitalizationDate = Date()
        recyclerViewModel.removeCek(it)
        recyclerViewModel.addHosp(it)
    }

    private fun initObservers() {
        recyclerViewModel.getCekaonica().observe(viewLifecycleOwner, Observer {
            cekaonicaAdapter.submitList(it)
        })
    }


}