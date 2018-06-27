package org.kb4md.disease.view.mapper;

import org.kb4md.disease.view.data.PhenotypeInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface PhenotypeInfoMapper {

    /**
     * 推荐
     * @param geneSymbol
     * @return
     */
    List<PhenotypeInfo> getGeneRecommend(@Param("geneSymbol") String geneSymbol);
}
