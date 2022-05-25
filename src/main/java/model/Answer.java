package model;

public class Answer {

    public String ans;
    public String type;

    public Answer(String ans, String type) {
        this.ans = ans;
        this.type = type;
    }

    public String getAns() {
        return ans;
    }

    public String getType() {
        return type;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void setType(String type) {
        this.type = type;
    }
}