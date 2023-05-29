package com.example.testpfe11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.exemple.testPFE11.MainActivity1
import com.exemple.testPFE11.R
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.login.LoginManager
import org.json.JSONObject

class HomeMainActivity2 : AppCompatActivity() {
    private lateinit var fbImage: ImageView
    private lateinit var fbName:TextView
    private lateinit var fbId:TextView
    private lateinit var fbEmail:TextView
    private lateinit var fbLogout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main2)
        fbImage= findViewById(R.id.fb_image)
        fbName= findViewById(R.id.fb_name)
        fbId= findViewById(R.id.fb_id)
        fbEmail= findViewById(R.id.fb_email)
        fbLogout=findViewById(R.id.fb_log_out)
        val accessToken=AccessToken.getCurrentAccessToken()
        val request=GraphRequest.newMeRequest(accessToken,
            object : GraphRequest.GraphJSONObjectCallback {
                override fun onCompleted(`object`: JSONObject?, response: GraphResponse?) {
                    val id=`object`?.getString("id")
                    val email=`object`?.getString("email")
                    val fullname=`object`?.getString("name")
                    val profileurl=`object`?.getJSONObject("picture")
                        ?.getJSONObject("data")?.getString("url")
                    fbName.text=fullname
                    fbId.text=id
                    fbEmail.text=email
                    Glide.with(applicationContext).load(profileurl).into(fbImage)

                }
            })

        val parameters=Bundle()
        parameters.putString("feild","id,name,link,picture.type(large),email")
        request.parameters=parameters
        request.executeAsync()
        fbLogout.setOnClickListener {
            LoginManager.getInstance().logOut()
            startActivity(Intent(this, MainActivity1::class.java))
            finish()
        }








        }
}