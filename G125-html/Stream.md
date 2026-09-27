<h3>Stream API - поток данных. Способствует написанию функционального кода при помощи
Лямбда-выражений.</h3>

Для чего нужно использовать потоки?
- более компактный читаемый код.
- функциональный подход(использование лямбда выражений).
- параллельная обработка данных(при работе с большими данными).
- Изоляция операции(данные обрабатываются в одном потоке, недоступен извне);

Операции stream. Примеры:
- .filter
```java
  List<Integer> filteredNumbers = numbers.stream()
          .filter(number -> number >= 0)
          .toList();
  
  System.out.println(filteredNumbers); // [1, 2, 3, 4, 5]
```

- .map
```java
    List<String> fullNames = students.stream()
        .map(Student::getFullName)
        .toList();
```

- .sort
```java
    List<Student> sortedStudents = students.stream()
        .sorted(Comparator.comparing(Student::getAge))
        .toList();
    System.out.println(sortedStudents);
```

- .findFirst
```java
Optional<Student> optionalStudent = students.stream()
        .filter(student -> student.getHeight() < 50)
        .findFirst();

    optionalStudent.ifPresent(student -> {
      System.out.println("Результат");
      System.out.println(student);
    });
```

- .sum
```java
int sum = numbers.stream()
        .mapToInt(number -> number)
        .sum();
```

- .distinct
```java
employees.stream()
        .map(Employee::getLastName)
        .sorted()
        .distinct() // удаляет дубликаты
        .collect(Collectors.toList())
        .forEach(System.out::println);
```

- .anyMatch // возвращает boolean значение. (Если хотя бы одному сотруднику меньше 18)
```java
boolean isExist = employeeList.stream()
        .anyMatch(employee -> employee.getAge() < 18); 
```

- allMatch // возвращает boolean значение. (Если всем сотрудникам больше 18)
```java
boolean isCorrect = employeeList.stream()
        .allMatch(employee -> employee.getAge() >= 18);
```




