import java.sql.*;

public class Connection {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "admin";
    public java.sql.Connection connection() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("hello");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }finally {
            
        }
        return conn;
    }

    public void createNews(News news) {
        String sqlInsertNews = "insert into news (title, text, date) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sqlInsertNews);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setDate(3, Date.valueOf(news.getData()));
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getNews() {
        String sqlSelectNews = "select title, text, date from news";
        try {
            Statement statement = connection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectNews);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title")
                        + " " + resultSet.getString("text")
                        + " " + resultSet.getString("date"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteNews(int id) {
        String sqlDeleteNews = "delete from news where id = ?";
        try {
            PreparedStatement prSt = connection().prepareStatement(sqlDeleteNews);
            prSt.setInt(1, id);
            prSt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateNews(News news, int id) {
        String sqlUpdateNews = "update news set title = ?, text = ?, date = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sqlUpdateNews);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setDate(3, Date.valueOf(news.getData()) );
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}