package com.example.dell.pandalive.ui.home.presenter;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/25.
 */

public interface IHomePresenter {

    void ShowBanner();
    void SendBanner(ArrayList<String> imalist, ArrayList<String> titlelist);
}
