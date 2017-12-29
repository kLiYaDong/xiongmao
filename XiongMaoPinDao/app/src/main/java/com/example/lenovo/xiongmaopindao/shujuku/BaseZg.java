package com.example.lenovo.xiongmaopindao.shujuku;

import com.example.lenovo.xiongmaopindao.sqilts.AlllistBean;
import com.example.lenovo.xiongmaopindao.sqilts.TablistBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/23.
 */

public class BaseZg {
    private List<TablistBean> tablist;
    private List<AlllistBean> alllist;

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public List<AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<AlllistBean> alllist) {
        this.alllist = alllist;
    }
}
