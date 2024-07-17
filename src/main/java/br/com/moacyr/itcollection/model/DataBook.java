package br.com.moacyr.itcollection.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook( String title,
                       @JsonProperty("authors") Author[] authors,
                       @JsonProperty("subjects") String[] subjects,
                       @JsonProperty("languages") String[] languages
                       ) {
}
