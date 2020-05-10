package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff.PatientDiff
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder.OtpViewHolder

class OtpAdapter(
    patientDiff: PatientDiff
) : ListAdapter<Patient, OtpViewHolder>(patientDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtpViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patients_otp, parent, false)
        return OtpViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: OtpViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }


}