package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proximity03.*
import kotlinx.android.synthetic.main.activity_proximity05.*

class proximity05 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity05)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")

        step4_5_b1.setOnClickListener { view->
            var val4 = "정상"
            var intent = Intent(this,finalResult::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            intent.putExtra("answer4",val4)
            startActivityForResult(intent,1)

        }
        step4_5_b2.setOnClickListener { view->
            var val4 = "비정상"
            var intent = Intent(this,finalResult::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            intent.putExtra("answer4",val4)
            startActivityForResult(intent,1)
        }
    }
}
