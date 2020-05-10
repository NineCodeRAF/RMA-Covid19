package rs.raf.projekat1.Nikola_Adamovic_RN4217.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stanje.*
import kotlinx.android.synthetic.main.fragment_unos.*
import rs.raf.projekat1.Nikola_Adamovic_RN4217.R
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import rs.raf.projekat1.Nikola_Adamovic_RN4217.view.recycler.adapter.CekaonicaAdapter
import rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel.RecyclerViewModel
import java.util.*

class UnosFragment : Fragment(R.layout.fragment_unos) {

    private val recyclerViewModel: RecyclerViewModel by activityViewModels()

    private lateinit var cekaonicaAdapter: CekaonicaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initObservers()
        add()
    }

    private fun add(){
        btn.setOnClickListener {
            var flag = true
            if(edit1.text.toString() == ""){
                flag=false
                txt1.visibility= View.VISIBLE
            }
            if(edit2.text.toString() == ""){
                flag=false
                txt2.visibility= View.VISIBLE
            }
            if(edit3.text.toString() == ""){
                flag=false
                txt3.visibility= View.VISIBLE
            }

            if (flag)
            {
                var i = (recyclerViewModel.getCekaonicaList().size?:0)+(recyclerViewModel.getHospList().size?:0)+(recyclerViewModel.getOtpList().size?:0)+1

                val patient = Patient(
                    i,
                    "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                    edit1.text.toString(),
                    edit2.text.toString(),
                    edit3.text.toString()
                )
                recyclerViewModel.addCek(patient)
                //brojCekaonica.text = recyclerViewModel.getCekaonicaList().size.toString()
                Toast.makeText(this.context,"Pacijent je uspesno dodat", Toast.LENGTH_SHORT).show()
                Toast.makeText(this.context, recyclerViewModel.getCekaonicaList().size.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }


}