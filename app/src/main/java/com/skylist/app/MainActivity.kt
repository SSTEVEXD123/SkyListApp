package com.skylist.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.skylist.app.ui.SkyListApp
import com.skylist.app.ui.theme.SkyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyListTheme {
                Surface {
                    SkyListApp()
                }
            }
        }
    }
}
