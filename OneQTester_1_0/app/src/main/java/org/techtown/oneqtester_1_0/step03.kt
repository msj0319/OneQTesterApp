package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_step01.*
import kotlinx.android.synthetic.main.activity_step02.*
import kotlinx.android.synthetic.main.activity_step03.*
import kotlinx.android.synthetic.main.activity_touch01.*

class step03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step03)
        button4.setOnClickListener { view->
            var intent = Intent(this,touch01::class.java)
            startActivity(intent)
        }
    }
}
