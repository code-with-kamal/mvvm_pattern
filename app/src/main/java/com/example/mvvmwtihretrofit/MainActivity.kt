package com.example.mvvmwtihretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwtihretrofit.adapter.ProductAdapter
import com.example.mvvmwtihretrofit.databinding.ActivityMainBinding
import com.example.mvvmwtihretrofit.errorhandling.ResultRes
import com.example.mvvmwtihretrofit.viewmodal.MyViewModal


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModal: MyViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val text: TextView = findViewById(R.id.txt)
        text.text = "Retrofit Error Handling..."
        val pro: ProgressBar = findViewById(R.id.progress_circular)
        pro.isVisible = true
        myViewModal = ViewModelProvider(this)[MyViewModal::class.java]
        myViewModal.getuserViewModel().observe(this) {
            println("RepositoryRetrofit.onCreate   main Activity $it")
            when (it) {
                ResultRes.Loading -> {
                    binding.txt.text = "Loading Please wait.."
                    binding.txt.isVisible = true
                    println("RepositoryRtrofit.onCreate   loading ")
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                    pro.isVisible = true
                }

                is ResultRes.Error -> {
                    pro.isVisible = false
                    binding.txt.text = "Network problem please check network connetion.."
                    binding.txt.isVisible = true
                    println("RepositoryRtrofit.onCreate   error ${it.exception}")
                    Toast.makeText(this, "Error.${it.exception}", Toast.LENGTH_SHORT).show()
                }

                is ResultRes.Success -> {
                    pro.isVisible = false
                    binding.txt.isVisible = false
                    binding.productRecyclerview.adapter = ProductAdapter(it.data)
                    println("RepositoryRtrofit.onCreate   main sucess ${it.data}")
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}