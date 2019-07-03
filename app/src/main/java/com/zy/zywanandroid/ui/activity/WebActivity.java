package com.zy.zywanandroid.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.zy.framework.base.BaseActivity;
import com.zy.framework.util.LogUtil;
import com.zy.zywanandroid.R;

import butterknife.BindView;

public class WebActivity extends BaseActivity {

    public static final String EXTRA_TITLE = "zy_web_title";
    public static final String EXTRA_URL = "zy_web_url";
    String mTitle;
    String mUrl;
    private AgentWeb agentWeb;
    private static final String TAG="WebActivity";

    @BindView(R.id.layout_progress)
    FrameLayout layout_progress;

    public static void start(Context context,String mTitle,String mUrl){
        Intent intent = new Intent(context,WebActivity.class);
        intent.putExtra(EXTRA_TITLE,mTitle);
        intent.putExtra(EXTRA_URL,mUrl);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_web;
    }

    @Override
    protected void beforeSetContentView() {
        if (getIntent() != null){
            mTitle = getIntent().getStringExtra(EXTRA_TITLE);
            mUrl = getIntent().getStringExtra(EXTRA_URL);
        }
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        super.initToolbar(toolbar);
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(mTitle);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        LogUtil.d(TAG,null,"title:%s,url:%s",mTitle,mUrl);
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(layout_progress, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator(-1, 3)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(mUrl);

        agentWeb.getWebCreator().getWebView().setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {

                    if (!url.startsWith("http:") &&!url.startsWith("https:")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                }
                catch (Exception e){
                    return false;
                }
                view.loadUrl(url);
                return true;
//                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (agentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onPause() {
        agentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        agentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        agentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    protected boolean showToolbar() {
        return true;
    }
}
