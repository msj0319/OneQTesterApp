package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record01.*
import kotlinx.android.synthetic.main.activity_record04.*

class record04 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record04)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")

        record_4_b1.setOnClickListener { view->
            var val3 = "정상"
            var intent = Intent(this,proximity01::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)

        }
        record_4_b2.setOnClickListener { view->
            var val3 = "비정상"
            var intent = Intent(this,proximity01::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)
        }
    }
}
