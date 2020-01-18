# spring5webapp [![Run on Repl.it](https://repl.it/badge/github/ravi2519/spring5webapp)](https://repl.it/github/ravi2519/spring5webapp)

Started with a Spring Boot Project with Web, JPA and H2

Added two  Entities -
  Author
  Book
 
`@Entity` - Make a class an entity
`@Id` - Assign a class variable as Id
`@GeneratedValue(stratergy = GeneratedType.AUTO)` - Assign the strategy of auto generation to id
 
`@ManyToMany` - Many to many mapping between Author and Book
 
`@JoinTable` - Add the join table annotation, name, joinColumns and inversejoinColumns can be added as arguments
`@JoinColumn` - Add the join columns

Equals, HashCOde and toStirng implemented for Author and Book
 
`spring.h2.console.enabled=true` is set in application properties. 
This helps in accessing the web console for H2 (localhost:8080/h2-console)
