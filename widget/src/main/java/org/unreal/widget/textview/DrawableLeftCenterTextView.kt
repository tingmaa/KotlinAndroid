package org.unreal.widget.textview

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * **类名称：** DrawableLeftCenterTextView <br></br>
 * **类描述：** <br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 16-11-15 上午11:19<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */

class DrawableLeftCenterTextView : AppCompatTextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet,
                defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas) {
        val drawables = compoundDrawables
        if (drawables != null) {
            val drawableLeft = drawables[0]
            if (drawableLeft != null) {
                val textWidth = paint.measureText(text.toString())
                val drawablePadding = compoundDrawablePadding
                val drawableWidth = drawableLeft.intrinsicWidth
                val bodyWidth = textWidth + drawableWidth.toFloat() + drawablePadding.toFloat()
                canvas.translate((width - bodyWidth) / 2, 0f)
            }
        }
        super.onDraw(canvas)
    }


}