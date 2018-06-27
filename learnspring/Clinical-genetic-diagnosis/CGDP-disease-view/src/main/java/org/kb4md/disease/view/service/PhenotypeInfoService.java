package org.kb4md.disease.view.service;

import org.kb4md.disease.view.data.PhenotypeInfo;

import java.util.List;

public interface PhenotypeInfoService {

    List<PhenotypeInfo> getGeneRecommend(String geneSymbol);
}
