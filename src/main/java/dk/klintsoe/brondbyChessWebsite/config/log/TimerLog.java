package dk.klintsoe.brondbyChessWebsite.config.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TimerLog {

    private Logger timerLog = LogManager.getLogger("timer");

    private String identifier;

    private long startTime;
    private long markTime;

    private int markCounter = 0;

    private String identString;

    private List<String> list;

    TimerLog() {
        this.list = new ArrayList<>();
    }

    private void reset() {
        markCounter = 0;
        list.clear();
    }

    public void start(String identifier) {
        reset();
        startTime = System.nanoTime();
        markTime = System.nanoTime();
        this.identifier = identifier;

        identString = "["+identifier +"]:";
        String text = identString + "start timing";
        timerLog.debug(text);
    }

    public void mark(String deltaText) {
        long newTime = System.nanoTime();
        long deltaMark = (newTime - markTime);
        long deltaMarkInSec =  TimeUnit.SECONDS.convert(deltaMark, TimeUnit.NANOSECONDS);

        String text = markCounter++ + ":mark:["+ deltaText+"]:" + deltaMarkInSec + "sec";
        timerLog.debug(identString + text);
        list.add(text);
        markTime = newTime;
    }

    public void stopTimer(String deltaText) {
        long newTime = System.nanoTime();
        long deltaMark = (newTime - markTime);
        long deltaMarkInSec =  TimeUnit.SECONDS.convert(deltaMark, TimeUnit.NANOSECONDS);
        String text = markCounter++ + ":mark:["+ deltaText+"]:" + deltaMarkInSec + "sec";
        timerLog.debug(identString + text);

        long deltaTotal = (newTime - startTime);
        long deltaTotalInSec =  TimeUnit.SECONDS.convert(deltaTotal, TimeUnit.NANOSECONDS);

        String endtext = "[Total]:" + deltaTotalInSec + "sec";
        timerLog.debug(identString +  endtext);

        list.add(text);
        list.add(endtext);

        timerLog.info(printList(list));
    }


    private String printList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[{" );
        stringBuilder.append(identifier );
        stringBuilder.append("}");

        for (String string: list) {
            stringBuilder.append(string);
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
