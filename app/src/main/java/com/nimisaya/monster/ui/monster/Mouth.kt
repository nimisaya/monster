package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Mouth(
    modifier: Modifier = Modifier,
    mouthSize: Int = 300,
    color: Color = Color.Black,
    shadowColor: Color = Color.Blue
) {
    val radius = mouthSize * 0.8f

    val leftToothPath = leftToothPath(radius)
    val leftToothShadowPath = leftToothPath(radius, xOffset = radius * 2.6f)
    val rightToothShadowPath = rightToothPath(radius, xOffset = radius * 1.1f)
    val rightToothPath = rightToothPath(radius)

    Canvas(
        modifier = modifier.size(mouthSize.dp),
        onDraw = {
            // Mouth shadow
            drawRoundRect(
              color = shadowColor,
              size = Size(size.width, size.height * 0.22f),
                cornerRadius = CornerRadius(x = size.width * 0.25f, y = size.height * 0.25f)
            )
            // Mouth
            drawRoundRect(
              color = color,
              size = Size(size.width * 0.98f, size.height * 0.2f),
                cornerRadius = CornerRadius(x = size.width * 0.25f, y = size.height * 0.25f)
            )
            // Left tooth shadow
            drawPath(
                color = Color.Black,
                path = leftToothShadowPath
            )
            // Left tooth
            drawPath(
                color = Color.White,
                path = leftToothPath
            )
            // Right tooth shadow
            drawPath(
                color = Color.Black,
                path = rightToothShadowPath
            )
            // Right tooth
            drawPath(
                color = Color.White,
                path = rightToothPath
            )
        }
    )
}

@Composable
private fun leftToothPath(radius: Float, xOffset: Float = radius * 2.5f): Path {
    val leftToothPath = Path().apply {
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

    leftToothPath.translate(offset = Offset(x = xOffset, y = radius * 0.25f))
    return leftToothPath
}
@Composable
private fun rightToothPath(radius: Float, xOffset: Float = radius): Path {
    val leftToothPath = Path().apply {
        reset()

        // Top
        relativeQuadraticBezierTo(
            dx1 = -(radius * 0.5f),
            dy1 = -(radius * 0.25f),
            dx2 = -radius,
            dy2 = 0f
        )

        // Outer
        relativeQuadraticBezierTo(
            dx1 = -(radius * 0.5f),
            dy1 = radius * 0.5f,
            dx2 = 0f,
            dy2 = radius
        )

        // Inner
        relativeQuadraticBezierTo(
            dx1 = radius,
            dy1 = -(radius * 0.5f),
            dx2 = radius,
            dy2 = -radius
        )

        close()
    }

    leftToothPath.translate(offset = Offset(x = xOffset, y = radius * 0.25f))
    return leftToothPath
}


@Preview
@Composable
private fun MouthPreview() {
    Mouth(mouthSize = 100)
}
