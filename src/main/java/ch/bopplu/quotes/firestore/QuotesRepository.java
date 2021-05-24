package ch.bopplu.quotes.firestore;

import ch.bopplu.quotes.model.Quote;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface QuotesRepository extends FirestoreReactiveRepository<Quote> {

}
