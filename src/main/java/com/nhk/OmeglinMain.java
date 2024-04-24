package com.nhk;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class OmeglinMain {
    public static void main(String[] args) {
        Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.router.mount(router -> {
                router.ws("/api/matchmaking", Matchmaking::websocket);
            });
        }).start(7070);
    }
}
