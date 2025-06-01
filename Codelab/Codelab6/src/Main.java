import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private int angkaRandom;
    private int jumlahTebakan = 0;
    private boolean gameSelesai = false;

    private Label titleLabel, feedbackLabel, percobaanLabel;
    private TextField inputField;
    private Button tombol, darkModeToggle;
    private VBox layout;
    private boolean isDarkMode = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        angkaRandom = generateAngka();

        titleLabel = new Label("🔢 Tebak Angka 1–100");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        titleLabel.setTextFill(Color.DARKBLUE);

        feedbackLabel = new Label("Masukkan tebakkanmu!");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        feedbackLabel.setTextFill(Color.DARKGRAY);

        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(180);

        tombol = new Button("✅ Coba Tebak!");
        tombol.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        tombol.setPrefWidth(120);

        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        HBox inputBox = new HBox(10, inputField, tombol);
        inputBox.setAlignment(Pos.CENTER);

        darkModeToggle = new Button("🌙 Dark Mode");
        darkModeToggle.setOnAction(e -> toggleTheme());

        layout = new VBox(15, titleLabel, feedbackLabel, inputBox, percobaanLabel, darkModeToggle);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        setLightMode();

        tombol.setOnAction(e -> prosesTebakan());

        Scene scene = new Scene(layout, 420, 280);
        stage.setTitle("Tebak Angka Advance");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void prosesTebakan() {
        if (gameSelesai) {
            angkaRandom = generateAngka();
            gameSelesai = false;
            tombol.setText("✅ Coba Tebak!");
            tombol.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
            feedbackLabel.setText("Masukkan tebakkanmu!");
            feedbackLabel.setTextFill(isDarkMode ? Color.LIGHTGRAY : Color.DARKGRAY);
            inputField.setDisable(false);
            inputField.clear();
            jumlahTebakan = 0;
            percobaanLabel.setText("Jumlah percobaan: 0");
            return;
        }

        String input = inputField.getText();
        try {
            int tebakan = Integer.parseInt(input);
            jumlahTebakan++;

            if (tebakan > angkaRandom) {
                feedbackLabel.setText("⚠️ Terlalu besar!");
                feedbackLabel.setTextFill(Color.RED);
                shake(inputField);
            } else if (tebakan < angkaRandom) {
                feedbackLabel.setText("🔽 Terlalu kecil!");
                feedbackLabel.setTextFill(Color.ORANGE);
                shake(inputField);
            } else {
                feedbackLabel.setText("✅ Tebakan benar!");
                feedbackLabel.setTextFill(Color.LIMEGREEN);
                tombol.setText("🔄 Main Lagi");
                tombol.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                inputField.setDisable(true);
                gameSelesai = true;
            }
            percobaanLabel.setText("Jumlah percobaan: " + jumlahTebakan);
        } catch (NumberFormatException e) {
            feedbackLabel.setText("⚠️ Masukkan angka yang valid!");
            feedbackLabel.setTextFill(Color.RED);
            shake(inputField);
        }
    }

    private void shake(TextField field) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(70), field);
        tt.setFromX(-10);
        tt.setToX(10);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
        tt.play();
    }

    private void toggleTheme() {
        if (isDarkMode) {
            setLightMode();
        } else {
            setDarkMode();
        }
        isDarkMode = !isDarkMode;
    }

    private void setLightMode() {
        layout.setStyle("-fx-background-color: #EAF6FF;");
        titleLabel.setTextFill(Color.DARKBLUE);
        feedbackLabel.setTextFill(Color.DARKGRAY);
        darkModeToggle.setText("🌙 Dark Mode");
    }

    private void setDarkMode() {
        layout.setStyle("-fx-background-color: #2E2E2E;");
        titleLabel.setTextFill(Color.CYAN);
        feedbackLabel.setTextFill(Color.LIGHTGRAY);
        darkModeToggle.setText("☀️ Light Mode");
    }

    private int generateAngka() {
        return (int) (Math.random() * 100) + 1;
    }
}
