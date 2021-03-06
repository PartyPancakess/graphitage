package com.example.demo.Model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@JsonPropertyOrder({"paperId", "paperIdType", "title"})
@Getter
@Setter
@NodeEntity("Paper")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Paper extends PaperDetails implements Comparable<Paper> {

    @Id
    @Property("paperId")
    private String paperId;

    @Property("paperIdType")
    private String paperIdType;

    @Property("title")
    private String title;

    @JsonFormat(pattern = "yyyy")
    @JsonProperty("year")
    @Property("publishDate")
    private Date publishDate;


    @Property("keywords")
    private List<String> keywords;


    @Property("linkOfPaper")
    private String linkOfPaper;

    @Property("authors")
    private String authors;

    @JsonIgnoreProperties({"papers", "paper"})
    @Relationship(type = "PREPROCESSING")
    @JsonProperty("datasets")
    private List<Preprocessing> datasets = new ArrayList<>();

    @JsonProperty(value = "libraries")
    @Relationship(type = "HAS_LIBRARY")
    @JsonIgnoreProperties({"papers"})
    private List<Library> libraries = new ArrayList<>();

    @JsonProperty(value = "relatedWorks")
    @Relationship(type = "RELATED_WITH")
    @JsonIgnoreProperties({"relatedWorks"})
    private List<Paper> relatedWorks = new ArrayList<>();

    @JsonProperty(value = "reader")
    @Relationship(type = "HAS_READER")
    @JsonIgnoreProperties({"papers"})
    private List<Reader> readers = new ArrayList<>();


    public Paper() {
        super();
    }

    public Paper(String paperId, String paperIdType, String title, Date publishDate, List<String> keywords, String abstractOfPaper, List<String> targets, List<String> problems, List<String> summaries, List<String> components, List<String> applicationDomains, List<String> highlights, List<String> contributions, List<String> cons, List<String> pros, List<String> futureWorks, List<String> evaluationMetrics, String linkOfPaper, String authors, List<String> constraints, List<String> notes, List<String> comments) {
        super(abstractOfPaper, targets, problems, summaries, components, applicationDomains,
                highlights, contributions, cons, pros, futureWorks, evaluationMetrics,
                constraints, notes, comments);
        this.paperId = paperId;
        this.paperIdType = paperIdType;
        this.title = title;
        this.publishDate = publishDate;
        this.keywords = keywords;
        this.linkOfPaper = linkOfPaper;
        this.authors = authors;
    }

    @Override
    public int compareTo(Paper o) {
        return this.getPaperId().compareTo(o.getPaperId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return paperId.equals(paper.paperId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId);
    }
}
