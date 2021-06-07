package form;

import tool.records.CoursesRecord;
import tool.parsers.NewsParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class NewsForm extends JFrame {

    private String username;

    Container container = getContentPane();
    private JLabel titleLabel;
    public JButton configButton;

    public NewsForm(String username, ActionListener listener) {
        super("Новости");
        this.username = new String(username);

        titleLabel = new JLabel("Новости");
        configButton = new JButton("Настройки");

        addComponents();
        getNews();

        configButton.addActionListener(listener);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(700, 300, 600, 400);
        super.setVisible(true);
    }

    private void addComponents() {
        titleLabel.setBounds(20,0,100,50);
        configButton.setBounds(200, 10, 150, 25);

        container.add(titleLabel);
        container.add(configButton);
    }

    private void getNews() {
        NewsParser parser = new NewsParser();
        LinkedList<CoursesRecord> news = parser.CoursesList();

        int heightStep = 40, startHeight = 0;
        for(int i = 0; i < 11; i++) {
            if(i > news.size()) return;

            CoursesRecord record = news.get(i);
            JLabel newsLabel = new JLabel("" + (i+1) + ": " + record.title + " " + record.description + " - " + record.date);
            container.add(newsLabel).setBounds(20, startHeight + heightStep*(i+1), 600, 50);
        }

    }
}
