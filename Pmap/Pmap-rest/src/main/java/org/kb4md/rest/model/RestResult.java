package org.kb4md.rest.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * created by DC on 2018/06/08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RestResult {

    private RestStatus code = RestStatus.OK;
    private String message;
    private Object data;

    public RestResult(RestStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}
