package br.com.moacyr.itcollection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> tClass) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode resultNode = rootNode.path("results");
            if (resultNode.isArray() && resultNode.size() > 0){
                JsonNode firstResultNode = resultNode.get(0);
                return mapper.treeToValue(firstResultNode, tClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

