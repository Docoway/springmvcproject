package org.kb4md.disease.view.service;

import org.kb4md.disease.view.data.PhenotypeInfo;
import org.kb4md.disease.view.mapper.PhenotypeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by DC on 2018/06/26
 */
@Service
@Transactional(rollbackFor = {Exception.class}, transactionManager = "diseaseViewTxManager")
public class PhenotypeInfoServiceImpl implements PhenotypeInfoService {

    @Autowired
    private PhenotypeInfoMapper phenotypeInfoMapper;

    @Override
    public List<PhenotypeInfo> getGeneRecommend(String geneSymbol){
        List<PhenotypeInfo> phenotypeInfos = phenotypeInfoMapper.getGeneRecommend(geneSymbol);
        return phenotypeInfos;
    }
}
