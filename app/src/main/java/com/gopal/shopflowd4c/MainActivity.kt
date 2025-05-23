package com.gopal.shopflowd4c

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gopal.shopflowd4c.ui.screens.ShopScreen
import com.gopal.shopflowd4c.ui.theme.ShopFlowD4CTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopFlowD4CTheme {
                ShopScreen()
            }
        }
    }
}
