package org.kb4md.disease.view.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhenotypeInfo {

    private String HGNC_genes;
    private String Phenotype;
    private Integer Chromosome;
}
