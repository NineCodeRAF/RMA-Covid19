package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_hosp.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.activity.KartonActivity
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter.HospAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel.RecyclerViewModel

class HospFragment: Fragment(R.layout.recycler_hosp){

    private val recyclerViewModel: RecyclerViewModel by activityViewModels()

    private lateinit var hospAdapter: HospAdapter

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
        recycler_hosp.layoutManager = LinearLayoutManager(this.context)
        hospAdapter = HospAdapter(PatientDiff(),onKartonBtnClicked,onOtpBtnClicked)
        recycler_hosp.adapter = hospAdapter
    }

    private fun initListeners(){
        search_hosp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                recyclerViewModel.filterHosp(search_hosp.query.toString())
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
    }

    private val onKartonBtnClicked : (Patient) -> Unit = {
        val intent = Intent(this.context,KartonActivity::class.java)
        startActivity(intent)

    }

    private val onOtpBtnClicked : (Patient) -> Unit = {
        //it.hospitalizationDate = Date()
        recyclerViewModel.removeHosp(it)
        recyclerViewModel.addOtp(it)
    }

    private fun initObservers() {
        recyclerViewModel.getHosp().observe(this.viewLifecycleOwner, Observer {
            hospAdapter.submitList(it)
        })
    }


}