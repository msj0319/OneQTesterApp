package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proximity01.*
import kotlinx.android.synthetic.main.activity_proximity03.*

class proximity03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity03)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")

        step4_3_b1.setOnClickListener { view->
            var intent = Intent(this,proximity04::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)
        }
    }
}
