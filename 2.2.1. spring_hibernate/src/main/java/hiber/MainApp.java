package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      //
      Car car;
      User user;
      for (int i=0; i < 2; i++) {
         System.out.println("new Car(" + "mers"+ i + "...)");
         car = new Car("mers"+i, 10+i);
         System.out.println("new User(" + "User5"+ i +"...)");
         user = new User("User5"+i, "Lastname5"+i, "user5@mail.ru"+i);
         System.out.println("user.setCar(car):");
         user.setCar(car);
         System.out.println("carService.add(car):");
         carService.add(car);
         System.out.println("userService.add(user):");
         userService.add(user);
         User usr = userService.findUserByCar("mers"+i, 10+i );
         System.out.println("user by car = " + usr);
      }
      user = userService.findUserByCar("123", 0 );
      System.out.println("user by car (123, 0) = " + user);

      List<User> users = userService.listUsers();
      for (User usr : users) {
         System.out.println(usr);
      }

      context.close();
   }
}
