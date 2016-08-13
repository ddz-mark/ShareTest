package app.example.com.sharetest;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by Dudaizhong on 2016/7/11.
 */
public class Show
{
    public static void showInfo(int id)
    {
        switch (id)
        {
            case 1:
                Toast.makeText(MyApplication.getContext(),"QQ分享成功",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MyApplication.getContext(),"取消分享",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MyApplication.getContext(),"分享失败",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
