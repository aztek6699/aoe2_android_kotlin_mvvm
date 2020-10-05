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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_mvvm_aoe_2.R
import com.example.kotlin_mvvm_aoe_2.adapters.CivilizationsAdapter
import com.example.kotlin_mvvm_aoe_2.databinding.FragmentCivilizationsBinding

class CivilizationFragment : Fragment() {

    private lateinit var binding: FragmentCivilizationsBinding
    private lateinit var viewModel: CivilizationViewModel
    private lateinit var mContext: Context
    private lateinit var mCivilizationAdapter: CivilizationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_civilizations, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { mContext = it }
        viewModel = ViewModelProvider(this).get(CivilizationViewModel::class.java)

        initUi()
        initData()
        initListeners()
    }

    private fun initUi() {
        mCivilizationAdapter = CivilizationsAdapter(mContext)
        val layoutManager = LinearLayoutManager(mContext)
        binding.rvCivilizations.layoutManager = layoutManager
        binding.rvCivilizations.itemAnimator = DefaultItemAnimator()
        binding.rvCivilizations.adapter = mCivilizationAdapter
    }

    private fun initData() {
        viewModel.getAllCivilizations().observe(viewLifecycleOwner, Observer { list ->
            mCivilizationAdapter.renewItems(list)
        })
    }

    private fun initListeners() {
        mCivilizationAdapter.setOnClickListener {
            Log.d(TAG, "civilization adapter on click: " + it.name)
        }
    }

    companion object {
        private val TAG = CivilizationFragment::class.java.simpleName
    }
}