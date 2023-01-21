package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Nose(
    size: Float,
    fillColor: Color,
    outerShadowColor: Color,
    innerShadowColor: Color
) {

    val shadowRadius = size * 1.05F

    Box(
        modifier = Modifier
            .size(size.dp)
            .drawNoseShadow(
                radius = shadowRadius,
                darkColor = outerShadowColor,
                lightColor = innerShadowColor
            )
            .drawNose(
                radius = size,
                color = fillColor
            )
    ) {
    }
}

