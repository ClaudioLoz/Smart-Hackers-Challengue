package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class test implements Serializable {

    private static final long serialVersionUID = -1539425829491339286L;
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof test)) return false;
        test test = (test) o;
        return Objects.equals(num, test.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("test{");
        sb.append("num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}
