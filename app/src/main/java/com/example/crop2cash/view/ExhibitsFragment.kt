package com.example.crop2cash.view

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crop2cash.adapter.ExhibitsTitleAdapter
import com.example.crop2cash.base.BaseFragment
import com.example.crop2cash.databinding.FragmentExhibitsBinding
import com.example.crop2cash.model.Exhibit
import com.example.crop2cash.viewmodel.ExhibitsViewmodel
import javax.inject.Inject

class ExhibitsFragment : BaseFragment() {
    private lateinit var binding: FragmentExhibitsBinding
    @Inject
    lateinit var exhibitsViewModel: ExhibitsViewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExhibitsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE
        exhibitsViewModel = exhibitsComponent.getExhibitsViewModel()
        getExhibitsList()
    }

    private fun getExhibitsList() {
        exhibitsViewModel.getExhibitsList()?.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, "SUCCESS", Toast.LENGTH_LONG).show()
            displayExhibitsList(it!!)
        })
        showConnectionTimeoutErrorMessage()
    }

    private fun displayExhibitsList(exhibitList: List<Exhibit>) {
        binding.progressBar.visibility = View.INVISIBLE
        val exhibitsTitleAdapter = ExhibitsTitleAdapter()
        exhibitsTitleAdapter.exhibitsList = exhibitList
        binding.rvParent.adapter = exhibitsTitleAdapter
        binding.rvParent.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun showConnectionTimeoutErrorMessage() {
        binding.progressBar.visibility = View.GONE
        exhibitsViewModel.getNetworkErrorMessage().observe(viewLifecycleOwner, Observer {
            showToast("Please Check your Internet Connection")
        })
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(activity, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}