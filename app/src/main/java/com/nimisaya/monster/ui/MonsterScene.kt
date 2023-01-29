package com.nimisaya.monster.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nimisaya.monster.ui.monster.Monster

@Composable
fun MonsterScene(modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        Background()
        Column(
            modifier = Modifier.padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AnimatedText()
            Spacer(modifier = Modifier.height(48.dp))
            Monster(
                size = with(LocalDensity.current) { 100.dp.toPx() }.toInt(),
                strokeThickness = with(LocalDensity.current) { 2.5.dp.toPx() }
            )
        }
    }
}

@Preview
@Composable
private fun MonsterScenePreview() {
    MonsterScene()
}
