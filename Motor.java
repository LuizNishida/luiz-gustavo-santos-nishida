public class Motor {
    double motorInjecao = 1;

    boolean ligado = false;
    int giros() {
        if(!(ligado)){
return 0;
    }else{
        return (int) Math.round(motorInjecao * 3000);
    }
}
}
