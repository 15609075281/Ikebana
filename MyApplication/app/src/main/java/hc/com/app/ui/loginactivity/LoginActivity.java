package hc.com.app.ui.loginactivity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import com.hc.libs_base.Entity.loginentity.LoginEntity;
import com.hc.libs_base.database.realm.RealmSql;
import hc.com.app.R;
import hc.com.app.persen.loginpersen.LoginPersen;
import hc.com.app.view.loginview.LoginView;
import io.realm.RealmResults;


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
    private EditText code_input;
    private TextView code_get;
    private TextView login;

    @Override
    public int intiView() {
        return R.layout.app_loginactivity_xml;
    }

    @Override
    public void findView() {

        context = LoginActivity.this;
        loginPersen = new LoginPersen(LoginActivity.this);

        username = (EditText) findViewById(R.id.app_login_username);
        code_input = (EditText) findViewById(R.id.code_input);
        code_get = (TextView) findViewById(R.id.code_get);
        login = (TextView) findViewById(R.id.app_login_login);
        code_get.setOnClickListener(lister);
        login.setOnClickListener(lister);
    }

    android.view.View.OnClickListener lister = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.code_get:
                    loginPersen.onCode();
                    break;
                case R.id.app_login_login:
                    loginPersen.onLogin();
                    break;
                default:
            }


        }
    };


    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public void setCode_txt(String code) {
        code_get.setText(code);
        code_get.setOnClickListener(lister);
    }

    @Override
    public void setCode(String code) {
        code_get.setText(code);
        code_get.setOnClickListener(null);
    }

    @Override
    public String getCodeInput() {
        return code_input.getText().toString();
    }


    @Override
    public void setOnSuccess(String success) {
        Toast.makeText(context, success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setOnError(String error) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPersen.codeEnd();
    }
}
