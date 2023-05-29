package com.exemple.testPFE11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.exemple.testPFE11.databinding.ActivityMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FirestFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_first_, container, false)
        val button= view.findViewById<ImageButton>(R.id.heart)
        val button1= view.findViewById<ImageButton>(R.id.heart1)
        val button2= view.findViewById<ImageButton>(R.id.heart2)
        val button3= view.findViewById<ImageButton>(R.id.heart3)
        val button4= view.findViewById<ImageButton>(R.id.heart4)
        val button5= view.findViewById<ImageButton>(R.id.heart5)
        val button6= view.findViewById<ImageButton>(R.id.heart6)
        val butto= view.findViewById<ImageView>(R.id.image_premier)
        val butto1= view.findViewById<ImageView>(R.id.image_2)
        val butto2= view.findViewById<ImageView>(R.id.image_3)
        val butto3= view.findViewById<ImageView>(R.id.image_4)
        val butto4= view.findViewById<ImageView>(R.id.image_5)
        val butto5= view.findViewById<ImageView>(R.id.image_6)
        val butto6= view.findViewById<ImageView>(R.id.image_7)
        val button_actualise =view.findViewById<Button>(R.id.button_actualise)
        var onClick: Int = 0
        var saha: Int = 0
        var mont: Int = 0
        var compt : Int= 0
        button.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button.setBackgroundColor(resources.getColor(R.color.black))
                compt+=1
            }else{
                button.setBackgroundColor(resources.getColor(R.color.white))
                compt-=1
            }
        }
        button1.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button1.setBackgroundColor(resources.getColor(R.color.black))
                compt+=1
            }else{
                button1.setBackgroundColor(resources.getColor(R.color.white))
                compt-=1
            }
        }
        button2.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button2.setBackgroundColor(resources.getColor(R.color.black))
                compt+=1
            }else{
                button2.setBackgroundColor(resources.getColor(R.color.white))
                compt-=1

            }
        }
        button3.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button3.setBackgroundColor(resources.getColor(R.color.black))
                mont+=1
            }else{
                button3.setBackgroundColor(resources.getColor(R.color.white))
                mont-=1

            }
        }
        button4.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button4.setBackgroundColor(resources.getColor(R.color.black))
                mont+=1
            }else{
                button4.setBackgroundColor(resources.getColor(R.color.white))
                mont-=1
            }
        }
        button5.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button5.setBackgroundColor(resources.getColor(R.color.black))
                saha+=1
            }else{
                button5.setBackgroundColor(resources.getColor(R.color.white))
                saha-=1
            }
        }
        button6.setOnClickListener {
            onClick +=1
            if(onClick > 2) onClick=1
            if(onClick==1){
                button6.setBackgroundColor(resources.getColor(R.color.black))
                saha+=1
            }else{
                button6.setBackgroundColor(resources.getColor(R.color.white))
                saha-=1
            }
        }
        button_actualise.setOnClickListener {

            if(compt>=1){
                butto.setImageResource(R.drawable.naturel_ig4)
                butto6.setImageResource(R.drawable.naturel_ig5)
                compt=0
            }
            if(mont>=1) {
                butto.setImageResource(R.drawable.naturel_mont3)
                butto1.setImageResource(R.drawable.naturel_mont2)
                mont=0
            }
            if(saha>=1){
                butto.setImageResource(R.drawable.naturel_saha2)
                butto1.setImageResource(R.drawable.naturel_sahara3)
                saha=0
            }
            button.setBackgroundColor(resources.getColor(R.color.white))
            button1.setBackgroundColor(resources.getColor(R.color.white))
            button2.setBackgroundColor(resources.getColor(R.color.white))
            button3.setBackgroundColor(resources.getColor(R.color.white))
            button4.setBackgroundColor(resources.getColor(R.color.white))
            button5.setBackgroundColor(resources.getColor(R.color.white))
            button6.setBackgroundColor(resources.getColor(R.color.white))
        }
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Too_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}