package com.library.LibraryApp.dtos;

import java.util.Objects;

public class BookRequest {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRequest)) return false;
        BookRequest that = (BookRequest) o;
        return getTitle().equals(that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
