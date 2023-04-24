package eu.tutorials.mvvm2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorials.mvvm2.R
import eu.tutorials.mvvm2.databinding.FragmentRegisterBinding
import eu.tutorials.mvvm2.ui.vievmodel.RegisterViewModel

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding:FragmentRegisterBinding
    private lateinit var viewModel:RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_register,container,false)

        binding.registerFragment=this
        binding.toolbarRegisterTitle="Registration"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:RegisterViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun btn_register(name:String,gsm:String){
        viewModel.register(name,gsm)
    }
}