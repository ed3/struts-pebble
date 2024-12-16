package com.struts.pebble;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ActionContext;
import org.apache.struts2.ActionSupport;

import io.pebbletemplates.pebble.extension.Function;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.PebbleTemplate;

public class TextFunction implements Function {
	public static final String FUNCTION_NAME = "text";

	public TextFunction() {
	}

	@Override
	public List<String> getArgumentNames() {
		return null;
	}

	public Object execute(Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
		String key = (String) args.get("0");
		int i = 1;
		List<Object> arguments = new ArrayList<>();
		while (args.containsKey(String.valueOf(i))) {
			Object param = args.get(String.valueOf(i));
			arguments.add(param);
			i++;
		}
		ActionSupport as = (ActionSupport) ActionContext.getContext().getActionInvocation().getAction();
		String msg = as.getText(key, arguments);
		return msg;
	}
}