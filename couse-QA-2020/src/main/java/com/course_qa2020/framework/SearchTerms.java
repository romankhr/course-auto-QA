package com.course_qa2020.framework;

public enum SearchTerms {
    LONDON("London"),
    MANCHESTER("Manchester"),
    LEEDS("leeds"),
    LIVERPOOL("liverpool"),
    BIRMINGHAM("birmingham");
    private final String searchTerm;

    SearchTerms(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }
}
