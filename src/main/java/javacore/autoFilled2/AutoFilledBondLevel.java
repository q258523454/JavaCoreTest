package javacore.autoFilled2;
// Created by ZhangJian on 17/11/13.


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoFilledBondLevel {


    // 是否属于 手工维护的"Z"次级证券
    public boolean isSecondary(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.MANUAL_SECONDARY.length; i++) {
            if (bondShortName.equals(AutoFilledBondLevelConstant.MANUAL_SECONDARY[i])) {
                return true;
            }
        }
        return false;
    }

    // 包含"次优"属于次级几个特殊的例子
    public boolean isSecondarySpecialCase(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"B"的情况
    public boolean isSecondarySpecialCase_B(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_B.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_B[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"C"的情况
    public boolean isSecondarySpecialCase_C(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_C.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_C[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"D"的情况
    public boolean isSecondarySpecialCase_D(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_D.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_D[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"E"的情况
    public boolean isSecondarySpecialCase_E(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_E.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_E[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"F"的情况
    public boolean isSecondarySpecialCase_F(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_F.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_F[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"S", "R"的情况
    public boolean isSecondarySpecialCase_S_R(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_S_R.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_S_R[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"J"的情况
    public boolean isSecondarySpecialCase_J(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_J.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_J[i])) {
                return true;
            }
        }
        return false;
    }

    // 不含"次"的次级的特例, 含"HLNYCJ"的情况
    public boolean isSecondarySpecialCase_HLNYCJ(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_HLNYCJ.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SECONDARY_SPECIALCASE_CONTANS_HLNYCJ[i])) {
                return true;
            }
        }
        return false;
    }

    // 非次级证券中, 含有"A"属于优先B的特殊情况
    public boolean isPriorityBSpecialCase_A(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE_CONTANS_A.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE_CONTANS_A[i])) {
                return true;
            }
        }
        return false;
    }

    // 非次级证券中, 含有"优先B"属于优先B的特殊情况
    public boolean isPriorityBSpecialCase_YOUXIAN_B(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE_CONTANS_YOUXIAN_B.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE_CONTANS_YOUXIAN_B[i])) {
                return true;
            }
        }
        return false;
    }

    // 非次级证券中, 属于优先B的特殊情况
    public boolean isPriorityBSpecialCase(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.PRIORITY_B_SPECIALCASE[i])) {
                return true;
            }
        }
        return false;
    }

    // 非次级证券中, 不含有"A"含有"优"的9种特例
    // ------------------------------------  BEGIN  ----------------------------------------
    public boolean isSpecialCase_ContainsNoAContainsYOU_1(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_1.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_1[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_2(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_2.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_2[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_3(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_3.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_3[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_4(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_4.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_4[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_5(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_5.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_5[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_6(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_6.length; i++) {
            if (bondShortName.equals(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_6[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_7(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_7.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_7[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_8(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_8.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_8[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_ContainsNoAContainsYOU_9(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_9.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_CONTANS_NOA_YOU_9[i])) {
                return true;
            }
        }
        return false;
    }
    // ------------------------------------  END  ----------------------------------------


    // 非次级证券中, 不含有"A"且不含有"优"的2种特例
    // ------------------------------------  BEGIN  ----------------------------------------
    public boolean isSpecialCase_NOA_NOYOU_1(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_1.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_1[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_2(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_2.length; i++) {
            if (bondShortName.equals(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_2[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_3(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_3.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_3[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_4(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_4.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_4[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_5(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_5.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_5[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_6(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_6.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_6[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_7(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_7.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_7[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_8(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_8.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_8[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_9(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_9.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_9[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_10(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_10.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_10[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_11(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_11.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_11[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCase_NOA_NOYOU_12(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_12.length; i++) {
            if (bondShortName.contains(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_12[i])) {
                return true;
            }
        }
        return false;
    }
    // ------------------------------------  END  ----------------------------------------


    // 非次级证券中, 不含有"A"且不含有"优", 且不含有"B"和"C", 但属于优先C档的特例
    // ------------------------------------  BEGIN  ----------------------------------------
    public boolean isSpecialCase_NOA_NOYOU_NOB_NOC(String bondShortName) {
        for (int i = 0; i < AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_NOB_NOC.length; i++) {
            if (bondShortName.equals(AutoFilledBondLevelConstant.SPECIALCASE_NOA_NOYOU_NOB_NOC[i])) {
                return true;
            }
        }
        return false;
    }
    // ------------------------------------  END  ----------------------------------------


    public String autoFilledBondLevelByShortName(String bondShortName) {

        if (bondShortName.isEmpty() || bondShortName == null) {
            return ""; // 无法识别
        }

        String bondLevel = ""; // 初始化为空值

        // -----------------------   根据业务规律, 首先判定是否为次级证券   ------------------
        // 1. 如果bondShortName属于【人工维护】次级等级的字段名中, 直接返回次级等级"Z"
        if (this.isSecondary(bondShortName)) {
            return "Z";
        }

        // 2. 判断是否为次级
        if (bondShortName.contains("次")) {
            if (bondShortName.contains("次优")) { // 排除含有"次优"
                if (this.isSecondarySpecialCase(bondShortName)) { // "次优"属于次级的特例
                    bondLevel = "Z";
                    return bondLevel;
                } else {
                    bondLevel = ""; // 包含"次优"的, 仍无法识别
                }
            } else { // 含有"次", 但不包含"次优", 为次级
                bondLevel = "Z";
                return bondLevel;
            }
        } else { // 不含"次"
            // 特例
            if (bondShortName.contains("小米") && bondShortName.contains("优B")) {
                bondLevel = "B";
                return bondLevel;
            }
            // 特例-"花呗B优", "花呗分期B优", "17借呗ABN001A", "17易鑫租赁ABN001优先A", "17易鑫租赁ABN002优先A",
            if (bondShortName.contains("花呗B优") || bondShortName.contains("花呗分期B优") || bondShortName.contains("17借呗ABN001A")
                    || bondShortName.contains("17易鑫租赁ABN001优先A") || bondShortName.contains("17易鑫租赁ABN002优先A")) {
                bondLevel = "A";
                return bondLevel;
            }
            // 特例
            if (bondShortName.contains("易鑫3优B") || bondShortName.contains("易鑫优B") || bondShortName.contains("17借呗ABN001B")
                    || bondShortName.contains("17易鑫租赁ABN001优先B") || bondShortName.contains("17易鑫租赁ABN002优先B")) {
                bondLevel = "B";
                return bondLevel;
            }
            // 特例
            if (bondShortName.contains("17远东电子1C") ||
                    bondShortName.contains("远东委C") ||
                    bondShortName.contains("平安优C") ||
                    bondShortName.contains("16平安4C")) {
                bondLevel = "C";
                return bondLevel;
            }
            // 特例
            if (bondShortName.contains("优C") && bondShortName.contains("平安")) {
                bondLevel = "C";
                return bondLevel;
            }

            // 不包含"次"但属于"次级"的几种特殊情况
            if ((bondShortName.contains("B") && this.isSecondarySpecialCase_B(bondShortName)) ||
                    (bondShortName.contains("C") && this.isSecondarySpecialCase_C(bondShortName)) ||
                    (bondShortName.contains("D") && this.isSecondarySpecialCase_D(bondShortName)) ||
                    (bondShortName.contains("E") && this.isSecondarySpecialCase_E(bondShortName)) ||
                    (bondShortName.contains("F") && this.isSecondarySpecialCase_F(bondShortName)) ||
                    (bondShortName.contains("S") && this.isSecondarySpecialCase_S_R(bondShortName)) ||
                    (bondShortName.contains("R") && this.isSecondarySpecialCase_S_R(bondShortName)) ||
                    (bondShortName.contains("J") && this.isSecondarySpecialCase_J(bondShortName)) ||
                    this.isSecondarySpecialCase_HLNYCJ(bondShortName)) {
                bondLevel = "Z";
                return bondLevel;
            } else {
                bondLevel = ""; // 仍无法识别
            }
        }

        // 3. 在非次级中, 标记优先级A档
        if (bondShortName.contains("A")) {
            // 特例
            if (bondShortName.contains("海南国租优先A2")) {
                bondLevel = "A";
                return bondLevel;
            }
            // 以"A2"结尾属于优B的特例
            if ((bondShortName.lastIndexOf("A2") == (bondShortName.length() - "A2".length())) && this.isPriorityBSpecialCase_A(bondShortName)) {
                // lastIndexOf 与  indexOf 是有区别的, 一个向左一个向右搜索, 并返回第一个匹配下标
                bondLevel = "B";
                return bondLevel;
            }
            // 以"优先B"结尾属于优B的特例 -- "融和绿色", "悦达租赁", "新城控股", "世贸国际", "金鹰天地", "国控租赁", "中建投租", "远东租赁", "华药商业", "中民租赁"
            if ((bondShortName.lastIndexOf("优先B") == (bondShortName.length() - "优先B".length())) && this.isPriorityBSpecialCase_YOUXIAN_B(bondShortName)) {
                // lastIndexOf 与  indexOf 是有区别的, 一个向左一个向右搜索, 并返回第一个匹配下标
                bondLevel = "B";
                return bondLevel;
            }
            if (bondShortName.equals("17国租A3")) {
                bondLevel = "C";
                return bondLevel;
            }
            if (bondShortName.equals("17国租A4")) {
                bondLevel = "D";
                return bondLevel;
            }
            if (this.isPriorityBSpecialCase(bondShortName)) {
                bondLevel = "B";
                return bondLevel;
            }

            bondLevel = "A";
            return bondLevel;
        } else if (bondShortName.contains("优")) { // 不包含"A", 但包含"优"
            if ((bondShortName.contains("次优") && isSpecialCase_ContainsNoAContainsYOU_1(bondShortName)) ||
                    (bondShortName.contains("优B") && isSpecialCase_ContainsNoAContainsYOU_2(bondShortName)) ||
                    (bondShortName.contains("优先B") && isSpecialCase_ContainsNoAContainsYOU_3(bondShortName)) ||
                    (bondShortName.contains("优先级B") && isSpecialCase_ContainsNoAContainsYOU_4(bondShortName)) ||
                    ((bondShortName.lastIndexOf("2") == (bondShortName.length() - "2".length())) && isSpecialCase_ContainsNoAContainsYOU_5(bondShortName)) ||
                    isSpecialCase_ContainsNoAContainsYOU_6(bondShortName)
                    ) {
                bondLevel = "B";
                return bondLevel;
            }
            if ((bondShortName.contains("优C") && isSpecialCase_ContainsNoAContainsYOU_7(bondShortName)) ||
                    (bondShortName.contains("优先C") && isSpecialCase_ContainsNoAContainsYOU_8(bondShortName)) ||
                    (bondShortName.contains("优3") && isSpecialCase_ContainsNoAContainsYOU_9(bondShortName))
                    ) {
                bondLevel = "C";
                return bondLevel;
            } else if (bondShortName.contains("优先D") && bondShortName.contains("有钱花")) {
                bondLevel = "D";
                return bondLevel;
            }
            bondLevel = "A";
            return bondLevel;

        } else { // 不包含"A", 且不包含"优"
            if (bondShortName.contains("B")) {
                if (isSpecialCase_NOA_NOYOU_1(bondShortName)) {
                    bondLevel = "A";
                    return bondLevel;
                } else if (isSpecialCase_NOA_NOYOU_2(bondShortName)) {
                    bondLevel = "C";
                    return bondLevel;
                }
            }
            if (bondShortName.contains("C")) {
                if (isSpecialCase_NOA_NOYOU_3(bondShortName)) {
                    bondLevel = "A";
                    return bondLevel;
                } else if (isSpecialCase_NOA_NOYOU_4(bondShortName)) {
                    bondLevel = "B";
                    return bondLevel;
                }
            }
            if (isSpecialCase_NOA_NOYOU_5(bondShortName)) {
                bondLevel = "A";
                return bondLevel;
            }
            if (isSpecialCase_NOA_NOYOU_6(bondShortName)) {
                bondLevel = "B";
                return bondLevel;
            }
            if (isSpecialCase_NOA_NOYOU_7(bondShortName)) {
                bondLevel = "C";
                return bondLevel;
            }
            // 以'京东'开头，以'中间'结尾
            if (bondShortName.indexOf("京东") == 0 && (bondShortName.lastIndexOf("中间") == (bondShortName.length() - "中间".length()))) {
                bondLevel = "C";
                return bondLevel;
            }
            if (bondShortName.contains("E") && isSpecialCase_NOA_NOYOU_8(bondShortName)) {
                bondLevel = "A";
                return bondLevel;
            }
            if (bondShortName.contains("F") && isSpecialCase_NOA_NOYOU_9(bondShortName)) {
                bondLevel = "A";
                return bondLevel;
            }
            // 结尾是G或H结尾
            if ((bondShortName.lastIndexOf("G") == (bondShortName.length() - "G".length())) || (bondShortName.lastIndexOf("H") == (bondShortName.length() - "H".length()))) {
                if (isSpecialCase_NOA_NOYOU_10(bondShortName)) {
                    bondLevel = "A";
                    return bondLevel;
                }
            }
            if (bondShortName.contains("I") && bondShortName.contains("兴光")) {
                bondLevel = "A";
                return bondLevel;
            }
            // 以数字结尾
            Pattern pattern = Pattern.compile("\\d+$");
            Matcher matcher = pattern.matcher(bondShortName);
            if (matcher.find()) { // 以数字结尾且包含 "七热", "临热", "聚元" 等
                if (isSpecialCase_NOA_NOYOU_11(bondShortName)) {
                    bondLevel = "A";
                    return bondLevel;
                }
            }

            if (isSpecialCase_NOA_NOYOU_12(bondShortName)) {
                bondLevel = "A";
                return bondLevel;
            }

            bondLevel = ""; // 非次级中既不含"A"也不含""优, 而且不是"B""C"特例, 仍需进一步判断,
        }

        // 4. 在非次级中, 标记优先B级档. 注意: 已经经过优先档A的筛选
        if (bondShortName.contains("B")) {
            bondLevel = "B";
            return bondLevel;
        } else { //  不包含"B"
            if (((bondShortName.contains("金坤") || bondShortName.contains("水总") || bondShortName.contains("畅星")) && bondShortName.contains("02")) ||
                    ((bondShortName.contains("乌经开")) && (bondShortName.contains("06") || bondShortName.contains("07"))) ||
                    ((bondShortName.contains("东租")) && (bondShortName.contains("05") || bondShortName.contains("06"))) ||
                    ((bondShortName.contains("巩燃") || bondShortName.contains("宝信")) && (bondShortName.contains("03") || bondShortName.contains("05") || bondShortName.contains("06") || bondShortName.contains("07"))) ||
                    ((bondShortName.contains("吉水务")) && (bondShortName.contains("05") || bondShortName.contains("06") || bondShortName.contains("07"))) ||
                    (bondShortName.contains("金安中间") || bondShortName.contains("PR昆西中"))) {
                bondLevel = "B";
                return bondLevel;
            } else {
                // 仍无法识别, 继续判定
                bondLevel = "";
            }
        }

        // 5. 在非次级中, 标记优先级C档. 注意: 已经经过优先档A, B档的筛选
        if (bondShortName.contains("C")) {
            bondLevel = "C";
            return bondLevel;
        } else {
            if (isSpecialCase_NOA_NOYOU_NOB_NOC(bondShortName)) {
                bondLevel = "C";
                return bondLevel;
            } else {
                // 仍无法识别
                bondLevel = "";
            }
        }

        // 6. 在非次级中, 标记优先级D档. 注意: 已经经过优先档A, B, C档的筛选
        if (((bondShortName.contains("有钱花") || bondShortName.contains("光谷")) && bondShortName.contains("D")) ||
                (bondShortName.contains("国租") && bondShortName.contains("A4")) ||
                (bondShortName.contains("17水总04"))) {
            bondLevel = "D";
            return bondLevel;
        } else {
            // 仍无法识别, 需要人工判定
            bondLevel = "";
        }

        return bondLevel;
    }

    // test code
    public static void main(String[] args) {
        AutoFilledBondLevel autoFilled = new AutoFilledBondLevel();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("17畅星01"); // A
        arrayList.add("周燃0021"); // A
        arrayList.add("金风绿E"); // A
        arrayList.add("绍兴G"); // A
        arrayList.add("金安中间"); // B
        arrayList.add("05吉水务"); // B
        arrayList.add("14福元1C"); // A


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(autoFilled.autoFilledBondLevelByShortName(arrayList.get(i)));
        }
    }
}
