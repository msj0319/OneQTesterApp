package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_touch01.*
import kotlinx.android.synthetic.main.activity_touch02.*

class touch02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch02)
        touch_2_b1.setOnClickListener { view->
            var intent = Intent(this,touch03::class.java)
            startActivity(intent)
        }
        touch_2_b2.setOnClickListener { view->
            var intent = Intent(this,touch04::class.java)
            startActivity(intent)
        }
    }
}
