package cn.yoozoo.mob.DayDay.slice.share;

import cn.yoozoo.mob.DayDay.ResourceTable;
import cn.yoozoo.mob.DayDay.slice.BaseAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;

/**
 * 分享界面
 */
public class ShareSlice extends BaseAbilitySlice implements Component.ClickedListener {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_share);
        initComponents();
    }

    @Override
    protected void initComponents() {
        findComponentById(ResourceTable.Id_wechat).setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_QQ).setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_Sina).setClickedListener(this::onClick);
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_wechat:
                present(new WechatSlice(),new Intent());
                break;
            case ResourceTable.Id_QQ:
                present(new QQSlice(),new Intent());
                break;
            case ResourceTable.Id_Sina:
                present(new SinaSlice(),new Intent());
                break;

        }
    }

    @Override
    protected String getLable() {
        return "分享";
    }
}
