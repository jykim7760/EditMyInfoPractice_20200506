package kr.tjeit.editmyinfopractice_20200506.datas

import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class User {

    companion object {
        fun getUserFromJsonObject(json: JSONObject) : User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            parsedUser.category = Category.getCategoryFromJson(json.getJSONObject("category"))

            val createdAtStr = json.getString("created_at")


            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

//            가입일시의 값을 Date 타입으로 변환한 객체로 대입.
            parsedUser.createdAt.time =   sdf.parse(createdAtStr)


//            parsedUser.createdAt.set()

            return parsedUser
        }
    }

    var id = 0
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""

    val createdAt = Calendar.getInstance()
    var category = Category()

}