import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Sayasat_Sabit_230103164 extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        home(primaryStage);
    }
    private static void home(Stage primaryStage) throws FileNotFoundException {
        BorderPane root = new BorderPane();

        ImageView homeLabel = new ImageView(new Image(new FileInputStream("india2.png")));

        HBox topButtons = new HBox(10, homeLabel);
        topButtons.setPadding(new Insets(10, 10, 10, 10));
        topButtons.setStyle("-fx-background-color: #154360 ;");

        Label home = new Label("Home");
        Label bookingLabel = new Label("Booking");
        Label galleryLabel = new Label("Gallery");
        Label menuLabel = new Label("Menu");
        Label contactLabel = new Label("Contact");
        Label exitLabel = new Label("Exit");

        home.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        bookingLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        galleryLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        menuLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        contactLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        exitLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");

        home.setPrefWidth(90);
        bookingLabel.setPrefWidth(90);
        galleryLabel.setPrefWidth(90);
        menuLabel.setPrefWidth(90);
        contactLabel.setPrefWidth(90);
        exitLabel.setPrefWidth(90);

        HBox rightButtons = new HBox(20,home, bookingLabel, galleryLabel, menuLabel, contactLabel, exitLabel);
        rightButtons.setPadding(new Insets(0, 10, 0, 0));
        rightButtons.setAlignment(Pos.CENTER);

        HBox.setMargin(homeLabel, new Insets(0, 850, 0, 10));
        topButtons.getChildren().addAll(rightButtons);

        VBox content = new VBox();
        content.setSpacing(10);
        content.getChildren().add(topButtons);
        content.setStyle("-fx-background-color: white;");

        bookingLabel.setOnMouseEntered(event -> bookingLabel.setTextFill(Color.GRAY));
        bookingLabel.setOnMouseExited(event -> bookingLabel.setTextFill(Color.WHITE));
        bookingLabel.setOnMouseClicked(e -> {
            try {
                openBookingScene(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        galleryLabel.setOnMouseEntered(event -> galleryLabel.setTextFill(Color.GRAY));
        galleryLabel.setOnMouseExited(event -> galleryLabel.setTextFill(Color.WHITE));
        galleryLabel.setOnMouseClicked(event -> {
            try {
                openGalleryScene(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
//
        menuLabel.setOnMouseEntered(event -> menuLabel.setTextFill(Color.GRAY));
        menuLabel.setOnMouseExited(event -> menuLabel.setTextFill(Color.WHITE));

        contactLabel.setOnMouseEntered(event -> contactLabel.setTextFill(Color.GRAY));
        contactLabel.setOnMouseExited(event -> contactLabel.setTextFill(Color.WHITE));
        contactLabel.setOnMouseClicked(event -> {
            try {
                openContactScene(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        home.setOnMouseEntered(event -> home.setTextFill(Color.GRAY));
        home.setOnMouseExited(event -> home.setTextFill(Color.WHITE));
        home.setOnMouseClicked(event -> {
            try {
                home(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        exitLabel.setOnMouseEntered(event -> exitLabel.setTextFill(Color.GRAY));
        exitLabel.setOnMouseExited(event -> exitLabel.setTextFill(Color.WHITE));
        exitLabel.setOnMouseClicked(event -> { Platform.exit(); });

        ImageView imageView = new ImageView(new Image(new FileInputStream("tasteOfIndia.png")));
        imageView.setFitWidth(1529);
        imageView.setFitHeight(470);

        Label welcome = new Label("INDIRA");
        welcome.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 100px; -fx-text-fill: black;");
        Label miniInfo = new Label("a restaurant of upscale Indian cuisine where you will find everything you were looking for");
        miniInfo.setStyle("-fx-font-family: 'Ariel'; -fx-font-size: 20px; -fx-text-fill: black;");
        VBox well = new VBox();
        well.getChildren().addAll(welcome, miniInfo);
        well.setAlignment(Pos.CENTER);
        well.setPadding(new Insets(90, 0, 140, 0));

        ImageView menuTable = new ImageView(new Image(new FileInputStream("menuTable.png")));
        menuTable.setFitHeight(250);
        menuTable.setFitWidth(1530);

        GridPane homeFoods = new GridPane();
        homeFoods.setPadding(new Insets(50, 100, 0, 175));
        homeFoods.setHgap(20);
        homeFoods.setVgap(20);

        String[] imagePaths = {
                "food1.png", "food2.png", "food3.png", "food4.png", "food5.png", "food6.png",
                "food7.png", "food8.png", "food9.png", "food10.png", "food11.png", "food12.png"

        };

        String[] foodNames = {
                "BEEF CHILLI\n\n   3,600 ₸", "CHICKEN CURRY\n\n       3,000 ₸", "CHICKEN KADAI\n\n        3,000 ₸",
                "FISH CURRY\n\n     3,000 ₸", "MIXED VEGETABLES\n\n          2,600 ₸", "PRAWNS IN COCONUT MILK\n\n                   4,000 ₸",
                "SCHEZWAN NOODLES\n\n             2,500 ₸", "CHICKEN KORMA\n\n          3,000 ₸", "ALOO RAITA\n\n    1,000 ₸",
                "APPLE RINGS\n\n      2,000 ₸", "CHICKEN THALI\n\n        4,000 ₸", "CRISPY LAMB CHILLI\n\n            3,500 ₸",

        };

        for (int i = 0; i < imagePaths.length; i++) {
            Label foodLabel = createFoodLabel(imagePaths[i], foodNames[i]);
            homeFoods.add(foodLabel, i % 4, i / 4);
        }

        ImageView seeAllButton1 = new ImageView(new Image(new FileInputStream("seeAll.png")));
        content.setAlignment(Pos.CENTER);
        VBox.setMargin(seeAllButton1, new Insets(70, 0, 0, 0));
        seeAllButton1.setOnMouseEntered(e -> { seeAllButton1.setEffect(new DropShadow()); });
        seeAllButton1.setOnMouseExited(e -> { seeAllButton1.setEffect(null); });
        seeAllButton1.setOnMouseClicked(e -> {
            try {
                openMenuScene(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        ImageView traditions = new ImageView(new Image(new FileInputStream("traditions2.jpg")));
        traditions.setFitHeight(700);
        traditions.setFitWidth(700);

        ImageView tradIn = new ImageView(new Image(new FileInputStream("trad4.png")));
        tradIn.setTranslateX(500);
        tradIn.setTranslateY(-30);
        tradIn.setFitWidth(575);
        tradIn.setFitHeight(375);

        StackPane tradReg = new StackPane();
        tradReg.getChildren().addAll(traditions, tradIn);
        tradReg.setPadding(new Insets(100, 450, 100, 0));// верхний, правый, нижний, левый
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), tradIn);
        transition.setFromY(100); // Начальное положение вне видимой области
        transition.setToY(0); // Конечное положение на экране
        transition.setCycleCount(1); // Однократное выполнение анимации

        // Добавляем анимацию к tradIn
        tradReg.setOnMouseEntered(event -> transition.play());

        ImageView gal1 = new ImageView(new Image(new FileInputStream("gal4.png")));
        gal1.setFitWidth(1530);
        gal1.setFitHeight(215);

        ImageView galer1 = new ImageView(new Image(new FileInputStream("galer1.jpg")));
        galer1.setFitHeight(1450);
        galer1.setFitWidth(1450);

        ImageView seeAllButton2 = new ImageView(new Image(new FileInputStream("seeAll.png")));
        content.setAlignment(Pos.CENTER);
        VBox.setMargin(seeAllButton2, new Insets(70, 0, 0, 0));
        seeAllButton2.setOnMouseEntered(e -> { seeAllButton2.setEffect(new DropShadow()); });
        seeAllButton2.setOnMouseExited(e -> { seeAllButton2.setEffect(null); });
        seeAllButton2.setOnMouseClicked(e -> {
            try {
                openGalleryScene(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");
        end.setPadding(new Insets(70,0,0,0));

        content.getChildren().addAll(imageView, well, menuTable, homeFoods, seeAllButton1,tradReg,gal1,galer1,seeAllButton2,end);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(content);
        scrollPane.setFitToWidth(false);

        menuLabel.setOnMouseClicked(event -> {
            // Получаем вертикальное смещение до меню
            double targetOffsetY = menuTable.getBoundsInParent().getMinY();
            double currentOffsetY = scrollPane.getVvalue() * (content.getHeight() - scrollPane.getHeight());
            double deltaY = targetOffsetY - currentOffsetY;

            // Вычисляем новое вертикальное значение прокрутки
            double newVvalue = (currentOffsetY + deltaY) / (content.getHeight() - scrollPane.getHeight());

            // Создаем анимацию прокрутки
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.4), new KeyValue(scrollPane.vvalueProperty(), newVvalue))
            );
            timeline.play(); // Запускаем анимацию
        });

        galleryLabel.setOnMouseClicked(event -> {
            // Получаем вертикальное смещение до меню
            double targetOffsetY = gal1.getBoundsInParent().getMinY();
            double currentOffsetY = scrollPane.getVvalue() * (content.getHeight() - scrollPane.getHeight());
            double deltaY = targetOffsetY - currentOffsetY;

            // Вычисляем новое вертикальное значение прокрутки
            double newVvalue = (currentOffsetY + deltaY) / (content.getHeight() - scrollPane.getHeight());

            // Создаем анимацию прокрутки
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.4), new KeyValue(scrollPane.vvalueProperty(), newVvalue))
            );
            timeline.play(); // Запускаем анимацию
        });

        root.setTop(topButtons);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("INDIRA Restaurant");
        primaryStage.show();
    }

    private static void openGalleryScene(Stage galleryStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        HBox topButtons = createTopButtons(galleryStage);
        VBox content = new VBox();
        content.setStyle("-fx-background-color: white;");

        Label galleryWord = new Label("Gallery");
        galleryWord.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 100px;");
        galleryWord.setPadding(new Insets(30,0,50,580));

        ImageView line = new ImageView(new Image(new FileInputStream("line.png")));
        line.setFitWidth(1530);

        ImageView gallery1 = new ImageView(new Image(new FileInputStream("gallery2.jpg")));
        gallery1.setFitWidth(1300);
        gallery1.setFitHeight(1300);
        VBox.setMargin(gallery1, new Insets(50,0,0,120));
        ImageView gallery2 = new ImageView(new Image(new FileInputStream("gallery1.jpg")));
        gallery2.setFitWidth(1300);
        gallery2.setFitHeight(1300);
        VBox.setMargin(gallery2, new Insets(0,0,0,120));
        ImageView gallery3 = new ImageView(new Image(new FileInputStream("gallery3.jpg")));
        gallery3.setFitWidth(1300);
        gallery3.setFitHeight(1300);
        VBox.setMargin(gallery3, new Insets(0,0,0,120));
        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");
        end.setPadding(new Insets(70,0,0,0));

        content.getChildren().addAll(galleryWord,line,gallery1,gallery2,gallery3,end);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color: white;");
        scrollPane.setContent(content);
        scrollPane.setFitToWidth(false);

        root.setTop(topButtons);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root);

        galleryStage.setScene(scene);
        galleryStage.setFullScreen(true);
        galleryStage.setTitle("Gallery");
        galleryStage.show();
    }

    private static void openBookingScene(Stage bookingStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        HBox buttons = createTopButtons(bookingStage);
        VBox content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-background-color: white;");

        Label bookingWord = new Label("Booking");
        bookingWord.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 100px;");
        bookingWord.setPadding(new Insets(30,0,20,580));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField nameTextField = createTextField("Name");
        TextField emailTextField = createTextField("Email");
        setupEmailFieldValidation(emailTextField);
        DatePicker dateDatePicker = new DatePicker();
        dateDatePicker.setPromptText("Date");
        dateDatePicker.setStyle("-fx-font-size: 14px; -fx-border-color: black; -fx-border-width: 1px;");

        ComboBox<String> timeComboBox = new ComboBox<>();
        timeComboBox.setPromptText("Choose time");
        timeComboBox.setStyle("-fx-font-size: 14px; -fx-border-color: black; -fx-border-width: 1px;");
        timeComboBox.getItems().addAll(
                "10:00 ", "11:00 ", "12:00 ",
                "13:00 ", "14:00 ", "15:00 ",
                "16:00 ", "17:00 ", "18:00 ", "19:00 ", "20:00 ",
                "21:00 ", "22:00 "
        );
        timeComboBox.setEditable(true);

        TextField phoneTextField = createTextField("Phone");
        String phonePattern = "^\\+7\\d{10}$";
        phoneTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(phonePattern)) {
                phoneTextField.setStyle("-fx-border-color: red;");
            } else {
                phoneTextField.setStyle("-fx-border-color: inherit;");
            }
        });
        ComboBox<String> numberOfPeopleComboBox = new ComboBox<>();
        numberOfPeopleComboBox.setPromptText("Size");
        numberOfPeopleComboBox.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-border-color: black; -fx-border-width: 1px;");
        numberOfPeopleComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Label specialRequest = new Label("Special Requests : ");
        specialRequest.setStyle("-fx-font-family: 'Ariel'; -fx-font-size: 20px;");

        TextArea specialTextField = createTextArea("");
        specialTextField.setPrefHeight(100);

        Button bookButton = new Button("Book");
        bookButton.setStyle("-fx-background-radius: 50; -fx-background-color: white; -fx-text-fill: black; -fx-font-family: 'Times New Roman'; -fx-font-size: 20px; -fx-border-color: black; -fx-border-radius: 50; -fx-border-width: 1px;");
        bookButton.setPrefSize(100, 50);
        GridPane.setMargin(bookButton, new Insets(30, 0, 0, 100));
        bookButton.setOnAction(event -> {
            if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                    dateDatePicker.getValue() == null || timeComboBox.getValue() == null ||
                    phoneTextField.getText().isEmpty() || numberOfPeopleComboBox.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required!", ButtonType.OK);
                alert.showAndWait();
            } else {
                String bookingDetails = "Name: " + nameTextField.getText() + "\n" +
                        "Email: " + emailTextField.getText() + "\n" +
                        "Date: " + dateDatePicker.getValue() + "\n" +
                        "Time: " + timeComboBox.getValue() + "\n" +
                        "Phone: " + phoneTextField.getText() + "\n" +
                        "Size: " + numberOfPeopleComboBox.getValue() + "\n" +
                        "Special Requests: " + specialTextField.getText() + "\n\n";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Bookings.txt", true))) {
                    if (Files.exists(Paths.get("Bookings.txt")) && Files.size(Paths.get("Bookings.txt")) > 0) {
                        writer.write("--------------------\n");
                    }
                    writer.write(bookingDetails);
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION, "Booking successful!", ButtonType.OK);
                confirmation.showAndWait();
            }
        });
        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");

        gridPane.add(nameTextField, 0, 0);
        gridPane.add(emailTextField, 0, 1);
        gridPane.add(dateDatePicker, 0, 2);
        gridPane.add(timeComboBox, 0, 3);
        gridPane.add(phoneTextField, 0, 4);
        gridPane.add(numberOfPeopleComboBox,0,5);
        gridPane.add(specialRequest,0,6);
        gridPane.add(specialTextField, 0, 7);
        gridPane.add(bookButton, 0, 8);
        gridPane.add(end,0,16);

        gridPane.setPadding(new Insets(50,0,0,600));

        content.getChildren().addAll(bookingWord, gridPane);

        root.setTop(buttons);
        root.setCenter(content);

        Scene bookingScene = new Scene(root);

        bookingStage.setScene(bookingScene);
        bookingStage.setFullScreen(true);
        bookingStage.setTitle("Booking");
        bookingStage.show();
    }

    private static void setupEmailFieldValidation(TextField emailTextField) {
        String emailPattern = "^\\w+@(gmail\\.com|mail\\.ru|sdu\\.edu\\.kz)$";
        emailTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(emailPattern)) {
                emailTextField.setStyle("-fx-border-color: red;");
            } else {
                emailTextField.setStyle("-fx-border-color: inherit;");
            }
        });
    }

    private static TextField createTextField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setPrefWidth(300);
        textField.setStyle("-fx-font-size: 14px; -fx-border-width: 1px; -fx-border-color: black; -fx-padding: 5px; -fx-background-color: white;");
        textField.setAlignment(Pos.TOP_LEFT);
        return textField;
    }

    private static TextArea createTextArea(String promptText) {
        TextArea textArea = new TextArea();
        textArea.setPromptText(promptText);
        textArea.setPrefWidth(300);
        textArea.setPrefRowCount(5); // Set the preferred number of visible rows
        textArea.setStyle("-fx-font-size: 14px; -fx-border-width: 1px; -fx-border-color: black; -fx-padding: 5px; -fx-background-color: white;");
        textArea.setWrapText(true); // Enable text wrapping
        textArea.setPrefHeight(100); // Set max height to avoid excessive vertical space
        textArea.setOnKeyTyped(event -> {
            String text = textArea.getText();
            if (text.length() > 1000) {
                textArea.setText(text.substring(0, 1000)); // Limit text to 1000 characters
            }
        });
        return textArea;
    }

    private static void openContactScene(Stage contactStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        createTopButtons(contactStage);

        ImageView contactUsImage = new ImageView(new Image(new FileInputStream("contactUs.png")));
        contactUsImage.setFitWidth(960);
        contactUsImage.setFitHeight(540);

        Label name = new Label("Name : ");
        name.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");
        TextField nameSpace = createTextField("Example: John");
        Label email = new Label("Email : ");
        email.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");
        TextField emailSpace = createTextField("Example: hello123@gamil.com");
        setupEmailFieldValidation(emailSpace);
        Label leaveAReply = new Label("Leave A Reply");
        leaveAReply.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 20px;");
        TextArea comment = createTextArea("");
        comment.setPrefHeight(265);
        ImageView send = new ImageView(new Image(new FileInputStream("send1.png")));
        send.setFitHeight(60);
        send.setFitWidth(100);
        VBox.setMargin(send, new Insets(10, 0, 0, 100));
        send.setOnMouseClicked(e -> {
            if (nameSpace.getText().isEmpty() || emailSpace.getText().isEmpty() || comment.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required!", ButtonType.OK);
                alert.showAndWait();
            } else {
                String commentDetails = "Name: " + nameSpace.getText() + "\n" +
                        "Email: " + emailSpace.getText() + "\n" +
                        "Comment: " + comment.getText() + "\n";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Comments.txt", true))) {
                    if (Files.exists(Paths.get("Comments.txt")) && Files.size(Paths.get("Comments.txt")) > 0) {
                        writer.write("--------------------\n");
                    }
                    writer.write(commentDetails);
                    writer.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // Показ подтверждения отправки
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION, "Message sent successfully!", ButtonType.OK);
                confirmation.showAndWait();
            }
        });

        VBox contactText = new VBox(10);
        contactText.getChildren().addAll(name, nameSpace, email, emailSpace, leaveAReply, comment, send);

        HBox contactUs = new HBox();
        contactUs.getChildren().addAll(contactUsImage, contactText);
        contactUs.setSpacing(30);
        contactUs.setStyle("-fx-background-color: white;");

        contactUs.setPadding(new Insets(100, 0, 0,100));

        root.setTop(createTopButtons(contactStage));
        root.setCenter(contactUs);

        Scene menuScene = new Scene(root);

        contactStage.setScene(menuScene);
        contactStage.setFullScreen(true);
        contactStage.setTitle("Contact Us");
        contactStage.show();
    }

    private static void openMenuScene(Stage MenuStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        createTopButtons(MenuStage);
        VBox content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-background-color: white;");

        Label menuImage = new Label("MENU");
        menuImage.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 100px;");
        menuImage.setPadding(new Insets(30,0,20,615));

        ImageView mainDish = new ImageView(new Image(new FileInputStream("mainDish.png")));
        mainDish.setFitWidth(360);
        mainDish.setFitHeight(500);
        Label l1 = new Label("Main Dishes", mainDish);
        l1.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 14px;");
        l1.setContentDisplay(ContentDisplay.TOP);
        ImageView soup = new ImageView(new Image(new FileInputStream("soup.png")));
        soup.setFitWidth(360);
        soup.setFitHeight(500);
        Label l2 = new Label("Soups", soup);
        l2.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 14px;");
        l2.setContentDisplay(ContentDisplay.TOP);
        ImageView dessert = new ImageView(new Image(new FileInputStream("desert.png")));
        dessert.setFitWidth(360);
        dessert.setFitHeight(500);
        Label l3 = new Label("Desserts", dessert);
        l3.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 14px;");
        l3.setContentDisplay(ContentDisplay.TOP);

        l1.setOnMouseClicked(event -> {
            try {
                openMainDishes(MenuStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        l2.setOnMouseClicked(event -> {
            try {
                openSoup(MenuStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        l3.setOnMouseClicked(event -> {
            try {
                openDessert(MenuStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        HBox types = new HBox(70);
        types.getChildren().addAll(l1,l2,l3);
        types.setAlignment(Pos.CENTER);

        content.getChildren().addAll(menuImage,types);

        root.setTop(createTopButtons(MenuStage));
        root.setCenter(content);

        Scene menuScene = new Scene(root);

        MenuStage.setScene(menuScene);
        MenuStage.setFullScreen(true);
        MenuStage.setTitle("Menu");
        MenuStage.show();
    }
    private static void openMainDishes(Stage mainDishesStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        createTopButtons(mainDishesStage);
        createBackButton(mainDishesStage, "Main Dishes");
        ImageView line = new ImageView(new Image(new FileInputStream("line.png")));

        GridPane homeFoods = new GridPane();
        homeFoods.setPadding(new Insets(50, 100, 100, 175));
        homeFoods.setHgap(20);
        homeFoods.setVgap(20);

        String[] imagePaths = {
                "food8.png", "food12.png", "food6.png", "food4.png", "food2.png", "food11.png",
                "food7.png", "food1.png", "food5.png", "food3.png", "food13.png", "food14.png"
        };

        String[] foodNames = {
                "CHICKEN KORMA\n\n          3,000 ₸", "CRISPY LAMB CHILLI\n\n            3,500 ₸", "PRAWNS IN COCONUT MILK\n\n                   4,000 ₸",
                "FISH CURRY\n\n     3,000 ₸", "CHICKEN CURRY\n\n       3,000 ₸", "CHICKEN THALI\n\n        4,000 ₸",
                "SCHEZWAN NOODLES\n\n             2,500 ₸", "BEEF CHILLI\n\n   3,600 ₸",  "MIXED VEGETABLES\n\n          2,600 ₸",
                "CHICKEN KADAI\n\n        3,000 ₸", "BEEF IN OYSTER SAUCE\n\n               3,600 ₸", "GREEN CURRY LAMB\n\n            3,600 ₸"
        };

        for (int i = 0; i < imagePaths.length; i++) {
            Label foodLabel = createFoodLabel(imagePaths[i], foodNames[i]);
            homeFoods.add(foodLabel, i % 4, i / 4);
        }
        VBox content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-background-color: white;");
        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");

        content.getChildren().addAll(createBackButton(mainDishesStage, "Main Dishes"),line, homeFoods, end);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(content);
        scrollPane.setFitToWidth(false);

        root.setTop(createTopButtons(mainDishesStage));
        root.setCenter(scrollPane);

        Scene mainDishesScene = new Scene(root,1530,790);

        mainDishesStage.setScene(mainDishesScene);
        mainDishesStage.setFullScreen(true);
        mainDishesStage.setTitle("Main Dishes");
        mainDishesStage.show();
    }

    private static void openSoup(Stage soupStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        createTopButtons(soupStage);
        createBackButton(soupStage, "Soups");

        GridPane homeFoods = new GridPane();
        homeFoods.setPadding(new Insets(50, 100, 250, 175));
        homeFoods.setHgap(20);
        homeFoods.setVgap(20);

        String[] imagePaths = {
                "food9.png", "food15.png", "food16.png", "food17.png"
        };

        String[] foodNames = {
                "ALOO RAITA\n    1,000 ₸", "CHICKEN SHORBA\n           1,200 ₸",
                "HOT & SOUR CHICKEN SOUP\n                    1,800 ₸", "TOM YAM KOONG\n           2,800 ₸",
        };

        for (int i = 0; i < imagePaths.length; i++) {
            Label foodLabel = createFoodLabel(imagePaths[i], foodNames[i]);
            homeFoods.add(foodLabel, i % 4, i / 4);
        }
        VBox content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-background-color: white;");
        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");

        content.getChildren().addAll(createBackButton(soupStage, "Soups"), homeFoods, end);

        root.setTop(createTopButtons(soupStage));
        root.setCenter(content);
        Scene soupScene = new Scene(root,1530,790);

        soupStage.setScene(soupScene);
        soupStage.setFullScreen(true);
        soupStage.setTitle("Soups");
        soupStage.show();
    }

    private static void openDessert(Stage dessertStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        createTopButtons(dessertStage);
        createBackButton(dessertStage, "Desserts");

        GridPane homeFoods = new GridPane();
        homeFoods.setPadding(new Insets(50, 100, 250, 175));
        homeFoods.setHgap(20);
        homeFoods.setVgap(20);

        String[] imagePaths = {
                "food10.png", "food18.png", "food19.png", "food20.png"
        };

        String[] foodNames = {
                "APPLE RINGS\n     2,000 ₸", "GAJAR HALWA\n       1,100 ₸",
                "GULAB JAMIN\n      1,100 ₸", "MALAI KULFI\n      1,500 ₸",
        };

        for (int i = 0; i < imagePaths.length; i++) {
            Label foodLabel = createFoodLabel(imagePaths[i], foodNames[i]);
            homeFoods.add(foodLabel, i % 4, i / 4);
        }
        VBox content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-background-color: white;");
        Label end = new Label("All rights reserved by INDIRA RESTAURANT, TOO");

        content.getChildren().addAll(createBackButton(dessertStage, "Desserts"), homeFoods, end);

        root.setTop(createTopButtons(dessertStage));
        root.setCenter(content);
        Scene soupScene = new Scene(root,1530,790);

        dessertStage.setScene(soupScene);
        dessertStage.setFullScreen(true);
        dessertStage.setTitle("Desserts");
        dessertStage.show();
    }

    public static HBox createTopButtons(Stage primaryStage) throws FileNotFoundException {
        ImageView homeLabel = new ImageView(new Image(new FileInputStream("india2.png")));

        HBox topButtons = new HBox(10, homeLabel);
        topButtons.setPadding(new Insets(10, 10, 10, 10));
        topButtons.setStyle("-fx-background-color: #154360 ;");

        Label home = new Label("Home");
        Label bookingLabel = new Label("Booking");
        Label galleryLabel = new Label("Gallery");
        Label menuLabel = new Label("Menu");
        Label contactLabel = new Label("Contact");
        Label exitLabel = new Label("Exit");

        home.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        bookingLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        galleryLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        menuLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        contactLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");
        exitLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: 'Georgia';");

        home.setPrefWidth(90);
        bookingLabel.setPrefWidth(90);
        galleryLabel.setPrefWidth(90);
        menuLabel.setPrefWidth(90);
        contactLabel.setPrefWidth(90);
        exitLabel.setPrefWidth(90);

        HBox rightButtons = new HBox(20, home, bookingLabel, galleryLabel, menuLabel, contactLabel, exitLabel);
        rightButtons.setPadding(new Insets(0, 10, 0, 0));
        rightButtons.setAlignment(Pos.CENTER);

        HBox.setMargin(homeLabel, new Insets(0, 850, 0, 10));
        topButtons.getChildren().addAll(rightButtons);

        bookingLabel.setOnMouseEntered(event -> bookingLabel.setTextFill(Color.GRAY));
        bookingLabel.setOnMouseExited(event -> bookingLabel.setTextFill(Color.WHITE));
        bookingLabel.setOnMouseClicked(e -> {
            try {
                openBookingScene(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        galleryLabel.setOnMouseEntered(event -> galleryLabel.setTextFill(Color.GRAY));
        galleryLabel.setOnMouseExited(event -> galleryLabel.setTextFill(Color.WHITE));
        galleryLabel.setOnMouseClicked(event -> {
            try {
                openGalleryScene(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
//
        menuLabel.setOnMouseEntered(event -> menuLabel.setTextFill(Color.GRAY));
        menuLabel.setOnMouseExited(event -> menuLabel.setTextFill(Color.WHITE));
        menuLabel.setOnMouseClicked(e -> {
            try {
                openMenuScene(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        contactLabel.setOnMouseEntered(event -> contactLabel.setTextFill(Color.GRAY));
        contactLabel.setOnMouseExited(event -> contactLabel.setTextFill(Color.WHITE));
        contactLabel.setOnMouseClicked(event -> {
            try {
                openContactScene(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        home.setOnMouseEntered(event -> home.setTextFill(Color.GRAY));
        home.setOnMouseExited(event -> home.setTextFill(Color.WHITE));
        home.setOnMouseClicked(event -> {
            try {
                home(primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        exitLabel.setOnMouseEntered(event -> exitLabel.setTextFill(Color.GRAY));
        exitLabel.setOnMouseExited(event -> exitLabel.setTextFill(Color.WHITE));
        exitLabel.setOnMouseClicked(event -> { Platform.exit(); }); 

        homeLabel.setOnMouseClicked(e -> {
            try {
                home(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        return topButtons;
    }
    private static HBox createBackButton(Stage stage, String word) {
        ImageView backButton = null;
        try {
            backButton = new ImageView(new Image(new FileInputStream("backButton.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Label l1 = new Label(word);
        l1.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 80px;");
        backButton.setFitHeight(50);
        backButton.setFitWidth(50);
        backButton.setOnMouseClicked(event -> {
            try {
                openMenuScene(stage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        HBox back = new HBox(450);
        back.setPadding(new Insets(40, 0, 0, 30));
        back.getChildren().addAll(backButton, l1);
        return back;
    }

    private static Label createFoodLabel(String imagePath, String text) throws FileNotFoundException {
        ImageView imageView = new ImageView(new Image(new FileInputStream(imagePath)));
        imageView.setFitWidth(275);
        imageView.setFitHeight(275);
        Label label = new Label(text, imageView);
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        label.setContentDisplay(ContentDisplay.TOP);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


