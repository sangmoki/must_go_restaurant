package com.sangmoki.must_go_restaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*

// 이미지와 텍스트, 링크 정보를 담기 위해 모델 자체를 받는다.
class RvAdapter(val context : Context, val List : MutableList<DataModel>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {

        return List.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // 바인딩
        fun bindItems(item : DataModel) {

            val rv_img = itemView.findViewById<ImageView>(R.id.rv_imageArea)
            val rv_txt = itemView.findViewById<TextView>(R.id.rv_textArea)

            rv_txt.text = item.titleText

            // 글라이드 라이브러리를 사용하여 이미지 로드
            Glide.with(context)
                .load(item.titleImageUrl)
                .into(rv_img)
        }
    }

}