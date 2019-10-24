package com.vama.hidoc

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class AdapterData(private val mContext: Context, private val itemsList: List<Resultarray>) : RecyclerView.Adapter<AdapterData.SingleItemRowHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SingleItemRowHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_single_card, null)
        return SingleItemRowHolder(v)
    }

    override fun onBindViewHolder(holder: SingleItemRowHolder, i: Int) {

        val sublist = itemsList[i]
        holder.tvTitle.text = sublist.title
        holder.tv_url.text = sublist.pagelink
        Glide.with(mContext).load(sublist.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .into(holder.itemImage)
        holder.tv_des.text = Html.fromHtml(sublist.description)

    }


    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class SingleItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal val tvTitle: TextView = view.findViewById(R.id.tv_name)
        internal val itemImage: ImageView = view.findViewById(R.id.img_android)
        internal val tv_des: TextView = view.findViewById(R.id.tv_des)
        internal val tv_url: TextView = view.findViewById(R.id.tv_url)



    }

}