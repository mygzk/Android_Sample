package com.gzk.sample.model;

/**
 * Created by gzhenk on 16-1-22.
 */
public class MyActivity {
    private Class myClassActivity;
    private String decriptionText;

    public MyActivity(Class myClassActivity, String decriptionText) {
        this.myClassActivity = myClassActivity;
        this.decriptionText = decriptionText;
    }

    public Class getMyClassActivity() {
        return myClassActivity;
    }

    public void setMyClassActivity(Class myClassActivity) {
        this.myClassActivity = myClassActivity;
    }

    public String getDecriptionText() {
        return decriptionText;
    }

    public void setDecriptionText(String decriptionText) {
        this.decriptionText = decriptionText;
    }
}
