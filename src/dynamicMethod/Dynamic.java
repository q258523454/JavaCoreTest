package dynamicMethod;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*  w  w w  .j a v  a2s.c om*/
public class Dynamic {
    private int val = -1;

    public void setValue(int x) {
        val = x;
    }

    public int getValue() {
        return val;
    }

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        Dynamic result = new Dynamic();
        engine.put("result", result);
        String script = "3 + 4; result.setValue(1);";
        engine.eval(script);
        int returnedValue = result.getValue();
        System.out.println("Returned value is " + returnedValue);
        engine.eval("result.test()");
        Object t = engine.eval("result.test()");
        String tt = t.toString();
        System.out.println(tt);

        Object t2 = (boolean) engine.eval("result.test2()");
        System.out.println(t2);
        if (false == (boolean) t2) {
            System.out.println("yes");
        }

    }

    public String test() {
        return "hello!";
    }

    public boolean test2() {
        return false;
    }
}