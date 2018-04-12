package philosopher.paradise.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhilosopherTest {

    private final String TEST_ID = "test id";
    private final String TEST_NAME = "test name";
    private final String TEST_DESCRIPTION = "test description";
    private final String TEST_QUOTE_TEXT = "test philosopher id";
    private List<Category> categories = new ArrayList<>();
    private final Quote quote = new Quote(TEST_QUOTE_TEXT);
    private List<Quote> quotes = new ArrayList<>();
    private Philosopher philosopher;
    private Philosopher anotherPhilosopher;

    @Before
    public void setUp() throws Exception {
        categories.add(Category.METAPHYSICS);
        quotes.add(quote);
        philosopher = new Philosopher(TEST_NAME, categories, TEST_DESCRIPTION, quotes);
    }

    @Test
    public void testConstructor() {
        assertNotNull(philosopher.getId());
        assertNotNull(philosopher.getName());
        assertNotNull(philosopher.getCategories());
        assertNotNull(philosopher.getDescription());
        assertNotNull(philosopher.getQuotes());
    }

    @Test
    public void testGettersSetters() {
        String id = philosopher.getId();
        philosopher.setId(TEST_ID);
        assertNotEquals(id, philosopher.getId());

        philosopher.setName("another name");
        assertNotEquals(TEST_NAME, philosopher.getName());

        philosopher.setCategories(new ArrayList<>());
        assertNotEquals(categories, philosopher.getCategories());

        philosopher.setDescription("another description");
        assertNotEquals(TEST_DESCRIPTION, philosopher.getDescription());

        philosopher.setQuotes(new ArrayList<>());
        assertNotEquals(quotes, philosopher.getQuotes());
    }

    @Test
    public void testEqualsAndHashcode() {
        anotherPhilosopher = new Philosopher(TEST_NAME, categories, TEST_DESCRIPTION, quotes );
        assertNotEquals(philosopher, anotherPhilosopher);
        assertNotEquals(philosopher.hashCode(), anotherPhilosopher.hashCode());
    }

    @Test
    public void testToString() {
        anotherPhilosopher = philosopher;
        assertEquals(philosopher.toString(), anotherPhilosopher.toString());
    }
}