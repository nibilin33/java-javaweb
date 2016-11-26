package com.fase.po;

public class Helpcenter {
    private String helpid;

    private String questions;

    private String ans;

    public String getHelpid() {
        return helpid;
    }

    public void setHelpid(String helpid) {
        this.helpid = helpid == null ? null : helpid.trim();
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions == null ? null : questions.trim();
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans == null ? null : ans.trim();
    }
}