package com.example.duvan.petagram;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto extends AppCompatActivity {

    private TextInputEditText txCorreo;
    private TextInputEditText txNombre;
    private TextInputEditText txMensaje;
    private Button btnEnviar;
    Session session;
    private String contraseña = "jeisson9";
    private String correo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar =  findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        miActionBar.setTitle("Contacto");
        if (getSupportActionBar() != null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        txCorreo = (TextInputEditText) findViewById(R.id.txiCorreo);
        txNombre = (TextInputEditText) findViewById(R.id.txiNombre);
        txMensaje =(TextInputEditText) findViewById(R.id.txiMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy  threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");
                correo = txCorreo.getText().toString();
                String mensaje = txMensaje.getText().toString();
                Toast.makeText(view.getContext(), "Correo:"+ correo, Toast.LENGTH_SHORT).show();
                Toast.makeText(view.getContext(), "Mensaje:"+  mensaje, Toast.LENGTH_SHORT).show();


                try{
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña);
                        }
                    });

                    if(session !=null){

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Comentario Aplicacion");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("duvan618@hotmail.com"));
                        message.setContent(mensaje,"text/html; charset=utf-8");
                        Toast.makeText(view.getContext(), "Llego", Toast.LENGTH_SHORT).show();
                        Transport.send(message);
                        Toast.makeText(view.getContext(), "Envio", Toast.LENGTH_SHORT).show();



                    }



               } catch (Exception ex){
                    ex.printStackTrace();
                    Toast.makeText(view.getContext(), "Error:"+ex.getMessage()+ex.getStackTrace(), Toast.LENGTH_SHORT).show();




                }


            }
        });



    }
}
