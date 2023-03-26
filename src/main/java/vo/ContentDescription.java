package vo;

public class ContentDescription {
    private String contentId;
    private String overview;

    public ContentDescription() {
    }

    public ContentDescription(String contentId, String overview) {
        this.contentId = contentId;
        this.overview = overview;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
