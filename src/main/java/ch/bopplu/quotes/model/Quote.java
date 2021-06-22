package ch.bopplu.quotes.model;

import lombok.Data;

@Data
//@Document(collectionName = "quotes")
public class Quote {

//    @DocumentId
    private String index;
    
    private String text;
}
