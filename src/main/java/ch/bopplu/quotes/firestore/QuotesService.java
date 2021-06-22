package ch.bopplu.quotes.firestore;

import ch.bopplu.quotes.model.Quote;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuotesService {
    
    private final Firestore db;
    
    public Mono<Quote> findById(String id){
        var quote = db.collection("quotes").document(id).get();
        return Mono.fromCallable(() -> quote.get().toObject(Quote.class));
    }
}
