package domini;

//proba
public class Huma extends Usuari {

    private String Password;

    public Huma(String nom){
        super(nom);
        //this.Password = Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
