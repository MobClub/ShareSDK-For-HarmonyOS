package cn.yoozoo.mob.DayDay;

import android.text.Html;
import cn.yoozoo.mob.DayDay.slice.MainAbilitySlice;
import cn.yoozoo.mob.DayDay.slice.share.ShareSlice;
import cn.yoozoo.mob.DayDay.slice.share.WechatSlice;
import com.mob.MobSDK;
import com.mob.PrivacyPolicy;
import ohos.aafwk.content.Intent;
import ohos.agp.window.dialog.ToastDialog;
import ohos.bundle.IBundleManager;

public class MainAbility extends BaseAbility {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        addActionRoute("action.share", ShareSlice.class.getName());
        addActionRoute("action.wechat", WechatSlice.class.getName());
        initComponents();
        checkPermission();
        queryPrivacy();

    }

    private void askPrivacy(String content) {
        getUITaskDispatcher().asyncDispatch(new Runnable() {
            @Override
            public void run() {
                PrivacyDialog dialog = new PrivacyDialog(MainAbility.this, content);
                dialog.show();
            }
        });

    }

    @Override
    protected void initComponents() {
    }

    private void checkPermission() {
        if (verifySelfPermission("ohos.permission.READ_USER_STORAGE") != IBundleManager.PERMISSION_GRANTED) {
            requestPermissionsFromUser(new String[]{"ohos.permission.READ_USER_STORAGE"}, 1);
        }
        if (verifySelfPermission("ohos.permission.WRITE_USER_STORAGE") != IBundleManager.PERMISSION_GRANTED) {
            requestPermissionsFromUser(new String[]{"ohos.permission.WRITE_USER_STORAGE"}, 1);
        }
    }

    private void queryPrivacy() {

        // 异步方法
        MobSDK.getPrivacyPolicyAsync(MobSDK.POLICY_TYPE_URL, new PrivacyPolicy.OnPolicyListener() {
            @Override
            public void onComplete(PrivacyPolicy data) {
                if (data != null) {
                    // 富文本内容
                    String content = data.getContent();
                    String realText = getString(ResourceTable.String_privacy_content) + getString(ResourceTable.String_privacy_details) + Html.fromHtml(content) + "";
                    askPrivacy(realText);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // 请求失败
                new ToastDialog(MainAbility.this).setText("获取隐私协议内容失败！").setDuration(1000).show();
            }
        });
    }
}
