package rs.raf.projekat1.Nikola_Adamovic_RN4217.model

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.util.*

data class Patient(
    val id: Int,
    val picture: String,

    val ime: String,
    val prezime: String,
    val simptomi: String

)

