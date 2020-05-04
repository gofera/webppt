package cn.xdean.jslide.core.render;

import cn.xdean.jslide.core.model.Element;

public interface ElementRender {
    boolean support(String name);

    String render(Element element);

    default void initContext(RenderContext context) {
        // do nothing
    }
}