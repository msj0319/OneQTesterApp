package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_step02.*
import kotlinx.android.synthetic.main.activity_touch01.*

class touch01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch01)
        touch_1_b1.setOnClickListener { view->
            var intent = Intent(this,touch02::class.java)
            startActivity(intent)
        }
    }
}
