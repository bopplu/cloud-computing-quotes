package ch.bopplu.quotes.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.Data;

@Data
@Document(collectionName = "quotes")
public class Quote {
    
    @DocumentId
    private String index;
    
    private String text;
}
