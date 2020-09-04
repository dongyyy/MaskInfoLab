package com.dongy.example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dongy.example.databinding.ItemStoreBinding
import com.dongy.example.model.Store

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder>() {
    var storeList: List<Store> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // viewHolder 만드는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreBinding.inflate(inflater, parent, false)
        return StoreViewHolder(binding)
    }

    override fun getItemCount(): Int = storeList.size

    // viewHolder를 가지고 실제 데이터를 표시하는 부분
    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) =
        holder.bind(storeList[position])
}

// item view 정보를 가지고 있는 클래
class StoreViewHolder(private val binding: ItemStoreBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(store: Store) {
        with(itemView) {
            binding.apply {
                nameTextView.text = store.name
                addrTextView.text = store.addr
                distanceTextView.text = "1.0km"
                remainTextView.text = store.remainStat
                countTextView.text = "100개 이상"
            }
        }
    }
}
