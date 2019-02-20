package org.techtown.oneqtester_1_0

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_touch03.*
import android.widget.LinearLayout



class touch03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch03)
        val ll = LinearLayout(this) // 여러 뷰를 합칠 컨테이너
        ll.orientation = LinearLayout.VERTICAL

        val m = MyView(this@touch03)

        ll.addView(m) // 리니어레이아웃에 포함시킴
        setContentView(ll)
    }
}

internal class MyView(context: Context) : View(context) {
    var paint = Paint()
    var path = Path()    // 자취를 저장할 객체

    init {
        paint.setStyle(Paint.Style.STROKE) // 선이 그려지도록
        paint.setStrokeWidth(8f) // 선의 굵기 지정
    }

    protected override fun onDraw(canvas: Canvas) { // 화면을 그려주는 메서드
        canvas.drawPath(path, paint) // 저장된 path 를 그려라
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(x, y) // 자취에 그리지 말고 위치만 이동해라
            MotionEvent.ACTION_MOVE -> path.lineTo(x, y) // 자취에 선을 그려라
            MotionEvent.ACTION_UP -> {
            }
        }

        invalidate() // 화면을 다시그려라

        return true
    }
}
/*
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.Touch
import android.text.method.Touch.onTouchEvent
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_touch01.*
import kotlinx.android.synthetic.main.activity_touch03.*
import kotlinx.android.synthetic.main.activity_touch04.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class touch03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch03)
        //뒤로가기 터치 시 다음 액티비티 실행하게 만들기

        touch_3_b1.setOnClickListener { view->
            var intent = Intent(this,touch04::class.java)
            startActivity(intent)
        }

        val view = MyView(this)
        setContentView(view)
    }
    protected inner class MyView(context: Context) : View(context) {

        override fun onTouchEvent(event: MotionEvent): Boolean {
            // TODO Auto-generated method stub
            super.onTouchEvent(event)

            //event
            //event 종류/각각의 특성

            if (event.action == MotionEvent.ACTION_DOWN) {

                val x = event.x
                val y = event.y

                val msg = "터치를 입력받음 : $x / $y"

                Toast.makeText(this@touch03, msg, Toast.LENGTH_SHORT).show()
                return true
            }

            return false
        }
    }
}




*/

