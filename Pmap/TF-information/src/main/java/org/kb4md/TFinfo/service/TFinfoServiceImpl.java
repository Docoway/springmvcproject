package org.kb4md.TFinfo.service;


import org.kb4md.TFinfo.data.TFsInformation;
import org.kb4md.TFinfo.mapper.TFsInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by DC on 2018/06/08
 */
@Service
@Transactional(rollbackFor = {Exception.class}, transactionManager = "TFinfoManager")
public class TFinfoServiceImpl implements TFinfoService {

    @Autowired
    TFsInformationMapper tfsInformationMapper;

    @Override
    public List<TFsInformation> getPromoteridRecommend(String inputTerm){
        List<TFsInformation> tfsInformations = tfsInformationMapper.getPromoteridRecommend(inputTerm);
        return tfsInformations;
    }

    @Override
    public TFsInformation getPromoterByPromoterid(String promoterID){
        return tfsInformationMapper.getPromoterByPromoterid(promoterID);
    }

    @Override
    public TFsInformation getTFsByPromoterid(String promoterID){
        return tfsInformationMapper.getTFsByPromoterid(promoterID);
    }
}
