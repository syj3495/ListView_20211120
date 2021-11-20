package com.neppplus.listview_20211120

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.neppplus.listview_20211120.adapters.StudentAdapter
import com.neppplus.listview_20211120.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mStudentAdapter : StudentAdapter

    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add( StudentData("조경진", 1988, "서울시 동대문구") )
        mStudentList.add( StudentData("구영모",1990,"경기도 부천시"))
        mStudentList.add( StudentData("김정난",1976,"서울시 용산구"))
        mStudentList.add( StudentData("김정환",1981,"서울시 중랑구"))
        mStudentList.add( StudentData("김찬수",1996,"서울시 성북구"))
        mStudentList.add( StudentData("김창배",1993,"서울시 노원구"))
        mStudentList.add( StudentData("성연진",1994,"서울시 성동구"))
        mStudentList.add( StudentData("윤성노",1974,"서울시 중랑구"))
        mStudentList.add( StudentData("최연주",1985,"서울시 성북구"))

        mStudentAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mStudentAdapter

        studentListView.setOnItemClickListener { adapterView, view, position, l ->

//            position : 몇번째 줄이 눌렸는 지 알려줌.

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name} 클릭됨", Toast.LENGTH_SHORT).show()


        }


        studentListView.setOnItemLongClickListener { adapterView, view, position, l ->


//            길게 눌렀을 때의 별도 행동

            val longClickedStudent = mStudentList[position]

//            Toast.makeText(this, "${longClickedStudent.name}길게 클릭됨", Toast.LENGTH_SHORT).show()

//            학생 제거 전에, 진짜로 삭제할 것 인지 물어보자. AlertDialog

            val alert = AlertDialog.Builder( this )

            alert.setTitle("학생 삭제 확인")
            alert.setMessage("정말 ${longClickedStudent.name}학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

//                확인 버튼이 눌릴 때 실행될 코드
//            찾아낸 학생을 목록에서 제거 -> 리스트뷰 내용물 변경
                mStudentList.remove( longClickedStudent )

//            어댑터에게 새로고침
                mStudentAdapter.notifyDataSetChanged()

            })
            alert.setNegativeButton("취소", null)

            alert.show()



            return@setOnItemLongClickListener true



        }
    }
}