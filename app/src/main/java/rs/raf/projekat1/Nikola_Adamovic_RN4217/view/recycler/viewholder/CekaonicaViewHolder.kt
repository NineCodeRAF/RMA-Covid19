package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patients_cekaonica.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient

class CekaonicaViewHolder (
    override val containerView: View,
    onZdravBtnClick: (Int) -> Unit,
    onHospBtnClick: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer
    {
        init {
            zdravbtn.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onZdravBtnClick.invoke(adapterPosition)
                }
            }

            hospbtn.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onHospBtnClick.invoke(adapterPosition)
                }
            }

        }

        fun bind(patient: Patient) {
            Picasso.get().load("https://sm.ign.com/t/ign_sr/news/b/baby-yoda-/baby-yoda-is-an-acceptable-name-for-the-mandalorians-breakou_rkrm.h720.jpg").into(imageCIV)
            ime.text = patient.ime
            prezime.text = patient.prezime
            simptomi.text = patient.simptomi
        }
    }
