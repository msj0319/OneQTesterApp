package org.techtown.oneqtester_1_0


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.hardware.SensorManager
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.widget.Toast
import android.hardware.SensorEvent
import android.os.Vibrator
import kotlinx.android.synthetic.main.activity_proximity04.*


class proximity04 : AppCompatActivity(), SensorEventListener {
    var proximity: TextView? = null
    /*근접도를 보여줄 proximity를 하나 선언 ,센서에서  멀어지면 아무것도 안뜰줄 알고
        nullable 로 선언함
     */


    val sys_manager by lazy { //나중에 초기화 시켜주기 위해서 by lazy 사용
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    val vib_manager by lazy {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator //as는 자바에서 (vibrator)를 앞에 붙이는 것과 같다
    } //getsystemservice는 시스템 서비스를 입력으로 받아서 변수를 통해 해당 서비스를 이용하게 해주는 메소드이다

    /*
        센서와 연결해주는 센서 매니저를 하나 생성한다.
        얘는 하드웨어인 센서와 어플리케이션간 소통을 담당하며 , 정보를 주고받을때 항상 얘를 통해야한다.
        이친구는 추상 클래스 이기때문에 아래에서 다시 메소드들을 오버라이드를 사용해 재정의 해주어야한다.
        연결된 센서가 항상 필요한것이 아니기 때문에 이 센서 매니저를 통해 센서가 작동하고 중지할 시점을
        정해 줄 수 있다.
     */





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity04)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")

        proximity = findViewById(R.id.step4_4_t1)

        step4_4_b1.setOnClickListener { view->
            var intent = Intent(this,proximity05::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)
        }
    }

    /*
    onresume? onpause?

         :  센서는 하드웨어 이기때문에 필연적으로 시스템 자원을 소모할수밖에 없다. 이 자원들을 효율적으로 사용하기 위해
         이런 함수들을 사용해 시작되고 끝나는 지점을 정해줄 수 있다.

     */

    override fun onResume() { //onResume재정의
        super.onResume()

        sys_manager.registerListener(this,
            sys_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)
        // registerListener 은 센서 매니저에 센서를 등록해주는 메소드이다.
        /*
        4개의 인자를 필요로 하는데
         1.  어느 센서 매니저에 등록할건지
         2.  어느 센서를 등록할건지(센서 종류)
         3.  센서 값을 받아올 빈도? 라고 한다. 4가지 종류가 있고 , sensormanager를 import하면 기본적으로
         사용할수 있다.
         */
    }

    override fun onPause() {
        super.onPause()
        sys_manager.unregisterListener(this) //리스너를 등록해제 하여 불필요한 배터리 소모 제거
    }

    override fun onSensorChanged(event: SensorEvent) { //센서값(event)가 변경 되었을때 호출되는  메소드
        //조건문을 통해 센서 값의 변화에 따라 근접했는지 멀어졌는지를 proximity에 출력
        if (event.sensor.type == Sensor.TYPE_PROXIMITY) { //받아온 이벤트 값이 근접센서 일 경우 아래를 실행
            if (event.values[0] == 0f) { //근접센서에서 받아온 값이 , 0일 경우
                vib_manager.vibrate(100)
                step4_4_l1.setBackgroundColor(Color.BLACK)
            }
            else {
                proximity?.setText(" 멀어졌습니다")
                step4_4_l1.setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        when (accuracy) {
            SensorManager.SENSOR_STATUS_UNRELIABLE -> Toast.makeText(this, "UNRELIABLE", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_LOW -> Toast.makeText(this, "LOW", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> Toast.makeText(this, "MEDIUM", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> Toast.makeText(this, "HIGH", Toast.LENGTH_SHORT).show()
        }
    }


}
/*
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_proximity04.*


class proximity04 : AppCompatActivity(), SensorEventListener {



    var proximity: TextView? = null
    //var SensorManager :SensorManager? = null

    val sys_manager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity04)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")
        var val3 = intent.getStringExtra("answer3")

        proximity = findViewById(R.id.step4_4_t1);
        step4_4_b1.setOnClickListener { view->
            var intent = Intent(this,proximity05::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            intent.putExtra("answer3",val3)
            startActivityForResult(intent,1)
        }

    }

    override fun onResume() {
        super.onResume()

        sys_manager.registerListener(this,
            sys_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onPause() {
        super.onPause()
        sys_manager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0f) {
                proximity?.setText("Near : " + event.values[0].toString())
            } else {
                proximity?.setText(" Far :" + event.values[0].toString())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        when (accuracy) {
            SensorManager.SENSOR_STATUS_UNRELIABLE -> Toast.makeText(this, "UNRELIABLE", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_LOW -> Toast.makeText(this, "LOW", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> Toast.makeText(this, "MEDIUM", Toast.LENGTH_SHORT).show()
            SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> Toast.makeText(this, "HIGH", Toast.LENGTH_SHORT).show()
        }
    }


}
*/