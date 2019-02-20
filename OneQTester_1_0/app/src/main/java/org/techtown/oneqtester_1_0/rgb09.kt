package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rgb02.*
import kotlinx.android.synthetic.main.activity_rgb06.*
import kotlinx.android.synthetic.main.activity_rgb09.*

class rgb09 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb09)
        var val1 = intent.getStringExtra("answer1")


        rgb_9_b1.setOnClickListener { view->
            var val2 = "정상"
            var intent = Intent(this,record01::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            startActivityForResult(intent,1)
        }
        rgb_9_b2.setOnClickListener { view->
            var val2 = "비정상"
            var intent = Intent(this,record01::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            startActivityForResult(intent,1)
        }

    }
}
