package com.gopal.shopflowd4c.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gopal.shopflowd4c.R
import com.gopal.shopflowd4c.model.Category
import com.gopal.shopflowd4c.model.Product
import com.gopal.shopflowd4c.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ShopScreen() {
    val products = listOf(
        Product("Clencera", "French clay and algae-powered cleanser", "Skin Tightness • Dry & Dehydrated Skin", 355.20, 444.00, 249, R.drawable.clencera, true),
        Product("Glow", "French clay and algae-powered cleanser", "Skin Tightness • Dry & Dehydrated Skin", 355.20, 444.00, 249, R.drawable.glow, true),
        Product("Afterglow", "French clay and algae-powered cleanser", "Skin Tightness • Dry & Dehydrated Skin", 355.20, 444.00, 249, R.drawable.afterglow, false)
    )

    val categories = listOf(
        Category(name = "Cleaners", R.drawable.clencera),
        Category(name = "Serums", R.drawable.glow),
        Category(name = "Moisturisers", R.drawable.afterglow),
        Category(name = "Toner", R.drawable.clencera),
        Category(name = "Sunscreen", R.drawable.glow)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shop", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    Row {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.FavoriteBorder, contentDescription = "Favourite", tint = Color.White)
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.White)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xB5121212))
            )
        },
        containerColor = Color(0xB5121212)
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 12.dp)
        ) {
            // Banner
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(120.dp)
                        .background(Color.Black, shape = RoundedCornerShape(24.dp))
                ) {
                    Column(modifier = Modifier.align(Alignment.Center)) {
                        Text("GET 20% OFF", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text("Get 20% off", color = Color.LightGray, fontSize = 14.sp)
                        Text("12–16 October", color = Color(0xFFB2FF59), fontSize = 12.sp)
                    }
                }
            }

            // Categories Header
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xB5121212))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Categories",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "See all",
                        color = Color.White,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }

            // Categories Row (horizontal scroll)
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(categories) { category ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = category.imageRes),
                                contentDescription = category.name,
                                modifier = Modifier
                                    .size(64.dp)
                                    .background(color = Color.Black, shape = CircleShape)
                                    .padding(6.dp) // padding inside black circle to create border effect
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(category.name, color = Color.White, fontSize = 14.sp)
                        }
                    }
                }
            }

            // New Products Header
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xB5121212))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New Products",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "See all",
                        color = Color.White,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }

            // Products list
            items(products) { product ->
                ProductCard(product)
            }
        }
    }
}
