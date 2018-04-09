package hc.com.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;

/**
 * Created by Administrator on 2018/4/9.
 */
@Route(path = ARouterAddressManager.APP_TEST)
public class TestActivity extends AppCompatActivity {
    public static  final String TAG="TestActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Log.e(TAG,"TEST");
        findViewById(R.id.app_test_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"开始");
                ARouter.getInstance().build(ARouterAddressManager.HOME_MAIN_HOME).navigation();
                Log.e(TAG,"结束");
            }
        });

    }
}
