package org.techtown.oneqtester_1_0

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proximity03.*
import kotlinx.android.synthetic.main.activity_rgb02.*
import kotlinx.android.synthetic.main.activity_rgb04.*
import kotlinx.android.synthetic.main.activity_rgb05.*

class rgb05 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb05)
        rgb_5_b1.setBackgroundColor(Color.GREEN)
        var val1 = intent.getStringExtra("answer1")
        rgb_5_b1.setOnClickListener { view->
            var intent = Intent(this,rgb06::class.java)
            intent.putExtra("answer1",val1)
            startActivityForResult(intent,1)
        }
    }
}
