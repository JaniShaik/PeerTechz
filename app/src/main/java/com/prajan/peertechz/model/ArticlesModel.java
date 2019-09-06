package com.prajan.peertechz.model;

public class ArticlesModel {
    private String txtname;
    private String txtmessage;
    private int profilephoto;

    public ArticlesModel(String txtname, String txtmessage, int profilephoto) {
        this.txtname = txtname;
        this.txtmessage=txtmessage;
        this.profilephoto = profilephoto;
    }

    public String getTxtname() {
        return txtname;
    }

    public void setTxtname(String txtname) {
        this.txtname = txtname;
    }

    public String getTxtmessage() {
        return txtmessage;
    }

    public void setTxtmessage(String txtmessage) {
        this.txtmessage = txtmessage;
    }

    public int getProfilephoto() {
        return profilephoto;
    }

    public void setProfilephoto(int profilephoto) {
        this.profilephoto = profilephoto;
    }
}
