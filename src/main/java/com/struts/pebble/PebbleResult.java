package com.struts.pebble;

import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.ServletContext;
//import javax.servlet.ServletResponse;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletResponse;

import org.apache.struts2.ActionContext;
import org.apache.struts2.ActionInvocation;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.result.Result;

import com.opensymphony.xwork2.inject.Inject;

import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.loader.FileLoader;
import io.pebbletemplates.pebble.loader.Loader;
import io.pebbletemplates.pebble.template.PebbleTemplate;

public class PebbleResult implements Result {
	private static final long serialVersionUID = 1L;
	private String prefix = "WEB-INF/templates";
	private String suffix = ".html";
	private String charset = "UTF-8";
	private String templateName;
	public static final String DEFAULT_PARAM = "templateName";

	public PebbleResult() {
	}

	public PebbleResult(String templateName) {
		this.templateName = templateName;
	}

	@Inject(value = "struts.pebble.prefix", required = false)
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Inject(value = "struts.pebble.suffix", required = false)
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Loader<?> pebbleLoader() {
		ServletContext servletContext = (ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT);
		String path = servletContext.getRealPath("/");
		FileLoader loader = new FileLoader();
		loader.setCharset(this.charset);
		loader.setPrefix(path + prefix);
		loader.setSuffix(suffix);
		return loader;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Override
	public void execute(ActionInvocation ai) throws Exception {
		PebbleEngine.Builder builder = new PebbleEngine.Builder();
		Struts2Extension se = new Struts2Extension();
		builder.loader(pebbleLoader()).extension(se);
		PebbleEngine engine = builder.build();
		
		PebbleTemplate tmpl = engine.getTemplate(templateName);
		Map<String, Object> context = new HashMap<>();

		Field[] fields = ai.getInvocationContext().getValueStack().getRoot().get(0).getClass().getDeclaredFields();
		for(Field f : fields) {
			context.put(f.getName(), ai.getInvocationContext().getServletRequest().getAttribute(f.getName()));
		}

		Writer writer = new StringWriter();
		tmpl.evaluate(writer, context);
		ServletResponse response = (ServletResponse) ai.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("text/html;charset=" + this.charset);
		response.getWriter().write(writer.toString());
	}
}