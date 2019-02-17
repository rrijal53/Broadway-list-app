package com.rowsun.noticeapp.pojo;

public class Notice
{
    private String date;

    private String url;

    private String notice;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getNotice ()
    {
        return notice;
    }

    public void setNotice (String notice)
    {
        this.notice = notice;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", url = "+url+", notice = "+notice+"]";
    }
}