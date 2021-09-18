package cn.yoozoo.mob.DayDay;

import android.text.Html;
import android.util.Log;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.PrivacyPolicy;
import ohos.agp.components.*;
import ohos.agp.utils.TextAlignment;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.dialog.IDialog;
import ohos.agp.window.dialog.ToastDialog;
import ohos.agp.window.service.DisplayAttributes;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;

public class PrivacyDialog extends CommonDialog {
    private static final String TAG = PrivacyDialog.class.getName();
    /**
     * DIALOG_BOX_CORNER_RADIUS
     */
    public static final float DIALOG_BOX_CORNER_RADIUS = 36.0f;
    /**
     * DIALOG_BOX_WIDTH
     */
    public static final int DIALOG_BOX_WIDTH = 984;
    private Context context;
    private TextField text;//协议内容
    private Button yesBtn;//同意协议内容
    private Button noBtn;//不同意协议内容
    private Component contentComponent;
    private String content;

    public PrivacyDialog(Context context, String content) {
        super(context);
        this.context = context;
        this.content = content;
        init();
    }

    private void init() {
        setCornerRadius(DIALOG_BOX_CORNER_RADIUS);
        setAlignment(TextAlignment.CENTER);
        DisplayAttributes attributes = DisplayManager.getInstance().getDefaultDisplay(context).get().getRealAttributes();
        setSize(DIALOG_BOX_WIDTH, attributes.height * 3 / 5);
        initComponent();
        setAutoClosable(true);
    }

    private void initComponent() {
        contentComponent = LayoutScatter.getInstance(this.context).parse(ResourceTable.Layout_dialog_privacy_layout, null, true);
        text = (TextField) contentComponent.findComponentById(ResourceTable.Id_text);
        yesBtn = (Button) contentComponent.findComponentById(ResourceTable.Id_yes_btn);
        noBtn = (Button) contentComponent.findComponentById(ResourceTable.Id_no_btn);
        yesBtn.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                submitPrivacyGrantResult(true);
                destroy();
            }
        });
        noBtn.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                submitPrivacyGrantResult(false);
                destroy();
            }
        });
        text.setText(content);
        setContentCustomComponent(contentComponent);
    }



    private void submitPrivacyGrantResult(boolean granted) {
        MobSDK.submitPolicyGrantResult(granted, new OperationCallback<Void>() {
            @Override
            public void onComplete(Void data) {
                Log.e(TAG, "隐私协议授权结果提交：成功 ");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "隐私协议授权结果提交：失败: " + t);
            }
        });
    }
}
