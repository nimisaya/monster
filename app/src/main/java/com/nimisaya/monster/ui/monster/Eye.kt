package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Eye(
    modifier: Modifier = Modifier,
    eyeColor: Color = Color(0xff020c68),
    eyeOutlineColor: Color = Color(0xFF020952),
    bodyColor: Color = Color(0xff020c68),
    pupilColor: Color = Color.White,
    height: Int = with(LocalDensity.current) { 40.dp.toPx() }.toInt(),
    width: Int = with(LocalDensity.current) { 30.dp.toPx() }.toInt(),
) {
    val pupilHeight = height * 0.2F
    val pupilWidth = width / 6

    val highlightHeight = pupilHeight / 1.5
    val highlightWidth = pupilWidth / 1.5

    Canvas(
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
    ) {
        eyeSocket(bodyColor, eyeColor, width, height)
        iris(width = width, height = height, outlineColor = eyeOutlineColor, fillColor = eyeColor)
        pupil(width = pupilWidth, height = pupilHeight, fillColor = pupilColor, outlineColor = eyeOutlineColor)
        highlight(color = pupilColor, width = highlightWidth, height = highlightHeight)
    }
}

private fun DrawScope.highlight(
    color: Color,
    width: Double,
    height: Double
) {
    rotate(degrees = 140f) {
        drawOval(
            color = color,
            alpha = 0.2f,
            size = Size(width = width.dp.toPx(), height = height.dp.toPx()),
            topLeft = Offset(x = this.size.width * .85f, y = this.size.height * 0.35f)
        )
    }
}

private fun DrawScope.iris(
    width: Int,
    height: Int,
    fillColor: Color,
    outlineColor: Color
) {
    // Filled eye
    drawOval(
        color = fillColor,
        size = Size(width = width.dp.toPx(), height = height.dp.toPx())
    )
    // Eye outline
    drawOval(
        color = outlineColor,
        size = Size(width = width.dp.toPx(), height = height.dp.toPx()),
        style = Stroke(width = 4f)
    )
}

private fun DrawScope.pupil(
    width: Int,
    height: Float,
    fillColor: Color,
    outlineColor: Color
) {
    // Fill
    drawOval(
        color = fillColor,
        size = Size(width = width.dp.toPx(), height = height.dp.toPx()),
        topLeft = Offset(x = this.size.width * .6f, y = this.size.height * 0.2f),
    )
    // Outline
    drawOval(
        color = outlineColor,
        size = Size(width = width.dp.toPx(), height = height.dp.toPx()),
        style = Stroke(width = 4f),
        topLeft = Offset(x = this.size.width * .6f, y = this.size.height * 0.2f),
    )
}

private fun DrawScope.eyeSocket(
    bodyColor: Color,
    eyeColor: Color,
    width: Int,
    height: Int
) {
    // Fill
    drawOval(
        brush = Brush.horizontalGradient(
            colors = listOf(
                bodyColor,
                eyeColor,
                eyeColor,
                bodyColor
            )
        ),
        size = Size(width = (width * 1.05).dp.toPx(), height = (height * 1.05).dp.toPx()),
        alpha = 0.25f,
        topLeft = Offset(x = this.size.width * 0f, y = this.size.height * .08f)
    )
    // Outline - inner
    drawOval(
        brush = Brush.horizontalGradient(
            colors = listOf(
                Color.Transparent,
                eyeColor,
                eyeColor,
                Color.Transparent
            )
        ),
        size = Size(width = (width * 1.05).dp.toPx(), height = (height * 1.009).dp.toPx()),
        topLeft = Offset(x = this.size.width * 0f, y = this.size.height * .08f),
        style = Stroke(width = (width * 0.01).dp.toPx(), cap = StrokeCap.Round)
    )
    // Outline - outer
    drawOval(
        brush = Brush.horizontalGradient(
            colors = listOf(
                Color.Transparent,
                eyeColor,
                eyeColor,
                Color.Transparent
            )
        ),
        size = Size(width = (width * 1.05).dp.toPx(), height = (height * 1.05).dp.toPx()),
        topLeft = Offset(x = this.size.width * 0f, y = this.size.height * .08f),
        style = Stroke(width = (width * 0.01).dp.toPx(), cap = StrokeCap.Round)
    )
}

@Preview
@Composable
private fun EyePreview() {
    Eye()
}
