package com.nimisaya.monster.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.nimisaya.monster.R

@Composable
fun Background(modifier: Modifier = Modifier) {
    val starsImage = ImageBitmap.imageResource(id = R.drawable.star)
    val starsPatternBrush = remember(starsImage) {
        ShaderBrush(
            ImageShader(
                image = starsImage,
                tileModeX = TileMode.Repeated,
                tileModeY = TileMode.Repeated
            )
        )
    }
    val grassImage = ImageBitmap.imageResource(id = R.drawable.grass)
    val grassPatternBrush = remember(grassImage) {
        ShaderBrush(
            ImageShader(
                image = grassImage,
                tileModeX = TileMode.Repeated
            )
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xff0f0c29),
                        Color(0xff302b63),
                        Color(0xff24243e),
                    ),
                    start = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
                    end = Offset(x = Float.POSITIVE_INFINITY, y = 0f),
                )
            ),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(starsPatternBrush)
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0x0D0f0c29),
                                Color(0xcf302b63),
                                Color(0xff24243e),
                            )
                        )
                    ),
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.15f)
                        .background(grassPatternBrush)
                        .alpha(0.20f)
                        .align(Alignment.BottomCenter),
                ) {}
            }
        }
    }
}


@Preview
@Composable
private fun BackgroundPreview() {
    Background()
}
