package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient

class PatientDiff : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.ime == newItem.ime &&
                oldItem.prezime == newItem.prezime&&
                oldItem.simptomi == newItem.simptomi
    }

}