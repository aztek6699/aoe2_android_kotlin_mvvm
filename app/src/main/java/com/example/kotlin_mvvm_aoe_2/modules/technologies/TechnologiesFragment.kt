package com.example.kotlin_mvvm_aoe_2.modules.technologies

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
import com.example.kotlin_mvvm_aoe_2.adapters.TechnologiesAdapter
import com.example.kotlin_mvvm_aoe_2.databinding.FragmentTechnologiesBinding

class TechnologiesFragment : Fragment() {

    private lateinit var binding: FragmentTechnologiesBinding
    private lateinit var mContext: Context
    private lateinit var viewModel: TechnologiesViewModel
    private lateinit var mTechnologiesAdapter: TechnologiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_technologies, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { mContext = it }
        viewModel = ViewModelProvider(this).get(TechnologiesViewModel::class.java)

        initUi()
        initData()
        initListeners()
    }

    private fun initUi() {
        mTechnologiesAdapter = TechnologiesAdapter(mContext)
        val layoutManager = LinearLayoutManager(mContext)
        binding.tvTechnologies.layoutManager = layoutManager
        binding.tvTechnologies.itemAnimator = DefaultItemAnimator()
        binding.tvTechnologies.adapter = mTechnologiesAdapter
    }

    private fun initData() {
        viewModel.getAllTechnologies().observe(viewLifecycleOwner, Observer { list ->
            mTechnologiesAdapter.renewItems(list)
        })
    }

    private fun initListeners() {
        mTechnologiesAdapter.setOnClickListener { it ->
            Log.d(TAG, "structure adapter on click: " + it.name)
        }
    }

    companion object {
        private val TAG = TechnologiesFragment::class.java.simpleName
    }
}