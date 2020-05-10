package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patients_cekaonica.*
import kotlinx.android.synthetic.main.layout_patients_cekaonica.imageCIV
import kotlinx.android.synthetic.main.layout_patients_cekaonica.ime
import kotlinx.android.synthetic.main.layout_patients_cekaonica.prezime
import kotlinx.android.synthetic.main.layout_patients_cekaonica.simptomi
import kotlinx.android.synthetic.main.layout_patients_hosp.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient

class HospViewHolder(
    override val containerView: View,
    onKartonBtnClick: (Int) -> Unit,
    onOtpBtnClick: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer
{
    init {
        kartonbtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onKartonBtnClick.invoke(adapterPosition)
            }
        }

        otpustbtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onOtpBtnClick.invoke(adapterPosition)
            }
        }

    }

    fun bind(patient: Patient) {
        Picasso.get().load("https://sm.ign.com/t/ign_sr/news/b/baby-yoda-/baby-yoda-is-an-acceptable-name-for-the-mandalorians-breakou_rkrm.h720.jpg").into(imageCIV)
        ime.text = patient.ime
        prezime.text = patient.prezime
    }
}
