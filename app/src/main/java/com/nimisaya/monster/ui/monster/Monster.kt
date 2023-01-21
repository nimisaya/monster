package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun Monster(
    modifier: Modifier = Modifier,
    size: Int = 200,
    bodyOutlineThickness: Float = 3F,
    bodyColor: Color = Color(0xff25eb7d),
    eyeColor: Color = Color(0xff020c68),
    noseColor: Color = Color(0xff020c68),
    shadingColor: Color = Color(0xff179575),
    outlineColor: Color = Color(0xFF020952)
) {

    val eyeHeight = size / 5
    val eyeWidth = (eyeHeight / 1.2).toInt()
    val eyeGap = size / 5

    val foreheadHeight = (size * 0.25).dp

    val noseSize = size * 0.1F

    Box(
        modifier = modifier
            .size(size.dp)
            .drawBehind {
                body(
                    color = bodyColor,
                    outlineThickness = bodyOutlineThickness,
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
                Row {
                    Eye(
                        eyeColor = eyeColor,
                        eyeOutlineColor = outlineColor,
                        bodyColor = bodyColor,
                        height = eyeHeight,
                        width = eyeWidth
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
                Nose(
                    size = noseSize,
                    outerShadowColor = bodyColor,
                    fillColor = noseColor,
                    innerShadowColor = shadingColor
                )
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
                0.55f to color,
                1f to shadingColor
            ),
            center = Offset(x = this.size.width * 0.5f, y = this.size.height * 0.65f)
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

@Preview
@Composable
fun MonsterPreview() {
    Monster()
}
