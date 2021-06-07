package tool.parsers;

import tool.records.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tool.records.Record;

import java.util.LinkedList;

public class NewsParser extends Parser {

    protected LinkedList<CoursesRecord> coursesList;

    private void parseCoursesCalendar() {
        url = "https://all-events.ru/events/calendar/theme-is-informatsionnye_tekhnologii/";

        Document page = getPage();
        if(page == null) return;
        Elements eventList = page.select("div.event");

        for(Element event : eventList) {
            String title = event.selectFirst("a[class=event-name]").text();
            String type = event.selectFirst("div[class=event-type]").text().toLowerCase();
            String date = event.selectFirst("div[class=event-date]").text();
            String place = event.selectFirst("div[class=event-place]").text().toLowerCase();
            String ref = "https://all-events.ru" + event.selectFirst("a").attr("href");

            coursesList.add(new CoursesRecord(title, type, date, place, ref));
        }
    }

    public LinkedList<CoursesRecord> CoursesList() {
        coursesList = new LinkedList<>();
        parseCoursesCalendar();

        return coursesList;
    }
}