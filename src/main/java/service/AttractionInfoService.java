package service;

import vo.AttractionInfo;

import java.util.ArrayList;

public interface AttractionInfoService {
    ArrayList<AttractionInfo> selectAll();
    AttractionInfo selectOne(String contentId);

    int insert(AttractionInfo attractionInfo);

    int delete(String contentId);
}
