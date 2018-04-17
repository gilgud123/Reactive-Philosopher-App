package philosopher.paradise.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import philosopher.paradise.ReactivePhilosopherAppApplication;
import philosopher.paradise.entity.Category;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.entity.Quote;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ReactivePhilosopherAppApplication.class)
public class PhilosopherControllerTest {

    private final List<Category> protagorasCategories = new ArrayList<>();
    private final List<Quote> protagorasQuotes = new ArrayList<>();
    private Philosopher protagoras;

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @Before
    public void setUp() throws Exception {
        this.webTestClient = WebTestClient.bindToApplicationContext(this.context).configureClient().build();

        protagorasCategories.add(Category.EPISTEMOLOGY);
        protagorasQuotes.add(new Quote("Man is the measure of all things"));
        protagoras = new Philosopher("Protagoras", protagorasCategories, "A sophist philosopher and a contemporary of Plato.", protagorasQuotes);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void getPhilosophers() throws Exception{
        this.webTestClient.get().uri("/api/get")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Philosopher.class)
                ;
    }

    @Test
    @WithMockUser(roles = "USER")
    public void getPhilosopher() throws Exception{
        this.webTestClient.get().uri("/api/get/{id}", protagoras.getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Philosopher.class)
        ;
    }

    @Test
    @WithMockUser(roles = "USER")
    public void create() throws Exception{
        this.webTestClient.post().uri("/api/post")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(protagoras))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Philosopher.class)
        ;
    }

    @Test
    @WithMockUser(roles = "USER")
    public void update() throws Exception{
        this.webTestClient.put().uri("/api/put/{id}", protagoras.getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(protagoras))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Philosopher.class)
        ;
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void delete() throws Exception{
        this.webTestClient.delete().uri("/api/delete/{id}", protagoras.getId())
                .exchange()
                .expectStatus().isOk()
                ;
    }
}