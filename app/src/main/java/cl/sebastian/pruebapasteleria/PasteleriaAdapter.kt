import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.sebastian.pruebapasteleria.Cakes
import cl.sebastian.pruebapasteleria.databinding.ItemListBinding
import coil.load
import timber.log.Timber

class PasteleriaAdapter:RecyclerView.Adapter<PasteleriaAdapter.PasteleriaVH>() {


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


    class PasteleriaVH(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cakes: Cakes) {
            binding.ivImage.load(cakes.image)
            binding.tvTitle.text = cakes.title
            binding.tvSize.text = cakes.size
            binding.tvPrice.text = cakes.price.toString()
            binding.tvPreiewDes.text = cakes.previewDescription
        }
    }
}




