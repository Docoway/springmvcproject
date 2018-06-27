package org.kb4md.TFinfo.service;


import org.kb4md.TFinfo.data.TFsInformation;

import java.util.List;

public interface TFinfoService {

    List<TFsInformation> getPromoteridRecommend(String inputTerm);

    TFsInformation getPromoterByPromoterid(String promoterID);

    TFsInformation getTFsByPromoterid(String promoterID);
}
