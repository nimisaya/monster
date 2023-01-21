package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class ToothShape(
    private val radius: Float,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val toothPath = Path().apply {
            reset()

            // Top
            relativeQuadraticBezierTo(
                dx1 = radius * 0.5f,
                dy1 = -(radius * 0.25f),
                dx2 = radius,
                dy2 = 0f
            )

            // Outer
            relativeQuadraticBezierTo(
                dx1 = radius * 0.5f,
                dy1 = radius * 0.5f,
                dx2 = 0f,
                dy2 = radius
            )

            // Inner
            relativeQuadraticBezierTo(
                dx1 = -(radius),
                dy1 = -(radius * 0.5f),
                dx2 = -radius,
                dy2 = -radius
            )

            close()
        }

        toothPath.translate(offset = Offset(x = -(radius * 0.6f), y = -(radius * 0.5f)))

        return Outline.Generic(toothPath)
    }
}

fun Modifier.drawTooth(
    radius: Float,
    color: Color,
) = then(
    background(
        color = color,
        shape = ToothShape(
            radius = radius
        )
    )
)

@Preview(widthDp = 400, heightDp = 200)
@Composable
private fun ToothShapePreview() {
    val radius = 200F
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .drawTooth(
                radius = radius,
                color = Color.Black,
            )
    ) {
    }
}
