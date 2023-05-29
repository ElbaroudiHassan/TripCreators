package com.exemple.testPFE11
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.exemple.testPFE11.*
import com.exemple.testPFE11.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val fragmentListtttt = ArrayList<fortFragment>()


        val fragmentList = arrayListOf(FirestFragment(), Too_Fragment(),Three_Fragment(),Four_Fragment())
        val expectedList: ArrayList<Any> = fragmentList as ArrayList<Any>
        binding.apply {
            viewPage2.adapter=
                VeiwPageAdaptre(fragmentList ,this@MainActivity.supportFragmentManager,lifecycle )
            TabLayoutMediator( tabLayout, viewPage2){tab, positoin ->
                when(positoin){
                    0 ->{tab.text="Home"
                        tab.icon= ContextCompat.getDrawable(this@MainActivity, R.drawable.home_24)
                    }
                    1->{tab.text="Service ${positoin +1}"
                        tab.icon= ContextCompat.getDrawable(this@MainActivity, R.drawable.service)
                    }
                    2->{tab.text="Contact ${positoin +2}"
                        tab.icon= ContextCompat.getDrawable(this@MainActivity, R.drawable.contacts)
                    }
                    3->{tab.text="Maps"
                        tab.icon= ContextCompat.getDrawable(this@MainActivity, R.drawable.map)
                    }
                }
            }.attach()
        }
    }

}