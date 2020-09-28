package com.example.kotlin_mvvm_aoe_2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_aoe_2.R
import com.example.kotlin_mvvm_aoe_2.databinding.ItemGenericBinding
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto

class StructuresAdapter(private val mContext: Context) :
    RecyclerView.Adapter<StructuresAdapter.MyViewHolder>() {

    private var listener: ((StructureDto) -> Unit)? = null

    private var mStructureList: List<StructureDto> = ArrayList<StructureDto>()
    private lateinit var mInflater: LayoutInflater

    fun setOnClickListener(clickListener: ((StructureDto) -> Unit)) {
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
        val obj: StructureDto = mStructureList[position]

        holder.binding.tvName.text = obj.name
        holder.binding.tvExpansion.text = obj.expansion

        holder.binding.tvUniqueName.text = "Age:"
        holder.binding.tvUniqueValue.text = obj.age

        holder.binding.bg.setOnClickListener {
            listener?.invoke(obj)
        }
    }

    fun renewItems(list: List<StructureDto>) {
        mStructureList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mStructureList.size
    }

    inner class MyViewHolder(
        var binding: ItemGenericBinding
    ) : RecyclerView.ViewHolder(binding.root)
}