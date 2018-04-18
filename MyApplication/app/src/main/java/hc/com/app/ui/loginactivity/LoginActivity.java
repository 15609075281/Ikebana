package hc.com.app.ui.loginactivity;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import hc.com.app.R;
import hc.com.app.persen.loginpersen.LoginPersen;
import hc.com.app.view.loginview.LoginView;

/**
 * Created by Administrator on 2018/4/13.
 * maek:hc
 */
@Route(path = ARouterAddressManager.APP_LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity implements LoginView {

    private final String TAG = "LoginActivity";
    private Context context;

    private LoginPersen loginPersen;

    private EditText username;
    private EditText password;
    private TextView login;


    @Override
    public int intiView() {
        return R.layout.app_loginactivity_xml;
    }

    @Override
    public void findView() {
        context = LoginActivity.this;
        username = (EditText) findViewById(R.id.app_login_username);
        password = (EditText) findViewById(R.id.app_login_password);
        login = (TextView) findViewById(R.id.app_login_login);
        login.setOnClickListener(lister);
    }

    android.view.View.OnClickListener lister = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.app_login_login:
                    loginPersen=new LoginPersen(LoginActivity.this);
                    loginPersen.onLogin();
                    break;

                default:
                    Toast.makeText(context, "已超出范围", Toast.LENGTH_LONG).show();
            }


        }
    };


    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getPassWord() {
        return password.getText().toString();
    }

    @Override
    public void setOnSuccess(String success) {
        Toast.makeText(context, success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setOnError(String error) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }
}
