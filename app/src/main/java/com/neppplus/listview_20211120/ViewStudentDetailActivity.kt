package com.neppplus.listview_20211120

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_student_detail.*

class ViewStudentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student_detail)

//        이전 화면에서 넘겨준 이름 / 나이 / 주소 저장
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val age = intent.getIntExtra("age", 0)

        txtName.text = name
        txtAddress.text = address
        txtAge.text = ${age}세"
    }
}