package app.example.com.sharetest;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;


import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;


import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.moments.WechatMoments;
import rx.Observable;
import rx.Subscriber;
import rx.observers.Observers;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button shareButton;
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ShareSDK.initSDK(this);
    }

    private void initView() {
        shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_button:
                shareDialog = new ShareDialog(this);
                shareDialog.setCancelButtonOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        shareDialog.dismiss();

                    }
                });
                shareDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                                            int arg2, long arg3) {
                        HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
                        if (item.get("ItemText").equals("QQ")) {
                            Share.shares(1);
                        } else if (item.get("ItemText").equals("QQ空间")) {
                            Log.d("qz", "ok");
                            Share.shares(4);
                        } else if (item.get("ItemText").equals("新浪微博")) {
                            Log.d("weibo", "ok");
                            Share.shares(2);
                        } else if (item.get("ItemText").equals("微信朋友圈")) {
                            Log.d("wx", "ok");
                            Share.shares(3);
                        } else {
                            Log.d("ylm", "itemerror");
                        }
                        shareDialog.dismiss();

                    }
                });

                break;
            default:
                break;
        }

    }
}
