package com.wildma.wildmajpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import static com.wildma.wildmajpush.TagAliasOperatorHelper.ACTION_DELETE;
import static com.wildma.wildmajpush.TagAliasOperatorHelper.ACTION_SET;
import static com.wildma.wildmajpush.TagAliasOperatorHelper.TagAliasBean;
import static com.wildma.wildmajpush.TagAliasOperatorHelper.sequence;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mMessageBroadcastreceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBroadcastreceiver();
    }

    /**
     * 设置别名
     */
    public void setAlias(View view) {
        String alias = ((EditText) findViewById(R.id.et_alias)).getText().toString();
        if (!TextUtils.isEmpty(alias)) {
            TagAliasBean tagAliasBean = new TagAliasBean();
            tagAliasBean.action = ACTION_SET;
            sequence++;
            tagAliasBean.alias = alias;
            tagAliasBean.isAliasAction = true;
            TagAliasOperatorHelper.getInstance().handleAction(getApplicationContext(), sequence, tagAliasBean);
        }
    }

    /**
     * 删除别名
     */
    public void deleteAlias(View view) {
        TagAliasBean tagAliasBean = new TagAliasBean();
        tagAliasBean.action = ACTION_DELETE;
        sequence++;
        tagAliasBean.isAliasAction = true;
        TagAliasOperatorHelper.getInstance().handleAction(getApplicationContext(), sequence, tagAliasBean);
    }

    /**
     * 注册广播接收者
     */
    private void registerBroadcastreceiver() {
        mMessageBroadcastreceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                CommonUtil.showToast("收到推送消息", MainActivity.this);
            }
        };
        //注册广播
        registerReceiver(mMessageBroadcastreceiver, new IntentFilter(Constant.NOTICE_MESSAGE));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMessageBroadcastreceiver);//解注册广播
    }

}
