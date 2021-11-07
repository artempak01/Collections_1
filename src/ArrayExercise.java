import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayExercise {
    static public void testArray(){
        System.out.println("Ввведите числа через пробел");
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0;i<2;i++){
            list.add(Integer.parseInt(sc.next()));
        }
        int num = sc.nextInt();
        while (num !=0){
            System.out.println("Выбирайте действие:\n" +
                    "1. Добавить элемент в список;\n" +
                    "2. Удалить элемент из списка;\n" +
                    "3. Показать содержимое списка;\n" +
                    "4. Проверить есть ли значение в списке;\n" +
                    "5. Заменить значение в списке.");
            num = sc.nextInt();
            switch (num)
            {
                case 1:
                    System.out.println("Какое значение добавить?");
                    list.add(sc.nextInt());
                    System.out.println("Готово");

                    break;
                case 2:
                    System.out.println("Какое значение удалить?");
                    Integer i = sc.nextInt();
                    if(list.contains(i)) {
                        list.remove(i);
                        System.out.println("Готово");
                    }
                    else
                        System.out.println("Нет такого занчения");
                    break;
                case 3:
                    for (int item:list
                    ) {
                        System.out.println(item);
                    }
                    break;
                case 4:
                    System.out.println("Какое значение найти?");
                    Boolean ready = list.contains(sc.nextInt());
                    System.out.println(ready);
                    break;
                case 5:
                    System.out.println("Какое значение заменить?");
                    int oldValue = sc.nextInt();
                    System.out.println("На какое значение заменить?");
                    int newValue = sc.nextInt();
                    if(list.contains(oldValue)){
                        int index = list.indexOf(oldValue);
                        list.set(index, newValue);
                        System.out.println("Готово");
                    }
                    else
                        System.out.println("Нет такого занчения");
            }

        }
    }

    static public void testMap(){

        Scanner sc = new Scanner(System.in);
        HashMap<String,String> users = new HashMap<>();
        int num = 1;
        while (num != 0){
            System.out.println("Выбирайте действие:\n" +
                    "1. Добавить нового пользователя;\n" +
                    "2. Удалить существующего пользователя;\n" +
                    "3. Проверить существует ли пользователь;\n" +
                    "4. Изменить логин существующего пользователя;\n" +
                    "5. Изменить пароль существующего пользователя.");

            num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("Введите логин нового пользователя");
                    String newLogin = sc.next();
                    if(users.containsKey(newLogin)) System.out.println("Такой пользователь уже существует");
                    else {
                        System.out.println("Введите пароль");
                        String password = sc.next();
                        users.put(newLogin, password);
                        System.out.println(String.format("Пользователь %s добавлен.", newLogin));
                    }
                    break;
                case 2:
                    System.out.println("Введите логин удаляемого пользователя");
                    String deleteLogin = sc.next();
                    if(!users.containsKey(deleteLogin)) System.out.println("Такой пользователь не существует");
                    else {
                        users.remove(deleteLogin);
                        System.out.println(String.format("Пользователь %s удален.", deleteLogin));
                    }
                    break;
                case 3:
                    System.out.println("Введите логин пользователя");
                    String searchingLogin = sc.next();
                    if(users.containsKey(searchingLogin))
                        System.out.println("Такой пользователь существует");

                    else System.out.println("Такой пользователь не существует");
                    break;
                case 4:
                    System.out.println("Введите логин пользователя");
                    String editingLogin = sc.next();
                    if(users.containsKey(editingLogin)){
                        System.out.println("Введите новый логин");
                        String Pass = users.get(editingLogin);
                        String newEditingLogin = sc.next();
                        users.remove(editingLogin);
                        users.put(newEditingLogin,Pass);
                        System.out.println(String.format("Логин пользователя %s изменен на %s.", editingLogin, newEditingLogin));
                    }
                    else System.out.println("Такой пользователь не существует");
                    break;
                case 5:
                    System.out.println("Введите логин пользователя");
                    String editingLoginPass = sc.next();
                    if(users.containsKey(editingLoginPass)){
                        System.out.println("Введите новый пароль");
                        String newPassword = sc.next();
                        users.remove(editingLoginPass);
                        users.put(editingLoginPass,newPassword);
                        System.out.println(String.format("Пароль пользователя %s изменен.", editingLoginPass));
                    }
                    else System.out.println("Такой пользователь не существует");
                    break;
            }
        }

    }
}
