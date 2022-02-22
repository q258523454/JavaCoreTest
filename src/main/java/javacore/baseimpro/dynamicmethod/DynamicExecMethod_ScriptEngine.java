package javacore.baseimpro.dynamicmethod;

import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Slf4j
public class DynamicExecMethod_ScriptEngine {
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
        DynamicExecMethod_ScriptEngine dynamicClass = new DynamicExecMethod_ScriptEngine();
        engine.put("dynamicClass", dynamicClass);
        // 脚本赋值val
        String script = "dynamicClass.setValue(1);";
        engine.eval(script);
        int returnedValue = dynamicClass.getValue();
        log.info("Returned value is " + returnedValue);


        // 脚本执行test()
        Object t = engine.eval("dynamicClass.test()");
        log.info(t.toString());

        // 脚本执行test2()
        Object t2 = (boolean) engine.eval("dynamicClass.test2()");
        log.info(t2.toString());
        if (false == (boolean) t2) {
            log.info("yes");
        }
    }

}