package com.nimisaya.monster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nimisaya.monster.ui.MonsterScene
import com.nimisaya.monster.ui.theme.MonsterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonsterTheme {
                MonsterScene()
            }
        }
    }
}

