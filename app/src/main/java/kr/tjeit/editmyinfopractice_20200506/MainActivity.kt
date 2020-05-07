package kr.tjeit.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kr.tjeit.editmyinfopractice_20200506.datas.User
import kr.tjeit.editmyinfopractice_20200506.utils.ServerUtil
import org.json.JSONObject
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {

    lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        token = intent.getStringExtra("token")!!

        Log.d("로그인유져토큰", token)

//        토큰을 가지고 => 사용자 정보를 불러오기
//          => User클래스형태로 파싱 => UI에 값을 찍어주기. (자기소개까지)

        ServerUtil.getRequestMyInfo(mContext, token, object : ServerUtil.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
                Log.d("내정보응답", json.toString())

                val code = json.getInt("code")

                if (code == 200) {

                    val data = json.getJSONObject("data")
                    val user = data.getJSONObject("user")

                    val userObj = User.getUserFromJsonObject(user)

//                    만들어낸 사용자 객체를 화면에 반영 (UI작업)

                    runOnUiThread {

                        idTxt.text = userObj.loginId
                        nameEdt.setText(userObj.name)
                        phoneNumEdt.setText(userObj.phoneNum)
                        memoEdt.setText(userObj.memo)

//                        캘린더로 저장된 가입일시 -> 스트링으로 변환.
//                        텍스트뷰에 대입

                        val printSdf = SimpleDateFormat("yyyy년 M월 d일 (E)")

                        signUpDateTxt.text = printSdf.format(userObj.createdAt.time)


                    }



                }

            }

        })




    }

}
