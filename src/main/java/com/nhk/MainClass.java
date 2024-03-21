package com.nhk;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainClass {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles -> {
            	staticFiles.directory = "/public";
            	staticFiles.location = Location.CLASSPATH;
            });
        }).start(8080);
		
		

	}

}
