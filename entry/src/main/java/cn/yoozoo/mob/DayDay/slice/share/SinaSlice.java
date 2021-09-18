package cn.yoozoo.mob.DayDay.slice.share;

import android.net.Uri;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.yoozoo.mob.DayDay.ResourceTable;
import cn.yoozoo.mob.DayDay.manager.share.ShareTypeManager;
import cn.yoozoo.mob.DayDay.slice.BaseAbilitySlice;
import com.mob.MobSDK;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

import java.io.File;

public class SinaSlice extends BaseAbilitySlice implements Component.ClickedListener {
    Platform platform;
    private ShareTypeManager manager;
    private Button share_text_btn;
    private Button share_image_btn;
    private Button share_music_btn;
    private Button share_video_btn;
    private Button share_link_btn;
    private Button share_small_program_btn;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_share_sina_layout);
        initComponents();


    }

    @Override
    protected void initComponents() {
        super.initComponents();
        manager = new ShareTypeManager(this);
        platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        share_text_btn = (Button) findComponentById(ResourceTable.Id_share_text_btn);
        share_text_btn.setClickedListener(this::onClick);
        share_image_btn = (Button) findComponentById(ResourceTable.Id_share_image_btn);
        share_image_btn.setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_share_music_btn).setVisibility(Component.HIDE);
        share_video_btn = (Button) findComponentById(ResourceTable.Id_share_video_btn);
        share_video_btn.setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_share_emoj_btn).setVisibility(Component.HIDE);
        share_link_btn = (Button) findComponentById(ResourceTable.Id_share_link_btn);
        share_link_btn.setVisibility(Component.VISIBLE);
        share_link_btn.setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_share_small_program_btn).setVisibility(Component.HIDE);
    }

    @Override
    protected String getLable() {
        return "Sina分享";
    }

    @Override
    public void onClick(Component component) {
        if (null == platform || null == manager) {
            return;
        }
        switch (component.getId()) {
            case ResourceTable.Id_share_text_btn:
                manager.shareText(platform);
                break;
            case ResourceTable.Id_share_image_btn:
                manager.shareImage(platform);
                break;
            case ResourceTable.Id_share_video_btn:
                manager.shareVideo(platform);
                break;
            case ResourceTable.Id_share_link_btn:
                manager.shareWebPage(platform);
                break;

        }
    }


}
