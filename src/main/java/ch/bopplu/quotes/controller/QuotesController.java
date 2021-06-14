package ch.bopplu.quotes.controller;

import ch.bopplu.quotes.firestore.QuotesRepository;
import ch.bopplu.quotes.model.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Random;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quotes")
public class QuotesController {
    
    private static final int MAX_QUOTE = 3114;
    
    private final QuotesRepository quotesRepository;
    
    private final Random random = new Random();
    
    @CrossOrigin
    @GetMapping("/random")
    public Mono<Quote> getRandomQuote() {
        return quotesRepository.findById(String.format("%d", random.nextInt(MAX_QUOTE)));
    }

}
