package com.example.kotlin_mvvm_aoe_2.modules.civilizations

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_mvvm_aoe_2.R
import com.example.kotlin_mvvm_aoe_2.databinding.FragmentCivilizationDetailBinding
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto

class CivilizationDetailFragment : Fragment() {

    private lateinit var binding: FragmentCivilizationDetailBinding
    private lateinit var mContext: Context
    private lateinit var viewModel: CivilizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_civilization_detail,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { mContext = it }
        viewModel = ViewModelProvider(requireActivity()).get(CivilizationViewModel::class.java)

        initData()
    }

    private fun initData() {
        viewModel.civilizationDto.observe(viewLifecycleOwner, Observer { civDto ->
            Log.d(TAG, "initUi: " + civDto.name)
            initUi(civDto)
        })
    }

    private fun initUi(obj: CivilizationDto) {
        binding.tvId.text = obj.id.toString()
        binding.tvName.text = obj.name
        binding.tvExpansion.text = obj.expansion
        binding.tvArmyType.text = obj.armyType
        binding.tvTeamBonus.text = obj.teamBonus
    }

    companion object {
        private val TAG = CivilizationDetailFragment::class.java.simpleName
    }
}