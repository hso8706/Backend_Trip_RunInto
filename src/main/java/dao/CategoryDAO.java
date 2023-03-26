package dao;

import vo.AttractionInfo;
import vo.ContentDescription;

import java.util.ArrayList;
import java.util.Map;

public interface CategoryDAO {
    ArrayList<AttractionInfo> searchCategory(Map<String, Object> param);

//    ArrayList<AttractionInfo> selectCategory(String categoryNum);

    AttractionInfo selectOne(String contentId);

    ContentDescription selectDescription(String contentId);

    int getTotalArticleCount(Map<String, Object> param);

    ArrayList<AttractionInfo> selectCategory(String contentTypeId);
}
