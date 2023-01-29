package com.nimisaya.monster.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nimisaya.monster.R
import com.nimisaya.monster.ui.theme.DorianGore

@OptIn(ExperimentalTextApi::class)
@Composable
fun AnimatedText(
    modifier: Modifier = Modifier,
    colors: List<Color> = MonsterTimeColors,
    colorStops: List<Float> = MonsterTimeColorStops
) {
    val infiniteTransition = rememberInfiniteTransition()
    val radius by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 6000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Text(
        modifier = modifier,
        text = stringResource(R.string.monster_scene_title),
        style = TextStyle(
            brush = Brush.radialGradient(
                *colorStops.zip(colors).toTypedArray(),
                radius = radius,
                tileMode = TileMode.Clamp
            ),
            fontSize = 100.sp,
            fontFamily = DorianGore,
            textAlign = TextAlign.Center
        )
    )
}

private val MonsterTimeColors = listOf(
    Color(0xfffba949),
    Color(0xfffae442),
    Color(0xff25eb7d),
    Color(0xff179575),
    Color(0xff302b63)
)

private val MonsterTimeColorStops = listOf(0f, 0.2f, 0.4f, 0.6f, 1f)

@Preview
@Composable
private fun AnimatedTextPreview() {
    AnimatedText()
}
