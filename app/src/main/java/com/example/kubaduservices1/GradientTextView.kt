package com.example.kubaduservices1

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class GradientTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (w > 0) {
            val shader = LinearGradient(
                0f, 0f, w.toFloat(), 0f,
                intArrayOf(
                    context.getColor(R.color.gradient_start),
                    context.getColor(R.color.gradient_end)
                ),
                null,
                Shader.TileMode.CLAMP
            )
            paint.shader = shader
        }
    }
}
