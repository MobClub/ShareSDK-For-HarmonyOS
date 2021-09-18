package cn.yoozoo.mob.DayDay.slice;

import cn.yoozoo.mob.DayDay.ResourceTable;
import cn.yoozoo.mob.DayDay.slice.share.ShareSlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;

public class MainAbilitySlice extends BaseAbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initComponents();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    protected void initComponents() {
        findComponentById(ResourceTable.Id_share_btn).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                present(new ShareSlice(),new Intent());
            }
        });
        super.initComponents();
    }
}
