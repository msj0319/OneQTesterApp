package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_proximity01.*

class proximity01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity01)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")

        step4_1_b1.setOnClickListener { view->
            var intent = Intent(this,proximity02::class.java)//step01
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)
        }
    }
}
