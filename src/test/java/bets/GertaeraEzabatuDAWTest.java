package bets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;


public class GertaeraEzabatuDAWTest {

    //sut:system under test
     static DataAccess sut=new DataAccess();

     //additional operations needed to execute the test 
     static TestDataAccess testDA=new TestDataAccess();

     //no hay resultados
     @Test
     public void test1 () {

     }
     //question es nula
     @Test
     public void test2 () {

     }
     //resultado = false
     @Test
     public void test3 () {

     }
     //distinta fecha de la del evento dado
     @Test
     public void test4 () {

     }
     //lista quo vacia
     @Test
     public void test5() {

     }
     //apuesta no vacia y perdida
     @Test
     public void test6 () {

     }
     //apuesta no vacia y ganada
     @Test
     public void test7 () {

     }
     //lista quo y QUO fuera de rango
     @Test
     public void test8 () {

     }
     //lista QUO vacia
     @Test
     public void test9 () {

     }

}
