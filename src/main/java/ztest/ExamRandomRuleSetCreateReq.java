package ztest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)

public class ExamRandomRuleSetCreateReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 10000, min = 1)
    @Valid
    @JsonProperty("examRandomRuleSetObjectList")
    private List<ExamRandomRuleSetObject> examRandomRuleSetObjectList = new ArrayList<ExamRandomRuleSetObject>();

    public ExamRandomRuleSetCreateReq() {
        super();
    }

    /**
     * minLength: 1
     * maxLength: 10000
     **/
    public List<ExamRandomRuleSetObject> getExamRandomRuleSetObjectList() {
        return examRandomRuleSetObjectList;
    }

    public void setExamRandomRuleSetObjectList(List<ExamRandomRuleSetObject> examRandomRuleSetObjectList_in) {
        this.examRandomRuleSetObjectList = examRandomRuleSetObjectList_in;
    }


}
