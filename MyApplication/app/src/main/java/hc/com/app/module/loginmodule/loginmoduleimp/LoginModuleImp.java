package hc.com.app.module.loginmodule.loginmoduleimp;

/**
 * Created by Administrator on 2018/4/18.
 * mark:hc
 */
public interface LoginModuleImp {

    void OnLoginLister(String username,String password,OnLoginLister onLoginLister);

    interface OnLoginLister {

        void OnSuccess(String result);

        void OnError(String error);
    }

    ;


}
