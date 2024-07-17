package br.com.moacyr.itcollection;

import br.com.moacyr.itcollection.main.Main;
import br.com.moacyr.itcollection.model.DataBook;
import br.com.moacyr.itcollection.model.UserInteraction;
import br.com.moacyr.itcollection.service.ConsumptionAPI;
import br.com.moacyr.itcollection.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class ItcollectionApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ItcollectionApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		Main main = new Main();
		UserInteraction user = new UserInteraction();
		var consumption = new ConsumptionAPI();

		int option = -1;
		String book = null;

		while (option != 0){

			main.display();
			option = user.getOptionFromUser();

			switch (option){
				case 1:
					book = user.findBook();
					break;
				default:
								
			}
			var json = consumption.getData(main.getUrl(book));

			System.out.println("Teste " +json);
		}

		//var json = consumption.getData("https://gutendex.com/books?search=dom+casmurro");

/*		System.out.println("Teste " +json);

		DataConverter dataConverter = new DataConverter();

		DataBook dataBook = dataConverter.getData(json, DataBook.class);

		if(dataBook != null){
			System.out.println("Title: " + dataBook.title());
			System.out.println("Author: ");
			for (var author : dataBook.authors()) {
				System.out.println(" - " + author.name() + " (" + author.birth_year()+ " - " + author.death_year() + ")");
				
			}
			System.out.println("Subject: " + String.join(", ", dataBook.subjects()));
			System.out.println("Language: " + String.join(", ", dataBook.languages()));
		}
		else{
			System.out.println("No results found");
		}

 */
	}
}
