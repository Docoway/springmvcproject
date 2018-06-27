package org.kb4md.rest.DiseaseView;


import org.kb4md.disease.view.data.PhenotypeInfo;
import org.kb4md.disease.view.service.PhenotypeInfoService;
import org.kb4md.rest.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by DC on 2018/06/26
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/DiseaseView")
public class DiseaseViewController {

    @Autowired
    private PhenotypeInfoService phenotypeInfoService;

    @GetMapping(value = "/recommend/{geneSymbol}")
    public RestResult getGeneRecommend(@PathVariable String geneSymbol){
        RestResult restResult = new RestResult();
        List<PhenotypeInfo> phenotypeInfos = phenotypeInfoService.getGeneRecommend(geneSymbol);
        restResult.setData(phenotypeInfos);
        return restResult;
    }
}
