package cn.yoozoo.mob.DayDay.slice.share;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.yoozoo.mob.DayDay.Const;
import cn.yoozoo.mob.DayDay.ResourceTable;
import cn.yoozoo.mob.DayDay.manager.share.ShareTypeManager;
import cn.yoozoo.mob.DayDay.slice.BaseAbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.RadioContainer;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;

public class QQSlice extends BaseAbilitySlice implements Component.ClickedListener {
    Platform platform;
    Platform qqPlatform;

    Platform qqZonePlatform;
    private ShareTypeManager manager;
    private Button share_text_btn;
    private Button share_image_btn;
    private Button share_music_btn;
    private Button share_video_btn;
    private Button share_link_btn;
    private Button share_small_program_btn;
    public static final int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_share_qq_layout);
        initComponents();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        manager = new ShareTypeManager(this);
        RadioContainer radioContainer = (RadioContainer) findComponentById(ResourceTable.Id_tencent_type_rc);
        radioContainer.setMarkChangedListener(new RadioContainer.CheckedStateChangedListener() {
            @Override
            public void onCheckedChanged(RadioContainer radioContainer, int i) {
                switch (i) {
                    case 0://qq
                        if (null == qqPlatform) {
                            qqPlatform = ShareSDK.getPlatform(QQ.NAME);
                        }
                        platform = qqPlatform;
                        break;
                    case 1://QQ空间
                        if (null == qqZonePlatform) {
                            qqZonePlatform = ShareSDK.getPlatform(QZone.NAME);
                        }
                        platform = qqZonePlatform;
                        break;

                }
                if (0 == i) {
                    share_text_btn.setVisibility(Component.HIDE);
                    share_video_btn.setVisibility(Component.HIDE);
                    share_small_program_btn.setVisibility(Component.HIDE);
                    share_image_btn.setVisibility(Component.VISIBLE);
                    share_link_btn.setVisibility(Component.VISIBLE);
                    share_music_btn.setVisibility(Component.VISIBLE);

                } else {
                    share_music_btn.setVisibility(Component.HIDE);
                    share_small_program_btn.setVisibility(Component.VISIBLE);
                    share_image_btn.setVisibility(Component.VISIBLE);
                    share_link_btn.setVisibility(Component.VISIBLE);
                    share_text_btn.setVisibility(Component.VISIBLE);
                    share_video_btn.setVisibility(Component.VISIBLE);
                }

            }
        });
        share_text_btn = (Button) findComponentById(ResourceTable.Id_share_text_btn);
        share_text_btn.setClickedListener(this::onClick);
        share_image_btn = (Button) findComponentById(ResourceTable.Id_share_image_btn);
        share_image_btn.setClickedListener(this::onClick);
        share_music_btn = (Button) findComponentById(ResourceTable.Id_share_music_btn);
        share_music_btn.setClickedListener(this::onClick);
        share_video_btn = (Button) findComponentById(ResourceTable.Id_share_video_btn);
        share_video_btn.setClickedListener(this::onClick);
        share_link_btn = (Button) findComponentById(ResourceTable.Id_share_link_btn);
        share_link_btn.setClickedListener(this::onClick);
        share_small_program_btn = (Button) findComponentById(ResourceTable.Id_share_small_program_btn);
        share_small_program_btn.setClickedListener(this::onClick);
        findComponentById(ResourceTable.Id_share_emoj_btn).setVisibility(Component.HIDE);
        radioContainer.mark(0);
        findComponentById(ResourceTable.Id_wechat_friend).callOnClick();
    }

    @Override
    protected String getLable() {
        return "QQ分享";
    }

    @Override
    public void onClick(Component component) {
        if (null == platform || null == manager) {
            new ToastDialog(this).setText("请选择分享平台").setDuration(1000).show();
            return;
        }
        switch (component.getId()) {
            case ResourceTable.Id_share_text_btn:
                manager.shareText(platform);
                break;
            case ResourceTable.Id_share_image_btn:
                manager.shareImage(platform);
                break;
            case ResourceTable.Id_share_music_btn:
                manager.shareMusic(platform);
                break;
            case ResourceTable.Id_share_video_btn:
                manager.shareVideo(platform);
                break;
            case ResourceTable.Id_share_link_btn:
                manager.shareWebPage(platform);
                break;
            case ResourceTable.Id_share_small_program_btn:
                manager.shareQQMiniProgram(platform);
                break;
        }
    }

}
