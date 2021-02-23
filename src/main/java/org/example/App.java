package org.example;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App
{
    public class Condition {
        public int moduloValue;
        public String outPut;
        public Condition(int moduloValue, String outPut){
            this.moduloValue=moduloValue;
            this.outPut=outPut;
        }

        public boolean match(int input){
            return input%moduloValue==0;
        }

        public Condition compose(Condition param){
            return new Condition(0, this.outPut+param.outPut);
        }
        public String applying(int input, String valueActual){
           // if (input%moduloValue==0) valueActual+=outPut;
            return valueActual;
        }
    }

    ArrayList<Condition> lstCondition;

    public App (){
        lstCondition=new ArrayList<>();
        lstCondition.add(new Condition(3, "fizz"));
        lstCondition.add(new Condition(5, "buzz"));
        //lstCondition.add(new Condition(7, "fuzz"));
        //lstCondition.add(new Condition(11, "bazz"));
    }
    public String fizzbuzz(int i) {
        return lstCondition.stream().filter(condition -> condition.match(i)).reduce(
                Condition::compose
        ).map(condition -> condition.outPut).orElse(Integer.toString(i));
    }
}
