package app.example.com.sharetest;

import android.os.Message;
import android.util.Log;

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
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Dudaizhong on 2016/7/11.
 * 分享内容文档
 * http://wiki.mob.com/%E4%B8%8D%E5%90%8C%E5%B9%B3%E5%8F%B0%E5%88%86%E4%BA%AB%E5%86%85%E5%AE%B9%E7%9A%84%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E/
 *1-4分别为QQ，微博，微信，空间
 */
public class Share
{
    public static void shares(int id)
    {
        ShareSDK.initSDK(MyApplication.getContext());
            switch (id)
            {
                case 1://QQ
                    QQ.ShareParams sp = new QQ.ShareParams();
                    sp.setTitle("测试分享的标题");
                    sp.setTitleUrl("http://sharesdk.cn"); // 标题的超链接
                    sp.setText("测试分享的文本");
                    sp.setImageUrl("http://f1.sharesdk.cn/imgs/2014/05/21/oESpJ78_533x800.jpg");//分享网络图片
                    Platform qq = ShareSDK.getPlatform(QQ.NAME);
                    qq.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            if (platform.getName().equals(QQ.NAME)) {// 判断成功的平台是不是QQ
                                Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                    @Override
                                    public void call(Integer integer) {
                                        Show.showInfo(integer);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(Platform platform, int i, Throwable throwable) {
                            throwable.printStackTrace();
                            Observable.just(3).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }
                        @Override
                        public void onCancel(Platform platform, int i) {
                            Observable.just(2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }
                    });
                    qq.share(sp);
                    break;
                case 2://微博
                    SinaWeibo.ShareParams wbsp = new SinaWeibo.ShareParams();
                    wbsp.setText("我是分享的文本 分享文本 http://www.baidu.com");
                    wbsp.setImageUrl("http://f1.sharesdk.cn/imgs/2014/05/21/oESpJ78_533x800.jpg");
                    Platform wb = ShareSDK.getPlatform(SinaWeibo.NAME);
                    wb.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            if (platform.getName().equals(SinaWeibo.NAME)) {// 判断成功的平台是不是新浪微博
                                Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                    @Override
                                    public void call(Integer integer) {
                                        Show.showInfo(integer);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(Platform platform, int i, Throwable throwable)
                        {
                            throwable.printStackTrace();
                            Observable.just(3).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }

                        @Override
                        public void onCancel(Platform platform, int i) {
                            Observable.just(2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }
                    });
                    wb.share(wbsp);
                    break;
                case 3://微信
                    WechatMoments.ShareParams wxsp = new WechatMoments.ShareParams();
                    wxsp.setTitle("我来组成头部");
                    wxsp.setUrl("http://www.baidu.com");
                    wxsp.setImageUrl("http://f1.sharesdk.cn/imgs/2014/05/21/oESpJ78_533x800.jpg");
                    wxsp.setShareType(Platform.SHARE_WEBPAGE);

                    Platform wx = ShareSDK.getPlatform(WechatMoments.NAME);
                    wx.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap)
                        {
                            if (platform.getName().equals(WechatMoments.NAME)) {// 判断成功的平台是不是QQ
                                Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                    @Override
                                    public void call(Integer integer) {
                                        Show.showInfo(integer);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(Platform platform, int i, Throwable throwable)
                        {
                            throwable.printStackTrace();
                            Observable.just(3).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }

                        @Override
                        public void onCancel(Platform platform, int i) {
                            Observable.just(2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }
                    });
                    wx.share(wxsp);
                    break;
                case 4://Qzone
                    Log.d("shareqz","ok");
                    QZone.ShareParams qzsp = new QZone.ShareParams();
                    qzsp.setTitle("我来组成头部");
                    qzsp.setTitleUrl("http://www.baidu.com");
                    qzsp.setText("我来组成身体");
                    qzsp.setImageUrl("http://f1.sharesdk.cn/imgs/2014/05/21/oESpJ78_533x800.jpg");
                    qzsp.setSite("我是site");
                    qzsp.setSiteUrl("http://www.campussay.com/");
                    Platform qzone = ShareSDK.getPlatform(QZone.NAME);
                    qzone.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            if (platform.getName().equals(QZone.NAME)) {// 判断成功的平台是不是新浪微博
                                Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                    @Override
                                    public void call(Integer integer) {
                                        Show.showInfo(integer);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(Platform platform, int i, Throwable throwable) {
                            throwable.printStackTrace();
                            Observable.just(3).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }

                        @Override
                        public void onCancel(Platform platform, int i)
                        {
                            Observable.just(2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
                                @Override
                                public void call(Integer integer) {
                                    Show.showInfo(integer);
                                }
                            });
                        }
                    });
                    qzone.share(qzsp);
                    break;
                default:
                    break;
            }



            }





}
