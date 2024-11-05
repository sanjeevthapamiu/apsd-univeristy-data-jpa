# APSD University Data JPA

## ERD
![ERD](https://github.com/sanjeevthapamiu/apsd-univeristy-data-jpa/blob/main/screenshots/ERD.jpeg)

## Output

### Professors Sorted by Last Name
![Output1](https://github.com/sanjeevthapamiu/apsd-univeristy-data-jpa/blob/main/screenshots/Output1.png)

### Courses in the Computer Science Department (Sorted by Course Name)
![Output1](https://github.com/sanjeevthapamiu/apsd-univeristy-data-jpa/blob/main/screenshots/Output2.png)

### Departments with their Courses (Sorted By Department Name)
![Output1](https://github.com/sanjeevthapamiu/apsd-univeristy-data-jpa/blob/main/screenshots/Output3.png)

## Notes
### ERD Guide
Read the statement first, then add relationship only to the other end. Look at sample data and with reasoning start adding the remaining relationships

### docker command
`docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=sanjeev   -e MYSQL_PASSWORD=password -e MYSQL_DATABASE=... -p 3306:3306 mysql`

### application.properties
`spring.datasource.url=jdbc:mysql://localhost:3306/universitydatajpa`

`spring.datasource.username=sanjeev`

`spring.datasource.password=password`

`spring.jpa.hibernate.ddl-auto=update`

`spring.jpa.show-sql=true`

`spring.jpa.properties.hibernate.format_sql=true`

`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect`

### JoinColumn Placing
`@JoinColum(name="fk_id)` should be on `@ManytoOne` side

### Add Helper placing
```java 
private final List<Entity> entityList = new ArrayList<>();

addEntity(Entity entity) {
    entity.setCurrentEntity(this);
    entityList.add(entity);
}
```
This logic: `entity.setCurrentEntity(this);` is required on `@OneToMany` side, if it is bidirectional. This logic: `entity.setCurrentEntity(this);` does not matter on bidirectional `@ManyToMany`
