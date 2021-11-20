package com.neppplus.listview_20211120.datas

import java.time.Year

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String ) {

//    학생데이터의 기능 추가 -> 년도를 넣으면 나이로 계산  (함수 제작)

    fun getAgeByYear( year : Int ) : Int{

        val age = year - this.birthYear + 1

        return  age

    }

}