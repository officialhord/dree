//package com.yugrow.dree.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.yugrow.dree.model.rule.Rule;
//import org.bson.Document;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//import org.springframework.stereotype.Component;
//
//@Component
//@ReadingConverter
//public class RuleReadConverter implements Converter<Document, Rule> {
//
//    private final ObjectMapper objectMapper;
//
//    public RuleReadConverter(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public Rule convert(Document source) {
//        try {
//            String json = source.toJson();
//            return objectMapper.readValue(json, Rule.class);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to convert Document to Rule", e);
//        }
//    }
//}