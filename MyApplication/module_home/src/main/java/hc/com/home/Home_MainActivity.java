package hc.com.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;

@Route(path = ARouterAddressManager.HOME_MAIN_HOME)
public class Home_MainActivity extends AppCompatActivity {
    public static  final String TAG="Home_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_mainactivity);
        findViewById(R.id.home_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"开始");
                ARouter.getInstance().build(ARouterAddressManager.CLASSIFY_MAIN).navigation();
                Log.e(TAG,"结束");
            }
        });
    }
}
