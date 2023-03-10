package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Monster(
    modifier: Modifier = Modifier,
    size: Int = with(LocalDensity.current) { 150.dp.toPx() }.toInt(),
    strokeThickness: Float = with(LocalDensity.current) { 3.dp.toPx() },
    bodyColor: Color = Color(0xff25eb7d),
    eyeColor: Color = Color(0xff020c68),
    noseColor: Color = Color(0xff020c68),
    shadingColor: Color = Color(0xff179575),
    outlineColor: Color = Color(0xFF020952),
    mouthColor: Color = Color(0xFF020952)
) {

    val eyeHeight = size / 5
    val eyeWidth = (eyeHeight / 1.2).toInt()
    val eyeGap = size * 0.05f

    val foreheadHeight = (size * 0.25).dp

    val noseSize = size * 0.1f

    val mouthSize = (size * 0.1f).toInt()
    val mouthGap = size * 0.08f

    Box(
        modifier = modifier
            .size(size.dp)
            .drawBehind {
                body(
                    color = bodyColor,
                    outlineThickness = strokeThickness,
                    size = size,
                    outlineColor = outlineColor,
                    shadingColor = shadingColor
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Box {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(foreheadHeight))
                Row(verticalAlignment = Alignment.Bottom) {
                    Eye(
                        eyeColor = eyeColor,
                        eyeOutlineColor = outlineColor,
                        bodyColor = bodyColor,
                        height = eyeHeight,
                        width = eyeWidth
                    )
                    Spacer(modifier = Modifier.width(eyeGap.dp))
                    Nose(
                        size = noseSize,
                        outerShadowColor = bodyColor,
                        fillColor = noseColor,
                        innerShadowColor = shadingColor
                    )
                    Spacer(modifier = Modifier.width(eyeGap.dp))
                    Eye(
                        eyeColor = eyeColor,
                        eyeOutlineColor = outlineColor,
                        bodyColor = bodyColor,
                        height = eyeHeight,
                        width = eyeWidth
                    )
                }
                Spacer(modifier = Modifier.height(mouthGap.dp))
                Mouth(mouthSize = mouthSize, color = mouthColor, shadowColor = shadingColor)
            }
        }
    }
}

private fun DrawScope.body(
    size: Int,
    outlineThickness: Float,
    color: Color,
    outlineColor: Color,
    shadingColor: Color
) {
    // Fill
    drawCircle(
        brush = Brush.radialGradient(
            colorStops = arrayOf(
                0.25f to color,
                1f to shadingColor
            ),
            center = Offset(x = size * 1.2f, y = size * 1.9f)
        ),
        radius = size.toFloat(),
    )
    // Outline - thick stroke
    drawCircle(
        color = outlineColor,
        radius = size.toFloat(),
        style = Stroke(
            width = outlineThickness,
            cap = StrokeCap.Round,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(200f, 50f, 70f, 10f, 70f)
            )
        )
    )
    // Outline - thin stroke
    drawCircle(
        color = outlineColor,
        radius = size.toFloat(),
        style = Stroke(width = outlineThickness * 0.5F, cap = StrokeCap.Round)
    )
}

@Preview(widthDp = 400, heightDp = 400)
@Composable
fun MonsterPreview() {
    Monster()
}
