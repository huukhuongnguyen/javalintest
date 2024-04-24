package com.nhk;

import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinFreemarker;

public class MainClass {

	public static void main(String[] args) {
//		Javalin app = Javalin.create(config -> {
//            config.staticFiles.add(staticFiles -> {
//            	staticFiles.directory = "/public";
//            	staticFiles.location = Location.CLASSPATH;
//            });
//        }).start(8080);
		
		Javalin app = Javalin.create(config -> {
			config.fileRenderer(new JavalinFreemarker());
        }).start(8080);
		
		app.get("/",  ctx -> { // will match anything starting with /path/
			Map<String, Object> root = new HashMap<>();
			root.put("message", "hello");
			ctx.render("/templates/freemarker/test.ftl", root);
		});

	}

}
