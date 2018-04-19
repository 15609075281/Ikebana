package hc.com.app.persen.loginpersen;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.hc.libs_base.Entity.loginentity.LoginEntity;
import com.hc.libs_base.database.realm.RealmSql;
import hc.com.app.module.loginmodule.LoginModule;
import hc.com.app.module.loginmodule.loginmoduleimp.LoginModuleImp;
import hc.com.app.view.loginview.LoginView;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmResults;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/4/18.
 * mark:hc
 */
public class LoginPersen {
    //ui界面
    private LoginView loginView;
    //逻辑处理
    private LoginModule loginModule;
    /**
     * 倒计时/获取验证码
     */
    private Timer timer;
    private int time;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String code = (String) msg.obj;
            switch (msg.arg1) {
                case 1:
                    loginView.setCode_txt(code);
                    break;
                case 2:
                    loginView.setCode(code);
                    break;
                default:
            }
        }
    };

    /**
     * 数据库
     */
    private RealmSql realmSql;


    //初始化
    public LoginPersen(LoginView loginView) {
        this.loginView = loginView;
        loginModule = new LoginModule();
        realmSql = new RealmSql();
    }


    /**
     * 获取验证码
     */
    public void onCode() {
        if (timer == null) {
            timer = new Timer();
        }
        time = 60;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                --time;
                loginModule.OnCodeLister(String.valueOf(time), new LoginModuleImp.OnCodeLister() {
                    @Override
                    public void codeGet(String code) {
                        codeEnd();
                        Message message = new Message();
                        message.arg1 = 1;
                        message.obj = code;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void codeCountDown(String code) {
                        Message message = new Message();
                        message.arg1 = 1;
                        message.obj = code;
                        handler.sendMessage(message);
                    }
                });

            }
        }, 0, 1000);
    }

    /**
     * 模拟登录
     */
    public void onLogin() {
        loginModule.OnLoginLister(loginView.getUsername(), loginView.getCodeInput(), new LoginModuleImp.OnLoginLister() {
            @Override
            public void OnSuccess(String result) {
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setUsername(loginView.getUsername());
                loginEntity.setCode(loginView.getCodeInput());
                realmSql.saveObject(loginEntity);
                RealmResults<LoginEntity> loginActivities = realmSql.findAll(LoginEntity.class);
                int i = 0;
                for (LoginEntity l1 : loginActivities) {
                    Log.e(i++ + "", l1.toString());
                }
                loginView.setOnSuccess(result);
            }

            @Override
            public void OnError(String error) {
                loginView.setOnError(error);
            }
        });
    }


    /**
     * 结束timer所有线程任务
     * 清空所有handler消息
     */
    public void codeEnd() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        handler.removeCallbacks(null);
    }
}
