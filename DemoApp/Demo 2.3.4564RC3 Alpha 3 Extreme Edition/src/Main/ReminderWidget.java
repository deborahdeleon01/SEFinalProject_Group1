package Main;

import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ReminderWidget extends Application {


    private Text reminderText;
    private ObservableList<ReminderInfo> data;
    HBox reminder;
    private VBox remWidget = new VBox();
    ComboBox comboBox;
    ScrollPane scrollPane;
    private final String pattern = "MM-dd-yyyy";
    private DatePicker datePicker;

    public VBox reminderWidget() {

        data = getInitData();
        // Window label
        Label label = new Label("Set Reminders");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 50));
        HBox labelHb = new HBox();
        labelHb.setAlignment(Pos.CENTER);
        labelHb.getChildren().add(label);

        HBox cal = new HBox();
        cal.setAlignment(Pos.CENTER);
        cal.getChildren().add(displayCalendar());

        ScrollPane sp = scrollPane();

        // Vbox
        remWidget.setAlignment(Pos.CENTER);
        remWidget.setPadding(new Insets(0, 0, 0, 0));
        remWidget.setSpacing(50);
        remWidget.getChildren().addAll(labelHb, cal, sp);

        return remWidget;
    }

    private ScrollPane scrollPane() {
        scrollPane = new ScrollPane();
        HBox reminderArea = reminderText();
        scrollPane.setMinViewportHeight(300);
        scrollPane.setContent(reminderArea);

        return scrollPane;
    }

    private Node displayCalendar() {

        datePicker = new DatePicker();
        DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
        Node popupContent = datePickerSkin.getPopupContent();
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        datePicker.setConverter(converter);
        datePicker.setPromptText(pattern.toLowerCase());
        datePicker.setOnAction(new DialogButtonListener() {
            @Override
            public void handle(ActionEvent event) {

                displayDialog();

            }
        });

        return popupContent;
    }

    private void displayDialog() {

        Dialog<ReminderInfo> dialog = new Dialog<>();
        dialog.setTitle("Reminders");
        dialog.setHeaderText("Set Your Reminder");
        dialog.setResizable(true);

        Label dateText = new Label(datePicker.getValue().format(DateTimeFormatter.ofPattern(pattern)));
        Label descLabel = new Label("Description: ");
        TextField descText = new TextField();
        ComboBox cb = comboBox();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 35, 20, 35));

        grid.add(dateText, 1, 1); // col=1, row=1
        grid.add(cb, 2, 1);
        grid.add(descLabel, 1, 2); // col=1, row=2
        grid.add(descText, 2, 2);

        dialog.getDialogPane().setContent(grid);

        // Add button to dialog
        ButtonType buttonTypeOk = new ButtonType("Set Reminder", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        // Result converter for dialog
        dialog.setResultConverter(new Callback<ButtonType, ReminderInfo>() {
            @Override
            public ReminderInfo call(ButtonType b) {

                if (!comboBox.getSelectionModel().isEmpty()) {
                    if (b == buttonTypeOk) {

                        String x = datePicker.getValue().format(DateTimeFormatter.ofPattern(pattern));
                        String y = comboBox.getSelectionModel().getSelectedItem().toString();
                        String z = descText.getText();

                        return new ReminderInfo(x, y, z);
                    }
                }

                return null;
            }
        });

        // Show dialog
        Optional<ReminderInfo> result = dialog.showAndWait();

        if (result.isPresent()) {

            data.add(0, result.get());
            reminderText.setText(data.toString().replaceAll("[\\[\\]]", "").replaceAll(",", " "));
        }
    }

    private ObservableList<ReminderInfo> getInitData() {

        List<ReminderInfo> list = new ArrayList<>();
        ObservableList<ReminderInfo> data1 = FXCollections.observableList(list);
        list.add(new ReminderInfo(" ", " ", " "));
        return data1;
    }

    private HBox reminderText() {
        reminder = new HBox();
        // Status message text
        reminderText = new Text();
        reminderText.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        reminderText.setFill(Color.BLUE);
        reminder.getChildren().addAll(reminderText);

        return reminder;
    }

    private ComboBox comboBox() {
        comboBox = new ComboBox();
        comboBox.setPromptText("Select Time");
        List<String> timeList = new ArrayList<>();

        timeList.add("12:00AM");
        timeList.add("1:00AM");
        timeList.add("2:00AM");
        timeList.add("3:00AM");
        timeList.add("4:00AM");
        timeList.add("5:00AM");
        timeList.add("6:00AM");
        timeList.add("7:00AM");
        timeList.add("8:00AM");
        timeList.add("9:00AM");
        timeList.add("10:00AM");
        timeList.add("11:00AM");
        timeList.add("12:00PM");
        timeList.add("1:00PM");
        timeList.add("2:00PM");
        timeList.add("3:00PM");
        timeList.add("4:00PM");
        timeList.add("5:00PM");
        timeList.add("6:00PM");
        timeList.add("7:00PM");
        timeList.add("8:00PM");
        timeList.add("9:00PM");
        timeList.add("10:00PM");
        timeList.add("11:00PM");

        comboBox.getItems().addAll(timeList);

        return comboBox;
    }

    /**
     * @return the remWidget
     */
    public VBox getRemWidget() {
        return remWidget;
    }

    /**
     * @param remWidget the remWidget to set
     */
    public void setRemWidget(VBox remWidget) {
        this.remWidget = remWidget;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ReminderInfo {

        private String date;
        private String time;
        private String desc;

        ReminderInfo(String s1, String s2, String s3) {

            date = s1;
            time = s2;
            desc = s3;
        }

        @Override
        public String toString() {
            String value = String.format("%1$-20s %2$10s", date, time + "\n" + desc + "\n\n");
            return value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        /**
         * @return the date
         */
        public String getDate() {
            return date;
        }

        /**
         * @param date the date to set
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         * @return the time
         */
        public String getTime() {
            return time;
        }

        /**
         * @param time the time to set
         */
        public void setTime(String time) {
            this.time = time;
        }
    }

    private class DialogButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            displayDialog();
        }
    }
}
