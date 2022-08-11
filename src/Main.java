import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {
        Connection conn = new Connection();
        conn.connection();
        News news = new News("Greeting", "Hello world! I'm here)", "2021-03-12");
        conn.createNews(news);//1
        conn.getNews();//2
        conn.deleteNews(5);//3
        News upNews = new News("", "My name is Bakay, I'm future programmer", "2022-08-11");
        conn.updateNews(upNews, 6);//4
    }
}