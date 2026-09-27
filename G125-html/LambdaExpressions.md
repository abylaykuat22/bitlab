<h2>Предыстория</h2>

Существует 2 парадигмы программирования:
- Императивное программирование в контексте ООП и языка Java. Объекты являются самым важным понятием.
А методы это составная часть объектов. Без объекта методы не могут существовать.

- Функциональное программирование.
Здесь самым важным понятием выступают функции. Функция вызывает функцию, которая вызывает другую функцию и т.д.

Каждый из этих парадигм имеет свои преимущества.

Чтобы использовать преимущества функционального программирования в Java были добавлены Лямбда выражения.

- `JFrame frame = new JFrame();` - библиотека для создания графического интерфейса;
- `frame.setVisible(true);` - установить видимость окна;
- `frame.setSize(500, 500);` - установить ширину и высоту окна;
- `Button button = new Button("Салем алем");` - создание кнопки;
- `button.addActionListener()` - действие при нажатии на кнопки;
- `frame.getContentPane().add(button);` - добавить кнопку в окно;

Полный код без лямбды выражения:
```java
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(500, 500);

    Button button = new Button("Салем алем");

    String correct = "Перевод верный";
    String incorrect = "Перевод не верный";

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String translate = JOptionPane.showInputDialog("Переведите на английский");

        if ("Hello world".equals(translate)) {
          JOptionPane.showMessageDialog(frame, correct);
        } else {
          JOptionPane.showMessageDialog(frame, incorrect);
        }
      }
    });

    frame.getContentPane().add(button);
```

Полный код с использованием Лямбда выражения:
```java
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(500, 500);

    Button button = new Button("Салем алем");

    String correct = "Перевод верный";
    String incorrect = "Перевод не верный";

    button.addActionListener(actionEvent -> {
      String translate = JOptionPane.showInputDialog("Переведите на английский");

      if ("Hello world".equals(translate)) {
        JOptionPane.showMessageDialog(frame, correct);
      } else {
        JOptionPane.showMessageDialog(frame, incorrect);
      }
    });

    frame.getContentPane().add(button);
```

Результат:
Замена кода на выражение лямбда `actionEvent -> `

Работе с переменными:

```java
    String correct = "Перевод верный";
    String incorrect = "Перевод не верный";
``` 
- Не должны изменяться, иначе будет ошибка.
- Желательно объявить их как `final` 

Если есть необходимость их редактировать, то:

- Переменные нужно объявить за методом в самом классе;
- Использовать `AtomicReference<>`. Пример:
```java
    AtomicReference<String> correct = new AtomicReference<>("Перевод верный");
    correct.set("Перевод правильный");
    correct.get();
```

<h3>Функциональный интерфейс - интерфейс который содержит только один абстрактый метод</h3>
Пример использования:
```java
  public static void main(String[] args) {
    ArithmeticFunction<Integer, Integer, Integer> function = (value1, value2) -> value1 + value2;
    System.out.println(function.calculate(5, 6));

  }

  @FunctionalInterface
  interface ArithmeticFunction<C extends Number, A extends Number, B extends Number> {
    C calculate(A value1, B value2);
  }
```




