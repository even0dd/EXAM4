public class News {
    private String title;
    private String content;
    private String data;


    public News(String title, String content, String date) {
        this.title = title;
        this.content = content;
        if (date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            this.data = date;
        } else {
            this.data = "2022-08-08";
        }
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}