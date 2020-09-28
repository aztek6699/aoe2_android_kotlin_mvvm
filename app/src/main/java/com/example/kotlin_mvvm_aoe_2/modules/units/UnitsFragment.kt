package com.example.kotlin_mvvm_aoe_2.modules.units

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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_mvvm_aoe_2.R
import com.example.kotlin_mvvm_aoe_2.adapters.UnitsAdapter
import com.example.kotlin_mvvm_aoe_2.databinding.FragmentUnitsBinding
import com.example.kotlin_mvvm_aoe_2.modules.technologies.TechnologiesFragment

class UnitsFragment : Fragment() {

    private lateinit var binding: FragmentUnitsBinding
    private lateinit var mContext: Context
    private lateinit var viewModel: UnitsViewModel
    private lateinit var mUnitsAdapter: UnitsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_units, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { mContext = it }
        viewModel = ViewModelProvider(this).get(UnitsViewModel::class.java)

        initUi()
        initData()
        initListeners()
    }

    private fun initUi() {
        mUnitsAdapter = UnitsAdapter(mContext)
        val layoutManager = LinearLayoutManager(mContext)
        binding.rvUnits.layoutManager = layoutManager
        binding.rvUnits.itemAnimator = DefaultItemAnimator()
        binding.rvUnits.adapter = mUnitsAdapter
    }

    private fun initData() {
        viewModel.getAllUnits().observe(viewLifecycleOwner, Observer { list ->
            mUnitsAdapter.renewItems(list)
        })
    }

    private fun initListeners() {
        mUnitsAdapter.setOnClickListener { it ->
            Log.d(TAG, "structure adapter on click: " + it.name)
        }
    }

    companion object {
        private val TAG = TechnologiesFragment::class.java.simpleName
    }

}