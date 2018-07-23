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
        Philosopher aristotle = new Philosopher("Aristotle", aristotleCategories, "A philosopher, scientist, historian and the teacher of Alexandre the Great, Aristotles teachings remain immensly influential in our cultlure. He was first to start a systematic classification of schientific exploits of his time laying basis for many branches of science. His philosophical views are less rigid and more dialictical than those of Plato, as was his vision of politics, with an enlightened ruler, such as Alexandre, at the head of a state.", aristotleQuotes);
        Philosopher socrates = new Philosopher("Socrates", socratesCategories, "The father of modern Western philosophy, Socrates also developed some basic logical methods that were further developed by his successors, Plato and Aristotle, and which modern science uses up till now. His dialectical method, also known as the Socratic method, lies at the basis of European critical free-thiking. Unfortunately it also cost Socrates his life eventually, as his undermining critical view of his contemporary morals and politics became increasingly threatening to the Athens authorities.", socratesQuotes);
        Philosopher protagoras = new Philosopher("Protagoras", protagorasCategories, "Protagoras was sophist philosopher and a contemporary of Plato. As the Platonic, and later Christian, views prevailed, every divergent thinking was pushed into oblivion and even destroyed. All we have left of Protagoras are a few facts and phrases preserved in bias reports by his winning opponents. Yet this gives us a notion of a daring relativist who opted to blade run the ethical dilemmas of human condition while irreputable truths were still a norm.", protagorasQuotes);
        Philosopher saintAugustine = new Philosopher("Saint Augustine", saintAugustineCategories, "A prominent theologician and one of the most respected fathers of the Christian church, Saint-Augustine began as a decadent and a neo-Platonic philosopher only to turn to faith later. Due to his effort, the Platonic ideas became thouroughly incorporated into the Western Christianity. His original ideas, that survive up till today, are of the divine grace, the original sin, the just war and the very concept of the Holy Trinity. His concept of the two cities, one of the the immortal holy city of God, goes along the lines of the platonic story of the cave and the bright world of immortal devine ideas.", saintAugustineQuotes);
        Philosopher nietzsche = new Philosopher("Nietzsche",nietzscheCategories, "The first famous nihilist with a rather troublesome relationship with the God gather-figure, Nietzsche is charched with inventing the ubermensch and inspiring Wagner and Hitler alike. His famous announcement that -God is dead and we killed him- heralded the niew atheistic and existentialist attitude towards reality. His answer to the problem was to promote the idea of ubermensch, a new sort of human being unbounded by conventional morals and ideas. An idea that appealed to the nazi culture and led to redesigning of Western morals.", nietzscheQuotes);
        Philosopher plato = new Philosopher("Plato",platoCategories, "A student of Socrates, an idealist and a hater of women. His ideal of state system was a caste-based dictatorship. His most prominent legacy is a a notion of this world being build as a reflection of a perfect world of ideas, or pattern for all things present. Still can be traced in various ways of thinking in modern culture.", platoQuotes);
        Philosopher kant = new Philosopher("Kant",kantCategories, "A German classic philosopher to whom we owe many ideas behind the Declaration of Human rights, Kant saw reason as the main unifying characteristic of human species. Rationality was the basis of his idea of faith, religion and ethics, too. Morality was in direct connecion with reason and as such - its logical outcome. Kant made an important contribution to the theory of cognition and science by his notion of ding an sich, a true natural object that we cannot penetrate but only learn by proxy, by a mental construct due to our physical limitations (e.g. nuclear physics or black holes).", kantQuotes);
        Philosopher heidegger = new Philosopher("Heidegger", heideggerCategories, "One of the most influential philosophers of the past century, Heidegger is hard to classify, since his main concern lies not with the objectivity of the external world but with its perception. Not a subjectivist as such, Heidegger found the idea of being itself, as a presence (dasein) of every thing in the world, fascinating. Dasein is for him more than mere presence, but an active awareness of living beings in the world that upholds it. Dasein is intentional and means care for the world and its things. Unfortunately Heidegger also collaborated with the nazi regime which to an extent smeared his image in the West.", heideggerQuotes);
        Philosopher descartes = new Philosopher("Descartes", descartesCategories, "The father of modern science, Descartes was the first to emancipate cognition and scientific method from theology. He managed to find the basis of thought and human existance in the mental process of cognition making it the major characteristic of humanity. His is also credited with the invention of the Cartesian coordinate system and analytical geometry. He also denied the divine explanation of the natural phenomena. Another controversial thesis by Descarte was that animals have no soul and are mere authomatons, which paved the way to further exploitation of nature in the industrial era.", descartesQuotes);
        Philosopher spinoza = new Philosopher("Spinoza", spinozaCategories, "One of the first modern thinkers who promoted freedom of social, political and religious identity in the 17th century Netherlands, Spinoza was initially raised to become a leading rabbi of the Amsterdam Jewish community. His break with the tradition lead to his excommunication that lasted till late 20th century. His way of life can be seen as the first example of a truly modern man who sees his views and identity as a personal choice. His concept of God as Nature inspired a.o. the deep ecology movement.", spinozaQuotes);
        Philosopher sartre = new Philosopher("Sartre", sartreCategories, "The most prominent existential philosopher, Sartre helped promoting most radical and forward-thinking social projects of his time, like female emancipation, civil rights, global peace etc. Supported and actively participated in the events of 1968 in Paris. A socialist by conviction, Sartre distantiated himself from the USSR politics. His wife, a French feminist and philosopher Simone de Beauvoir, and Sartre himself actively promoted the feminist agenda. Many of Sartres works are written in a form of a play. His main focus was on anthropology, seeing life as meaningless and godless, with human beings being sentenced to create their own meaning of life while constantly causing each other pain through persuing their own interests.", sartreQuotes);
        Philosopher marx = new Philosopher("Marx", marxCategories, "If not a most elaborate thinker, Marx certainly remains one of the most influential so far. The creater of communism and an excellent economy theoritician, Marx is accounted among the prominent political and social philosophers of the modern era. Instrumental to his political views, his philosophy can arguably be couted as an ideologically tainted attempt at digesting Hegels metaphysics. While ignoring Hegels Absoluter Geist, Marx adopts his theory of spyral dynamics of social, political and historical development and uses it as the base for his class struggle theory. Another feature of Marxs philosophy is the dye-hard materialism that leaves no space for any traces of transcedency.", marxQuotes);

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
