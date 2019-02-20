package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rgb01.*
import kotlinx.android.synthetic.main.activity_touch04.*

class rgb01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb01)
        var val1 = intent.getStringExtra("answer1")
        rgb_1_b1.setOnClickListener { view->
            var intent = Intent(this,rgb02::class.java)
            intent.putExtra("answer1",val1)
            startActivityForResult(intent,1)
        }
    }
}
