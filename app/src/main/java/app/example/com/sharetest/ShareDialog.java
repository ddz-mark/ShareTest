package app.example.com.sharetest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dudaizhong on 2016/7/11.
 */
public class ShareDialog {
    private Context context;
    private AlertDialog dialog;
    private GridView gridView;
    private RelativeLayout cancelButton;
    private SimpleAdapter saImageItems;
    private int[] image={R.drawable.logo_qq,R.drawable.logo_qzone,R.drawable.logo_sinaweibo,R.drawable.logo_wechat};
    private String[] name={"QQ","QQ空间","新浪微博","微信朋友圈"};

    public ShareDialog(Context context){
        this.context=context;
        dialog=new android.app.AlertDialog.Builder(context).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.share_dialog);
        gridView=(GridView) window.findViewById(R.id.share_gridView);
        cancelButton=(RelativeLayout) window.findViewById(R.id.share_cancel);
        List<HashMap<String, Object>> shareList=new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<image.length;i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", image[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            shareList.add(map);
        }

        saImageItems =new SimpleAdapter(context, shareList, R.layout.share_item, new String[] {"ItemImage","ItemText"}, new int[] {R.id.imageView1,R.id.textView1});
        gridView.setAdapter(saImageItems);
    }

    public void setCancelButtonOnClickListener(View.OnClickListener Listener){
        cancelButton.setOnClickListener(Listener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        gridView.setOnItemClickListener(listener);
    }


    /**
     * 关闭对话框
     */
    public void dismiss() {
        dialog.dismiss();
    }
}
