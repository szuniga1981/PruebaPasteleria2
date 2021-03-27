package cl.sebastian.pruebapasteleria

import DetailFragment
import PasteleriaAdapter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sebastian.pruebapasteleria.databinding.FragmentListingBinding

class ListingFragment :Fragment() {

    private lateinit var binding: FragmentListingBinding
    private val viewModel: PasteleriaVM by activityViewModels()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)
        val adapter = PasteleriaAdapter()
        binding.rvListFragment.layoutManager = LinearLayoutManager(context)
        binding.rvListFragment.adapter = adapter
        viewModel.pasteleriaList.observe(viewLifecycleOwner,{
            it?.let {
                adapter.updateList(it)
            }
        })
        adapter.selectedPasteleria().observe(viewLifecycleOwner,{
            viewModel.setSelected(it)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container,DetailFragment())
                ?.addToBackStack("details")
                ?.commit()
        })
    return binding.root
    }
}