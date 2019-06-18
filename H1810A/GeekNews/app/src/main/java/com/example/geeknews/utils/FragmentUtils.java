package com.example.geeknews.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

public class FragmentUtils {

    public static void addFragment(FragmentManager fragmentManager, Class<? extends Fragment> tClass, int layoutId) {
        addFragment(fragmentManager, tClass, layoutId, null, false);
    }

    public static void addFragment(FragmentManager fragmentManager, Class<? extends Fragment> tClass, int layoutId, Bundle bundle) {
        addFragment(fragmentManager, tClass, layoutId, bundle, false);
    }

    public static void addFragment(FragmentManager fragmentManager, Class<? extends Fragment> tClass, int layoutId, Bundle bundle, boolean isNeedToBackStack) {

        String tag = tClass.getName();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragment == null) {
            try {
                fragment = tClass.newInstance();
                fragment.setArguments(bundle);
                transaction.add(layoutId, fragment);
                hideOtherFragment(fragmentManager, transaction, fragment);//隐藏其他
                if (isNeedToBackStack) {
                    transaction.addToBackStack(tag);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    fragment.setArguments(bundle);
                    transaction.show(fragment);
                    hideOtherFragment(fragmentManager, transaction, fragment);
                }
            } else {
                fragment.setArguments(bundle);
                transaction.add(layoutId, fragment, tag);
                hideOtherFragment(fragmentManager, transaction, fragment);
            }
        }
        transaction.commit();
    }

    private static void hideOtherFragment(FragmentManager fragmentManager, FragmentTransaction transaction, Fragment willShowFragment) {
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != willShowFragment && !fragment.isHidden())
                transaction.hide(fragment);
        }
    }
}
