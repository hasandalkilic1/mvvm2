package eu.tutorials.mvvm2.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import eu.tutorials.mvvm2.R
import eu.tutorials.mvvm2.data.entity.Person
import eu.tutorials.mvvm2.databinding.CardDesignBinding
import eu.tutorials.mvvm2.ui.fragment.MainScreenFragmentDirections
import eu.tutorials.mvvm2.ui.vievmodel.MainScreenViewModel
import eu.tutorials.mvvm2.util.transition

class PersonAdapter(var context:Context, var personList:List<Person>,var viewModel:MainScreenViewModel)
    :RecyclerView.Adapter<PersonAdapter.mViewHolder>() {
    inner class mViewHolder(binding:CardDesignBinding):RecyclerView.ViewHolder(binding.root){
        var binding:CardDesignBinding
        init {
            this.binding=binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val layoutInflater=LayoutInflater.from(context)
        val binding:CardDesignBinding=DataBindingUtil.inflate(layoutInflater, R.layout.card_design,parent,false)
        return mViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val person= personList[position]
        val b=holder.binding

        b.person=person

        b.ivDelete.setOnClickListener {
            Snackbar.make(it,"Are you sure you want to delete ${person.name}?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.personDelete(person.id)
                }.show()
        }

        b.mainCardView.setOnClickListener {view->
            val transition= MainScreenFragmentDirections.detailTransition(person=person)
            Navigation.transition(transition, view)
        }
    }


}