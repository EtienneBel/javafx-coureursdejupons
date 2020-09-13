package com.coureurdejupons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CoureurDeJuponsApp extends Application {
	private int totalGirlFriendsCount = 3;
	private Label statusLabel;
	private Button addGirlFriend;
	private Button removeGirlFriend;

	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
		primaryStage.setTitle("Coureur de jupons");

//		Label label = new Label("Hello World");
//		Rectangle rectangle = new Rectangle(400, 200, Color.YELLOW);
//		
//		StackPane root = new StackPane();
//		root.getChildren().addAll(label, rectangle);
//		
//		Scene scene = new Scene(root, 600, 400);
//		primaryStage.setScene(scene);

		statusLabel = new Label();
		updateStatusLabel(totalGirlFriendsCount);

		ImageView likeImageView = new ImageView(getClass().getResource("/ressources/like.png").toString());
		ImageView likeImageViewHover = new ImageView(getClass().getResource("/ressources/like-hover.png").toString());
		addGirlFriend = new Button("J'ai une nouvelle copine");
		addGirlFriend.setGraphic(likeImageView);
		addGirlFriend.setContentDisplay(ContentDisplay.TOP);
		addGirlFriend.setOnMouseEntered(e -> {
			addGirlFriend.setGraphic(likeImageViewHover);
		});
		addGirlFriend.setOnMouseExited(e -> {
			addGirlFriend.setGraphic(likeImageView);
		});

		addGirlFriend.setOnAction(e -> {
			totalGirlFriendsCount++;
			updateStatusLabel(totalGirlFriendsCount);
//				System.out.println(totalGirlFriendsCount);
		});

		ImageView disLikeImageView = new ImageView(getClass().getResource("/ressources/dislike.png").toString());
		ImageView disLikeImageViewHover = new ImageView(
				getClass().getResource("/ressources/dislike-hover.png").toString());
		removeGirlFriend = new Button("J'ai perdu une copine");
		removeGirlFriend.setGraphic(disLikeImageView);
		removeGirlFriend.setContentDisplay(ContentDisplay.TOP);
		removeGirlFriend.setOnMouseEntered(e -> {
			removeGirlFriend.setGraphic(disLikeImageViewHover);
		});
		removeGirlFriend.setOnMouseExited(e -> {
			removeGirlFriend.setGraphic(disLikeImageView);
		});
		removeGirlFriend.setOnAction(e -> {
			if (totalGirlFriendsCount > 0) {
				totalGirlFriendsCount--;
				updateStatusLabel(totalGirlFriendsCount--);
			}
		});

		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25));
		root.getChildren().addAll(statusLabel, addGirlFriend, removeGirlFriend);

		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void updateStatusLabel(int newGirlFriendsTotal) {
		statusLabel.setText("Nombre de copines actuel : " + newGirlFriendsTotal);
	}

}
