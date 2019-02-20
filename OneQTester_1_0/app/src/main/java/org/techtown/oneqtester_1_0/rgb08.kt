package org.techtown.oneqtester_1_0

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rgb02.*
import kotlinx.android.synthetic.main.activity_rgb04.*
import kotlinx.android.synthetic.main.activity_rgb06.*
import kotlinx.android.synthetic.main.activity_rgb08.*

class rgb08 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb08)
        rgb_8_b1.setBackgroundColor(Color.BLACK)
        var val1 = intent.getStringExtra("answer1")
        rgb_8_b1.setOnClickListener { view->
            var intent = Intent(this,rgb09::class.java)
            intent.putExtra("answer1",val1)
            startActivityForResult(intent,1)
        }
    }
}
