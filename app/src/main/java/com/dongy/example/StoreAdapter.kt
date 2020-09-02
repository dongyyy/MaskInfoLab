package com.dongy.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dongy.example.model.Store
import kotlinx.android.synthetic.main.item_store.view.*

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder>() {
    var storeList : List<Store> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //viewHolder 만드는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_store, parent, false)
        return StoreViewHolder(view)
    }

    override fun getItemCount(): Int
            = storeList.size

    //viewHolder를 가지고 실제 데이터를 표시하는 부분
    override fun onBindViewHolder(holder: StoreViewHolder, position: Int)
            = holder.bind(storeList[position])

}

//item view 정보를 가지고 있는 클래
class StoreViewHolder(view : View) : RecyclerView.ViewHolder(view){
    fun bind(store: Store){
        with(itemView){
            name_text_view.text = store.name
            addr_text_view.text = store.addr
            distance_text_view.text = "1.0km"
            remain_text_view.text = store.remainStat
            count_text_view.text = "100개 이상"
        }
    }
}
