import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.sebastian.pruebapasteleria.PasteleriaVM
import cl.sebastian.pruebapasteleria.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val viewModel:PasteleriaVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
        viewModel.getDetail().observe(viewLifecycleOwner,{
            it?.let {

                //binding.ivDetail.load(it.images.src)
            }
        })
        return binding.root
    }
}