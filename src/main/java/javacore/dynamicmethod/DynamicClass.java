package javacore.dynamicmethod;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DynamicClass {
    private int val = -1;

    public void setValue(int x) {
        val = x;
    }

    public int getValue() {
        return val;
    }


    public String test() {
        return "hello!";
    }

    public boolean test2() {
        return false;
    }


    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        DynamicClass dynamicClass = new DynamicClass();
        engine.put("dynamicClass", dynamicClass);
        String script = "dynamicClass.setValue(1);";
        engine.eval(script);
        int returnedValue = dynamicClass.getValue();
        System.out.println("Returned value is " + returnedValue);
        engine.eval("dynamicClass.test()");
        Object t = engine.eval("dynamicClass.test()");
        System.out.println(t.toString());

        Object t2 = (boolean) engine.eval("dynamicClass.test2()");
        System.out.println(t2);
        if (false == (boolean) t2) {
            System.out.println("yes");
        }
    }

}