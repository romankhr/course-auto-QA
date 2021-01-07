package com.course_qa2020.framework;

public class SearchTermsDataProvider {

    public static Object[][] getAllSearchTerms() {

        Object[][] searchTerms = new Object[5][1];
        searchTerms[0][0] = SearchTerms.LONDON.getSearchTerm();
        searchTerms[1][0] = SearchTerms.MANCHESTER.getSearchTerm();
        searchTerms[2][0] = SearchTerms.LEEDS.getSearchTerm();
        searchTerms[3][0] = SearchTerms.LIVERPOOL.getSearchTerm();
        searchTerms[4][0] = SearchTerms.BIRMINGHAM.getSearchTerm();
        return searchTerms;
    }

}
