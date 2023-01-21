package com.nimisaya.monster.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nimisaya.monster.ui.monster.Monster

@Composable
fun MonsterScene(modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        Monster(
            size = with(LocalDensity.current) { 150.dp.toPx() }.toInt(),
            strokeThickness = with(LocalDensity.current) { 3.dp.toPx() }
        )
        Background()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MonsterScenePreview() {
    MonsterScene()
}
