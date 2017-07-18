package canada118.com.wellcome;

/**
 * Created by beigly on 05.03.2017.
 */

public class Form {
    private String name;
    private String tel;
    private String age;
    private String email;
    private String branch;
    private String grade;
    private String ielts ;
    private String french ;
    private String advan ;
    private String moni  ;
    private String history ;
    private String msg ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public String getTitel(){
        String s =" Request form : "+ name +" by Mobile App. ";
        return s ;
    }
    public String getbody(){

        String s ="Email \n"+
                  "___________________________________________\n\n"+
                  " Name  : " + name + "\n\n"+
                  " Tel      : " + tel  + "\n\n"+
                  " Age     : " + age  + "\n\n"+
                  " Email  : " + email+ "\n\n"+
                  " Branch: " + branch  + "\n\n"+
                  " Education  Level : " +grade   + "\n"+
                  "______________________________________________________________________\n\n"+
                  " IETS    : " +ielts   + "\n "+
                  "______________________________________________________________________\n\n"+
                  " French  : " +french  + "\n "+
                  "______________________________________________________________________\n\n"+
                  " Other   :\n" + advan   + "\n"+
                  "___________________________________________\n\n"+
                  " Property: " +moni    + "\n\n"+
                  "___________________________________________\n\n"+
                  " Exp.    :\n" +  history + "\n\n"    +
                  "___________________________________________\n\n"+
                  " Message :\n " + msg;
        return s ;
    }

    public String getMoni() {
        return moni;
    }

    public void setMoni(String prop) {
        this.moni = prop;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }


    public String getAdvan() {
        return advan;
    }

    public void setAdvan(String advan) {
        this.advan = advan;
    }

    public String getIelts() {
        return ielts;
    }

    public void setIelts(String ielts) {
        this.ielts = ielts;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }




    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
