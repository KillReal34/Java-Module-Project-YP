public class Converter {
    double count;

    Converter(float count){
        this.count = count;
    }

    String check(){
        if (count % 100 > 10 && count % 100 < 20){
            return "рублей";
        }
        else if(count % 100 >= 1 && count % 100 < 2){
            return "рубль";
        }
        else if (count % 100 > 1 && count % 10 < 5){
            return "рубля";
        }
        else{
            return "рублей";
        }
    }
}
