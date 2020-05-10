package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder.CekaonicaViewHolder
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder.HospViewHolder

class HospAdapter(
    patientDiff: PatientDiff,
    private val onKartonBtnClick: (Patient) -> Unit,
    private val onOtpBtnClick: (Patient) -> Unit) : ListAdapter<Patient, HospViewHolder>(patientDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patients_hosp, parent, false)
        return HospViewHolder(containerView,onKartonBtnClicked,onOtpBtnClicked)
    }

    override fun onBindViewHolder(holder: HospViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

    private val onKartonBtnClicked: (Int) -> Unit = {
        onKartonBtnClick.invoke(getItem(it))
    }

    private val onOtpBtnClicked: (Int) -> Unit = {
        onOtpBtnClick.invoke(getItem(it))
    }

}