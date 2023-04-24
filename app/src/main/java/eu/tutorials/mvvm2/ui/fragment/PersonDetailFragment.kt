package eu.tutorials.mvvm2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorials.mvvm2.R
import eu.tutorials.mvvm2.databinding.FragmentPersonDetailBinding
import eu.tutorials.mvvm2.ui.vievmodel.PersonDetailViewModel

@AndroidEntryPoint
class PersonDetailFragment : Fragment() {

    private lateinit var binding:FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail,container,false)

        binding.personDetailFragment=this
        binding.toolbarDetailTitle="Details"

        //fragmenttan fragmenta veri aktarma
        val bundle:PersonDetailFragmentArgs by navArgs()
        val person=bundle.person
        //xml person= main fragmenttan alınan person
        binding.person=person

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:PersonDetailViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun btnUpdatePerson(id:Int,name:String,gsm:String){
        viewModel.updatePerson(id,name,gsm)
    }

}