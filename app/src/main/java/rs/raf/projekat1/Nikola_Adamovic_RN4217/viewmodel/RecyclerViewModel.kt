package rs.raf.projekat1.Nikola_Adamovic_RN4217.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.Nikola_Adamovic_RN4217.model.Patient
import java.util.*
import kotlin.random.Random

class RecyclerViewModel : ViewModel() {



    private val cekaonica : MutableLiveData<List<Patient>> = MutableLiveData()
    private val hosp : MutableLiveData<List<Patient>> = MutableLiveData()
    private val otp : MutableLiveData<List<Patient>> = MutableLiveData()

    private val cekaonicaList : MutableList<Patient> = mutableListOf()
    private val hospList : MutableList<Patient> = mutableListOf()
    private val otpList : MutableList<Patient> = mutableListOf()


    init {
        for (i in 1..10) {
            val patient = Patient(
                i,
                "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                "ime$i",
                "prezime$i",
                "simptomi$i"
            )
            cekaonicaList.add(patient)
        }
        val listToSubmit1 = mutableListOf<Patient>()
        listToSubmit1.addAll(cekaonicaList)
        cekaonica.value = listToSubmit1


        for (i in 11..17) {
            val patient = Patient(
                i,
                "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                "ime$i",
                "prezime$i",
                "simptomi$i"
            )
            hospList.add(patient)
        }
        val listToSubmit2 = mutableListOf<Patient>()
        listToSubmit2.addAll(hospList)
        hosp.value = listToSubmit2


        for (i in 18..21) {
            val patient = Patient(
                i,
                "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                "ime$i",
                "prezime$i",
                "simptomi$i"
            )
            otpList.add(patient)
        }
        val listToSubmit3 = mutableListOf<Patient>()
        listToSubmit3.addAll(otpList)
        otp.value = listToSubmit3
    }



    fun getCekaonica() : LiveData<List<Patient>> {
        return cekaonica
    }

    fun getHosp() : LiveData<List<Patient>> {
        return hosp
    }

    fun getOtp() : LiveData<List<Patient>> {
        return otp
    }

    fun getCekaonicaList() : MutableList<Patient> {
        return cekaonicaList
    }

    fun getHospList() : MutableList<Patient> {
        return hospList
    }

    fun getOtpList() : MutableList<Patient> {
        return otpList
    }



    fun filterCekaonica(filter: String) {
        val filteredList = cekaonicaList.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) || it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        cekaonica.value = filteredList
    }

    fun filterHosp(filter: String) {
        val filteredList = hospList.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) || it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        hosp.value = filteredList
    }

    fun filterOtp(filter: String) {
        val filteredList = otpList.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) || it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        otp.value = filteredList
    }

    fun addCek(patient: Patient) {
        cekaonicaList.add(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(cekaonicaList)
        cekaonica.value = listToSubmit
    }

    fun addHosp(patient: Patient) {
        hospList.add(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(hospList)
        hosp.value = listToSubmit
    }

    fun addOtp(patient: Patient) {
        otpList.add(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(otpList)
        otp.value = listToSubmit
    }

    fun removeCek(patient: Patient) {
        cekaonicaList.remove(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(cekaonicaList)
        cekaonica.value = listToSubmit
    }

    fun removeHosp(patient: Patient) {
        hospList.remove(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(hospList)
        hosp.value = listToSubmit
    }

    fun removeOtp(patient: Patient) {
        otpList.remove(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(otpList)
        otp.value = listToSubmit
    }

}