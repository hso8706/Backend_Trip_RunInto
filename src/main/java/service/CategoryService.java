package service;

import util.PageNavigation;
import vo.AttractionInfo;
import vo.ContentDescription;
import vo.Pagination;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<AttractionInfo> searchCategory(Pagination pagination);

    AttractionInfo selectOne(String contentId);

    ContentDescription description(String contentId);

    PageNavigation makePageNavigation(Pagination pagination);

    ArrayList<AttractionInfo> selectCategory(String contentTypeId);
}
