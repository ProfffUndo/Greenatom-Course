package com.company.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Developer {
    private String name;
    private List<String> languages;

    public Developer(String name, List<String> languages) {
        this.name=name;
        this.languages=languages;

    }


    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}
