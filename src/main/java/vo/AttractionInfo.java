package vo;

public class AttractionInfo {
    String contentId;
    String contentTypeId;
    String title;
    String addr1;
    String addr2;
    String zipcode;
    String tel;
    String firstImage;
    String firstImage2;
    String readCount;
    String sidoCode;
    String gugunCode;
    String latitude;
    String longitude;
    String mlevel;
    public AttractionInfo() {}

    public AttractionInfo(String contentId, String contentTypeId, String title, String addr1, String addr2, String zipcode, String tel, String firstImage, String firstImage2, String readCount, String sidoCode, String gugunCode, String latitude, String longitude, String mlevel) {
        this.contentId = contentId;
        this.contentTypeId = contentTypeId;
        this.title = title;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.zipcode = zipcode;
        this.tel = tel;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.readCount = readCount;
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mlevel = mlevel;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(String contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getFirstImage2() {
        return firstImage2;
    }

    public void setFirstImage2(String firstImage2) {
        this.firstImage2 = firstImage2;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getSidoCode() {
        return sidoCode;
    }

    public void setSidoCode(String sidoCode) {
        this.sidoCode = sidoCode;
    }

    public String getGugunCode() {
        return gugunCode;
    }

    public void setGugunCode(String gugunCode) {
        this.gugunCode = gugunCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    @Override
    public String toString() {
        return "AttractionInfo{" +
                "contentId='" + contentId + '\'' +
                ", contentTypeId='" + contentTypeId + '\'' +
                ", title='" + title + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", addr2='" + addr2 + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", tel='" + tel + '\'' +
                ", firstImage='" + firstImage + '\'' +
                ", firstImage2='" + firstImage2 + '\'' +
                ", readCount='" + readCount + '\'' +
                ", sidoCode='" + sidoCode + '\'' +
                ", gugunCode='" + gugunCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", mlevel='" + mlevel + '\'' +
                '}';
    }
}
