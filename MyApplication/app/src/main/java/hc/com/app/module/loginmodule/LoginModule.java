package hc.com.app.module.loginmodule;

import hc.com.app.module.loginmodule.loginmoduleimp.LoginModuleImp;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/4/18.
 */
public class LoginModule implements LoginModuleImp {


    @Override
    public void OnCodeLister(String time, OnCodeLister onCodeLister) {
        if (time.equals("0")) {
            onCodeLister.codeGet("获取验证码");
        } else {
            onCodeLister.codeCountDown(time + "s");
        }
    }

    @Override
    public void OnLoginLister(String username, String code_input, OnLoginLister onLoginLister) {
        if (username.equals(code_input)) {
            onLoginLister.OnSuccess("登录成功");
        } else {
            onLoginLister.OnError("登录失败");
        }
    }

}
