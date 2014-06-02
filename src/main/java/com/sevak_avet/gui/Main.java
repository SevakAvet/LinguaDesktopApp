package com.sevak_avet.gui;

import com.sevak_avet.logic.HibernateUtil;
import com.sevak_avet.logic.domain.Topic;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Scene scene = new Scene(root);
        Screen screen = Screen.getPrimary();
        stage.setMinWidth(screen.getBounds().getWidth() / 1.8);
        stage.setMinHeight(screen.getBounds().getHeight() / 1.4);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


        Platform.runLater(() -> {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            ((List<Topic>) session.createQuery("select topic from Topic topic," +
                    "Answer ans where" +
                    "(ans.name = '')" +
                    "and (ans.gender = 'ж')" +
                    "and (ans.occupation = 'Технарь')" +
                    "and (ans.userId = topic.userId)")
                    .list()).stream().forEach(i -> {
                System.out.println(i.getTopic());
                System.out.println("------------------");
            });



            //session.getTransaction().commit();
            session.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
