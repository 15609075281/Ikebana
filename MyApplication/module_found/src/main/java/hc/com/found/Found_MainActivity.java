package hc.com.found;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;

@Route(path = ARouterAddressManager.FOUND_MAIN)
public class Found_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found_activity_main);
        findViewById(R.id.found_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterAddressManager.ME_MAIN).navigation();
            }
        });
    }
}
