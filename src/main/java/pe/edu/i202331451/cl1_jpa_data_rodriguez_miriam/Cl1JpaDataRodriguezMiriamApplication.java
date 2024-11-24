package pe.edu.i202331451.cl1_jpa_data_rodriguez_miriam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202331451.cl1_jpa_data_rodriguez_miriam.entity.Country;
import pe.edu.i202331451.cl1_jpa_data_rodriguez_miriam.repository.CountryRepository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataRodriguezMiriamApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {

		SpringApplication.run(Cl1JpaDataRodriguezMiriamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		/**
		 * ifPresentOrElse()
		 */
		Optional<Country> optional = countryRepository.findById("ARG");

		optional.ifPresentOrElse(
				(countryArg) -> {
					LocalDate localDate = LocalDate.now();
					System.out.println(localDate);
					System.out.println("Lenguajes en el país de Argentina (ARG):");
					countryArg.getCountryLanguage().forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					Optional<Country> optionalPeru = countryRepository.findById("PER");
					optionalPeru.ifPresentOrElse(
							(countryPer) -> {
								System.out.println("Lenguajes  en el país de Perú (PER):");
								countryPer.getCountryLanguage().forEach(language -> System.out.println(language.getLanguage()));
							},
							() -> System.out.println("No se encontró los lenguajes del país de Perú (PER)")
					);
				}
		);

		/**
		 * deleteAllById()
		 */
//        List<String> lista = List.of("COL","ARG");
//        lista.stream().filter((id) -> {
//            return countryRepository.existsById(id);
//        }).collect(Collectors.toList());
//        lista.stream().filter(countryRepository::existsById).collect(Collectors.toList());
//        countryRepository.deleteAllById(lista);


	}
}
