package com.sample;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}
