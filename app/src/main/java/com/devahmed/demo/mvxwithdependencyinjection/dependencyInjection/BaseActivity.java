package com.devahmed.demo.mvxwithdependencyinjection.dependencyInjection;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot controllerCompostionRoot;

    private CompositionRoot compositionRoot;

    protected ControllerCompositionRoot getCompositionRoot(){
        compositionRoot = new CompositionRoot();
        if(controllerCompostionRoot == null){
            controllerCompostionRoot =
                    new ControllerCompositionRoot(compositionRoot, this);
        }
        return controllerCompostionRoot;
    }


}
