package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record01.*
import kotlinx.android.synthetic.main.activity_rgb01.*

class record01 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record01)
        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")

        record_1_b1.setOnClickListener { view->
            var intent = Intent(this,record02::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            startActivityForResult(intent,1)
        }

    }
}
