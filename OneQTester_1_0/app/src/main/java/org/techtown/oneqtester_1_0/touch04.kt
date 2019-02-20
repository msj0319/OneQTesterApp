package org.techtown.oneqtester_1_0

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_touch01.*
import kotlinx.android.synthetic.main.activity_touch04.*

class touch04 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch04)
        touch_4_b1.setOnClickListener { view->//네
            var intent = Intent(this,rgb01::class.java)
            intent.putExtra("answer1","정상")
            startActivityForResult(intent,1)
        }
        touch_4_b2.setOnClickListener { view->
            var intent = Intent(this,rgb01::class.java)
            intent.putExtra("answer1","비정상")
            startActivityForResult(intent,1)

        }
    }
}
