package itp341.carter.christin.a7.app.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chris on 10/27/2015.
 */
public class Note {
    private String title;
    private String content;
    private Date date;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = Calendar.getInstance().getTime();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate(){
        String formattedDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        formattedDate = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" +
                cal.get(Calendar.YEAR);

        return formattedDate;
    }
}
