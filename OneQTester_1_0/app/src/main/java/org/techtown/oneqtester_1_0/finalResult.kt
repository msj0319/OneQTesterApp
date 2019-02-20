package org.techtown.oneqtester_1_0

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final_result.*
import kotlinx.android.synthetic.main.activity_main.*

class finalResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")
        var val4 = intent.getStringExtra("answer4")

        final_1_t3.text=val1
        final_1_t5.text=val2
        final_1_t7.text=val3
        final_1_t9.text=val4

    }
}
