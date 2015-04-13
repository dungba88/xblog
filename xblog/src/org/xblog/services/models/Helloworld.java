package org.xblog.services.models;

public class Helloworld {

	private long id;
    private String content;

    public Helloworld(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
