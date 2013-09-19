import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornDemo {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("nashorn");
        String jsCode = "function displayString(str) {" +
                        "   print('-->' + str + '<--');" +
                        "}" +
                        "displayString('one');" +
                        "displayString('two');";
        engine.eval(jsCode);
    }
}
