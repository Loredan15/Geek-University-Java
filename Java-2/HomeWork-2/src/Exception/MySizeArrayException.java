package Exception;

public class MySizeArrayException extends ArrayIndexOutOfBoundsException {
    public MySizeArrayException(int needRow, int needCol, int actualRow, int actualCol){
        super(String.format("Требовался массив размером %d на %d, а подали на вход %d на %d",needRow, needCol, actualRow, actualCol));
    }


}
