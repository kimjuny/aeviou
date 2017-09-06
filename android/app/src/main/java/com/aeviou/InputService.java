package com.aeviou;

import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;

/**
 * Created by erickim on 2017/8/26.
 */
public class InputService extends InputMethodService {

    public static InputService instance;

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public View onCreateInputView() {
        // create react-native Keyboard View
        mReactRootView = new ReactRootView(this);
//        mReactRootView.setBackgroundColor(getResources().getColor(android.R.color.transparent));

//        LinearLayout inputView = (LinearLayout) getLayoutInflater().inflate(R.layout.inputlayout, null);

        LinearLayout inputView = new LinearLayout(this);
        inputView.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        inputView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        inputView.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(this);
        textView.setText("this is a test textview!");

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(AeviouPackage.getInstance())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        mReactRootView.startReactApplication(mReactInstanceManager, "IME", null);

        inputView.addView(textView);
        Log.d("InputService", "TextView - get height " + textView.getHeight());
        Log.d("InputService", "TextView - get measured height " + textView.getMeasuredHeight());
        Log.d("InputService", "ReactRootView - get height " + mReactRootView.getHeight());
        Log.d("InputService", "ReactRootView - get measured height " + mReactRootView.getMeasuredHeight());
        inputView.addView(mReactRootView);

        return inputView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // CTRL + M hooks dev menu
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
