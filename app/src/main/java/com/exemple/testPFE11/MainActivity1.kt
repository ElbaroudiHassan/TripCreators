package com.exemple.testPFE11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.testpfe11.HomeMainActivity2
import com.example.testpfe11.ImageAdapter
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlin.math.absoluteValue

class MainActivity1 : AppCompatActivity() {

    ///
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var signIn:Button


    ////
    private lateinit var callbackManager:CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
       val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
                val intent2 = Intent(this,Page3::class.java)
                startActivity(intent2)
        }
        ////
        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
        ///
         signIn= findViewById(R.id.sing_in)
        callbackManager=CallbackManager.Factory.create()
        val accessToken= AccessToken.getCurrentAccessToken()
        if(accessToken!=null && !accessToken.isExpired){
            startActivity(Intent(this, HomeMainActivity2::class.java))
            finish()
        }
        LoginManager.getInstance().registerCallback(callbackManager,
            object :FacebookCallback<LoginResult>{
                override fun onCancel() {
                }
                override fun onError(error: FacebookException) {

                }
                override fun onSuccess(result: LoginResult) {
                    startActivity(Intent(this@MainActivity1, HomeMainActivity2::class.java))
                    finish()
                }
            })
        signIn.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this , listOf("public_prorifil,email"))
        }

    }
    /////
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)

    }
    private val runnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(20))
        transformer.addTransformer{  page,position ->
            val r = 1 - position.absoluteValue
            page.scaleY = 0.84f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }
    private fun init(){
        viewPager2 = findViewById(R.id.viewPage2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()
        imageList.add(R.drawable.main1)
        imageList.add(R.drawable.ilgheman)
        imageList.add(R.drawable.mosem)
        imageList.add(R.drawable.too)
        adapter = ImageAdapter(imageList,viewPager2)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
    //////

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)

    }
}