package philosopher.paradise.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import philosopher.paradise.entity.Category;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.repository.PhilosopherRepository;
import philosopher.paradise.repository.QuoteRepository;
import philosopher.paradise.repository.TopicRepository;
import philosopher.paradise.service.PhilosopherServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final PhilosopherRepository pRepo;
    private final QuoteRepository qRepo;
    private final TopicRepository tRepo;

    public Bootstrap(PhilosopherRepository pRepo, QuoteRepository qRepo, TopicRepository tRepo) {
        this.pRepo = pRepo;
        this.qRepo = qRepo;
        this.tRepo = tRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //creating topics
        Topic truth = Topic.builder().text("truth").build();
        Topic cognition = Topic.builder().text("cognition").build();
        Topic morals = Topic.builder().text("morals").build();
        Topic religion = Topic.builder().text("religion").build();
        Topic politics = Topic.builder().text("politics").build();
        Topic human_condition = Topic.builder().text("human condition").build();
        Topic general = Topic.builder().text("general").build();

        //creating quotes
        Quote q1 = Quote.builder().text("Happiness is the highest good.").build();
        Quote q2 = Quote.builder().text("Plato is a friend but Truth is a better friend.").build();
        Quote q3 = Quote.builder().text("The only thing I know is that I know nothing.").build();
        Quote q4 = Quote.builder().text("Man is the measure of all things.").build();
        Quote q5 = Quote.builder().text("We are too weak to discover the truth by reason alone.").build();
        Quote q6 = Quote.builder().text("God is dead! He remains dead! And we have killed him.").build();
        Quote q7 = Quote.builder().text("You can discover more about a person in an hour of play than in a year of conversation.").build();
        Quote q8 = Quote.builder().text("Happiness is not an ideal of reason but of imagination.").build();
        Quote q9 = Quote.builder().text("He who thinks great thoughts, often makes great errors.").build();
        Quote q10 = Quote.builder().text("Cogito ergo sum.").build();
        Quote q11 = Quote.builder().text("I can control my passions and emotions if I can understand their nature.").build();
        Quote q12 = Quote.builder().text("Everything that exists is born for no reason, carries on living through weakness, and dies by accident.").build();
        Quote q13 = Quote.builder().text("Philosophers have hitherto only interpreted the world in various ways; the point, however, is to change it.").build();
        Quote q14 = Quote.builder().text("Religion is the sign of the oppressed ... it is the opium of the people.").build();

        //Linking topics to quotes
        List<Topic> q1Topics = new ArrayList<>();
        q1Topics.add(morals);
        q1.setTopics(q1Topics);

        List<Topic> q2Topics = new ArrayList<>();
        q2Topics.add(truth);
        q2.setTopics(q2Topics);

        List<Topic> q3Topics = new ArrayList<>();
        q3Topics.add(cognition);
        q3.setTopics(q3Topics);

        //creating category lists
        List<Category> aristotleCategories = new ArrayList<>();
        aristotleCategories.add(Category.METAPHYSICS);
        aristotleCategories.add(Category.ETHICS);
        aristotleCategories.add(Category.EPISTEMOLOGY);
        aristotleCategories.add(Category.ESTHETICS);

        List<Category> socratesCategories = new ArrayList<>();
        socratesCategories.add(Category.METAPHYSICS);
        socratesCategories.add(Category.ETHICS);
        socratesCategories.add(Category.EPISTEMOLOGY);

        List<Category> protagorasCategories = new ArrayList<>();
        protagorasCategories.add(Category.EPISTEMOLOGY);
        protagorasCategories.add(Category.ETHICS);

        //creating quotes lists for philosophers
        List<Quote> aristotleQuotes = new ArrayList<>();
        aristotleQuotes.add(q1);
        aristotleQuotes.add(q2);

        List<Quote> socratesQuotes = new ArrayList<>();
        socratesQuotes.add(q3);

        List<Quote> protagorasQuotes = new ArrayList<>();
        protagorasQuotes.add(q4);

        //creating philosophers
        Philosopher aristotle = new Philosopher("Aristotle", aristotleCategories, "A philosopher, scientist, historian and the teacher of Alexandre the Great, Aristotles teachings remain immensly influential in our cultlure.", aristotleQuotes);
        Philosopher socrates = new Philosopher("Socrates", socratesCategories, "The father of philosophy as we know it!", socratesQuotes);
        Philosopher protagoras = new Philosopher("Protagoras", protagorasCategories, "A sophist philosopher and a contemporary of Plato. A daring relativist who opted to blade run the ethical dilemmas of human condition while irreputable truths were still a norm.", protagorasQuotes);

        //linking philosophers to quotes
        q1.setPhilosopherId(aristotle.getId());
        q2.setPhilosopherId(aristotle.getId());
        q3.setPhilosopherId(socrates.getId());
        q4.setPhilosopherId(protagoras.getId());

        if(tRepo.count().block()==0){
            System.out.println(" === Loading topics to the database ===");

            //loading topics
            tRepo.save(truth).block();
            tRepo.save(cognition).block();
            tRepo.save(morals).block();
            tRepo.save(religion).block();
            tRepo.save(politics).block();
            tRepo.save(human_condition).block();
            tRepo.save(general).block();

            System.out.println("Loaded topics: " + tRepo.count().block());
        }

        if(qRepo.count().block() == 0){
            System.out.println(" === Loading quotes to the database ===");

            //loading quotes
            qRepo.save(q1).block();
            qRepo.save(q2).block();
            qRepo.save(q3).block();
            qRepo.save(q4).block();
            qRepo.save(q5).block();
            qRepo.save(q6).block();
            qRepo.save(q7).block();
            qRepo.save(q8).block();
            qRepo.save(q9).block();
            qRepo.save(q10).block();
            qRepo.save(q11).block();
            qRepo.save(q12).block();
            qRepo.save(q13).block();
            qRepo.save(q14).block();

            System.out.println("Loaded quotes: " + qRepo.count().block());
        }

        if(pRepo.count().block() == 0){
            System.out.println(" === Loading philosophers to the database ===");

            //loading philosophers
            pRepo.save(aristotle).block();
            pRepo.save(socrates).block();

            System.out.println("Loaded philosophers: " + pRepo.count().block());
        }
    }
}
