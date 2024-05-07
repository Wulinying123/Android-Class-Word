package com.example.middleexam

data class Commodity(
    val id: Int,
    val name:String,
    val price:Double,
    val quantity:Int,
    val description:String
)
data class Equipment(
    val id: Int,
    val name:String,
    val type: String,
    val status:String,
    val manufacturer:String
)

object UserData{
    val commodityList = listOf(
        Commodity(1,"商品1",22.0,8,"描述1"),
        Commodity(2,"商品2",23.0,4,"描述2"),
        Commodity(3,"商品3",33.0,6,"描述3"),
    )
    val equipmentList = listOf(
        Equipment(1,"装备1","品牌1","可用","良好"),
        Equipment(2,"装备2","品牌2","可用","损坏"),
        Equipment(3,"装备3","品牌3","可用","可用"),
    )
}
