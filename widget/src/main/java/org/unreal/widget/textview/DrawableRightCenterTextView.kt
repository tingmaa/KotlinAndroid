package org.unreal.widget.textview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.widget.TextView

/**
 * **类名称：** DrawableLeftCenterTextView <br></br>
 * **类描述：** <br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 16-11-15 上午11:19<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */

class DrawableRightCenterTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet,
                defStyle: Int) : super(context, attrs, defStyle) {
    }

    override fun onDraw(canvas: Canvas) {
        val drawables = compoundDrawables//left,top,right,bottom
        if (drawables != null) {
            val drawableRight = drawables[2]
            if (drawableRight != null) {
                val textWidth = paint.measureText(text.toString())
                val drawablePadding = compoundDrawablePadding
                val drawableWidth = drawableRight.intrinsicWidth
                val bodyWidth = textWidth + drawableWidth.toFloat() + drawablePadding.toFloat()
                setPadding(0, 0, (width - bodyWidth).toInt(), 0)
                canvas.translate((width - bodyWidth) / 2, 0f)
            }
        }
        super.onDraw(canvas)
    }


}