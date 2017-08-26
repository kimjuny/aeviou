package com.aeviou;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

/**
 * Created by erickim on 2017/8/26.
 */
public class AeviouPackage extends MainReactPackage {

    public static AeviouPackage instance;

    public static AeviouPackage getInstance() {
        // TODO: singleton
        if (instance == null) {
            instance = new AeviouPackage();
        }
        return instance;
    }

    @Override
    public List<ModuleSpec> getNativeModules(final ReactApplicationContext context) {
        List<ModuleSpec> nativeModules = new ArrayList<>(super.getNativeModules(context));
        nativeModules.add(new ModuleSpec(AeviouModule.class, new Provider<NativeModule>() {
            @Override
            public NativeModule get() {
                return new AeviouModule(context);
            }
        }));
        return nativeModules;
    }
}
