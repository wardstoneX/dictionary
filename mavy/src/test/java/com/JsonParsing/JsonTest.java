package com.JsonParsing;

import com.JsonParsing.pojos.AuthorPojo;
import com.JsonParsing.pojos.BookPojo;
import com.JsonParsing.pojos.DayPojo;
import com.JsonParsing.pojos.simpleTestCaseJsonPojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    String simpleTestCase =  "{\n" +
            "  \"title\": \"Code with me\",\n" +
            "  \"age\": 29\n" +
            "}";
    private String dayScenario1 = "{\n" +
            "  \"date\": \"2019-12-25\",\n" +
            "  \"name\": \"Christmas Day\"\n" +
            "}";
    private String authorBooksScenario = "{\n" +
            "  \"authorName\": \"Rui\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inPrint\": true,\n" +
            "      \"publishDate\": \"2019-12-15\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inPrint\": false,\n" +
            "      \"publishDate\": \"2019-01-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    @Test
    void parse() throws IOException {


        JsonNode node = Json.parse(simpleTestCase);

        assertEquals(node.get("title").asText(),"Code with me");


    }
    @Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(simpleTestCase);
        simpleTestCaseJsonPojo pojo = Json.fromJson(node,simpleTestCaseJsonPojo.class);
        assertEquals(pojo.getTitle(),"Code with me");
        assertEquals(pojo.getAge(),29);



    }

    @Test
    void toJson() {
        simpleTestCaseJsonPojo  pojo =  new simpleTestCaseJsonPojo();
        pojo.setTitle("Testing 123");
        JsonNode node = Json.toJson(pojo);
        assertEquals(node.get("title").asText(),"Testing 123");

    }
    @Test
    void stringify() throws JsonProcessingException {
        simpleTestCaseJsonPojo  pojo =  new simpleTestCaseJsonPojo();
        pojo.setTitle("Testing 123");
        JsonNode node = Json.toJson(pojo);
        System.out.println(Json.stringify(node));
        System.out.println(Json.prettyPrint(node));

    }
    @Test
    void dayTestScenario1() throws IOException {
        JsonNode node = Json.parse(dayScenario1);
        DayPojo pojo = Json.fromJson(node, DayPojo.class);


        assertEquals("2019-12-25",pojo.getDate().toString());



    }
    @Test
    void authorTestScenario1() throws IOException {
        JsonNode node = Json.parse(authorBooksScenario);
        AuthorPojo pojo = Json.fromJson(node, AuthorPojo.class);


        System.out.println("Author :" + pojo.getName());
        for(BookPojo bp : pojo.getBooks()) {
            System.out.println("Book :" + bp.getTitle());
            System.out.println("Book :" + bp.getPublishDate());
            System.out.println("Book :" + bp.isInPrint());

        }



    }

}