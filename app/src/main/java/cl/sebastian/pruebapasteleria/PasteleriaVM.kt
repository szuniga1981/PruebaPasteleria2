package cl.sebastian.pruebapasteleria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

class PasteleriaVM:ViewModel() {


    val repository=PasteleriaRepository()
    val razimoList=repository.pasteleriaList
    val detailRazimo=repository.detailPasteleria
    private val detail=MutableLiveData<Cakes>()

    init {
       Timber.d("PasteleriaVm")
        viewModelScope.launch {
            repository.getPasteleriaFromApi()
        }
    }
    private lateinit var  selectedPasteleria:Cakes

    fun setSelected(cakes: Cakes){
        selectedPasteleria=cakes
    }
    fun getDetail():LiveData<Cakes>{
        return  repository.getProducts(selectedPasteleria.id)
    }
}