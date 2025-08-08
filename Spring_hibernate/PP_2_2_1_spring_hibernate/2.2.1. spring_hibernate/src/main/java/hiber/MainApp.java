package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

       User User1 = new User("User1", "Lastname1", "user1@mail.ru");
       User User2 = new User("User2", "Lastname2", "user2@mail.ru");
       User User3 = new User("User3", "Lastname3", "user3@mail.ru");
       User User4 = new User("User4", "Lastname4", "user4@mail.ru");
       User Daniil = new User("Daniil" , "Ribyakov" , "mr.deni_2022@mail.ru");


       Car Dodge = new Car("Doge Challenger" , 1968 , 5);
       Car Ford = new Car("Ford Focus 3" , 2011 , 1.6);
       Car BMW = new Car("BMW M5" , 2020 , 4.5);
       Car Audi = new Car("Audi RS6" , 2025 , 4);

       userService.add(Daniil.setCar(Dodge).setUser(Daniil));
       userService.add(User1.setCar(Ford).setUser(User1));
       userService.add(User2.setCar(BMW).setUser(User2));
       userService.add(User3.setCar(Audi).setUser(User3));
       userService.add(User4.setCar(Ford).setUser(User4));

      // for (User user : userService.listUsers()) {
      //     System.out.println("У пользователя " + user.toString() + " " + "Машина " + user.getCar());
      // }

       userService.getUserCar(Dodge.getModel(), Dodge.getSeries());

       List<User> users = userService.listUsers();
       for (User user : users) {
       System.out.println("Id = "+user.getId());
       System.out.println("First Name = "+user.getFirstName());
       System.out.println("Last Name = "+user.getLastName());
       System.out.println("Email = "+user.getEmail());
       System.out.println("Car = "+user.getCar());
       System.out.println();
      }

      context.close();
   }
}
