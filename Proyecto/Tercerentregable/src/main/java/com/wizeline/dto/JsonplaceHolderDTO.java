package com.wizeline.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonplaceHolderDTO {
    /* Conversión del contenido consumido usando JAXB o Jackson: Jackson - @JsonProperty */

    @JsonProperty("CampoUserId")
    private Long userId;
    @JsonProperty("CampoId")
    private Long id;
    @JsonProperty("CampoTitle")
    private String title;
    @JsonProperty("CampoCompleted")
    private boolean completed;

    public JsonplaceHolderDTO(){}
    public JsonplaceHolderDTO(long userId, long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
