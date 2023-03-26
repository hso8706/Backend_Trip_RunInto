package service;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import util.PageNavigation;
import util.SizeConstant;
import vo.AttractionInfo;
import vo.ContentDescription;
import vo.Pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService{
    CategoryDAO cdao;

    public CategoryServiceImpl() {
        cdao = new CategoryDAOImpl();
    }

    @Override
    public ArrayList<AttractionInfo> selectCategory(String contentTypeId) {
        return cdao.selectCategory(contentTypeId);
    }

    @Override
    public ArrayList<AttractionInfo> searchCategory(Pagination pagination) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("contentTypeId", pagination.getContent_type_id());
        param.put("word", pagination.getWord());
        int pgno = Integer.parseInt(pagination.getPgno()); // 현재 페이지
        int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE; //계산된 시작점
        param.put("start", start);
        param.put("listsize", SizeConstant.LIST_SIZE); // 총 목록 개수
        //param_keys : "contentTypeId", "word", "start", "listsize"

        return cdao.searchCategory(param);
    }

    @Override
    public AttractionInfo selectOne(String contentId) {
        return cdao.selectOne(contentId);
    }

    @Override
    public ContentDescription description(String contentId) {
        return cdao.selectDescription(contentId);
    }

    @Override
    public PageNavigation makePageNavigation(Pagination pagination) {
        PageNavigation pageNavigation = new PageNavigation();

        int naviSize = SizeConstant.NAVIGATION_SIZE;
        int sizePerPage = SizeConstant.LIST_SIZE;
        int currentPage = Integer.parseInt(pagination.getPgno());

        pageNavigation.setCurrentPage(currentPage);
        pageNavigation.setNaviSize(naviSize);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("content_type_id", pagination.getContent_type_id());
        param.put("word", pagination.getWord().isEmpty() ? "" : pagination.getWord());

        int totalCount = cdao.getTotalArticleCount(param);
        pageNavigation.setTotalCount(totalCount);
        int totalPageCount = (totalCount - 1) / sizePerPage + 1;
        pageNavigation.setTotalPageCount(totalPageCount);
        boolean startRange = currentPage <= naviSize;
        pageNavigation.setStartRange(startRange);
        boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
        pageNavigation.setEndRange(endRange);
        pageNavigation.makeNavigator();

        return pageNavigation;
    }
}
