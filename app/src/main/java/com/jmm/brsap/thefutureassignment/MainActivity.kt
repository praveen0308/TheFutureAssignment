package com.jmm.brsap.thefutureassignment

import android.R.attr.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmm.brsap.thefutureassignment.adapter.ImageAdapter
import com.jmm.brsap.thefutureassignment.databinding.ActivityMainBinding
import com.jmm.brsap.thefutureassignment.model.ModelImage


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var imageAdapter : ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRvImages()
        imageAdapter.setImageList(getImageList())

    }

    private fun setUpRvImages(){
        imageAdapter = ImageAdapter()
        binding.rvData.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = imageAdapter

        }

    }

    private fun getImageList():List<ModelImage>{
        val images = mutableListOf<ModelImage>()
        images.add(ModelImage(R.drawable.img1))
        images.add(ModelImage(R.drawable.img2))
        images.add(ModelImage(R.drawable.img3))
        images.add(ModelImage(R.drawable.img4))
        images.add(ModelImage(R.drawable.img5))

        return images
    }

    private fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

