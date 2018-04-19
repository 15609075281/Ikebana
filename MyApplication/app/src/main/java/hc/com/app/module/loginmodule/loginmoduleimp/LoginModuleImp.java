package hc.com.app.module.loginmodule.loginmoduleimp;

/**
 * Created by Administrator on 2018/4/18.
 * mark:hc
 */
public interface LoginModuleImp {

    /**
     * 获取验证码
     * @param onCodeLister
     */
    void OnCodeLister(String time,OnCodeLister onCodeLister);

    interface  OnCodeLister{

        void codeGet(String code);

        void codeCountDown(String code);

    }

    /**
     * 登录
     * @param username
     * @param code_input
     * @param onLoginLister
     */
    void OnLoginLister(String username,String code_input,OnLoginLister onLoginLister);

    interface OnLoginLister {

        void OnSuccess(String result);

        void OnError(String error);
    }




}
