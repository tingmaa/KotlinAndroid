package org.unreal.common.widget.window

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.PopupWindow
import android.widget.TextView
import org.unreal.common.widget.R


/**
 * **类名称：** WaitScreen <br></br>
 * **类描述：** 等待界面<br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 16-9-28 下午5:35<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */
class WaitScreen(private val context: Activity) {
    private val popupWindow: PopupWindow?
    private val view: View = LayoutInflater.from(context).inflate(R.layout.weight_wait_screen, null)
    private val progress: View
    private val wait: View
    private val messageView: TextView

    init {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()// 创建了一张白纸
        windowManager.defaultDisplay.getMetrics(dm)// 给白纸设置宽高
        popupWindow = PopupWindow(view, dm.widthPixels, dm.heightPixels)
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        popupWindow.isClippingEnabled = false
        progress = view.findViewById(R.id.progress)
        wait = view.findViewById(R.id.wait)
        messageView = view.findViewById(R.id.message) as TextView
    }

    /**
     * 弹出等待提示框
     */
    fun show(): PopupWindow? {
        context.window.decorView.post {
            popupWindow!!.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0)
            val rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate_progress)
            progress.startAnimation(rotateAnim)
        }
        return popupWindow
    }

    /**
     * 弹出等待提示框
     */
    fun show(message: String): PopupWindow? {
        context.window.decorView.post {
            popupWindow!!.showAsDropDown(view)
            val rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate_progress)
            progress.startAnimation(rotateAnim)
            messageView.text = message
        }
        return popupWindow
    }

    /**
     * 以动画的方式关闭等待弹屏
     */
    fun close(onAnimationEnd: () -> Unit) {
        if (popupWindow != null && popupWindow.isShowing) {
            popupWindow.isFocusable = false
            val alphaAnim = AnimationUtils.loadAnimation(context, R.anim.alpha_hide_progress)
            wait.startAnimation(alphaAnim)
            Handler().postDelayed({
                popupWindow.dismiss()
                onAnimationEnd.invoke()
            }, alphaAnim.duration)
        }
    }

    /**
     * 关闭弹屏
     */
    fun dismiss() {
        if (popupWindow != null && popupWindow.isShowing) {
            popupWindow.dismiss()
        }
    }

}

