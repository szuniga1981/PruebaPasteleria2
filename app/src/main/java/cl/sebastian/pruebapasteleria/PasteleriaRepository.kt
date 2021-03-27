package cl.sebastian.pruebapasteleria

import androidx.lifecycle.LiveData
import timber.log.Timber

class PasteleriaRepository {

    private val pasteleriaDao=PasteleriaApplication.pasteleriaDatabase!!.pasteleriaDao()
    val pasteleriaList=pasteleriaDao.getProducts()
    val detailPasteleria=pasteleriaDao.getProducts()

    suspend fun getPasteleriaFromApi(){
        Timber.d("buscandodatos")
        val response = RetrofitClient.retrofitCliente().getProducts()
        Timber.d("buscandodatosdespues")



        when (response.isSuccessful){
            true-> {
                response.body()?.let {
                    pasteleriaDao.insertProducts(it)
                    Timber.d(" getPasteleriaFromApi con :${it.size} Pasteleria")
                }
            }
            false ->
                Timber.d(" getPasteleriafalse: ${response.code()}")
        }
    }
    fun getProducts(code:Int): LiveData<Cakes> {
        return  pasteleriaDao.getProductsDetail(code)
    }
}