package com.example.lenovo.xiongmaopindao.bean;

/**
 * Created by lenovo on 2017/12/20.
 */
public class SetString {
    private String name;
    private String url;

    public SetString(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SetString{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
