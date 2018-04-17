package philosopher.paradise.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TopicTest {

    private final String TEST_ID = "test topic id";
    private final String TEST_TEXT = "test topic text";
    private final String TEST_QUOTE_TEXT = "test quote text";
    private Quote quote = new Quote(TEST_QUOTE_TEXT);
    private List<Quote> quoteList = new ArrayList<>();
    private Topic topic;

    @Before
    public void setUp() throws Exception {
        quoteList.add(quote);
        topic = new Topic(TEST_ID, TEST_TEXT, quoteList);
    }

    @Test
    public void testBuilderAllArgsConstructor() {
        assertNotNull(topic.getId());
        assertNotNull(topic.getText());
        assertNotNull(topic.getQuotes());
    }

    @Test
    public void testTextArgConstructor() {
        Topic topicTextArgConstructor = new Topic(TEST_TEXT);
        assertNotNull(topicTextArgConstructor.getText());
        assertNull(topicTextArgConstructor.getQuotes());
    }

    @Test
    public void testGettersSetters() {
        topic.setId(TEST_TEXT);
        assertNotEquals(TEST_ID, topic.getId());
        topic.setText(TEST_QUOTE_TEXT);
        assertNotEquals(TEST_TEXT, topic.getText());
        topic.setQuotes(new ArrayList<>());
        assertNotEquals(quoteList, topic.getQuotes());
    }

    @Test
    public void testEqualsAndHashCode() {
        Topic anotherTopic = new Topic(TEST_ID, TEST_QUOTE_TEXT, quoteList);
        assertNotEquals(topic.hashCode(), anotherTopic.hashCode());
        assertNotEquals(topic, anotherTopic);
    }

    @Test
    public void testToString() {
        Topic toStringTopic = topic;
        assertEquals(topic.toString(), toStringTopic.toString());
    }
}