package org.techtown.oneqtester_1_0


import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_record03.*
import java.io.IOException
import java.sql.Time
import java.util.*

class record03 : AppCompatActivity() {


    //음성 녹음 권한 요청 코드
    val REQUEST_CODE_RECORD_AUDIO_PERMISSION = 200

    //녹음 된 음성파일 이름
    var voiceFileName: String = ""

    //음성 녹음을 위한 MediaRecoder
    var mediaRecorder: MediaRecorder? = null

    //음성 플레이를 위한 MediaPlayer
    var mediaPlayer: MediaPlayer? = null

//    //녹음이 시작되었는지 상태 변수
//    var isRecordStart = false
//
//    //음성 플레이가 시작되었는지 상태 변수
//    var isStartPlaying = false //초기 상태는 음성 녹음을 하지 않는다.

    //로그에서 사용할 태그
    var LOG_TAG = "ThirdRecordTestActivity"

    //앱에서 필요로 하는 권한 배열
    private var permissions: Array<String> = arrayOf(android.Manifest.permission.RECORD_AUDIO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record03)

        var val1 = intent.getStringExtra("answer1")
        var val2 = intent.getStringExtra("answer2")

        //RunTime에 권한 요청
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_RECORD_AUDIO_PERMISSION)
        //저장될 음성 파일 위치 지정
        voiceFileName = "${externalCacheDir.absolutePath}/voice_record.3gp"

        //음성 녹음 버튼이 클릭 된 경우
        record_3_b1.setOnClickListener { view ->
            startRecording()
            Toast.makeText(this,"녹음이 시작되었어요! 말해보세요.",Toast.LENGTH_LONG).show()
        }
        //음성 녹음 중지 버튼이 클릭 된 경우.
        record_3_b2.setOnClickListener { view ->
            stopRecording()
            Toast.makeText(this,"녹음이 중지되었어요!\n재생버튼을 눌러 확인해보세요.",Toast.LENGTH_LONG).show()
        }
        //음성 재생 버튼이 클릭 된 경우
        record_3_imgb1.setOnClickListener { view ->
            startPlaying()
            Toast.makeText(this,"음성이 재생됩니다.\n일시정지를 눌러 다음단계로 이동하세요.",Toast.LENGTH_LONG).show()
        }
        //음성 중지 버튼이 클릭 된 경우
        record_3_imgb2.setOnClickListener { view ->
            stopPlaying()

            var intent = Intent(this,record04::class.java)
            intent.putExtra("answer1",val1)
            intent.putExtra("answer2",val2)
            startActivityForResult(intent,1)
        }
    }

    //prepare 메소드
    //mediaRecorder, mediaPlayer의 초기 상태는 prepare 메소드 (초기 상태)로 시작.
    //release 메소드로 (종료 상태) 마무리.

    //release 메소드 //End State
    //mediaPlayer 나 mediaRecorder 객체를 중지할 때 릴리즈 메소드를 호출하여 객체를 해제.
    //릴리즈 메소드를 호출하지 않으면 배터리 소모, 다른 응용프로그램에서 재생 오류.

    fun startRecording() {
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC) //오디오 소스는 마이크로 세팅
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP) //3gp 파일로 포맷설정
            setOutputFile(voiceFileName) //저장되는 음성 파일은 파일 명으로
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB) //코덱 종류인듯?

            try {
                prepare()
            } catch (e: IOException) { //입출력 예외 처리를 한 이유?
                Log.e(LOG_TAG, "prepare() failed") //
            }

            start()
        }
    }

    fun stopRecording() {
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
    }

    fun startPlaying() {
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(voiceFileName) //미디어플레이어에서 재생할 데이터 소스는 지정한 파일이름.
                prepare()
                start()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
        }
    }

    fun stopPlaying() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    //액티비티가 사라지면 전부 릴리즈 상태, 즉 종료.
    override fun onStop() {
        super.onStop()
        mediaRecorder?.release()
        mediaRecorder = null
        mediaPlayer?.release()
        mediaPlayer = null
    }

    //권한 요청이 완료된 경우 호출 되는 함수
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionToRecordAccepted = if (requestCode == REQUEST_CODE_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
//권한을 거절한 경우 종료
    }
}



/*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record01.*
import kotlinx.android.synthetic.main.activity_record03.*

class record03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record03)
        record_3_b1.setOnClickListener { view->
            var intent = Intent(this,record04::class.java)
            startActivity(intent)
        }
    }
}
*/