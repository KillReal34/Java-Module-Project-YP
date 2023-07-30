public class Converter {
    float count;

    Converter(float count){
        this.count = count;
    }

    String check(){
        float remainTen = count % 10;
        float remainHundred = count % 100;

        if (remainTen > 10 && remainTen < 20 || remainHundred > 10 && remainHundred < 20){
            return "рублей";
        }
        else if(remainTen >= 1 && remainTen < 2 || remainHundred >= 1 && remainHundred < 2){
            return "рубль";
        }
        else if (remainTen > 1 && remainTen < 5 || remainHundred > 1 && remainHundred < 5){
            return "рубля";
        }
        else{
            return "рублей";
        }
    }
}
