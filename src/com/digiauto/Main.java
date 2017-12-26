package com.digiauto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.digiauto.beans.User;
import com.digiauto.utils.HibernetUtils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridPane = prepareLoginScreen();

			primaryStage.setTitle("MS AUTO");
			Scene scene = new Scene(gridPane, 800, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GridPane prepareLoginScreen() {
		// TODO Auto-generated method stub
		Text welcomeNote = new Text();
		Text errorNote = new Text("Enter valid username and password!");

		welcomeNote.setX(550);
		welcomeNote.setY(50);
		welcomeNote.setText("MS AUTO Digital Portal");
		// welcomeNote.setUnderline(true);

		Text username = new Text("Username:");
		Text password = new Text("Password:");

		TextField usernamaeField = new TextField();
		PasswordField passwordField = new PasswordField();

		Button login = new Button("Login");

		login.setId("login");
		errorNote.setId("labels");
		welcomeNote.setId("welcome-note");
		username.setId("labels");
		password.setId("labels");
		usernamaeField.setId("fields");
		passwordField.setId("fields");

		GridPane gridPane = new GridPane();

		// Setting size for the pane
		gridPane.setMinSize(400, 200);

		// Setting the padding
		gridPane.setPadding(new Insets(50, 50, 50, 50));

		// Setting the vertical and horizontal gaps between the columns
		gridPane.setVgap(25);
		gridPane.setHgap(10);

		// Setting the Grid alignment
		gridPane.setAlignment(Pos.CENTER);

		// Arranging all the nodes in the grid
		gridPane.add(welcomeNote, 0, 0);
		gridPane.add(username, 0, 1);
		gridPane.add(usernamaeField, 1, 1);
		gridPane.add(password, 0, 2);
		gridPane.add(passwordField, 1, 2);
		gridPane.add(login, 1, 3);
		gridPane.add(errorNote, 0, 4);

		errorNote.setVisible(false);

		GridPane.setColumnSpan(welcomeNote, 2);
		GridPane.setColumnSpan(errorNote, 2);

		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (usernamaeField.getText() != null && !usernamaeField.getText().isEmpty()
						&& passwordField.getText() != null && !passwordField.getText().isEmpty()) {
					
					read(usernamaeField.getText(),passwordField.getText());
				} else {
					errorNote.setVisible(true);
				}
			}
		});

		return gridPane;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
    public List<User> read(String username,String password){
        Session session = HibernetUtils.getHibernateSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot=criteria.from(User.class);
        criteria.select(userRoot);

        criteria.where(builder.equal(userRoot.get("name"),username));
        criteria.where(builder.equal(userRoot.get("password"), password));
        List<User> userList=session.createQuery(criteria).getResultList();
        return userList;
   }  
}
