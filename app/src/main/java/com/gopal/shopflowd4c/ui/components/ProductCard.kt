package com.gopal.shopflowd4c.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gopal.shopflowd4c.model.Product

@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { }
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color(0xFF8C8787))
                ),
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            androidx.compose.material3.IconButton(onClick = { }) {
                androidx.compose.material3.Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Add to Favourite",
                    tint = Color(0xF05C625C),
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { }
                )
            }

            androidx.compose.material3.IconButton(onClick = { }) {
                androidx.compose.material3.Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Add to Cart",
                    tint = Color(0xF05C625C),
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { }
                )
            }
        }
        Column {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(product.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(product.description1, fontSize = 14.sp)
            Text(product.description2, fontSize = 14.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            Text("Rs. ${product.price}", color = Color(0xFF30E539), fontWeight = FontWeight.Bold)
            if (product.price < product.originalPrice) {
                Text(
                    text = "Rs. ${product.originalPrice}",
                    style = androidx.compose.ui.text.TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.DarkGray
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("⭐⭐⭐⭐⭐ ${product.reviews} reviews", fontSize = 12.sp)
                Text(
                    text = if (product.inStock) "In Stock" else "Out of Stock",
                    color = if (product.inStock) Color.Green else Color.Red,
                    fontSize = 12.sp
                )
            }
        }
    }
}
