package canada118.com.wellcome;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;

import static android.view.KeyEvent.KEYCODE_NAVIGATE_NEXT;

public class MainActivity extends AppCompatActivity {
    public static String[] target ={"info@canada118.com" , "sepehr@canada118.com"};
    public static String epasw = "sepehr123";
    public static String source = "pariafaramarz118@gmail.com";

    Form form ;
    EditText name,tel,em ,age,brnch,iS ,iL,iW,ir,fS ,fL,fW,fr ,money ,history , msg ;
    RadioButton r1 , r2, r3, r4;
    CheckBox  c1 , c2, c3, c4 ;
    Button trig ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        trig = (Button) findViewById(R.id.triger);
        trig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(  checkForm() ){

                    new SendMail().execute("");

                };
            }
        });


     Start();

     init();
      r1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                   r2.setChecked(false); r3.setChecked(false);r4.setChecked(false);
                                }
                            }
      );
      r2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      r1.setChecked(false); r3.setChecked(false);r4.setChecked(false);
                                  }
                              }
       );
      r3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      r1.setChecked(false); r2.setChecked(false);r4.setChecked(false);
                                  }
                              }
      );
      r4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      r1.setChecked(false); r2.setChecked(false);r3.setChecked(false);
                                  }
                              }
      );
    }
    private void clear(){
        name.setText(""); tel.setText(""); em.setText("");  age.setText("");
        brnch.setText(""); iS.setText("");  iL.setText(""); iW.setText("");
        ir.setText(""); fS.setText("");  fL.setText(""); fW.setText("");
        fr.setText("");  money.setText("");  history.setText("");msg.setText("");
        c1.setChecked(false);  c2.setChecked(false); c3.setChecked(false); c4.setChecked(false);
        r1.setChecked(false);r2.setChecked(false);r3.setChecked(false);r4.setChecked(false);
    }
    private void init() {
        form = new Form();

        name = (EditText)findViewById(R.id.etname);
       // InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
       // imm.hideSoftInputFromWindow(name.getWindowToken() ,InputMethodManager.HIDE_NOT_ALWAYS);

        tel  = (EditText)findViewById(R.id.ettel);

       
        em  = (EditText)findViewById(R.id.etemail);
        age  = (EditText)findViewById(R.id.etage);
        brnch= (EditText)findViewById(R.id.etBranch);

        r1 =   (RadioButton) findViewById(R.id.rb1)   ;
        r2 =   (RadioButton) findViewById(R.id.rb2)   ;
        r3 =   (RadioButton) findViewById(R.id.rb3)   ;
        r4 =   (RadioButton) findViewById(R.id.rb4)   ;

        iS = (EditText)findViewById(R.id.etIS);
        iL  = (EditText)findViewById(R.id.etIL);
        iW = (EditText)findViewById(R.id.etIW);
        ir  = (EditText)findViewById(R.id.etIR);

        fS = (EditText)findViewById(R.id.etFS);
        fL  = (EditText)findViewById(R.id.etFL);
        fW = (EditText)findViewById(R.id.etFW);
        fr  = (EditText)findViewById(R.id.etFR);

        c1 =   (CheckBox) findViewById(R.id.cB1)   ;
        c2 =   (CheckBox) findViewById(R.id.cB2)   ;
        c3 =   (CheckBox) findViewById(R.id.cB3)   ;
        c4 =   (CheckBox) findViewById(R.id.cB4)   ;

        money = (EditText)findViewById(R.id.etmoni);
        history  = (EditText)findViewById(R.id.ethist);
        msg  = (EditText)findViewById(R.id.etmsg);



    }




    private boolean checkForm() {
        Boolean result = true ;
        String s = name.getText().toString();
        if (s.trim().isEmpty()) {
            result = false;
            Toast.makeText(this," Name field is empty ",Toast.LENGTH_LONG).show();
        }
        form.setName(s);

        s = tel.getText().toString().trim();
        if (s.isEmpty() || s.length() < 5 ) {
            result = false;
            Toast.makeText(this," Tel: field is empty ",Toast.LENGTH_LONG).show();
        }
        form.setTel(s);

        s = em.getText().toString().trim();
        if (s.isEmpty() || s.length() < 7 || s.indexOf("@")<0 ) {
            result = false;
            Toast.makeText(this," Email is wrong ",Toast.LENGTH_LONG).show();
        }
        form.setEmail(s);

        s = age.getText().toString();
        if (s.trim().isEmpty()) {
            result = false;
            Toast.makeText(this," Age: field is empty ",Toast.LENGTH_LONG).show();
        }
        form.setAge(s);

        s = brnch.getText().toString();
        if (s.trim().isEmpty()) {
            result = false;
            Toast.makeText(this," Branch: field is empty ",Toast.LENGTH_LONG).show();
        }
        form.setBranch(s);
        if( r1.isChecked() ){ form.setGrade("diplom");};
        if( r2.isChecked() ){ form.setGrade("Batchor");};
        if( r3.isChecked() ){ form.setGrade("MS.");};
        if( r4.isChecked() ){ form.setGrade("Dr.");};

        form.setIelts("Reading : "  + ir.getText().toString() +"    "
                     +"Writing : "  + iW.getText().toString() +"    "

                     +"Speaking : " + iS.getText().toString() +"    "
                     +"Listening : "+ iL.getText().toString() +"    "
        );
        form.setFrench("Reading : "  + fr.getText().toString() +"    "
                      +"Writing : "  + fW.getText().toString() +"    "

                      +"Speaking : " + fS.getText().toString() +"    "
                      +"Listening : "+ fL.getText().toString() +"    "
        );
        form.setAdvan("");
        if (c1.isChecked()){  form.setAdvan(  " خیشاوند در کانادا دارد"  +"\n");} ;
        if (c2.isChecked()){  form.setAdvan( form.getAdvan() + " سابقه کار ویا تحصیل در کانادا دارد"  +"\n");} ;
        if (c3.isChecked()){  form.setAdvan( form.getAdvan() + " همسر متقاضی ایلتس دارد"  +"\n");} ;
        if (c4.isChecked()){  form.setAdvan( form.getAdvan() + " پیشنهاد دعوت به کار دارد"  +"\n");} ;

        form.setMoni( money.getText().toString());
        form.setHistory( history.getText().toString());
        form.setMsg(msg.getText().toString());
        return result;
    }


    private void  Start() {
        Intent  intend = new Intent(MainActivity.this,Main2Activity.class );
        startActivity (intend  );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            finish();
            return true;
        }
        if (id == R.id.clear) {
             clear();

            return true;
        }
        if (id == R.id.email) {
            if(  checkForm() ){
               new SendMail().execute("");};
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private class SendMail extends AsyncTask<String, Integer, Boolean> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this, "Please wait", "Sending mail", true, false);
        }

        @Override
        protected void onPostExecute(Boolean params) {
            super.onPostExecute(params);
            progressDialog.dismiss();
            if (params) {
                Toast.makeText(MainActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
                clear();
                Toast.makeText(MainActivity.this, "Thank You for Email.  we will review your form.   we will contact you"
                        , Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "ارزیابی رایگان از فرم ارسالی شما انجام خواهد شد"
                        , Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "دراولین فرصت با شما از طریق ایمیل یا تلفن تماس میگیریم "
                        , Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
                String[] TO = target;
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, form.getTitel());
                emailIntent.putExtra(Intent.EXTRA_TEXT, form.getbody());

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));


                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }



            }
        }

        protected Boolean doInBackground(String... params) {
            Boolean result = true ;
            Mail m = new Mail(source, epasw);

            String[] toArr = target;
            m.setTo(toArr);
            m.setFrom(source);
            m.setSubject(form.getTitel());
            m.setBody(form.getbody());

            try {
                 result = m.send() ;
            } catch(Exception e) {
                result = false ;
                Log.e("MailApp", "Could not send email", e);
            }
            return result;
        }
    }




}
