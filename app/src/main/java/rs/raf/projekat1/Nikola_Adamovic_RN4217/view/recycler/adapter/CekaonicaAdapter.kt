package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder.CekaonicaViewHolder

class CekaonicaAdapter(
    patientDiff: PatientDiff,
    private val onZdavBtnClick: (Patient) -> Unit,
    private val onHospBtnClick: (Patient) -> Unit) : ListAdapter<Patient, CekaonicaViewHolder>(patientDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CekaonicaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patients_cekaonica, parent, false)
        return CekaonicaViewHolder(containerView,onZdavBtnClicked,onHospBtnClicked)
    }

    override fun onBindViewHolder(holder: CekaonicaViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

    private val onZdavBtnClicked: (Int) -> Unit = {
        onZdavBtnClick.invoke(getItem(it))
    }

    private val onHospBtnClicked: (Int) -> Unit = {
        onHospBtnClick.invoke(getItem(it))
    }
}