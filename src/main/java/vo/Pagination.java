package vo;

public class Pagination {

    private String pgno;
    private String word;
    private String content_type_id;

    public Pagination() {
    }

    public Pagination(String pgno, String word, String content_type_id) {
        this.pgno = pgno;
        this.word = word;
        this.content_type_id = content_type_id;
    }

    public String getPgno() {
        return pgno;
    }

    public void setPgno(String pgno) {
        this.pgno = pgno;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getContent_type_id() {
        return content_type_id;
    }

    public void setContent_type_id(String content_type_id) {
        this.content_type_id = content_type_id;
    }
}
