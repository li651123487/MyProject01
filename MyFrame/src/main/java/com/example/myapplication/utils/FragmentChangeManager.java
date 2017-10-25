package com.example.myapplication.utils;

import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * @author Zhaop
 * @Description fragment切换管理器 @version
 * @type <T>
 */
public class FragmentChangeManager {

    private final HashMap<String, TabInfo> mTabs=new HashMap<String, TabInfo>();

    private TabInfo mLastTab;

    private FragmentActivity mActivity;

    private int mContainerId;

    public FragmentChangeManager(FragmentActivity activity, int containerId) {
        this.mActivity=activity;
        this.mContainerId=containerId;
    }

    public void addFragment(String tag, Class<?> clss, Bundle args) {
        if(mActivity == null)
            return;
        TabInfo info=new TabInfo(tag, clss, args);

        // Check to see if we already have a fragment for this tab, probably
        // from a previously saved state. If so, deactivate it, because our
        // initial state is that a tab isn't shown.

        info.fragment=mActivity.getSupportFragmentManager().findFragmentByTag(tag);
        if(info.fragment != null && !info.fragment.isDetached()) {
            FragmentTransaction ft=mActivity.getSupportFragmentManager().beginTransaction();
            ft.detach(info.fragment);
//            info.fragment.setArguments(args);
            ft.commit();
        }

        mTabs.put(tag, info);
    }

    public void onFragmentChanged(String tabId) {
        if(mActivity == null)
            return;
        TabInfo newTab=mTabs.get(tabId);
        if(mLastTab != newTab) {
            FragmentTransaction ft=mActivity.getSupportFragmentManager().beginTransaction();
            if(mLastTab != null) {
                if(mLastTab.fragment != null) {
                    ft.hide(mLastTab.fragment);
                }

            }
            if(newTab != null) {
                if(newTab.fragment == null || !newTab.fragment.isAdded()) {
                    newTab.fragment=Fragment.instantiate(mActivity, newTab.clss.getName(), newTab.args);
                    ft.add(mContainerId, newTab.fragment, newTab.tag);
                } else {
                    ft.show(newTab.fragment);
                }
            }

            mLastTab=newTab;
            ft.commit();
            mActivity.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public Fragment getFragmentByTag(String tag) {
        return mTabs.get(tag).fragment;
    }

    static final class TabInfo {

        private final String tag;

        private final Class<?> clss;

        private final Bundle args;

        private Fragment fragment;

        TabInfo(String _tag, Class<?> _class, Bundle _args) {
            tag=_tag;
            clss=_class;
            args=_args;
        }
    }
}