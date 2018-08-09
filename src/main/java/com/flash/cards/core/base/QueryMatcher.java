package com.flash.cards.core.base;

/**
 * @author lizheng
 * @since 2018/5/11 13:28
 **/
public enum QueryMatcher {
    //------------------fields -------------------------
    EQ					(0, "EQ"),
    LIKE				(1, "LIKE"),
    GT					(2, "GT"),
    LT					(3, "LT"),
    GTE					(4, "GTE"),
    LTE					(5, "LTE"),
    EQ4Char				(6, "EQ4Char"),
    EQ4Int				(7, "EQ4Int"),
    NE					(8, "NE"),
    NE4Int  			(9, "NE4Int"),
    ChildOf 			(10, "ChildOf"),
    Between4Long		(11, "Between4Long"),
    IN					(12, "IN"),
    Between4Integer		(13, "Between4Integer"),
    Between4Date		(14, "Between4Date"),
    NotIN				(15, "NotIN"),
    IsNull              (16, "IsNull"),
    NotNull             (17, "NotNull"),
    EXP                 (18, "EXP");



    //------------------instance methods -------------------------
    private int code;
    private String value;
    QueryMatcher(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
