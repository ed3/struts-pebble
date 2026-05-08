package net.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ActionSupport;

public class PropertyAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String pro = "Property!";
    private String[] letters = {"A", "B"};
    private List<String> names = new ArrayList<String>();

    public String execute() throws Exception {
        names.add("Ed");
        names.add("Lee");
        return SUCCESS;
    }

    public String getPro() {
        return pro;
    }

    public String[] getLetters() {
        return letters;
    }

    public List<String> getNames() {
        return names;
    }
}