package ua.opnu.view;

import javax.swing.JButton;
import java.awt.Font;

/*
 * Нам потрібна звичайна кнопка, але щоб текст кнопки
 * був більше, ніж стандартний. Щоб для кожної кнопки
 * не викликати метод setFont(), ми просто створюємо підклас
 * класу JButton та в конструкторі класу викликаємо метод setFont().
 *
 * Таким чином, щоразу коли буде створюватися об'єкт класу
 * BigTextButton, ми отримаємо звичайну кнопку, але з текстом більшого розміру
 */
public class BigTextButton extends JButton {

    public BigTextButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}