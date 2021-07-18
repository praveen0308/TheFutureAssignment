package com.jmm.brsap.thefutureassignment.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jmm.brsap.thefutureassignment.model.ModelImage
import com.jmm.brsap.thefutureassignment.databinding.TemplateImageViewBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val mList = mutableListOf<ModelImage>()

    inner class ImageViewHolder(private val binding: TemplateImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

            binding.imageView.setOnTouchListener { view, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {

                    val lp = ConstraintLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    lp.setMargins(8, 8, 8, 8)
                    view.layoutParams = lp

                } else if (event.action == MotionEvent.ACTION_UP) {

                    val lp = ConstraintLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    lp.setMargins(0, 0, 0, 0)
                    view.layoutParams = lp
                }
                true
            }


        }

        fun bindViews(item: ModelImage) {
            binding.apply {
                imageView.setImageResource(item.imageUrl)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            TemplateImageViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindViews(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setImageList(mList: List<ModelImage>) {
        this.mList.clear()
        this.mList.addAll(mList)
        notifyDataSetChanged()
    }
}