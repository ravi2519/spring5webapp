# spring5webapp 

### Spring Boot 
  Started with a Spring Boot Project with 
  - Web, 
  - JPA
  - H2
  - Actuator

### Added JPA Entities
  - Author
  - Book

  #### Class Details
    - Equals, HashCode and toStirng implemented for Author and Book
    - A blank and one argument constructor added.
    
  #### Annotations used
    - `@Entity` - Make a class an entity
    - `@Id` - Assign a class variable as Id
    - `@GeneratedValue(stratergy = GeneratedType.AUTO)` - Assign the strategy of auto generation to id
    - `@ManyToMany` - Many to many mapping between Author and Book 
    - `@JoinTable` - Add the join table annotation, name, joinColumns and inversejoinColumns can be added as arguments
    - `@JoinColumn` - Add the join columns

### Added Repositories
  - Repositories are the operational extension that will help in CRUD operations.
  - We have to extend the `CrudRepository` interface to make it operational.
  - Two repositories added for two entitiy classes
    - `AuthorRepository`
    - `BookRepository`

### Application Properties
  - `spring.h2.console.enabled=true` is set in application properties. 
    This helps in accessing the web console for H2 (localhost:8080/h2-console)
    JDBC Url will be "jdbc:h2:mem:testdb"

### Bootstrap 
  - Class implementing `ApplicationListener` added that will add data to the H2 db during initialization.
  
  #### org.springframework.context interfaces used
    - `ApplicationListener`  :  ApplicationListener can generically declare
      the event type that it is interested in. When registered with a Spring
      ApplicationContext, events will be filtered accordingly, with the
      listener getting invoked for matching event objects only.
    - `ContextRefreshedEvent` : Event raised when an `ApplicationContext` gets initialized or refreshed. 
