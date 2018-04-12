package philosopher.paradise.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuoteTest {

    private final String TEST_ID = "test id";
    private final String TEST_TEXT = "test text";
    private final String TEST_TOPIC_TEXT = "test topic text";
    private final String TEST_PHILOSOPHER_ID = "test philosopher id";
    private List<Topic> topics = new ArrayList<>();
    private final Topic topic = new Topic(TEST_TOPIC_TEXT);
    private Quote quote;
    private Quote anotherQuote;

    @Before
    public void setUp() throws Exception {
        topics.add(topic);
        quote = Quote.builder().id(TEST_ID).text(TEST_TEXT).topics(topics).philosopherId(TEST_PHILOSOPHER_ID).build();
    }

    @Test
    public void testBuilderAllArgsConstructor() {
        assertNotNull(quote.getId());
        assertNotNull(quote.getText());
        assertNotNull(quote.getTopics());
        assertNotNull(quote.getPhilosopherId());
    }

    @Test
    public void testGettersSetters() {
        quote.setId(TEST_PHILOSOPHER_ID);
        assertNotEquals(TEST_ID, quote.getId());

        quote.setText(TEST_TOPIC_TEXT);
        assertNotEquals(TEST_TEXT, quote.getText());

        quote.setTopics(new ArrayList<>());
        assertNotEquals(topics, quote.getTopics());

        quote.setPhilosopherId(TEST_ID);
        assertNotEquals(TEST_PHILOSOPHER_ID, quote.getPhilosopherId());
    }

    @Test
    public void testEqualsAndHashCode() {
        anotherQuote = new Quote("another id", TEST_TEXT, topics, TEST_PHILOSOPHER_ID);

        assertNotEquals(quote, anotherQuote);
        assertNotEquals(quote.hashCode(), anotherQuote.hashCode());
    }

    @Test
    public void testToString() {
        anotherQuote = quote;
        assertEquals(quote.toString(), anotherQuote.toString());
    }
}