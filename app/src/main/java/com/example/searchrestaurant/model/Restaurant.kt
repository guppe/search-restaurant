package com.example.searchrestaurant.model

data class Restaurant(
    val results: Results,
){
    data class Results(
        val shop: List<Shop>
    ) {
        data class Shop(
            val access: String,
            val address: String?,
            val id: String,
            val name: String,
            val open: String?,
            val photo: Photo,
        ) {
            data class Photo(
                val mobile: Mobile?,
            ) {
                data class Mobile(
                    val l: String?,
                    val s: String?
                )
            }
        }
    }
}
