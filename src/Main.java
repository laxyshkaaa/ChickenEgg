public class Main {
    public static void main(String[] args) throws InterruptedException {

        ChickenEggOut chicken = new ChickenEggOut("Курица");
        ChickenEggOut egg = new ChickenEggOut("Яйцо");


        chicken.start();
        egg.start();

        // Вызываем метод для определения, какой поток завершится первым
        String result = determineFirstFinished(chicken, egg);
        System.out.println("На свет раньше появилось: " + result);
    }


    public static String determineFirstFinished(Thread t1, Thread t2) throws InterruptedException {
        // Ждем завершения одного из потоков
        while (true) {
            if (!t1.isAlive()) {
                t2.join(); // Ждем завершения второго потока
                return t1.getName(); // Возвращаем имя первого завершившегося потока
            }
            if (!t2.isAlive()) {
                t1.join(); // Ждем завершения первого потока
                return t2.getName(); // Возвращаем имя первого завершившегося потsZока
            }
        }
    }
}

class ChickenEggOut extends Thread {
    public ChickenEggOut(String itemName) {
        super(itemName); // Используем конструктор Thread для задания имени
    }

    public void run() {
        System.out.println(getName());
    }
}