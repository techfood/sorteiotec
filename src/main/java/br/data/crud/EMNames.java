package br.data.crud;

import java.util.HashMap;
import java.util.Map;

public class EMNames {
    
    public static final String EMN1 = "sfpaPU";

    public static Map<String, String> getEMN1Props() {

        String heroku_db = System.getenv("DATABASE_URL"); // variavel de ambiente criada pelo Heroku
        Map<String, String> properties = new HashMap<>();

        if (heroku_db == null) { //caso nao tenhamos a variavel de ambiente       
            properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/sorteiotec");
            properties.put("javax.persistence.jdbc.user", "postgres");
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("javax.persistence.jdbc.password", "12345");
        } else { //se a variavel de ambiente foi criada, indica que o projeto está alocado no heroku
            //   properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://ec2-184-73-202-79.compute-1.amazonaws.com:5432/d27dm10t2iscbc?sslmode=require");
            //   properties.put("javax.persistence.jdbc.user", "okdvfyabceaqmz");
            //   properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            //   properties.put("javax.persistence.jdbc.password", "037e654cd0b0f5b25b3973734a99cc9b3cec28a354eee53d92d742e0e4737ce3");
            //obter demais variaveis e configurar persistence.xml
            String jdbc_database_url = System.getenv("JDBC_DATABASE_URL");
            String jdbc_database_username = System.getenv("JDBC_DATABASE_USERNAME");
            String jdbc_database_password = System.getenv("JDBC_DATABASE_PASSWORD");

            properties.put("javax.persistence.jdbc.url", jdbc_database_url);
            properties.put("javax.persistence.jdbc.user", jdbc_database_username);
            properties.put("javax.persistence.jdbc.password", jdbc_database_password);
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver"); //configurando driver para postgres
        }
        return properties;
    }
}
