package com.neppplus.listview_20211120.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listview_20211120.R
import com.neppplus.listview_20211120.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId:Int,
    val mList: ArrayList<StudentData> ) : ArrayAdapter<StudentData>(mContext, resId, mList){

//        Adapter 역할 : xml + 데이터클래스 자료 조합.

//        xml파일을 -> 이 Adapter 코드에서 끌어다 사용하게 도와줌. (도구)

        val mInflater = LayoutInflater.from(mContext)

//        xml + 데이터 조함 -> 위치에 뿌려주는 함수 (ArrayAdapter 제공) -> 커스터마이징 (함수 오버라이딩)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null){

            tempRow = mInflater.inflate(R.layout.student_list_item, null)

        }

//        xml -> row 변수에 담아두자.
        val row = tempRow!!

//        row를 실제 데이터로 가공해주고

//        근거 데이터를 가져오자.
        val data = mList[position]

//        뿌려질 UI들을 가져오자. 내부에서 찾아오자
        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)

//        UI에 데이터에서 필요한 변수 추출 반영
        txtStudentName.text = data.name





//        row에 담긴 xml을 화면에 뿌려주게 내보내자.
        return row

    }
}