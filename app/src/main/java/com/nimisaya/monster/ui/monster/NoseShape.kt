package com.nimisaya.monster.ui.monster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class NoseShape(
    private val radius: Float,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val noseTopPath = Path().apply {
            addOval(
                oval = Rect(
                    center = Offset(x = radius + radius * 0.5f, y = radius),
                    radius = radius
                )
            )
        }
        val noseRightPath = Path().apply {
            addOval(
                oval = Rect(
                    center = Offset(x = radius, y = radius + radius * 0.5f),
                    radius = radius * 0.85f
                )
            )
        }
        val noseLeftPath = Path().apply {
            addOval(
                oval = Rect(
                    center = Offset(x = radius * 2f, y = radius + radius * 0.5f),
                    radius = radius * 0.85f
                )
            )
        }

        val noseSidePaths = Path.combine(operation = PathOperation.Union, noseLeftPath, noseRightPath)
        val path = Path.combine(operation = PathOperation.Union, noseSidePaths, noseTopPath)

       path.translate(offset = Offset(x = 0f, y = radius * 1.5f))

        return Outline.Generic(path)
    }
}

fun Modifier.drawNose(
    radius: Float,
    color: Color,
) = then(
    background(
        color = color,
        shape = NoseShape(
            radius = radius
        )
    )
)


fun Modifier.drawNoseShadow(
    radius: Float,
    darkColor: Color,
    lightColor: Color = Color(0xff179575)
) = then(
    background(
        brush =  Brush.radialGradient(
            colorStops = arrayOf(
                0.5f to darkColor,
                1f to lightColor,
            )
        ),
        shape = NoseShape(
            radius = radius
        )
    )
)

@Preview
@Composable
private fun NoseShapePreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .drawNose(
                radius = 200F,
                color = Color.Black,
            )
    ) {}
}
