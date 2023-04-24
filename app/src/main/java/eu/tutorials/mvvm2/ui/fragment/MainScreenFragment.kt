package eu.tutorials.mvvm2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorials.mvvm2.R
import eu.tutorials.mvvm2.data.entity.Person
import eu.tutorials.mvvm2.databinding.FragmentMainScreenBinding
import eu.tutorials.mvvm2.ui.adapters.PersonAdapter
import eu.tutorials.mvvm2.ui.vievmodel.MainScreenViewModel
import eu.tutorials.mvvm2.util.transition

@AndroidEntryPoint
class MainScreenFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding:FragmentMainScreenBinding
    private lateinit var viewModel:MainScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen,container,false)

        binding.mainScreenFragment=this
        binding.toolbarMainScreenTitle="Members"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainScreen)

        viewModel.personList.observe(viewLifecycleOwner){
            val adapter=PersonAdapter(requireContext(),it,viewModel)
            binding.personAdapter=adapter
        }




        requireActivity().addMenuProvider(object:MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_main_screen_menu,menu)

                val item = menu.findItem(R.id.action_search)

                val searchView=item.actionView as SearchView

                searchView.setOnQueryTextListener(this@MainScreenFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:MainScreenViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun onClickFab(view:View){
        Navigation.transition(R.id.registerTransition,view)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchWord:String){
        viewModel.search(searchWord)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllPerson()
    }

}