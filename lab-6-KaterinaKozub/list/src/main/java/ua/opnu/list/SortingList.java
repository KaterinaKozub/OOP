package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;

/*
 * Цей клас успадковується від стандартного класу Application.
 * Клас Application відповідає за роботу FX-додатку.
 * Якщо ви пишете додаток з використанням бібліотеки javaFX, то ви
 * повинні створити свій клас, який успадковується від класу Application
 */
public class SortingList extends Application {

    // Список студентів.
    // Інтерфейс ObservableList схожий на інтерфейс List, але
    // має можливість оповіщати інші об'єкти у тому, що він змінився
    private ObservableList<Student> students;

    /*
     * Цей метод запускається, коли запускається ваш додаток.
     * Stage - клас "підмостки". Вважайте, що це щось подібне до вікна додатку.
     * Просто в JavaFX вікно називається "підмостками", як театральні підмостки.
     * Найперші "підмостки" (перше вікно програми) створює за вас система і передає
     * його вам як вхідний параметр. Якщо ви захочете створити додаткові "підмостки"
     * - ви повинні зробити це самі
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Заголовок вікна
        primaryStage.setTitle("Список студентів");

        // Заповнюємо список студентів даними
        students = populateList();

        // Це вертикальний ряд із елементами
        final VBox vbox = new VBox();
        // Відстань між елементами
        vbox.setSpacing(5);
        // Встановлюємо padding у 5 пікселів у всіх напрямках
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER);

        // Це віджет списку, у ньому можна відображати список із даними.
        // Під час створення віджету списку, передаємо йому список (students) зі студентами
        // Для кожного студента зі списку викликається метод toString() і виводиться на екран
        final ListView<Student> listView = new ListView<>(students);
        // Переважні розміри віджету списку
        listView.setPrefSize(400, 240);

        // Настроюємо горизонтальний ряд кнопок
        final HBox hbox = setButtons();

        // Додаємо зверху віджет списку, після чого додаємо рядок з кнопками
        vbox.getChildren().addAll(listView, hbox);

        // Це клас "Сцена", який є контейнером для всіх інших віджетів.
        // На "сцені" розташовані кнопки, поля, перемикачі тощо.
        // У нашому випадку, на сцені у нас розташований вертикальний ряд елементів
        // де зверху буде список зі студентами, а знизу – ряд із кнопками
        Scene scene = new Scene(vbox);

        // Додаємо об'єкт сцени до Stage. Сцени можна міняти простим методом, що
        // дозволяє дуже просто змінювати вміст вікон
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        // Показуємо "підмостки"
        primaryStage.show();
    }

    /*
     * Заповнюємо список даними вручну
     */
    private ObservableList<Student> populateList() {
        Student student1 = new Student("Іван", "Іванов", 75);
        Student student2 = new Student("Петро", "Петренко", 92);
        Student student3 = new Student("Сергій", "Сергієнко", 61);
        Student student4 = new Student("Григорій", "Сковорода", 88);

        // Клас ObservableArrayList дуже схожий на ArrayList,
        // але дозволяє сповіщати інші класи у тому, що він змінився
        return FXCollections.observableArrayList(
                student1, student2, student3, student4);
    }

    /*
     * Налаштовуємо кнопки. Тут має бути ваш код
     */
    private HBox setButtons() {
        // Кнопка JavaFX має клас Button
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за оцінкою");

        // Блок коду нижче дозволяє кнопкам розтягуватися завширшки, щоб зайняти
        // весь простір HBox, причому кнопки будуть однакового розміру
        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);
        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        // Обробка натискання кнопки за допомогою об'єкта анонімного класу,
        // реалізує інтерфейс Comparable
        sortByNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new NameSorter());
            }
        });

        // TODO: Обробка натискання на кнопку "Сортувати за прізвищем"

        // TODO: Обробка натискання на кнопку "Сортувати за оцінкою"

        // Створюємо горизонтальний ряд
        HBox hb = new HBox();
        // Відстань між елементами ряду
        hb.setSpacing(5);
        // Додаємо до ряду елементи. У нашому випадку – кнопки
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        // Говоримо, що елементи в ряді мають бути вирівняні по центру
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        // Метод запускає додаток
        launch(args);
    }
}