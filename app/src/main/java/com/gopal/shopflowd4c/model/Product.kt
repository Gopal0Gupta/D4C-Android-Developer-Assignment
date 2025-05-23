package com.gopal.shopflowd4c.model

data class Product(
    val name: String,
    val description1: String,
    val description2: String,
    val price: Double,
    val originalPrice: Double,
    val reviews: Int,
    val imageRes: Int,
    val inStock: Boolean
)