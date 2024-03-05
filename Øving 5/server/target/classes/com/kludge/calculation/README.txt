CalculatorApplication.java: Hovedklassen som kjører Spring Boot-applikasjonen.
config/: Denne mappen inneholder konfigurasjonsklasser, for eksempel for sikkerhet med Spring Security.
controller/: Controllere som håndterer HTTP-forespørsler, returnerer data til klienten eller mottar data fra klienten.
entity/: Entitetsklasser som representerer tabeller i databasen din og definerer databasemodellen.
repository/: Repository-interfaces som brukes av Spring Data JPA for å abstrahere dataaksesslaget.
service/: Service-klasser som inneholder forretningslogikken, kaller metoder i repositories og utfører operasjoner på dataene.
dto/: (Data Transfer Object) Dette er valgfritt og brukes for å strukturere data som sendes mellom klient og server, spesielt når du vil eksponere en annen datastruktur enn dine entiteter.
resources/: Inneholder applikasjonens konfigurasjonsfiler (som application.properties eller application.yml), samt mapper for statiske ressurser og templates hvis du serverer webinnhold direkte fra applikasjonen.