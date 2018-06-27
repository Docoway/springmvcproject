package org.kb4md.rest.TFInformation;


import org.kb4md.TFinfo.data.TFsInformation;
import org.kb4md.TFinfo.service.TFinfoService;
import org.kb4md.rest.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by DC on 2018/06/08
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/TFinfo")
public class TFInformationController {

    @Autowired
    private TFinfoService tfinfoService;

    @GetMapping(value = "/recommend/{inputTerm}")
    public RestResult getPromoteridRecommend(@PathVariable String inputTerm){
        RestResult restResult = new RestResult();
        List<TFsInformation> tfsInformations = tfinfoService.getPromoteridRecommend(inputTerm);
        restResult.setData(tfsInformations);
        return restResult;
    }

    @GetMapping(value = "/promoter/{promoterID}")
    public RestResult getPromoterByPromoterid(@PathVariable String promoterID){
        RestResult restResult = new RestResult();
        TFsInformation tfsInformation = this.tfinfoService.getPromoterByPromoterid(promoterID);
        restResult.setData(tfsInformation);
        return restResult;
    }

    @GetMapping(value = "/TFs/{promoterID}")
    public RestResult getTFsByPromoterid(@PathVariable String promoterID){
        RestResult restResult = new RestResult();
        restResult.setData(tfinfoService.getTFsByPromoterid(promoterID));
        return restResult;
    }
}
