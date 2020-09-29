package cn.xmz.domain;

import java.util.Date;

public class UserDate {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserDate{" +
                "date=" + date +
                '}';
    }
}
