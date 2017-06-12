package org.unreal.web.api

import android.webkit.JavascriptInterface
import org.json.JSONException
import org.json.JSONObject
import org.unreal.web.WebActivity
import org.unreal.widget.web.CompletionHandler

/**
 * **类名称：** JsApi <br></br>
 * **类描述：** <br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 2017年05月08日 15:11<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */
class JsApi(val activity: WebActivity) {

    @JavascriptInterface
    @Throws(JSONException::class)
    internal fun aliPay(jsonObject: JSONObject, handler: CompletionHandler) {
//        val aliPayConfig = AliPayConfig.Builder()
//                .with(activity)
//                .setOrderInfo(jsonObject.getString("order"))
//                .create()
//        val aliPay = PayFactory.get(aliPayConfig)
//        aliPay.setOnPayResultListener(object : PayResultListener() {
//            fun onPaySuccess() {
//                handler.complete("{ state:\"success\" }")
//            }
//
//            fun onPayFailure() {
//                handler.complete("{ state:\"failure\" }")
//            }
//
//            fun onPayConfirming() {
//                handler.complete("{ state:\"confirming\" }")
//            }
//
//            fun onPayCheck(state: Boolean) {
//                aliPay.payOrder()
//            }
//        })
//        aliPay.checkPayState()
    }


    @JavascriptInterface
    @Throws(JSONException::class)
    internal fun weiXinPay(jsonObject: JSONObject, handler: CompletionHandler) {
//        val weiXinPayConfig = WeiXinPayConfig.Builder()
//                .with(activity)
//                .setPackageValue(jsonObject.getString("package"))
//                .setTimeStamp(jsonObject.getString("timestamp"))
//                .setNonceStr(jsonObject.getString("noncestr"))
//                .setSign(jsonObject.getString("sign"))
//                .setPartnerId(jsonObject.getString("partnerid"))
//                .setAppId(jsonObject.getString("appid"))
//                .setPrepayId(jsonObject.getString("prepayid"))
//                .setSignType(jsonObject.getString("signType"))
//                .create()
//        val weiXinPay = PayFactory.get(weiXinPayConfig)
//        weiXinPay.setOnPayResultListener(object : PayResultListener() {
//            fun onPaySuccess() {
//                handler.complete("{ state:\"success\" }")
//            }
//
//            fun onPayFailure() {
//                handler.complete("{ state:\"failure\" }")
//            }
//
//            fun onPayConfirming() {
//                handler.complete("{ state:\"confirming\" }")
//            }
//
//            fun onPayCheck(state: Boolean) {
//                weiXinPay.payOrder()
//            }
//        })
//        weiXinPay.checkPayState()
    }
}
