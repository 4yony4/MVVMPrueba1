package com.eurekamps.mvvmprueba1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class ThirdFragment : Fragment(),View.OnClickListener {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: MainActivityViewModel
    lateinit var tvHello:TextView
    lateinit var btnChange:Button
    lateinit var btnback:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mainActivity = activity as MainActivity
        viewModel = ViewModelProvider(mainActivity).get(MainActivityViewModel::class.java)
        setObservables()

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvHello=view.findViewById(R.id.tvHello)
        btnChange=view.findViewById(R.id.btnChange)
        btnChange.setOnClickListener(this)
        btnback=view.findViewById(R.id.btnback)
        btnback.setOnClickListener(this)
        //tvHello.text=viewModel.text
    }



    fun setObservables(){
        viewModel.text.observe(viewLifecycleOwner, Observer {
            tvHello.text=it
        })
    }

    override fun onClick(v: View?) {
        if(v==btnChange){
            viewModel.updateText("ESTOY EN EL THIRD")
        }
        else if(v==btnback){
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }
    }

}