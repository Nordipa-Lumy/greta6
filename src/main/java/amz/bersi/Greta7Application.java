package amz.bersi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import amz.bersi.dao.ConseilDAO;
import amz.bersi.dao.QuestionDAO;
import amz.bersi.entities.Conseil;
import amz.bersi.entities.Question;

@SpringBootApplication
public class Greta7Application implements CommandLineRunner{

	@Autowired
	private QuestionDAO questionDAO;  
	
	@Autowired
	private ConseilDAO conseilDAO;  

	public static void main(String[] args) {
		SpringApplication.run(Greta7Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		/*questionDAO.save(new Question("Hauteur vague la plus haute du monde (en metre)?", "125", "236", "524", "406", "C", "Nature", "Environnement", 2019));*/	
		questionDAO.save(new Question("Hauteur vague la plus haute du monde (en metre)?", "125", "236", "524", "406", "C", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Chaleur la plus élevée en degré sur terre (en degre celsius)?", "45", "50.3", "58", "61.2", "C", "Climat", "Environnement", 2019));
		questionDAO.save(new Question("Longueur du canal du midi (en km) ?", "241", "225", "256", "234", "A", "Transport", "Economique", 2019));
		questionDAO.save(new Question("Hauteur du Mont Blanc (en metre) ?", "2550", "3859", "4910", "4810", "D", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Longueur du fleuve Amazone (en km) ?", "4502", "6400", "8955", "6020", "B", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Superficie mini d'une pièce habitable (en m2) ?", "7", "10", "9", "11", "C", "Habitat", "Social", 2019));
		questionDAO.save(new Question("Poids déchets par habitant/an en France (en kg)?", "513", "212", "326", "401", "A", "Habitat", "Environnement", 2019));
		questionDAO.save(new Question("Différence salaire mensuel net moyen homme/femme en France (en %) ?", "21.3", "15.9", "5.5", "18.5", "D", "Emploi", "Social", 2019));
		questionDAO.save(new Question("Ville francaise comportant plus d'espaces verts ?", "Angers", "Toulouze", "Ste-Marie-Aux-Mines", "Rennes", "A", "Habitat", "Environnement", 2019));
		questionDAO.save(new Question("Nombre de réacteurs nucléaires en activité en France ?", "61", "56", "55", "58", "D", "Habitat", "Economique", 2019));
		questionDAO.save(new Question("Nombre exploitations agricoles bio en France ?", "26210", "41600", "55220", "63230", "B", "Emploi", "Economique", 2019));
		questionDAO.save(new Question("Part parc véhicules electriques en France (en %)?", "1.8", "2.3", "3.1", "4.5", "A", "Transport", "Economique", 2019));
		questionDAO.save(new Question("Consommation electrique par habitant/an en France (en kWh)?", "7035.3", "2569.3", "3589.42", "6939.52", "D", "Habitat", "Environnement", 2019));
		questionDAO.save(new Question("Part déchets plastiques non recyclés au monde (en %) ?", "91", "55", "33", "22", "A", "Climat", "Environnement", 2019));
		questionDAO.save(new Question("Longueur moyenne trajet voiture par jour (en km)?", "1.3", "2.9", "15.6", "25.2", "D", "Transport", "Social", 2019));
		questionDAO.save(new Question("Nombre tués au travail en France en 2017 ?", "180", "258", "356.3", "530", "D", "Transport", "Emploi", 2019));
		questionDAO.save(new Question("Part du télétravail en France 2018 (en %)?", "11", "15", "20", "25", "D", "Emploi", "Economique", 2019));
		questionDAO.save(new Question("Part des bouteilles verre recyclées (en %)?", "100", "80", "75", "60", "C", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Superficie de la foret Amazonie (en km2)?", "1.3", "2.6", "5.6", "5.5", "D", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Hauteur du K2 (en metre) ?", "8611", "6399", "5523", "6963", "A", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Longueur de la Loire (en km) ?", "1012", "2330", "969", "856", "A", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Profondeur du lac Léman (en m)?", "30", "210", "310", "410", "C", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Poids A320 à vide (en tonne) ?", "45.3", "40.3", "55.2", "60.1", "B", "Transport", "Economique", 2019));
		questionDAO.save(new Question("Distance nébuleuse crabe (en année-lumière)?", "1652", "2366", "5699", "6523", "D", "Nature", "Environnement", 2019));
		questionDAO.save(new Question("Superficie de Antartartique (en million km)?", "11", "12", "13", "14", "D", "Nature", "Environnement", 2019));
 
		conseilDAO.save(new Conseil("Il faut ramasser ses détritus après le pique nique !"));
		conseilDAO.save(new Conseil("Il faut prendre une douche plutot qu'un bain !"));
		conseilDAO.save(new Conseil("Il faut acheter en vrac !"));
		conseilDAO.save(new Conseil("Il ne faut pas manger nos amis les animaux !"));
		conseilDAO.save(new Conseil("Il faut faire du sport !"));
		
		/*
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_1.0");
		feed.setTitle("Test title");
		feed.setLink("http://www.somelink.com");
		feed.setDescription("Basic description");
		
		SyndEntry entry = new SyndEntryImpl();
		entry.setTitle("Entry title");        
		entry.setLink("http://www.somelink.com/entry1");
		     
		feed.setEntries(Arrays.asList(entry));
		
		SyndContent description = new SyndContentImpl();
		description.setType("text/html");
		description.setValue("First entry");
		 
		entry.setDescription(description);
		
		
		List<SyndCategory> categories = new ArrayList<>();
		SyndCategory category = new SyndCategoryImpl();
		category.setName("Sophisticated category");
		categories.add(category);
		 
		entry.setCategories(categories);
		
		URL feedSource = new URL("http://rssblog.whatisrss.com/feed/");
		SyndFeedInput input = new SyndFeedInput();
		feed = input.build(new XmlReader(feedSource));
*/		
	}
}