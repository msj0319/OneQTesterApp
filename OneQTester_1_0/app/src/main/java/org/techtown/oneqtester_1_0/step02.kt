package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_step01.*
import kotlinx.android.synthetic.main.activity_step02.*

class step02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step02)
        button3.setOnClickListener { view->
            var intent = Intent(this,step03::class.java)
            startActivity(intent)
        }
    }
}
