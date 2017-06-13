package org.unreal.widget.textview

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * **类名称：** DrawableBottomCenterTextView <br></br>
 * **类描述：** <br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 16-11-15 上午11:19<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */

class DrawableBottomCenterTextView : AppCompatTextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet,
                defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas) {
        val drawables = compoundDrawables
        if (drawables != null) {
            val drawableTop = drawables[3]
            if (drawableTop != null) {
                val fm = paint.fontMetrics
                val textHeight = Math.ceil((fm.descent - fm.ascent).toDouble()).toInt()
                val drawablePadding = compoundDrawablePadding
                val drawableHeight = drawableTop.intrinsicHeight
                val bodyHeight = (textHeight + drawableHeight + drawablePadding).toFloat()
                canvas.translate(0f, (height - bodyHeight) / 2)
            }
        }
        super.onDraw(canvas)
    }


}