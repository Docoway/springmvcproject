package org.kb4md.TFinfo.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * created by DC on 2018/06/08
 */
@Setter
@Getter
@ToString
public class TFsInformation {

    private Integer chr;
    private String promoterID;
    private String direction;
    private Integer proStart;
    private Integer proEnd;
    private String promoter;
    private String TFs;
}
