package com.example.mvvmwtihretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmwtihretrofit.databinding.SingleProductLayoutBinding
import com.example.mvvmwtihretrofit.modal.ProductData

class ProductAdapter(val dataList: ProductData) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private var binding: SingleProductLayoutBinding? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SingleProductLayoutBinding.inflate(inflater, parent, false)
        return ProductHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        Glide.with(holder.itemView.context).load(dataList[position].image)
            .into(holder.binding.imageview)
        holder.binding.title.text=dataList[position].title
        holder.binding.description.text=dataList[position].description
        holder.binding.price.text=dataList[position].price.toString()
    }

    class ProductHolder(val binding: SingleProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}