package com.example.kotlin_mvvm_aoe_2.modules.structures

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
import com.example.kotlin_mvvm_aoe_2.adapters.StructuresAdapter
import com.example.kotlin_mvvm_aoe_2.databinding.FragmentStructuresBinding

class StructuresFragment : Fragment() {

    private lateinit var binding: FragmentStructuresBinding
    private lateinit var mContext: Context
    private lateinit var viewModel: StructuresViewModel
    private lateinit var mStructuresAdapter: StructuresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_structures, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { mContext = it }
        viewModel = ViewModelProvider(this).get(StructuresViewModel::class.java)

        initUi()
        initData()
        initListeners()
    }

    private fun initUi() {
        mStructuresAdapter = StructuresAdapter(mContext)
        val layoutManager = LinearLayoutManager(mContext)
        binding.rvStructures.layoutManager = layoutManager
        binding.rvStructures.itemAnimator = DefaultItemAnimator()
        binding.rvStructures.adapter = mStructuresAdapter
    }

    private fun initData() {
        viewModel.getAllStructures().observe(viewLifecycleOwner, Observer { list ->
            mStructuresAdapter.renewItems(list)
        })
    }

    private fun initListeners() {
        mStructuresAdapter.setOnClickListener { it ->
            Log.d(TAG, "structure adapter on click: " + it.name)
        }
    }

    companion object {
        private val TAG = StructuresAdapter::class.java.simpleName
    }
}