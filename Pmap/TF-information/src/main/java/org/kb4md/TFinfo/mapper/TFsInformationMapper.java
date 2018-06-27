package org.kb4md.TFinfo.mapper;


import org.kb4md.TFinfo.data.TFsInformation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by DC on 2018/06/08
 */
@Repository
public interface TFsInformationMapper {

    /**
     * 根据输入推荐promoterid
     * @param inputTerm
     * @return
     */
    List<TFsInformation> getPromoteridRecommend(@Param("inputTerm") String inputTerm);

    TFsInformation getPromoterByPromoterid(@Param("promoterID") String promoterID);

    TFsInformation getTFsByPromoterid(@Param("promoterID") String promoterID);
}
