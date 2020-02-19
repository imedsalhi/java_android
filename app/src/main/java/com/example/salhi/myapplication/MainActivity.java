package com.example.salhi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.*;
import android.widget.Button;
import android.widget.EditText;
import java.sql.* ;
import java.io.* ;
import java.sql.* ;
import java.io.* ;
import com.* ;

public class MainActivity extends AppCompatActivity {
    public void changer(View view){
        EditText txt=(EditText)findViewById(R.id.txt) ;
        EditText pass=(EditText)findViewById(R.id.pass) ;
        Log.i("info","button pressed");
        Log.i("values",txt.getText().toString());
        Log.i("values",pass.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            try {

                Class c = Class.forName("com.mysql.jdbc.Driver") ;
                Driver pilote = (Driver)c.newInstance() ;

                DriverManager.registerDriver(pilote);

                String protocole =  "jdbc:mysql:" ;

                String ip =  "localhost" ;  // dépend du contexte
                String port =  "8080" ;  // port MySQL par défaut

                String nomBase =  "dbparcauto" ;  // dépend du contexte

                String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;

                String nomConnexion =  "user" ;  // dépend du contexte
                String motDePasse =  "passwd" ;  // dépend du contexte
                // Connexion
                Connection con = DriverManager.getConnection(
                        conString, nomConnexion, motDePasse) ;

                // Envoi d’un requête générique
                String sql =  "select * from Marins" ;
                Statement smt = con.createStatement() ;
                ResultSet rs = smt.executeQuery(sql) ;
                while (rs.next()) {
                    System.out.println(rs.getString("nom")) ;
                }
            }  catch (Exception e) {
                // gestion des exceptions
            }
        }

    }

