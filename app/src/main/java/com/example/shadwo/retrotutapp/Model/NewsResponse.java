package com.example.shadwo.retrotutapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shadwo on 5/30/2017.
 */

public class NewsResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("source")
    private String source;
    @SerializedName("sortBy")
    private String sortBy;
    @SerializedName("articles")
    private List<News> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<News> getResults() {
        return results;
    }

    public void setResults(List<News> results) {
        this.results = results;
    }
}
