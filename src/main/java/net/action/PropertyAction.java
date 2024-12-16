package net.action;

import org.apache.struts2.ActionSupport;

public class PropertyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name = "Property!";
	private String[] names = {"A","B"};
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public String[] getNames() {
		return names;
	}
}