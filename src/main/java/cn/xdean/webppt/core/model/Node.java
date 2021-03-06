package cn.xdean.webppt.core.model;

import javax.annotation.Nullable;

public interface Node {

    String getName();

    @Nullable
    Element getParent();

    void setParent(Element element);

    RawInfo getRawInfo();

    @Nullable
    Parameter getParameter(String key);

    default boolean contains(Node node) {
        return node == this;
    }
}
