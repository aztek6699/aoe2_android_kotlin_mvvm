package com.example.kotlin_mvvm_aoe_2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_aoe_2.R
import com.example.kotlin_mvvm_aoe_2.databinding.ItemGenericBinding
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto

class CivilizationsAdapter(private val mContext: Context) :
    RecyclerView.Adapter<CivilizationsAdapter.MyViewHolder>() {

    private var listener: ((CivilizationDto) -> Unit)? = null

    private var mCivilizationList: List<CivilizationDto> = ArrayList<CivilizationDto>()
    private lateinit var mInflater: LayoutInflater

    fun setOnClickListener(clickListener: ((CivilizationDto) -> Unit)) {
        listener = clickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        mInflater = LayoutInflater.from(parent.context)

        val binding: ItemGenericBinding =
            DataBindingUtil.inflate(mInflater, R.layout.item_generic, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val obj: CivilizationDto = mCivilizationList[position]

        holder.binding.tvName.text = obj.name
        holder.binding.tvExpansion.text = obj.expansion

        holder.binding.tvUniqueName.text = "Army Type:"
        holder.binding.tvUniqueValue.text = obj.armyType

        holder.binding.bg.setOnClickListener {
            listener?.invoke(obj)
        }
    }

    fun renewItems(list: List<CivilizationDto>) {
        mCivilizationList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mCivilizationList.size
    }

    inner class MyViewHolder(
        var binding: ItemGenericBinding
    ) : RecyclerView.ViewHolder(binding.root)
}