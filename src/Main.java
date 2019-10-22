import boats.PolyCellBoat;
import boats.SingleCellBoat;
import field.Cell;
import field.Field;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Field field = new Field(10, 10);
        int ch = 0;
        do {
            field.printField();
            System.out.println("\n1. Поставить одиночный кораблик\n2. Поставить длинный кораблик\n3. Выйти");
            ch = scan.nextInt();
            int x, y, l;
            boolean isVertical;
            switch (ch) {
                case 1:
                    System.out.print("Введите координаты:\nx = ");
                    x = scan.nextInt();
                    System.out.print("y = ");
                    y = scan.nextInt();
                    field.setBoat(new SingleCellBoat(new Cell(x, y)));
                    break;
                case 2:
                    System.out.print("Введите координаты:\nx = ");
                    x = scan.nextInt();
                    System.out.print("y = ");
                    y = scan.nextInt();
                    System.out.print("Введите длину:\nl = ");
                    l = scan.nextInt();
                    System.out.print("Выберите ориентацию:\n1.Вертикальный\n2.Горизонтальный\n");
                    if(scan.nextInt() == 1)
                        isVertical = true;
                    else
                        isVertical = false;
                    field.setBoat(new PolyCellBoat(new Cell(x, y), l, isVertical));
                    break;
            }
        } while (ch != 3);
    }
}
