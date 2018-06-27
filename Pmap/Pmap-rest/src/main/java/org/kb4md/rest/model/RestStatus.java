package org.kb4md.rest.model;

/**
 * created by DC on 2018/06/08
 */
public enum RestStatus {

    OK(0), INFO(1), ERROR(2);

    private Integer value;

    RestStatus(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }
}
