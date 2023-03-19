import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Doctor> doctors = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Николаев Александр Сергеевич");
        System.out.println("Группа РИБО-01-21");

        doctors.add(new Doctor("Антонов Антон Антонович", "терапевт", 345, 15, true));
        doctors.add(new Doctor("Иванов Иван Иванович", "хирург", 5, 20, true));
        doctors.add(new Doctor("Юрьев Юрий Аристархович", "офтальмолог", 65, 10, false));

        int action;
        while (true) {
            while (true) {
                System.out.println();
                System.out.println("Выберите действие (введите число):");
                System.out.println("1 - Добавить врача");
                System.out.println("2 - Изменить флаг о прохождении аттестации");
                try {
                    action = Integer.parseInt(scan());
                    if (action != 1 && action != 2) {
                        System.out.println("Необходимо ввести целое число 1 или 2");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Необходимо ввести целое число 1 или 2");
                }
            }
            switch (action) {
                case 1:
                    addDoctor(createDoctor());
                    print();
                    break;
                case 2:
                    changeFlag();
                    print();
                    break;
            }
        }
    }

    public static Doctor createDoctor() {
        String fullName, speciality;
        int number, countOfShifts, a;

        while (true) {
            System.out.println();
            System.out.println("Введите ФИО врача:");
            fullName = scan();
            if (fullName.isEmpty() || fullName.isBlank()) {
                System.out.println("Поле \"ФИО\" должно быть заполнено");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println();
            System.out.println("Введите специальность врача:");
            speciality = scan();
            if (speciality.isEmpty() || speciality.isBlank()) {
                System.out.println("Поле \"Специальность\" должно быть заполнено");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println();
            System.out.println("Введите порядковый номер врача:");
            try {
                number = Integer.parseInt(scan());
                if (number < 0) {
                    System.out.println("Порядковый номер должен быть целым положительным числом");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Порядковый номер должен быть целым положительным числом");
            }
        }

        while (true) {
            System.out.println();
            System.out.println("Введите количество смен врача в месяц:");
            try {
                countOfShifts = Integer.parseInt(scan());
                if (countOfShifts < 0) {
                    System.out.println("Количество смен должно быть целым положительным числом");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Количество смен должно быть целым положительным числом");
            }
        }

        while (true) {
            System.out.println();
            System.out.println("Имеет ли врач аттестацию? (введите число):");
            System.out.println("1 - Да");
            System.out.println("2 - Нет");
            try {
                a = Integer.parseInt(scan());
                if (a != 1 && a != 2) {
                    System.out.println("Необходимо ввести целое число 1 или 2");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число 1 или 2");
            }
        }

        return new Doctor(fullName, speciality, number, countOfShifts, a==1);
    }

    public static void addDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException();
        }
        System.out.println();
        if (doctors.isEmpty()) {
            doctors.add(doctor);
            System.out.println("Врач успешно добавлен!");
            return;
        }

        for (Doctor doc : doctors) {
            if (doc.getSerialNumber() == doctor.getSerialNumber()) {
                System.out.println("Врач с таким порядковым номером уже есть!");
                return;
            }
        }

        doctors.add(doctor);
        System.out.println("Врач успешно добавлен!");
    }

    public static void changeFlag() {
        if (doctors.isEmpty()) {
            System.out.println();
            System.out.println("Список пуст.");
            return;
        }

        int a = 1;
        int action;
        while (true) {
            System.out.println();
            System.out.println("Выберите у какого врача изменить флаг (введите число):");
            for (Doctor doctor : doctors) {
                System.out.println(a++ + " - " + doctor);
            }
            try {
                action = Integer.parseInt(scan());
                if (action < 1 || action > doctors.size()) {
                    System.out.println("Необходимо ввести целое число 1 до " + doctors.size());
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число 1 до " + doctors.size());
            }
        }

        doctors.get(action - 1).setHasCertification(!doctors.get(action - 1).isHasCertification());
        System.out.println();
        System.out.println("Флаг успешно изменен!");
    }

    public static void print() {
        System.out.println();
        if (doctors.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        doctors.stream().sorted(Comparator.comparing(Doctor::getFullName)).forEach(System.out::println);
    }

    public static String scan() {
        return new Scanner(System.in).nextLine();
    }
}