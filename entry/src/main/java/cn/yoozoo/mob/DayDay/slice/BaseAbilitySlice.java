package cn.yoozoo.mob.DayDay.slice;

import android.util.Log;
import cn.yoozoo.mob.DayDay.Const;
import cn.yoozoo.mob.DayDay.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public abstract class BaseAbilitySlice extends AbilitySlice {
    private void initTitle() {
        Image backImage = (Image) findComponentById(ResourceTable.Id_back);
        if (backImage != null) {
            backImage.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    onStop();
                }
            });
        }
        Text titleText = (Text) findComponentById(ResourceTable.Id_title);
        if (titleText != null) {
            titleText.setText(getLable());
        }
    }

    protected String getLable() {
        return "";
    }

    protected void initComponents() {
        initTitle();
    }
}
