package Exception;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int col, int row){
        super(String.format("Невозможно преобразовать данные к числу в ячейке [%d][%d], не забываем, что нумерация с нуля", col, row));
    }
}
