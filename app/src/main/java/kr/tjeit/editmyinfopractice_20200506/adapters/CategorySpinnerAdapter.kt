package kr.tjeit.editmyinfopractice_20200506.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.tjeit.editmyinfopractice_20200506.R
import kr.tjeit.editmyinfopractice_20200506.datas.Category



class CategorySpinnerAdapter : ArrayAdapter<Category>() {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }


        val row = tempRow!!

        val colorTxt = row.findViewById<ImageView>(R.id.colorTxt)
        val titleTxt = row.findViewById<TextView>(R.id.titleTxt)

        titleTxt.text = data.title

        colorTxt.setBackgroundColor(Color.parseColor(data.color))



        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getDropDownView(position, convertView, parent)
    }
}