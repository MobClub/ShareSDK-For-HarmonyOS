package cn.yoozoo.mob.DayDay;

import com.mob.MobSDK;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {
        super.onInitialize();
        MobSDK.init(MobSDK.getContext(),"2dbe655e88c80","a7b9f1918c596eacbff8a172ba8ed158");
    }

}
