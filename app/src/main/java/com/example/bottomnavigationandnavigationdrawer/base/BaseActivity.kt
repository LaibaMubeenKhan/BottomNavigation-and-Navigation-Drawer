package com.example.bottomnavigationandnavigationdrawer.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<VB: ViewBinding,VM:ViewModel>:AppCompatActivity() {
    lateinit var binding: VB
    lateinit var viewModel:VM

    abstract fun getViewModelClass(): Class<VM>
    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // for viewBinding
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
        //for view model
        viewModel= ViewModelProvider(this).get(getViewModelClass())

        // calling Abstract method
        initViews()
    }


    abstract fun initViews()


}