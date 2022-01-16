package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class URL implements Serializable {

    private static final long serialVersionUID = -8920550150026843855L;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof URL)) return false;
        URL URL1 = (URL) o;
        return Objects.equals(url, URL1.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("url{");
        sb.append("url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
