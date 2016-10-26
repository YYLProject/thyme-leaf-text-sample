package com.sample;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

public class Sample {
    public static void main(String... args){
        Sample sample = new Sample();
        sample.createText();
    }

    void createText(){
        Context context = new Context();
        context.setVariable("targetId", "12345");

        setTargetInfo(context);

        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix("resources/");
        resolver.setTemplateMode(TemplateMode.TEXT);
        TemplateEngine engine = new TemplateEngine();
        engine.addTemplateResolver(resolver);
        Path path = Paths.get("out/sample.txt");

        try (Writer writer = Files.newBufferedWriter(path)) {
            engine.process("sample.template", context, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void setTargetInfo(Context context) {
        List<TargetInfo> list = Arrays.asList(
            new TargetInfo("name1", "dir1", 1)
           ,new TargetInfo("name2", "dir2", 2)
        );
        context.setVariable("targetList", list);
    }
}
class TargetInfo {
    String name;
    String dir;
    int ver;
    TargetInfo(String name, String dir, int ver) {
        this.name = name;
        this.dir = dir;
        this.ver = ver;
    }
    public String getName() {
        return name;
    }
    public String getDir() {
        return dir;
    }
    public String getVer() {
        return String.valueOf(ver);
    }
}

