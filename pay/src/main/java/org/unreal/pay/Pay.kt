package org.unreal.pay

import android.app.Activity
import android.content.Intent
import org.unreal.pay.alipay.AliPayImplement
import org.unreal.pay.union.UnionBankPayImplement
import org.unreal.pay.weixin.WeiXinPayImplement

/**
 * <b>类名称：</b> Pay <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年06月01日 17:01<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
sealed class Pay {
    data class WeiXinPay(val activity: Activity,
                         val appId: String,
                         val partnerId: String,
                         val prepayId: String,
                         val packageValue: String,
                         val nonceStr: String,
                         val timeStamp: String,
                         val sign: String,
                         val signType: String) : Pay()

    data class UnionBankPay(val activity: Activity,
                            val tradeCode: String,
                            val serverModel: String) : Pay()

    data class AliPay(val activity: Activity,
                      val order: String) : Pay()
}

interface PayFunction {
    fun checkPluginState(onCheckState: (Boolean) -> Unit)
    fun payment()
    fun filterResult(result: Intent?)
}

fun payment(payOrder: Pay, onSuccess: () -> Unit, onError: (String) -> Unit): PayFunction {
    val functions: PayFunction
    when (payOrder) {
        is Pay.WeiXinPay -> {
            functions = WeiXinPayImplement(payOrder, onSuccess, onError)
        }
        is Pay.UnionBankPay -> {
            functions = UnionBankPayImplement(payOrder, onSuccess, onError)
        }
        is Pay.AliPay -> {
            functions = AliPayImplement(payOrder, onSuccess, onError)
        }
    }
    return functions

}



