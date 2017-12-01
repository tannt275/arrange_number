package model;

import java.util.List;

import helper.AppConstant;

/**
 * Created by tan.nt on 11/10/17.
 */

public class MGame extends MBase {
    private List<MMain> results;
    private List<MMain> allResults;

    public List<MMain> getResults() {
        return results;
    }

    public void setResults(List<MMain> results) {
        this.results = results;
    }

    public List<MMain> getAllResults() {
        return allResults;
    }

    public void setAllResults(List<MMain> allResults) {
        this.allResults = allResults;
    }
}
