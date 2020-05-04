package cn.xdean.jslide.core.render.text;

import cn.xdean.jslide.core.model.Element;
import cn.xdean.jslide.core.render.RenderKeys;
import cn.xdean.jslide.core.render.TextRender;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlainTextRender extends AbstractTextRender {
    public PlainTextRender() {
        super("plain");
    }

    @Override
    public String render(Element element, List<String> lines) {
        List<List<String>> paragraphs = new ArrayList<>();
        List<String> pendingLines = new ArrayList<>();
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                if (!pendingLines.isEmpty()) {
                    paragraphs.add(pendingLines);
                    pendingLines = new ArrayList<>();
                }
            } else {
                pendingLines.add(line);
            }
        }
        if (!pendingLines.isEmpty()) {
            paragraphs.add(pendingLines);
        }
        return renderService.renderView("text/plain.ftlh", new ModelMap()
                .addAttribute(RenderKeys.MODEL, PlainTextModel.builder().paragraphs(paragraphs).build()));
    }

    @Value
    @Builder
    public static class PlainTextModel {
        List<List<String>> paragraphs;
    }
}
