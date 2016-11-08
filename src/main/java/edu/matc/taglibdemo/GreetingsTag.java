package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Created by student on 10/26/16.
 */
public class GreetingsTag extends SimpleTagSupport {
    private static final String GOOD_MORNING = "Good Morning!";
    private static final String GOOD_AFTERNOON= "Good Afternoon!";
    private static final String GOOD_EVENING = "Good Evening!";
    private static final String GOOD_NIGHT = "Good Night!";
    private static final String HAPPY_THANKSGIVING= "Happy Thanksgiving!";
    private static final String HAPPY_HALLOWEEN = "Happy Halloween!";

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        LocalDateTime localDatetime =  LocalDateTime.now();

        int hourOfDay = localDatetime.getHour();
        int day = localDatetime.getDayOfMonth();
        int month = localDatetime.getMonthValue();
        if (hourOfDay < 12)
            out.println(GOOD_MORNING);
        else if (hourOfDay < 18)
            out.println(GOOD_AFTERNOON);
        else if (hourOfDay < 21 )
            out.println(GOOD_EVENING);
        else
            out.println(GOOD_NIGHT);

        if (day == 31 && month == 10)
            out.println(HAPPY_HALLOWEEN);
        else  if (day == 24 && month == 11)
            out.println(HAPPY_THANKSGIVING);

    }
}
