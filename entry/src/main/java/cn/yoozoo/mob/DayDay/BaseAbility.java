package cn.yoozoo.mob.DayDay;

import ohos.aafwk.ability.Ability;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;

public abstract class BaseAbility extends Ability {

    private void initTitle() {
        findComponentById(ResourceTable.Id_back).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                onStop();
            }
        });
        Text titleText= (Text) findComponentById(ResourceTable.Id_title);
        titleText.setText(getLable());
    }

    protected void initComponents() {
        initTitle();
    }
    protected String getLable() {
        return "";
    }
}
