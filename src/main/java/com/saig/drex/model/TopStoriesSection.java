package com.saig.drex.model;

import java.util.*;

public enum TopStoriesSection {

    unknown("unknown section: "), arts("arts"), automobiles("automobiles"), books("books"),
    business("business"), fashion("fashion"), food("food"),
    health("health"), home("home"), insider("insider"),
    magazine("magazine"), movies("movies"), nyregion("nyregion"),
    obituaries("obituaries"), opinion("opinion"), politics("politics"),
    realestate("realestate"), science("science"), sports("sports"),
    sundayreview("sundayreview"), technology("technology"), theater("theater"),
    t_magazine("t-magazine"), travel("travel"), upshot("upshot"), us("us"), world("world");

    private final String section;
    private static final String SECTION_TYPE = ".json";
    private static final Map<TopStoriesSection, String> sectionsMap = new HashMap<>();

    static {
        for (TopStoriesSection storiesSection : values()) {
            sectionsMap.put(storiesSection, storiesSection.getSection());
        }
    }

    TopStoriesSection(String section) {
        this.section = section;
    }

    public static String fromSection(String section) {
        return sectionsMap.getOrDefault(TopStoriesSection.valueOf(section), home.getSection());
    }

    public String getSection() {
        return section + SECTION_TYPE;
    }
}
