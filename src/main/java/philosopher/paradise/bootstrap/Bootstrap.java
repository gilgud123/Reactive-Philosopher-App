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
        Topic truth = new Topic("truth");
        Topic cognition = new Topic("cognition");
        Topic morals = new Topic("morals");
        Topic religion = new Topic("religion");
        Topic politics = new Topic("politics");
        Topic human_condition = new Topic("human condition");
        Topic happiness = new Topic("happiness");
        Topic perception = new Topic("perception");
        Topic causality = new Topic("causality");
        Topic teleology = new Topic("teleology");

        //creating quotes
        Quote q1 = new Quote("Happiness is the highest good.");
        Quote q2 = new Quote("Plato is a friend but Truth is a better friend.");
        Quote q3 = new Quote("The only thing I know is that I know nothing.");
        Quote q4 = new Quote("Man is the measure of all things.");
        Quote q5 = new Quote("We are too weak to discover the truth by reason alone.");
        Quote q6 = new Quote("God is dead! He remains dead! And we have killed him.");
        Quote q7 = new Quote("You can discover more about a person in an hour of play than in a year of conversation.");
        Quote q8 = new Quote("Happiness is not an ideal of reason but of imagination.");
        Quote q9 = new Quote("He who thinks great thoughts, often makes great errors.");
        Quote q10 = new Quote("Cogito ergo sum.");
        Quote q11 = new Quote("I can control my passions and emotions if I can understand their nature.");
        Quote q12 = new Quote("Everything that exists is born for no reason, carries on living through weakness, and dies by accident.");
        Quote q13 = new Quote("Philosophers have hitherto only interpreted the world in various ways; the point, however, is to change it.");
        Quote q14 = new Quote("Religion is the sign of the oppressed ... it is the opium of the people.");

        //Linking topics to quotes
        List<Topic> q1Topics = new ArrayList<>();
        q1Topics.add(morals);
        q1Topics.add(happiness);
        q1.setTopics(q1Topics);

        List<Topic> q2Topics = new ArrayList<>();
        q2Topics.add(truth);
        q2.setTopics(q2Topics);

        List<Topic> q3Topics = new ArrayList<>();
        q3Topics.add(cognition);
        q3.setTopics(q3Topics);

        List<Topic> q4Topics = new ArrayList<>();
        q4Topics.add(cognition);
        q4Topics.add(morals);
        q4.setTopics(q4Topics);

        List<Topic> q5Topics = new ArrayList<>();
        q5Topics.add(cognition);
        q5Topics.add(truth);
        q5.setTopics(q5Topics);

        List<Topic> q6Topics = new ArrayList<>();
        q6Topics.add(human_condition);
        q6Topics.add(religion);
        q6.setTopics(q6Topics);

        List<Topic> q7Topics = new ArrayList<>();
        q7Topics.add(cognition);
        q7.setTopics(q7Topics);

        List<Topic> q8Topics = new ArrayList<>();
        q8Topics.add(happiness);
        q8Topics.add(perception);
        q8.setTopics(q8Topics);

        List<Topic> q9Topics = new ArrayList<>();
        q9Topics.add(truth);
        q9.setTopics(q9Topics);

        List<Topic> q10Topics = new ArrayList<>();
        q10Topics.add(cognition);
        q10Topics.add(human_condition);
        q10Topics.add(perception);
        q10.setTopics(q10Topics);

        List<Topic> q11Topics = new ArrayList<>();
        q11Topics.add(cognition);
        q11Topics.add(perception);
        q11Topics.add(causality);
        q11.setTopics(q11Topics);

        List<Topic> q12Topics = new ArrayList<>();
        q12Topics.add(causality);
        q12.setTopics(q12Topics);

        List<Topic> q13Topics = new ArrayList<>();
        q13Topics.add(teleology);
        q13.setTopics(q13Topics);

        List<Topic> q14Topics = new ArrayList<>();
        q14Topics.add(religion);
        q14Topics.add(politics);
        q14.setTopics(q14Topics);

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

        List<Category> saintAugustineCategories = new ArrayList<>();
        saintAugustineCategories.add(Category.ETHICS);
        saintAugustineCategories.add(Category.THEOLOGY);

        List<Category> nietzscheCategories = new ArrayList<>();
        nietzscheCategories.add(Category.ETHICS);
        nietzscheCategories.add(Category.THEOLOGY);
        nietzscheCategories.add(Category.METAPHYSICS);

        List<Category> platoCategories = new ArrayList<>();
        platoCategories.add(Category.POLITICS);
        platoCategories.add(Category.EPISTEMOLOGY);
        platoCategories.add(Category.METAPHYSICS);
        platoCategories.add(Category.ESTHETICS);

        List<Category> kantCategories = new ArrayList<>();
        kantCategories.add(Category.ETHICS);
        kantCategories.add(Category.EPISTEMOLOGY);
        kantCategories.add(Category.METAPHYSICS);
        kantCategories.add(Category.ESTHETICS);

        List<Category> heideggerCategories = new ArrayList<>();
        heideggerCategories.add(Category.ETHICS);
        heideggerCategories.add(Category.EPISTEMOLOGY);
        heideggerCategories.add(Category.METAPHYSICS);

        List<Category> descartesCategories = new ArrayList<>();
        descartesCategories.add(Category.EPISTEMOLOGY);
        descartesCategories.add(Category.METAPHYSICS);

        List<Category> spinozaCategories = new ArrayList<>();
        spinozaCategories.add(Category.EPISTEMOLOGY);
        spinozaCategories.add(Category.METAPHYSICS);
        spinozaCategories.add(Category.ETHICS);

        List<Category> sartreCategories = new ArrayList<>();
        spinozaCategories.add(Category.POLITICS);
        spinozaCategories.add(Category.ETHICS);

        List<Category> marxCategories = new ArrayList<>();
        marxCategories.add(Category.POLITICS);
        marxCategories.add(Category.METAPHYSICS);

        //creating quotes lists for philosophers
        List<Quote> aristotleQuotes = new ArrayList<>();
        aristotleQuotes.add(q1);
        aristotleQuotes.add(q2);

        List<Quote> socratesQuotes = new ArrayList<>();
        socratesQuotes.add(q3);

        List<Quote> protagorasQuotes = new ArrayList<>();
        protagorasQuotes.add(q4);

        List<Quote> saintAugustineQuotes = new ArrayList<>();
        saintAugustineQuotes.add(q5);

        List<Quote> nietzscheQuotes = new ArrayList<>();
        nietzscheQuotes.add(q6);

        List<Quote> platoQuotes = new ArrayList<>();
        platoQuotes.add(q7);

        List<Quote> kantQuotes = new ArrayList<>();
        kantQuotes.add(q8);

        List<Quote> heideggerQuotes = new ArrayList<>();
        heideggerQuotes.add(q9);

        List<Quote> descartesQuotes = new ArrayList<>();
        descartesQuotes.add(q10);

        List<Quote> spinozaQuotes = new ArrayList<>();
        spinozaQuotes.add(q11);

        List<Quote> sartreQuotes = new ArrayList<>();
        sartreQuotes.add(q12);

        List<Quote> marxQuotes = new ArrayList<>();
        marxQuotes.add(q13);
        marxQuotes.add(q14);

        //creating philosophers
        Philosopher aristotle = new Philosopher("Aristotle", aristotleCategories, "A philosopher, scientist, historian and the teacher of Alexandre the Great, Aristotles teachings remain immensly influential in our cultlure.", aristotleQuotes);
        Philosopher socrates = new Philosopher("Socrates", socratesCategories, "The father of philosophy as we know it!", socratesQuotes);
        Philosopher protagoras = new Philosopher("Protagoras", protagorasCategories, "A sophist philosopher and a contemporary of Plato. A daring relativist who opted to blade run the ethical dilemmas of human condition while irreputable truths were still a norm.", protagorasQuotes);
        Philosopher saintAugustine = new Philosopher("Saint Augustine", saintAugustineCategories, "A prominent theologician and one of the most respected fathers of the Christian church.", saintAugustineQuotes);
        Philosopher nietzsche = new Philosopher("Nietzsche",nietzscheCategories, "The first nihilist and god hater. Invented the ubermensch and inspired Wagner and Hitler alike.", nietzscheQuotes);
        Philosopher plato = new Philosopher("Plato",platoCategories, "A student of Socrates, an idealist and a hater of women. His ideal of state system was a caste-based dictatorship. His most prominent legacy is a a notion of this world being build as a reflection of a perfect world of ideas, or pattern for all things present. Still can be traced in various ways of thinking in modern culture.", platoQuotes);
        Philosopher kant = new Philosopher("Kant",kantCategories, "The first nihilist and god hater. Invented the ubermensch and inspired Wagner and Hitler alike.", kantQuotes);
        Philosopher heidegger = new Philosopher("Heidegger", heideggerCategories, "One of the most influential philosophers of the past century. Concentrated not on the objectivity of the external world but on its perception, without subjectivism. Collaborated with the nazi regime.", heideggerQuotes);
        Philosopher descartes = new Philosopher("Descartes", descartesCategories, "The father of modern science, Descartes was the first to emancipate cognition and scientific method from theology.", descartesQuotes);
        Philosopher spinoza = new Philosopher("Spinoza", spinozaCategories, "One of the first truly modern thinkers. Promoted freedom of thought in his work, e.g. Tractatus Politologico, and his way of life by being religiously neutral in 17-century Holland. Inspired a.o. the deep ecology movement.", spinozaQuotes);
        Philosopher sartre = new Philosopher("Sartre", sartreCategories, "The most prominent existential philosopher, Sartre helped promoting most radical and forward-thinking social projects of his time, like female emancipation, civil rights, global peace etc. Many of his works are written in a form of a play.", sartreQuotes);
        Philosopher marx = new Philosopher("Marx", marxCategories, "If not a most elaborate thinker, Marx certainly remain one of the most influential so far. The father of communism and an excellent economy theoritician.", marxQuotes);

        //linking philosophers to quotes
        q1.setPhilosopherId(aristotle.getId());
        q2.setPhilosopherId(aristotle.getId());
        q3.setPhilosopherId(socrates.getId());
        q4.setPhilosopherId(protagoras.getId());
        q5.setPhilosopherId(saintAugustine.getId());
        q6.setPhilosopherId(nietzsche.getId());
        q7.setPhilosopherId(plato.getId());
        q8.setPhilosopherId(kant.getId());
        q9.setPhilosopherId(heidegger.getId());
        q10.setPhilosopherId(descartes.getId());
        q11.setPhilosopherId(spinoza.getId());
        q12.setPhilosopherId(sartre.getId());
        q13.setPhilosopherId(marx.getId());
        q14.setPhilosopherId(marx.getId());

        if(tRepo.count().block()==0){
            System.out.println(" === Loading topics to the database ===");

            //loading topics
            tRepo.save(truth).block();
            tRepo.save(cognition).block();
            tRepo.save(morals).block();
            tRepo.save(religion).block();
            tRepo.save(politics).block();
            tRepo.save(human_condition).block();
            tRepo.save(happiness).block();
            tRepo.save(perception).block();
            tRepo.save(causality).block();
            tRepo.save(teleology).block();

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
            pRepo.save(protagoras).block();
            pRepo.save(saintAugustine).block();
            pRepo.save(nietzsche).block();
            pRepo.save(plato).block();
            pRepo.save(kant).block();
            pRepo.save(heidegger).block();
            pRepo.save(descartes).block();
            pRepo.save(spinoza).block();
            pRepo.save(sartre).block();
            pRepo.save(marx).block();

            System.out.println("Loaded philosophers: " + pRepo.count().block());
        }
    }
}
