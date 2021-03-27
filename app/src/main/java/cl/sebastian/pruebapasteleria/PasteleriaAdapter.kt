package cl.sebastian.pruebapasteleria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.sebastian.pruebapasteleria.databinding.ItemListBinding
import timber.log.Timber

class PasteleriaAdapter:RecyclerView.Adapter<PasteleriaVH>() {

    private var pasteleriaList = listOf<Cakes>()
    private val selectedProduct = MutableLiveData<Cakes>()
    fun selectedPasteleria(): LiveData<Cakes> = selectedProduct
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasteleriaVH {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return PasteleriaVH(binding)
    }

    override fun onBindViewHolder(holder: PasteleriaVH, position: Int) {
        val products = pasteleriaList[position]
        holder.bind(products)
        holder.itemView.setOnClickListener {
            Timber.d("mostrando DetailFragment")
            selectedProduct.value = products
        }
    }

    override fun getItemCount(): Int {
        return pasteleriaList.size
    }

    fun updateList(lista: List<Cakes>) {
        pasteleriaList = lista
        notifyDataSetChanged()

    }
}

class PasteleriaVH (val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(products: Products) {

    }
}
