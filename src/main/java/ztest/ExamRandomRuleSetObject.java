package ztest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)

public class ExamRandomRuleSetObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 1000, min = 1)
    @Valid
    @NotNull()
    @JsonProperty("ruleItem")
    private String ruleItem = null;

    @Valid
    @JsonProperty("ruleLevel")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer ruleLevel = 0;

    @Valid
    @JsonProperty("totalCount")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer totalCount = 0;

    @Valid
    @JsonProperty("score")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer score = 0;

    @Size(max = 10000, min = 1)
    @Valid
    @JsonProperty("ruleSelectedList")
    private List<String> ruleSelectedList = new ArrayList<String>();

    @Size(max = 10000, min = 1)
    @Valid
    @JsonProperty("childs")
    private List<ExamRandomRuleSetObject> childs = new ArrayList<ExamRandomRuleSetObject>();

    public ExamRandomRuleSetObject() {
        super();
    }

    /**
     * 规则集名
     * minLength: 1
     * maxLength: 1000
     **/
    public String getRuleItem() {
        return ruleItem;
    }

    public void setRuleItem(String ruleItem_in) {
        this.ruleItem = ruleItem_in;
    }

    /**
     * 规则集层级
     **/
    public Integer getRuleLevel() {
        return ruleLevel;
    }

    public void setRuleLevel(Integer ruleLevel_in) {
        this.ruleLevel = ruleLevel_in;
    }

    /**
     * 总共选择题目
     **/
    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount_in) {
        this.totalCount = totalCount_in;
    }

    /**
     * 每道题分数
     **/
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score_in) {
        this.score = score_in;
    }

    /**
     * 选择对象id
     * minLength: 1
     * maxLength: 10000
     **/
    public List<String> getRuleSelectedList() {
        return ruleSelectedList;
    }

    public void setRuleSelectedList(List<String> ruleSelectedList_in) {
        this.ruleSelectedList = ruleSelectedList_in;
    }

    /**
     * minLength: 1
     * maxLength: 10000
     **/
    public List<ExamRandomRuleSetObject> getChilds() {
        return childs;
    }

    public void setChilds(List<ExamRandomRuleSetObject> childs_in) {
        this.childs = childs_in;
    }


}
